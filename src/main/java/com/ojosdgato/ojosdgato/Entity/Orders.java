package com.ojosdgato.ojosdgato.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_order", unique=true, nullable=false)
	private Long id_order;
	@Column(nullable=false)
	private int shipping;
	@Column(nullable=false)
	private int status;
	@Column (nullable=true)
	private String comment;
	
	public Orders() {super();}
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id_user", nullable = false)
	@JsonBackReference(value="user-order")
    private User user;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "service_order_id_serviceorder", referencedColumnName="id_serviceorder",nullable = false)
	@JsonBackReference(value="serviceorder-order")
	private ServiceOrder serviceOrder;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name= "product_order_id_productorder", referencedColumnName="id_productorder",nullable=false)
	@JsonBackReference(value="productorder-order")
	private ProductOrder productOrder;
	
	

	public Long getId_order() {
		return id_order;
	}

	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}

	public int getShipping() {
		return shipping;
	}

	public void setShipping(int shipping) {
		this.shipping = shipping;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ServiceOrder getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder(ServiceOrder serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	public ProductOrder getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(ProductOrder productOrder) {
		this.productOrder = productOrder;
	}


	
}
