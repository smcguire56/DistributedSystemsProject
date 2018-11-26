Create DATABASE CarBookingSQL;

USE CarBookingSQL;

CREATE TABLE IF NOT EXISTS Customers (
    custID int NOT NULL AUTO_INCREMENT,
    cust_firstName VARCHAR(255) NOT NULL,
	cust_lastName VARCHAR(255) NOT NULL,
    cust_mobile VARCHAR(255),
	cust_address VARCHAR(255),
	cust_email VARCHAR(255),
    PRIMARY KEY (CustID)
);

CREATE TABLE IF NOT EXISTS car (
	carID int NOT NULL AUTO_INCREMENT,
	car_colour VARCHAR(255) NOT NULL,
	car_brand VARCHAR(255) NOT NULL,
	car_model VARCHAR(255) NOT NULL,
	car_PurchaseDate DATE,
	PRIMARY KEY (CarID)
);

CREATE TABLE IF NOT EXISTS Orders (
    OrderID int NOT NULL AUTO_INCREMENT,
	Date DATE Not Null,
    CustID int Not Null,
	CarID int Not Null,
	UNIQUE(OrderID),
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustID) REFERENCES Customers(CustID),
	FOREIGN KEY (CarID) REFERENCES car(CarID)
);

 INSERT INTO Customers (cust_firstName, cust_lastName, cust_mobile, cust_address, cust_email)
VALUES ('sean','mcguire','123456789','galway','seanmcguire@gmail.ie'),
	   ('john','smith','987654321','dublin','johnsmith@hotmail.ie'),
	   ('Jim','hill','35796789942','cork','banana@gmail.com');

INSERT INTO CAR (car_colour, car_brand, car_model, car_PurchaseDate)
VALUES ('Blue','Juke','2012',CURDATE()),
	   ('red','Nissan ','2011',CURDATE()),
	   ('white','Hyundai','2001',CURDATE());
	   


INSERT INTO Orders (Date, CustID, CarID)
VALUES (CURDATE(),1,2),
	   (CURDATE(),3,4),
	   (CURDATE(),5,6);
	   (CURDATE(),6,7);

	   
INSERT INTO Orders (Date, CustID, CarID)
VALUES (CURDATE(),1,2),
	   (CURDATE(),3,4),
	   (CURDATE(),5,6),
	   (CURDATE(),7,8),
	   (CURDATE(),9,10);
