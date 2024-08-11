package storeshop.model.entities;

import com.google.gson.Gson;

public class Manager {
    private long managerId;
    private String managerName;
    private String managerFamily;
    private String managerNationalCode;
    private String managerCellPhone;

    public Manager() {
    }

    public Manager(long managerId, String managerName, String managerFamily, String managerNationalCode, String managerCellPhone) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerFamily = managerFamily;
        this.managerNationalCode = managerNationalCode;
        this.managerCellPhone = managerCellPhone;
    }

    public Manager(String managerName, String managerFamily, String managerNationalCode, String managerCellPhone) {
        this.managerName = managerName;
        this.managerFamily = managerFamily;
        this.managerNationalCode = managerNationalCode;
        this.managerCellPhone = managerCellPhone;
    }

    public long getManagerId() {
        return managerId;
    }

    public Manager setManagerId(long managerId) {
        this.managerId = managerId;
        return this;
    }

    public String getManagerName() {
        return managerName;
    }

    public Manager setManagerName(String managerName) {
        this.managerName = managerName;
        return this;
    }

    public String getManagerFamily() {
        return managerFamily;
    }

    public Manager setManagerFamily(String managerFamily) {
        this.managerFamily = managerFamily;
        return this;
    }

    public String getManagerNationalCode() {
        return managerNationalCode;
    }

    public Manager setManagerNationalCode(String managerNationalCode) {
        this.managerNationalCode = managerNationalCode;
        return this;
    }

    public String getManagerCellPhone() {
        return managerCellPhone;
    }

    public Manager setManagerCellPhone(String managerCellPhone) {
        this.managerCellPhone = managerCellPhone;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
