package ie.gmit.sw.CarHireBookings;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Customer;

@Path("Customers")
public class CustomersResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customer> getCustomers() throws MalformedURLException, RemoteException, NotBoundException, SQLException {

		DatabaseService s = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/Service");

		//s.createCustomer(105, "Sean", "Macg", 81456263, "galway", "gmail@gmail.com");

		//s.deleteCustomer(2);

		//s.updateCustomer(101, "Sean", "UPDATED", 81456263, "galway", "gmail@gmail.com");

		return s.readCustomer();
	}
}
