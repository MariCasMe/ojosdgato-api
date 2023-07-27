package com.ojosdgato.ojosdgato.Service;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ojosdgato.ojosdgato.Entity.OrderRequest;
import com.ojosdgato.ojosdgato.Entity.Orders;
import com.ojosdgato.ojosdgato.Entity.ProductOrder;
import com.ojosdgato.ojosdgato.Entity.ServiceOrder;
import com.ojosdgato.ojosdgato.Entity.User;
import com.ojosdgato.ojosdgato.Repository.OrderRepository;
import com.ojosdgato.ojosdgato.Repository.ProductOrderRepository;
import com.ojosdgato.ojosdgato.Repository.ServiceOrderRepository;
import com.ojosdgato.ojosdgato.Repository.UserRepository;

@Service
public class OrderService {
	
	private  OrderRepository ordersRepository;
	private  ProductOrderRepository productorderRepository;
	private  ServiceOrderRepository serviceorderRepository;
	private  UserRepository userRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository, ProductOrderRepository productorderRepository,
			ServiceOrderRepository serviceorderRepository, UserRepository userRepository) {
		super();
		this.ordersRepository = orderRepository;
		this.productorderRepository = productorderRepository;
		this.serviceorderRepository = serviceorderRepository;
		this.userRepository = userRepository;
	}

/*	//Obtener Get
	public List<Orders> getAllOrders(){
		return orderRepository.findAll();
	}
	
	//Get by ID
	public Orders getOrderById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}
	//Crear Post
	public Orders createOrder(Orders order) {
		return orderRepository.save(order);
	}
	//Actualiza Put
	public Orders updateOrder(Orders order) {
		return orderRepository.save(order);
	}
	
	//Borrar Delete
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	
	}*/
	// POST METHOD
		public Orders createOrder(OrderRequest orderRequest) {
			
			// Get data from users and save them
			int shipping = orderRequest.getShipping();
		    int status = orderRequest.getStatus();
			String comment=orderRequest.getComment();
			Long id_serviceorder = orderRequest.getId_serviceorder();
			Long id_productorder = orderRequest.getId_productorder();
			Long id_user = orderRequest.getId_user();
			
			
			User persistentUser = userRepository.findById(id_user).orElse(null);
			ServiceOrder persistentServiceorder = serviceorderRepository.findById(id_serviceorder).orElse(null);
			ProductOrder persistentProductorder = productorderRepository.findById(id_productorder).orElse(null);
			
			// Construct and populate a new UserHasBook instance
			Orders orders = new Orders();
			
			orders.setShipping(shipping);
			orders.setStatus(status);
			orders.setComment(comment);
			orders.setServiceOrder(persistentServiceorder);
			orders.setProductOrder(persistentProductorder);
			orders.setUser(persistentUser);
			
			// save it
			return ordersRepository.save(orders);
		}
}
