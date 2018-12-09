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

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

@Path("orders")
public class OrdersResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getOrders() throws MalformedURLException, RemoteException, NotBoundException, SQLException {

		DatabaseService s = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/Service");

		//s.createOrder(2, "2011-12-17", 2, 3);

		//s.deleteOrder(2);

		//s.updateOrder(1, 1, 2, "1997-09-02");

		return s.readOrder();
	}
	
}
