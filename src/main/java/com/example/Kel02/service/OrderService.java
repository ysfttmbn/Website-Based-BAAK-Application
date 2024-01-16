package com.example.Kel02.service;


import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kel02.model.Order;
import com.example.Kel02.model.Produk;
import com.example.Kel02.model.User;
import com.example.Kel02.repository.OrderRepository;
import com.example.Kel02.repository.ProdukRepository;
import com.example.Kel02.repository.UserRepository;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setUser(updatedOrder.getUser());
            order.setProduk(updatedOrder.getProduk());
            order.setJenisPembayaran(updatedOrder.getJenisPembayaran());
            order.setTotal(updatedOrder.getTotal());
            order.setAkunPengirim(updatedOrder.getAkunPengirim());
            return orderRepository.save(order);
        } else {
            // Handle the case when the Order with the given id is not found
            return null;
        }
    }
	public Order getOrder(long id) {
		return orderRepository.findById(id).get();
	}

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    
    public List<Order> getOrderByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Order existingOrder) {
		// TODO Auto-generated method stub
		
	}
    
}
