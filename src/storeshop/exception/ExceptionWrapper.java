package storeshop.exception;

import storeshop.model.entities.Customer;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ExceptionWrapper
{
    public static String getMessage(Object o, Exception e)
    {
        if( e instanceof SQLException && o instanceof Customer)
        {
            if( ((SQLException) e).getErrorCode() == 17289 )
            {
                return "Customer Not Found...!";
            }
        }
        return "Invalid Error";
    }

    public static String getMessage(Object o, SQLIntegrityConstraintViolationException e){
        if( o instanceof Customer)
        {
            if( ((Customer) o).getCustomerName() == null )
            {
                return "customer name is required";
            }
            else if( ((Customer) o).getCustomerFamily() == null )
            {
                return "customer family is required";
            }
            else if( ((Customer) o).getCustomerNationalCode() == null )
            {
                return "customer national code is required";
            }
            else if( ((Customer) o).getCustomerEmail() == null )
            {
                return "customer email is required";
            }
            else if( ((Customer) o).getCustomerCellPhone() == null )
            {
                return "customer cell phone is required";
            }
            else if( e.getErrorCode() == 1 && e.getSQLState().equals("23000") )
            {
                return "Unique key has duplicated";
            }
        }


        return "invalid error";
    }
}