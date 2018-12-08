package ie.gmit.sw.CarHireBookings;

import java.rmi.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {

	// orders
	public void createOrder(int orderId, String date, int custId, int carId) throws RemoteException, SQLException;
	public List<Order> readOrder()  throws RemoteException, SQLException;
	public void updateOrder(int orderId, int custId, int carId, String date) throws RemoteException, SQLException;
	public void deleteOrder(int orderId) throws RemoteException, SQLException;

	// Car 	
	public void createCar(int carID, String carColour, String carBrand, String carModel, Date carPurchaseDate) throws RemoteException, SQLException;
	public List<Order> readCar()  throws RemoteException, SQLException;
	public void updateCar(int carID, String carColour, String carBrand, String carModel, Date carPurchaseDated) throws RemoteException, SQLException;
	public void deleteCar(int orderId) throws RemoteException, SQLException;
		
	
	
	// Customer
	public void createCustomer(String d, int custId, int carId) throws RemoteException, SQLException;
	public List<Order> readCustomer()  throws RemoteException, SQLException;
	public void updateCustomer(int orderId, int custId, int carId) throws RemoteException, SQLException;
	public void deleteCustomer(int orderId) throws RemoteException, SQLException;
		
}
