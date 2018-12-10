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

import ie.gmit.sw.Model.Car;

@Path("cars")
public class CarsResource {
	
	DatabaseService s;

	public CarsResource() throws MalformedURLException, RemoteException, NotBoundException {

		this.s = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/Service");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Car> getCars() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
		return s.readCar();
	}
	

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	public void createCar(Car o) throws SQLException, RemoteException {
		s.createCar(o.getCarColour(), o.getCarBrand(), o.getCarModel(), o.getCarPurchaseDate());
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteCar(Car o) throws SQLException, RemoteException {
		s.deleteCar(o.getCarID());
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateCar(Car o) throws SQLException, RemoteException {
		s.updateCar(o.getCarID(), o.getCarColour(), o.getCarBrand(), o.getCarModel(), o.getCarPurchaseDate());
	}
	
}
