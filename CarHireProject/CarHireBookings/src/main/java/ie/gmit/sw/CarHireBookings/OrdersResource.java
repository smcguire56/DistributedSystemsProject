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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.Model.Order;

@Path("/orders")
public class OrdersResource {
	DatabaseService s;

	public OrdersResource() throws MalformedURLException, RemoteException, NotBoundException {

		this.s = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/Service");
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/")
	public Response getOrders() throws  SQLException, RemoteException {
		
		List<Order> orders = s.readOrder();
		
		final GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(orders) {};
		
		return Response.status(200).entity(entity).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	public void createOrders(Order o) throws SQLException, RemoteException {
		System.out.println("in here: "+ o.getCar());
		s.createOrder(o.getDate(), o.getCust(), o.getCar());
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteOrder(Order o) throws SQLException, RemoteException {
		s.deleteOrder(o.getOrderID());
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateOrder(Order o) throws SQLException, RemoteException {
		s.updateOrder(o.getOrderID(), o.getCust(), o.getCar(), o.getDate());
	}

}
