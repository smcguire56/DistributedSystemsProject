package ie.gmit.sw.CarHireBookings;

import java.rmi.*;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;


public interface DatabaseService extends Remote {

	public String create(String s) throws RemoteException;
	public List<Order> read()  throws RemoteException, SQLException;
	public String update(String s)  throws RemoteException;
	public String delete(String s)  throws RemoteException;
	
}
