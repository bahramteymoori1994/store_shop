package storeshop;

import storeshop.controllers.CustomerController;
import storeshop.controllers.ManagerController;
import storeshop.model.entities.Manager;

public class Main {
    public static void main(String[] args) throws Exception {

        Manager manager = new Manager();
        manager
                .setManagerName("farzad")
                .setManagerFamily("farzadi")
                .setManagerNationalCode("7775300000")
                .setManagerCellPhone("09127775522");

        ManagerController managerController = new ManagerController();
        System.out.println(managerController.findAll());
    }
}