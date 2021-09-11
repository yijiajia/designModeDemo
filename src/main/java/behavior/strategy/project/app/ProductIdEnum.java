package behavior.strategy.project.app;

/**
 * 产品的定义
 * ps : 一般是存库的
 */
public enum ProductIdEnum {

    BOOK(1001,10.5),
    WATER(1002,2.5),
    YAO(1003,25),
    DIAN_NAO(1004,10000);


    private int productId;

    private double price;

    ProductIdEnum(int productId,double price) {
        this.productId = productId;
        this.price = price;
    }
}
