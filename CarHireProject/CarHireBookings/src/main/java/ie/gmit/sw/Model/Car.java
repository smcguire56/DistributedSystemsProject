package ie.gmit.sw.Model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private int carID;
	private String car_colour;
	private String car_brand;
	private String car_model;
	private Date car_PurchaseDate;

	public Car() {
		super();
	}

	public Car(int carID, String car_colour, String car_brand, String car_model, Date car_PurchaseDate) {
		super();
		this.carID = carID;
		this.car_colour = car_colour;
		this.car_brand = car_brand;
		this.car_model = car_model;
		this.car_PurchaseDate = car_PurchaseDate;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCar_colour() {
		return car_colour;
	}

	public void setCar_colour(String car_colour) {
		this.car_colour = car_colour;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public Date getCar_PurchaseDate() {
		return car_PurchaseDate;
	}

	public void setCar_PurchaseDate(Date car_PurchaseDate) {
		this.car_PurchaseDate = car_PurchaseDate;
	}

}
