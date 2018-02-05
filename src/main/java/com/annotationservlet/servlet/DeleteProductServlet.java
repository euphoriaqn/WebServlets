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
import java.util.UUID;

@WebServlet("/delete-product")
public class DeleteProductServlet extends HttpServlet {
    private IProductStorage productStorage = HibernateProductStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");

        System.out.println("PRODUCT ID <" + productId + ">");

        Product product = productStorage.get(UUID.fromString(productId));
        productStorage.delete(product);

        resp.sendRedirect("/all");
    }
}
