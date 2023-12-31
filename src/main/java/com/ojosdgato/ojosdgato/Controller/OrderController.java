package com.ojosdgato.ojosdgato.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojosdgato.ojosdgato.Entity.OrderRequest;
import com.ojosdgato.ojosdgato.Entity.Orders;
import com.ojosdgato.ojosdgato.Entity.ProductOrder;
import com.ojosdgato.ojosdgato.Entity.ServiceOrder;
import com.ojosdgato.ojosdgato.Entity.User;
import com.ojosdgato.ojosdgato.Service.OrderService;
import com.ojosdgato.ojosdgato.Service.ProductOrderService;
import com.ojosdgato.ojosdgato.Service.ServiceOrderService;
import com.ojosdgato.ojosdgato.Service.UserService;

@RequestMapping(path="/ojosdgato/orders")
@RestController
public class OrderController {
	
	private OrderService orderService;
	private ServiceOrderService serviceOrderService;
	private ProductOrderService productOrderService;
	private UserService userService;
	
	
	@Autowired
	public OrderController(OrderService orderService, ServiceOrderService serviceOrderService,
			ProductOrderService productOrderService, UserService userService) {
		super();
		this.orderService = orderService;
		this.serviceOrderService = serviceOrderService;
		this.productOrderService = productOrderService;
		this.userService = userService;
	}
	
	@GetMapping
	public List<Orders> getOrder(){
		return orderService.getAllOrders();
	}
	
	//Get individual
	@GetMapping("/{id}")
	public Orders getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping
	public Orders createOrder(@RequestBody OrderRequest orderRequest) {
		//Buscar un usuario que haga match en bd
		User persistentUser=userService.getUserById(orderRequest.getId_user());
		//Buscar un servicioPedido que haga match en bd
		ServiceOrder persistentOrderService=serviceOrderService.getServiceOrderById(orderRequest.getId_serviceorder());
		//Buscar un productoPedido que haga match en bd
		ProductOrder persistentProductOrder=productOrderService.getProductOrderById(orderRequest.getId_productorder());
		
		
		
		return orderService.createOrder(orderRequest);
	}
	
/*	//Put
	@PutMapping
	public Orders updateOrder(@RequestBody Orders order) {
		return orderService.updateOrder(order);
	}*/
	
	//Delete
/*	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
	}*/
	
	// OrderRequest es un DTO
		// Data Transfer Object, solamente se utilizan para el proceso de transferencias
	/*	@PostMapping
		public Orders createOrder(@RequestBody OrderRequest orderRequest) {
			return orderService.createOrder(orderRequest);
		}*/
	
}
