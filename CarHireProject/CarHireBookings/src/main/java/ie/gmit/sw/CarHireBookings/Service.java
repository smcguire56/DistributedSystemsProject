package ie.gmit.sw.CarHireBookings;

import java.rmi.*;

public interface Service extends Remote {

	public String create(String s) throws RemoteException;
	public void read()  throws RemoteException;
	public String update(String s)  throws RemoteException;
	public String delete(String s)  throws RemoteException;
	
}
