package behavior.strategy.project.app;

import lombok.*;

/**
 * 订单Item
 */
@Data
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
public class OrderItemDef {

//    private int itemId;

    private int orderId;

    /**
     * 购买数量
     */
    private int amount;

    /**
     * 产品id
     */
    private int productId;

    /**
     * 订单价格
     */
    private double price;

}
