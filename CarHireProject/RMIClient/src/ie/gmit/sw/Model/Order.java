package ie.gmit.sw.Model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private int OrderID;
	private Date date;
	private int cust;
	private int car;
	
	public Order() {
		super();
	}

	public Order(int orderID, Date date, int cust, int car) {
		super();
		OrderID = orderID;
		this.date = date;
		this.cust = cust;
		this.car = car;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCust() {
		return cust;
	}

	public void setCust(int cust) {
		this.cust = cust;
	}

	public int getCar() {
		return car;
	}

	public void setCar(int car) {
		this.car = car;
	}
	

}
