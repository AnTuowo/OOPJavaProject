/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurant.model;

/**
 *
 * @author nnnhi
 */
public class MenuItem {
     private int itemID;
    private String name;
    private double price;
    private String category;
    // constructors
    public MenuItem() {}
    public MenuItem(int itemID, String name, double price, String category) {
        this.itemID = itemID; this.name = name; this.price = price; this.category = category;
    }
    // getters/setters
    public int getItemID() { return itemID; }
    public void setItemID(int itemID) { this.itemID = itemID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
