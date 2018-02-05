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
import java.util.UUID;

@WebServlet("/edit-manufacturer")
public class EditManufacturerServlet extends HttpServlet{

    private IManufacturerStorage storage = HibernateManufacturerStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID id = UUID.fromString(req.getParameter("manufacturerId"));
        Manufacturer manufacturer = storage.get(id);
        req.setAttribute("manufacturer", manufacturer);
        req.getRequestDispatcher("/jsp/edit-manufacturer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manufacturer manufacturer = new Manufacturer().withId(UUID.fromString(req.getParameter("manufacturerId")))
                .withName(req.getParameter("manufacturerName"));
        storage.update(manufacturer);
        resp.sendRedirect("/list-manufacturer");

    }
}
