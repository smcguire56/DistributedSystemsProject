package ie.gmit.sw.CarHireBookings;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Setup {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		Service s = new ServiceImpl();
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("Service", s);
		
		System.out.println("Server Ready");
	}
}
