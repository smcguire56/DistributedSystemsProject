package ie.gmit.sw.CarHireBookings;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private Connection conn;
	private Statement statement;

	private static final long serialVersionUID = 1L;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carbookingsql?useSSL=false", "root", "");

	}

	@Override
	public void createOrder(int orderId, String date, int custId, int carId) throws RemoteException, SQLException {
		String sql = "insert into Orders(orderId, Date, CustID, CarID) values (?,?, ?, ?)";

		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, orderId);
		p.setString(2, date);
		p.setInt(3, custId);
		p.setInt(4, carId);
		p.execute();
		p.close();
	}

	@Override
	public List<Order> readOrder() throws RemoteException, SQLException {

		statement = conn.createStatement();
		List<Order> list = new ArrayList<>();

		String str = "select * from orders order by orderid";

		ResultSet results = statement.executeQuery(str);

		while (results.next()) {
			int OrderID = results.getInt("OrderID");
			Date Date = results.getDate("Date");
			int cust = results.getInt("CustID");
			int car = results.getInt("CarID");

			Order s = new Order(OrderID, Date, cust, car);
			list.add(s);
		}

		return list;
	}

	@Override
	public void updateOrder(int orderId, int custId, int carId, String date) throws RemoteException, SQLException { // update
																													// date

		System.out.println("Order ID: " + orderId);
		System.out.println("Customer ID: " + custId);
		System.out.println("car ID: " + carId);

		String sql = "UPDATE Orders SET custId = ?, carId = ?, Date = ? WHERE orderId = ?";

		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, custId);
		p.setInt(2, carId);
		p.setString(3, date);
		p.setInt(4, orderId);
		p.execute();
		p.close();

	}

	@Override
	public void deleteOrder(int orderId) throws RemoteException, SQLException {

		PreparedStatement p = conn.prepareStatement("DELETE FROM Orders WHERE orderId = ?");
		p.setInt(1, orderId);
		p.executeUpdate();
		p.close();
	}

	@Override
	public void createCar(int carID, String carColour, String carBrand, String carModel, String carPurchaseDate)
			throws RemoteException, SQLException {
		String sql = "insert into Orders(carID, carColour, carBrand, carModel, carPurchaseDate) values (?,?, ?, ?)";

		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, carID);
		p.setString(2, carColour);
		p.setString(3, carBrand);
		p.setString(4, carModel);
		p.setString(5, carPurchaseDate);
		p.execute();
		p.close();
	}

	@Override
	public List<Car> readCar() throws RemoteException, SQLException {

		statement = conn.createStatement();
		List<Car> list = new ArrayList<>();

		String str = "select * from car order by carID";

		ResultSet results = statement.executeQuery(str);

		while (results.next()) {
			int carID = results.getInt("carID");
			String carColour = results.getString("carColour");
			String carBrand = results.getString("carBrand");
			String carModel = results.getString("carModel");
			Date carPurchaseDate = results.getDate("carPurchaseDate");

			Car s = new Car(carID, carColour, carBrand, carModel, carPurchaseDate);
			list.add(s);
		}

		return list;
	}

	@Override
	public void updateCar(int carID, String carColour, String carBrand, String carModel, String carPurchaseDated)
			throws RemoteException, SQLException {
		String sql = "UPDATE Car SET carColour = ?, carBrand = ?, carModel = ?, carPurchaseDated = ? WHERE carID = ?";

		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, carColour);
		p.setString(2, carBrand);
		p.setString(3, carModel);
		p.setString(4, carPurchaseDated);
		p.setInt(5, carID);
		p.execute();
		p.close();
	}

	@Override
	public void deleteCar(int orderId) throws RemoteException, SQLException {
		
		PreparedStatement p = conn.prepareStatement("DELETE FROM Orders WHERE orderId = ?");
		p.setInt(1, orderId);
		p.executeUpdate();
		p.close();
	}

	@Override
	public List<Customer> readCustomer() throws RemoteException, SQLException {
		statement = conn.createStatement();
		List<Customer> list = new ArrayList<>();

		String str = "select * from customers order by custID";

		ResultSet results = statement.executeQuery(str);

		// int custID, String custFirstName, String custLastName, int custMobile, String custAddress,String custEmail
		while (results.next()) {
			int custID = results.getInt("custID");
			String custFirstName = results.getString("custFirstName");
			String custLastName = results.getString("custLastName");
			int custMobile = results.getInt("custMobile");
			String custAddress = results.getString("custAddress");
			String custEmail = results.getString("custEmail");

			Customer s = new Customer(custID, custFirstName, custLastName, custMobile, custAddress, custEmail);
			list.add(s);
		}

		return list;
	}

	@Override
	public void deleteCustomer(int orderId) throws RemoteException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCustomer(int custID, String custFirstName, String custLastName, int custMobile,
			String custAddress, String custEmail) throws RemoteException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomer(int custID, String custFirstName, String custLastName, int custMobile,
			String custAddress, String custEmail) throws RemoteException, SQLException {
		// TODO Auto-generated method stub

	}

}
