package storeshop.model.entities;

import com.google.gson.Gson;

public class Employee {
    private long employeeId;
    private long managerId;
    private String employeeName;
    private String employeeFamily;
    private String employeeCellPhone;

    public Employee() {
    }

    public Employee(long employeeId, long managerId, String employeeName, String employeeFamily, String employeeCellPhone) {
        this.employeeId = employeeId;
        this.managerId = managerId;
        this.employeeName = employeeName;
        this.employeeFamily = employeeFamily;
        this.employeeCellPhone = employeeCellPhone;
    }

    public Employee(long managerId, String employeeName, String employeeFamily, String employeeCellPhone) {
        this.managerId = managerId;
        this.employeeName = employeeName;
        this.employeeFamily = employeeFamily;
        this.employeeCellPhone = employeeCellPhone;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public long getManagerId() {
        return managerId;
    }

    public Employee setManagerId(long managerId) {
        this.managerId = managerId;
        return this;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Employee setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public String getEmployeeFamily() {
        return employeeFamily;
    }

    public Employee setEmployeeFamily(String employeeFamily) {
        this.employeeFamily = employeeFamily;
        return this;
    }

    public String getEmployeeCellPhone() {
        return employeeCellPhone;
    }

    public Employee setEmployeeCellPhone(String employeeCellPhone) {
        this.employeeCellPhone = employeeCellPhone;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
