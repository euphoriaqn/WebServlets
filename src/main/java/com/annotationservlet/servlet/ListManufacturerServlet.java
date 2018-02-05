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
import java.util.List;

@WebServlet("/list-manufacturer")
public class ListManufacturerServlet extends HttpServlet{
    private IManufacturerStorage storage = HibernateManufacturerStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manufacturer> manufacturers = storage.listAll();
        req.setAttribute("manufacturers", manufacturers);
        req.getRequestDispatcher("/jsp/list-manufacturer.jsp").forward(req, resp);
    }
}
