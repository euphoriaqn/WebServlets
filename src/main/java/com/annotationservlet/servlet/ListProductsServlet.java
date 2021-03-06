package com.annotationservlet.servlet;

import com.annotationservlet.entity.Product;
import com.annotationservlet.storage.HibernateProductStorage;
import com.annotationservlet.storage.IProductStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class ListProductsServlet extends HttpServlet {
    private IProductStorage storage = HibernateProductStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = storage.listAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/jsp/list-products.jsp").forward(req, resp);
    }
}
