package ie.gmit.sw.CarHireBookings;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

	// ###############################################################################################################################
	// ORDER
	// ###############################################################################################################################

	@Override
	public void createOrder(Date date, int custId, int carId) throws RemoteException, SQLException {
		String sql = "insert into Orders (Date, CustID, CarID) values (?, ?, ?)";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = format.format(new Date());

		System.out.println(newDate);

		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, newDate);
		p.setInt(2, custId);
		p.setInt(3, carId);
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
	public void updateOrder(int orderId, int custId, int carId, Date date) throws RemoteException, SQLException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = format.format(new Date());

		String sql = "UPDATE Orders SET custId = ?, carId = ?, Date = ? WHERE orderId = ?";

		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, custId);
		p.setInt(2, carId);
		p.setString(3, newDate);
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

	// ###############################################################################################################################
	// CAR
	// ###############################################################################################################################

	@Override
	public void createCar(String carColour, String carBrand, String carModel, Date carPurchaseDate)
			throws RemoteException, SQLException {
		String sql = "insert into car (car_colour, car_brand, car_model, car_PurchaseDate) values (?, ?, ?, ?)";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = format.format(new Date());

		System.out.println(newDate);

		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, carColour);
		p.setString(2, carBrand);
		p.setString(3, carModel);
		p.setString(4, newDate);
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
			String carColour = results.getString("car_colour");
			String carBrand = results.getString("car_brand");
			String carModel = results.getString("car_model");
			Date carPurchaseDate = results.getDate("car_PurchaseDate");

			Car s = new Car(carID, carColour, carBrand, carModel, carPurchaseDate);
			list.add(s);
		}

		return list;
	}

	@Override
	public void updateCar(int carID, String carColour, String carBrand, String carModel, Date carPurchaseDated)
			throws RemoteException, SQLException {

		String sql = "UPDATE Car SET car_colour = ?, car_brand = ?, car_model = ?, car_PurchaseDate = ? WHERE carID = ?";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = format.format(new Date());

		System.out.println(newDate);

		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, carColour);
		p.setString(2, carBrand);
		p.setString(3, carModel);
		p.setString(4, newDate);
		p.setInt(5, carID);
		p.execute();
		p.close();
	}

	@Override
	public void deleteCar(int orderId) throws RemoteException, SQLException {

		PreparedStatement p = conn.prepareStatement("DELETE FROM Car WHERE carID = ?");
		p.setInt(1, orderId);
		p.executeUpdate();
		p.close();
	}

	// ###############################################################################################################################
	// CUSTOMER
	// ###############################################################################################################################

	@Override
	public List<Customer> readCustomer() throws RemoteException, SQLException {
		statement = conn.createStatement();
		List<Customer> list = new ArrayList<>();

		String str = "select * from customers order by custID";

		ResultSet results = statement.executeQuery(str);

		while (results.next()) {
			int custID = results.getInt("custID");
			String custFirstName = results.getString("cust_firstName");
			String custLastName = results.getString("cust_lastName");
			int custMobile = results.getInt("cust_mobile");
			String custAddress = results.getString("cust_address");
			String custEmail = results.getString("cust_email");

			Customer s = new Customer(custID, custFirstName, custLastName, custMobile, custAddress, custEmail);
			list.add(s);
		}

		for (Customer customer : list) {
			System.out.println(customer.getCustAddress());
		}

		return list;
	}

	@Override
	public void deleteCustomer(int custID) throws RemoteException, SQLException {
		PreparedStatement p = conn.prepareStatement("DELETE FROM Customers WHERE custID = ?");
		p.setInt(1, custID);
		p.executeUpdate();
		p.close();
	}

	@Override
	public void createCustomer(String custFirstName, String custLastName, int custMobile, String custAddress,
			String custEmail) throws RemoteException, SQLException {
		String sql = "insert into Customers (cust_firstName, cust_lastName, cust_mobile, cust_address, cust_email) values (?, ?, ?, ?, ?)";

		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, custFirstName);
		p.setString(2, custLastName);
		p.setInt(3, custMobile);
		p.setString(4, custAddress);
		p.setString(5, custEmail);
		p.execute();
		p.close();
	}

	@Override
	public void updateCustomer(int custID, String custFirstName, String custLastName, int custMobile,
			String custAddress, String custEmail) throws RemoteException, SQLException {
		String sql = "UPDATE Customers SET cust_firstName = ?, cust_lastName = ?, cust_mobile = ?, cust_address = ?, cust_email = ? WHERE custID = ?";

		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, custFirstName);
		p.setString(2, custLastName);
		p.setInt(3, custMobile);
		p.setString(4, custAddress);
		p.setString(5, custEmail);
		p.setInt(6, custID);
		p.execute();
		p.close();
	}

}
