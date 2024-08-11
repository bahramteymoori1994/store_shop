package storeshop;

import storeshop.controllers.CustomerController;

public class Main {
    public static void main(String[] args) throws Exception {

        //        Customer customer = new Customer();
//        customer
//                .setCustomerName("jaber")
//                .setCustomerFamily(null)
//                .setCustomerNationalCode("9999333210")
//                .setCustomerCellPhone("09123330011")
//                .setCustomerEmail("jaber.jabari@gmail.com");

        CustomerController customerController = new CustomerController();
        System.out.println(customerController.findById(8));

        //        if( customerController.add(customer) == null )
//        {
//            System.out.println("Data is not added");
//        }
//        else
//        {
//            System.out.println(customerController.add(customer));
//        }
    }
}