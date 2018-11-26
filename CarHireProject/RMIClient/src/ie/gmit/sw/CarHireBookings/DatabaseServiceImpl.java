package ie.gmit.sw.CarHireBookings;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public String create(String s) throws RemoteException {
		return null;
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		
		statement = conn.createStatement();
		List<Order> list = new ArrayList<>();
		
		String str = "select * from orders order by orderid";
		
		ResultSet results = statement.executeQuery(str);
		
		while(results.next()) {
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
	public String update(String s) throws RemoteException {
		return null;
	}

	@Override
	public String delete(String s) throws RemoteException {
		return null;
	}

}
