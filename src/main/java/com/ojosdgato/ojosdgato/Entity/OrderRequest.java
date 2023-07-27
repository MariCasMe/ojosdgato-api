package com.ojosdgato.ojosdgato.Entity;


//DTO
public class OrderRequest {

	private int shipping;
	private int status;
	private String comment;

	private Long id_serviceorder;
	private Long id_productorder;
	private Long id_user;
	//Getters y setters
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
	public Long getId_serviceorder() {
		return id_serviceorder;
	}
	public void setId_serviceorder(Long id_serviceorder) {
		this.id_serviceorder = id_serviceorder;
	}
	public Long getId_productorder() {
		return id_productorder;
	}
	public void setId_productorder(Long id_productorder) {
		this.id_productorder = id_productorder;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	
}
