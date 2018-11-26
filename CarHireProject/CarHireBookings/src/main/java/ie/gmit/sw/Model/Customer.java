package ie.gmit.sw.Model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private int custID;
	private String cust_firstName;
	private String cust_lastName;
	private int cust_mobile;
	private String cust_address;
	private String cust_email;
	
	public Customer(int custID, String cust_firstName, String cust_lastName, int cust_mobile, String cust_address,
			String cust_email) {
		super();
		this.custID = custID;
		this.cust_firstName = cust_firstName;
		this.cust_lastName = cust_lastName;
		this.cust_mobile = cust_mobile;
		this.cust_address = cust_address;
		this.cust_email = cust_email;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCust_firstName() {
		return cust_firstName;
	}

	public void setCust_firstName(String cust_firstName) {
		this.cust_firstName = cust_firstName;
	}

	public String getCust_lastName() {
		return cust_lastName;
	}

	public void setCust_lastName(String cust_lastName) {
		this.cust_lastName = cust_lastName;
	}

	public int getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(int cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	


}
