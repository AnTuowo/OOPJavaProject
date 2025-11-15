/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.restaurant.controller;

import com.restaurant.dao.MenuDAO;
import com.restaurant.model.MenuItem;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private MenuDAO dao = new MenuDAO();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        List<MenuItem> menu = dao.getAll();
        req.setAttribute("menuList", menu);
        RequestDispatcher rd = req.getRequestDispatcher("/pages/menu.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String action = req.getParameter("action");
        
        if("create".equals(action)){
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String cat = req.getParameter("category");
            MenuItem m = new MenuItem();
            m.setName(name);
            m.setPrice(price);
            m.setCategory(cat);
            dao.insert(m);
            resp.sendRedirect(req.getContextPath()+"/menu");
            
        } else if("delete".equals(action)){
            int id = Integer.parseInt(req.getParameter("itemID"));
            dao.delete(id);
            resp.sendRedirect(req.getContextPath()+"/menu");
            
        } else if("update".equals(action)){
            int id = Integer.parseInt(req.getParameter("itemID"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String cat = req.getParameter("category");
            MenuItem m = new MenuItem(id, name, price, cat);
            dao.update(m);
            resp.sendRedirect(req.getContextPath()+"/menu");
            
        } else {
            resp.sendError(400);
        }
    }
}