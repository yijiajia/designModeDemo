package behavior.strategy.project.app;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单的定义
 */
@Data
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
public class OrderDef {

    /**
     * 订单id
     */
    private int orderId;


    /**
     * item
     */
    private List<OrderItemDef> list;


    /**
     * 订单状态
     */
    private int status;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 购买产品到购物车
     * @param productId
     * @param amount
     */
    public void addCartItem(int productId,int amount) {
        double price = 0.0;

        /**
         * 计算总价
         */
        sumPrice(price);

        /**
         * 添加产品
         */
        OrderItemDef orderItem = OrderItemDef.builder()
                .amount(amount).productId(productId).price(price).build();
        list.add(orderItem);
    }

    /**
     * 计算总价
     */
    public void sumPrice(double price) {
       /* this.totalPrice += price;  */ /** 精度丢失警告！！ **/
        BigDecimal bigDecimal = new BigDecimal(this.totalPrice);
        BigDecimal addNum = new BigDecimal(price);
        this.totalPrice = new Double(bigDecimal.add(addNum).toString());
    }

    /**
     * 移除订单
     */

    /**
     * 结算产品
     */




}
