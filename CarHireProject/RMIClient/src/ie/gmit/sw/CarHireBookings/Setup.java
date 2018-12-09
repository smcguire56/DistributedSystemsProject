package ie.gmit.sw.CarHireBookings;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

public class Setup {
	public static void main(String[] args) throws RemoteException, MalformedURLException, SQLException {

		DatabaseService s = new DatabaseServiceImpl();

		LocateRegistry.createRegistry(1099);

		Naming.rebind("Service", s);

		System.out.println("Server Ready");
	}
}
