package com.example.baitapmvc.controller;

import com.example.baitapmvc.model.Product;
import com.example.baitapmvc.service.ProductService;
import com.example.baitapmvc.service.ProductServiceInter;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Product", value = "/products")

public class ProductServlet extends HttpServlet {
    ProductServiceInter productServiceInter = new ProductService();

    public void doGet( HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "find":
                showProductPage(req,resp);
                break;
            default:
                showListProduct(req, resp);
                break;
        }
    }
    private void showProductPage(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/findProduct.jsp");
        dispatcher.forward(req, resp);
    }
    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void showEditForm (HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/edit.jsp");
        requestDispatcher.forward(req,resp);
    }
    private void showListProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Product> productList = productServiceInter.findAll();
        req.setAttribute("pList", productList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/listProduct.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productServiceInter.findById(id);
        req.setAttribute("thisP",product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/delete.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "create" :
                createProduct(req,resp);
                break;
            case "find" :
                showProductByName(req,resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;
            case "delete" :
                deleteProduct(req,resp);
                break;
        }
    }
    private void createProduct(HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException{
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int id = (int) (Math.random() * 100);

        Product product = new Product(id,name,price,description,brand);
        productServiceInter.addProduct(product);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/create.jsp");
        req.setAttribute("message" ,"Create Product Successfully");
        requestDispatcher.forward(req,resp);
    }
    private void showProductByName(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        List<Product> productList = productServiceInter.findAll();
        String name = req.getParameter("findname");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equalsIgnoreCase(name)){
                Product product = productList.get(i);
                req.setAttribute("namePro",product);
            }
            else {
                req.setAttribute("message","Not Found");
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/findProduct.jsp");
        requestDispatcher.forward(req,resp);
    }
    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product(id,name,price,description,brand);
        productServiceInter.editProduct(id,product);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/edit.jsp");
        req.setAttribute("message", "Edit Product Succesfully !!!");
        requestDispatcher.forward(req, resp);
    }
    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        productServiceInter.deleteProduct(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/delete.jsp");
        req.setAttribute("message", "Delete Product Successfully !!!");
        requestDispatcher.forward(req, resp);
    }
}
