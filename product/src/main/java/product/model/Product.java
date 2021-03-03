package product.model;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private int ID;
    private int creditID;
    private String productName;
    private int value;

    public Product() {
    }

    public Product(int ID, int creditID, String productName, int value) {
        this.ID = ID;
        this.creditID = creditID;
        this.productName = productName;
        this.value = value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
