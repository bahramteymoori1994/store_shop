package storeshop.model.entities;

import com.google.gson.Gson;

import java.time.LocalDateTime;

public class Cheque {
    private long chequeId;
    private long customerId;
    private long managerId;
    private int chequeProductCount;
    private LocalDateTime chequeRegisterDate;

    public Cheque() {
    }

    public Cheque(long chequeId, long customerId, long managerId, int chequeProductCount, LocalDateTime chequeRegisterDate) {
        this.chequeId = chequeId;
        this.customerId = customerId;
        this.managerId = managerId;
        this.chequeProductCount = chequeProductCount;
        this.chequeRegisterDate = chequeRegisterDate;
    }

    public Cheque(long customerId, long managerId, int chequeProductCount) {
        this.customerId = customerId;
        this.managerId = managerId;
        this.chequeProductCount = chequeProductCount;
    }

    public long getChequeId() {
        return chequeId;
    }

    public Cheque setChequeId(long chequeId) {
        this.chequeId = chequeId;
        return this;
    }

    public long getCustomerId() {
        return customerId;
    }

    public Cheque setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public long getManagerId() {
        return managerId;
    }

    public Cheque setManagerId(long managerId) {
        this.managerId = managerId;
        return this;
    }

    public int getChequeProductCount() {
        return chequeProductCount;
    }

    public Cheque setChequeProductCount(int chequeProductCount) {
        this.chequeProductCount = chequeProductCount;
        return this;
    }

    public LocalDateTime getChequeRegisterDate() {
        return chequeRegisterDate;
    }

    public Cheque setChequeRegisterDate(LocalDateTime chequeRegisterDate) {
        this.chequeRegisterDate = chequeRegisterDate;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}