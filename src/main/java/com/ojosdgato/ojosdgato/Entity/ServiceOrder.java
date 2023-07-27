package com.ojosdgato.ojosdgato.Entity;	

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ServiceOrder")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serviceorder", unique = true, nullable = false)
    private Long id_serviceorder;

    @Column(nullable = false)
    private int quantity;

    // Constructor vacio
    public ServiceOrder() {}

    @ManyToOne
    @JoinColumn(name = "Service_id_service", nullable = false)
    private Services service;

    @OneToMany(mappedBy="serviceOrder")
	private List<Orders> orders; 

    // Getters y Setters
    public Long getId_serviceorder() {
        return id_serviceorder;
    }

    public void setId_serviceorder(Long id_serviceorder) {
        this.id_serviceorder = id_serviceorder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

	
}
	
