package com.annotationservlet.servlet;

import com.annotationservlet.entity.Manufacturer;
import com.annotationservlet.entity.Product;
import com.annotationservlet.storage.HibernateManufacturerStorage;
import com.annotationservlet.storage.HibernateProductStorage;
import com.annotationservlet.storage.IManufacturerStorage;
import com.annotationservlet.storage.IProductStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
    private IProductStorage productStorage = HibernateProductStorage.getInstance();
    private IManufacturerStorage storage = HibernateManufacturerStorage.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manufacturer> manufacturers = storage.listAll();
        req.setAttribute("manufacturers", manufacturers);
        req.getRequestDispatcher("/jsp/add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        for(String paramName : req.getParameterMap().keySet()) {
            System.out.println(paramName + "=" + req.getParameter(paramName));
        }
        Manufacturer manufacturer = storage.get(UUID.fromString(req.getParameter("manufacturer")));
        String productName = req.getParameter("productName").toString();
        BigDecimal productPrice = new BigDecimal(req.getParameter("productPrice"));
        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);
        product.setManufacturer(manufacturer);
        productStorage.add(product);

        resp.sendRedirect("/all");
    }
}
