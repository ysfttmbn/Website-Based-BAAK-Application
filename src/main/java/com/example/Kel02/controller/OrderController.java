package com.example.Kel02.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kel02.model.Order;
import com.example.Kel02.model.Produk;
import com.example.Kel02.model.User;
import com.example.Kel02.service.LoginService;
import com.example.Kel02.service.OrderService;
import com.example.Kel02.service.ProdukService;


@RestController
@RequestMapping("/order")
public class OrderController {
	 @Autowired
    private  OrderService orderService;
	 
	 @Autowired
	 private LoginService userService;

	 @Autowired
	 private ProdukService produkService;


    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> orderList = orderService.getAllOrder();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    	User user;
    	Produk produk;
    	user = order.getUser();
    	produk = order.getProduk();
    	User getnewUser = userService.getUserById(user.getId());
    	Produk getnewProduk = produkService.getProdukById(produk.getId());
    	order.setUser(getnewUser);
    	order.setProduk(getnewProduk);
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order updated = orderService.updateOrder(id, updatedOrder);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrderByUser(@PathVariable Long userId) {
        List<Order> orderList = orderService.getOrderByUser(userId);

        if (orderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        }
    }
    // New endpoint to update status

}
