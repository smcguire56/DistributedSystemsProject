//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.08 at 05:50:05 PM GMT 
//


package ie.gmit.sw.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="car_colour" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="car_brand" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="car_model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="car_PurchaseDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "carID",
    "carColour",
    "carBrand",
    "carModel",
    "carPurchaseDate"
})
@XmlRootElement(name = "Car")
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int carID;
    @XmlElement(name = "carColour", required = true)
    protected String carColour;
    @XmlElement(name = "carBrand", required = true)
    protected String carBrand;
    @XmlElement(name = "carModel", required = true)
    protected String carModel;
    @XmlElement(name = "carPurchaseDate", required = true)
    @XmlSchemaType(name = "date")
    protected Date carPurchaseDate;
    
    

    public Car() {
		super();
	}

	public Car(int carID, String carColour, String carBrand, String carModel, Date carPurchaseDate) {
		super();
		this.carID = carID;
		this.carColour = carColour;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carPurchaseDate = carPurchaseDate;
	}

	/**
     * Gets the value of the carID property.
     * 
     */
    public int getCarID() {
        return carID;
    }

    /**
     * Sets the value of the carID property.
     * 
     */
    public void setCarID(int value) {
        this.carID = value;
    }

    /**
     * Gets the value of the carColour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarColour() {
        return carColour;
    }

    /**
     * Sets the value of the carColour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarColour(String value) {
        this.carColour = value;
    }

    /**
     * Gets the value of the carBrand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarBrand() {
        return carBrand;
    }

    /**
     * Sets the value of the carBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarBrand(String value) {
        this.carBrand = value;
    }

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarModel(String value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the carPurchaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getCarPurchaseDate() {
        return carPurchaseDate;
    }

    /**
     * Sets the value of the carPurchaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setCarPurchaseDate(Date value) {
        this.carPurchaseDate = value;
    }

}
