package storeshop.model.entities;

import com.google.gson.Gson;

public class ProductCheque {
    private long chequeId;
    private long productId;

    public ProductCheque() {
    }

    public ProductCheque(long chequeId, long productId) {
        this.chequeId = chequeId;
        this.productId = productId;
    }

    public long getChequeId() {
        return chequeId;
    }

    public ProductCheque setChequeId(long chequeId) {
        this.chequeId = chequeId;
        return this;
    }

    public long getProductId() {
        return productId;
    }

    public ProductCheque setProductId(long productId) {
        this.productId = productId;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
