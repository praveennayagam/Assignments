package com.mphasis.dao;

import java.util.List;

import com.mphasis.model.Orders;


public interface OrderDaoInterface {
    
    // Fetch all orders
    public List<Orders> findAll();
    
    // Find order by ID
    public Orders findById(int id);
    
    // Add a new order
    public void addOrder(Orders order);
    
    // Update an existing order
    public Orders updateOrder(Orders order, int id);
    
    // Delete an order by ID
    public void deleteOrder(int id);
    
    // Find orders by customer name (or customer id, depending on your model)
    public List<Orders> findByCustomer(String customer);
    
    // Find orders by filters (e.g., status, date, amount)
    public List<Orders> findByFilters(String status, String date, double amount);
}
