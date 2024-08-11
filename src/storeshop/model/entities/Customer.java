package storeshop.model.entities;

import com.google.gson.Gson;

public class Customer {
    private long customerId;
    private String customerName;
    private String customerFamily;
    private String customerNationalCode;
    private String customerCellPhone;
    private String customerEmail;

    public Customer() {
    }

    public Customer(long customerId, String customerName, String customerFamily, String customerNationalCode, String customerCellPhone, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerFamily = customerFamily;
        this.customerNationalCode = customerNationalCode;
        this.customerCellPhone = customerCellPhone;
        this.customerEmail = customerEmail;
    }

    public Customer(String customerName, String customerFamily, String customerNationalCode, String customerCellPhone, String customerEmail) {
        this.customerName = customerName;
        this.customerFamily = customerFamily;
        this.customerNationalCode = customerNationalCode;
        this.customerCellPhone = customerCellPhone;
        this.customerEmail = customerEmail;
    }

    public long getCustomerId() {
        return customerId;
    }

    public Customer setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Customer setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerFamily() {
        return customerFamily;
    }

    public Customer setCustomerFamily(String customerFamily) {
        this.customerFamily = customerFamily;
        return this;
    }

    public String getCustomerNationalCode() {
        return customerNationalCode;
    }

    public Customer setCustomerNationalCode(String customerNationalCode) {
        this.customerNationalCode = customerNationalCode;
        return this;
    }

    public String getCustomerCellPhone() {
        return customerCellPhone;
    }

    public Customer setCustomerCellPhone(String customerCellPhone) {
        this.customerCellPhone = customerCellPhone;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Customer setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
