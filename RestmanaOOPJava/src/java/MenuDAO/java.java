/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurant.dao;
import com.restaurant.model.MenuItem;
import com.restaurant.util.DBConnection;
import java.sql.*;
import java.util.*;

public class MenuDAO {
    public List<MenuItem> getAll() {
        List<MenuItem> list = new ArrayList<>();
        String sql = "SELECT * FROM MenuItem";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MenuItem m = new MenuItem();
                m.setItemID(rs.getInt("itemID"));
                m.setName(rs.getString("name"));
                m.setPrice(rs.getDouble("price"));
                m.setCategory(rs.getString("category"));
                list.add(m);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public MenuItem getById(int id) {
        String sql = "SELECT * FROM MenuItem WHERE itemID=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             ps.setInt(1,id);
             try(ResultSet rs=ps.executeQuery()){
               if(rs.next()){
                   return new MenuItem(rs.getInt("itemID"),rs.getString("name"),
                                     rs.getDouble("price"),rs.getString("category"));
               }
             }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public boolean insert(MenuItem m) {
        String sql = "INSERT INTO MenuItem(name,price,category) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, m.getName());
            ps.setDouble(2, m.getPrice());
            ps.setString(3, m.getCategory());
            int affected = ps.executeUpdate();
            if (affected == 0) return false;
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) m.setItemID(keys.getInt(1));
            }
            return true;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(MenuItem m) {
        String sql = "UPDATE MenuItem SET name=?, price=?, category=? WHERE itemID=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             ps.setString(1,m.getName());
             ps.setDouble(2,m.getPrice());
             ps.setString(3,m.getCategory());
             ps.setInt(4,m.getItemID());
             return ps.executeUpdate() > 0;
        } catch(SQLException e){ e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM MenuItem WHERE itemID=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             ps.setInt(1,id);
             return ps.executeUpdate() > 0;
        } catch(SQLException e){ e.printStackTrace(); return false; }
    }
}