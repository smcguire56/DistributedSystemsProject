package ie.gmit.sw.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;

@Service
public class carService {

	// these are the models
	// private Customer customer;
	// private Car car;
	public static List<Car> getAllCars() {
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/CarHireBookings/webapi/customers/");

		return webResource.get(new GenericType<List<Car>>() {
		});

	}

	public void addCar(Car car) {
		Client client = Client.create();

		WebResource web = client.resource("http://localhost:8080/CarHireBookings/webapi/orders/create/");

		Date date = new Date();
		car.setCarPurchaseDate(date);

		ClientResponse response = web.type("application/xml").post(ClientResponse.class, date);

		System.out.println("Response code: " + response.getStatus());
	}

	public void updateOrder(Order order) {
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/CarHireBookings/webapi/orders/update");

		ClientResponse response = webResource.type("application/xml").put(ClientResponse.class, order);

		System.out.println("Response code: " + response.getStatus());

		if (response.getStatus() != 200) {
			throw new RuntimeException("error " + response.getStatus());
		}
	}

}