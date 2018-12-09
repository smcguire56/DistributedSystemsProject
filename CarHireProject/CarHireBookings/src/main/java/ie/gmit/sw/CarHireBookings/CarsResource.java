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

@Path("cars")
public class CarsResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Car> getCars() throws MalformedURLException, RemoteException, NotBoundException, SQLException {

		DatabaseService s = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/Service");

		//s.createCar(102, "test", "test", "test", "2018-12-27");

		//s.deleteCar(2);

		//s.updateCar(3, "testUpdate", "testUpdate", "testUpdate", "2018-12-27");

		return s.readCar();
	}
	
	
}
