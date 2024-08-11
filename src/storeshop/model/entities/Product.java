package storeshop.model.entities;

import com.google.gson.Gson;
import storeshop.model.enums.ProductName;

public class Product {
    private long productId;
    private long personId;
    private long storageId;
    private String productNumber;
    private ProductName productName;
    private String productModel;
    private float productBuyPrice;
    private int productCount;

    public Product() {
    }

    public Product(long productId, long personId, long storageId, String productNumber, ProductName productName, String productModel, float productBuyPrice, int productCount) {
        this.productId = productId;
        this.personId = personId;
        this.storageId = storageId;
        this.productNumber = productNumber;
        this.productName = productName;
        this.productModel = productModel;
        this.productBuyPrice = productBuyPrice;
        this.productCount = productCount;
    }

    public Product(long personId, long storageId, String productNumber, ProductName productName, String productModel, float productBuyPrice, int productCount) {
        this.personId = personId;
        this.storageId = storageId;
        this.productNumber = productNumber;
        this.productName = productName;
        this.productModel = productModel;
        this.productBuyPrice = productBuyPrice;
        this.productCount = productCount;
    }

    public long getProductId() {
        return productId;
    }

    public Product setProductId(long productId) {
        this.productId = productId;
        return this;
    }

    public long getPersonId() {
        return personId;
    }

    public Product setPersonId(long personId) {
        this.personId = personId;
        return this;
    }

    public long getStorageId() {
        return storageId;
    }

    public Product setStorageId(long storageId) {
        this.storageId = storageId;
        return this;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public Product setProductNumber(String productNumber) {
        this.productNumber = productNumber;
        return this;
    }

    public ProductName getProductName() {
        return productName;
    }

    public Product setProductName(ProductName productName) {
        this.productName = productName;
        return this;
    }

    public String getProductModel() {
        return productModel;
    }

    public Product setProductModel(String productModel) {
        this.productModel = productModel;
        return this;
    }

    public float getProductBuyPrice() {
        return productBuyPrice;
    }

    public Product setProductBuyPrice(float productBuyPrice) {
        this.productBuyPrice = productBuyPrice;
        return this;
    }

    public int getProductCount() {
        return productCount;
    }

    public Product setProductCount(int productCount) {
        this.productCount = productCount;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
