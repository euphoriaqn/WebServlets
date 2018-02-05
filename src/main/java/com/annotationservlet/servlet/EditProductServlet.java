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
import java.math.BigDecimal;
import java.util.UUID;

@WebServlet("/edit-product")
public class EditProductServlet extends HttpServlet {
    private IProductStorage productStorage = HibernateProductStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID id = UUID.fromString(req.getParameter("productId"));
        Product product = productStorage.get(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/jsp/edit-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product().withId(UUID.fromString(req.getParameter("productId")))
                .withName(req.getParameter("productName"))
                .withPrice(new BigDecimal(req.getParameter("productPrice")));
        productStorage.update(product);
        resp.sendRedirect("/all");

    }
}
