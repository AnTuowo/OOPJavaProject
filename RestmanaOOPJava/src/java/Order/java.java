/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurant.model;
import java.util.*;

public class Order {
    private int orderID;
    private Integer customerID;
    private Integer tableID;
    private double totalAmount;
    private String orderStatus;
    private Date createdAt;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {}
    
    public void calculateTotal() {
        totalAmount = 0;
        for (OrderItem it : items) {
            totalAmount += it.getPrice() * it.getQuantity();
        }
    }
    
    // Getters and Setters
    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }
    public Integer getCustomerID() { return customerID; }
    public void setCustomerID(Integer customerID) { this.customerID = customerID; }
    public Integer getTableID() { return tableID; }
    public void setTableID(Integer tableID) { this.tableID = tableID; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}