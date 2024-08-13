package storeshop.exception;

import storeshop.model.entities.Customer;
import storeshop.model.entities.Employee;
import storeshop.model.entities.Manager;
import storeshop.model.entities.Storage;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ExceptionWrapper
{
    public static String getMessage(Object o, Exception e)
    {
        if( ((SQLException) e).getErrorCode() == 1017 && ((SQLException) e).getSQLState().equals("72000") )
        {
            return "Connection not working";
        }

        else if( e instanceof SQLException && o instanceof Customer)
        {
            if( ((SQLException) e).getErrorCode() == 17289 )
            {
                return "Customer Not Found...!";
            }
        }
        else if( e instanceof SQLException && o instanceof Manager)
        {
            if( ((SQLException) e).getErrorCode() == 17041 )
            {
                return "Manager Not Found...!";
            }
        }
        else if( e instanceof SQLException && o instanceof Employee)
        {
            if( ((SQLException) e).getErrorCode() == 17289 )
            {
                return "Employee Not Found...!";
            }
        }
        else if( e instanceof SQLException && o instanceof Storage )
        {
            if( ((SQLException) e).getErrorCode() == 17289 && ((SQLException) e).getSQLState().equals("99999") )
            {
                return "Storage Not Found...!";
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

        else if( o instanceof Manager )
        {
            if( ((Manager) o).getManagerName() == null )
            {
                return "Manager name is required";
            }
            else if( ((Manager) o).getManagerFamily() == null )
            {
                return "manager family is required";
            }
            else if( ((Manager) o).getManagerNationalCode() == null )
            {
                return "Manager national code is required";
            }
            else if( ((Manager) o).getManagerCellPhone() == null )
            {
                return "manager cell phone is required";
            }
            else if( e.getErrorCode() == 1 && e.getSQLState().equals("23000") )
            {
                return "Unique key has duplicated";
            }
        }

        else if( o instanceof Employee )
        {
            if( ((Employee) o).getManagerId() == 0 )
            {
                return "Manager id is required";
            }
            else if( ((Employee) o).getEmployeeName() == null )
            {
                return "Employee name is required";
            }
            else if( ((Employee) o).getEmployeeFamily() == null )
            {
                return "Employee family is required";
            }
            else if( ((Employee) o).getEmployeeCellPhone() == null )
            {
                return "Employee cell phone is required";
            }
            else if( e.getErrorCode() == 1 && e.getSQLState().equals("23000") )
            {
                return "Unique key has duplicated";
            }
        }

        else if( o instanceof Storage )
        {
            if( ((Storage) o).getEmployee_id() == 0)
            {
                return "Employee id must not be 0";
            }
            else if( ((Storage) o).getManager_id() == 0 )
            {
                return "Manager id must not be 0";
            }
        }

        return "Invalid Error...!";
    }
}