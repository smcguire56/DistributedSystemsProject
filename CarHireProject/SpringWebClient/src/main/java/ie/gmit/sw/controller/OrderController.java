package ie.gmit.sw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.gmit.sw.Model.Car;
import ie.gmit.sw.Model.Customer;
import ie.gmit.sw.Model.Order;
import ie.gmit.sw.services.OrderService;
import ie.gmit.sw.services.carService;
import ie.gmit.sw.services.customerService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String createOrder(Model model) {

		Order order = new Order();

		model.addAttribute("order", order);
		return "createOrder";
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addOrderPOST(@Valid @ModelAttribute("Order") Order order) {
		orderService.addOrder(order);
		return "redirect:viewOrder";
	}

	@RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(Model model) {

		this.orderService = new OrderService();
		List<Order> orders = orderService.getAllOrders();

		model.addAttribute("orders", orders);
		return "viewOrder";
	}

	@RequestMapping(value = "/updateOrder", method = RequestMethod.GET)
	public String updateOrder(Model model, @ModelAttribute("booking") Order order) {

		List<Order> orders = orderService.getAllOrders();
		Map<Integer, String> orderList = new HashMap<Integer, String>();
		for (Order o : orders) {
			orderList.put(o.getOrderID(), o.getDate() + " " + o.getCust() + " " + o.getCar());
		}
		
		List<Customer> customers = customerService.getAllCustomers();
		
		Map<Integer, String> customerList = new HashMap<Integer, String>();

		for (Customer customer : customers) {
			customerList.put(customer.getCustID(), customer.getCustFirstName() + " " + customer.getCustLastName() + " " + customer.getCustMobile()  + " " + customer.getCustEmail());
		}

		List<Car> cars = carService.getAllCars();
		Map<Integer, String> carList = new HashMap<Integer, String>();

		for (Car car : cars) {
			carList.put(car.getCarID(), car.getCarModel() + " " + car.getCarBrand() + " " + car.getCarColour() + " "+ car.getCarPurchaseDate());
		}

		model.addAttribute("orders", orders);
		model.addAttribute("ordersList", orderList);
		model.addAttribute("customerList", customerList);
		model.addAttribute("carList", carList);
		


		return "updateOrder";
	}
}
