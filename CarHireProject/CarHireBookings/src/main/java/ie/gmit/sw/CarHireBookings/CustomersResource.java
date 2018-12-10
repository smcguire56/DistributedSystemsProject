package ie.gmit.sw.CarHireBookings;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Customer;


@Path("customers")
public class CustomersResource {
	
	
	DatabaseService s;

	public CustomersResource() throws MalformedURLException, RemoteException, NotBoundException {

		this.s = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/Service");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
//	public Response getCustomers() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
	public List<Customer> getCustomers() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		List<Customer> customer = s.readCustomer();
		
		//final GenericEntity<List<Customer>> entity = new GenericEntity<List<Customer>>(customer) {};
		
//		return Response.status(200).entity(entity).build();
		return customer;
	}
	

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	public void createCustomer(Customer o) throws SQLException, RemoteException {
				
		s.createCustomer(o.getCustFirstName(), o.getCustLastName(), o.getCustMobile(), o.getCustAddress(), o.getCustEmail());
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteCustomer(Customer o) throws SQLException, RemoteException {
		s.deleteCustomer(o.getCustID());
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateCustomer(Customer o) throws SQLException, RemoteException {
		s.updateCustomer(o.getCustID(), o.getCustFirstName(), o.getCustLastName(), o.getCustMobile(), o.getCustAddress(), o.getCustEmail());
	}
	
	
	
	
}


