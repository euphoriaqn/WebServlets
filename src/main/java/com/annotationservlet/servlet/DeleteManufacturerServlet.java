package com.annotationservlet.servlet;

import com.annotationservlet.entity.Manufacturer;
import com.annotationservlet.storage.HibernateManufacturerStorage;
import com.annotationservlet.storage.IManufacturerStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/delete-manufacturer")
public class DeleteManufacturerServlet extends HttpServlet {
    private IManufacturerStorage storage = HibernateManufacturerStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufacturerId = req.getParameter("manufacturerId");

        System.out.println("MANUFACTURER ID <" + manufacturerId + ">");

        Manufacturer manufacturer = storage.get(UUID.fromString(manufacturerId));
        storage.delete(manufacturer);

        resp.sendRedirect("/list-manufacturer");
    }
}
