package storeshop.model.entities;

import com.google.gson.Gson;

public class Storage {
    private long storageId;
    private long manager_id;
    private long employee_id;

    public Storage() {
    }

    public Storage(long storageId, long manager_id, long employee_id) {
        this.storageId = storageId;
        this.manager_id = manager_id;
        this.employee_id = employee_id;
    }

    public Storage(long manager_id, long employee_id) {
        this.manager_id = manager_id;
        this.employee_id = employee_id;
    }

    public long getStorageId() {
        return storageId;
    }

    public Storage setStorageId(long storageId) {
        this.storageId = storageId;
        return this;
    }

    public long getManager_id() {
        return manager_id;
    }

    public Storage setManager_id(long manager_id) {
        this.manager_id = manager_id;
        return this;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public Storage setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
