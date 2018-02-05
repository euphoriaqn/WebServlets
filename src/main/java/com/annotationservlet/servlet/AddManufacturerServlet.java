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

@WebServlet("/add-manufacturer")
public class AddManufacturerServlet extends HttpServlet{
    private IManufacturerStorage storage = HibernateManufacturerStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add-manufacturer.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        for(String paramName : req.getParameterMap().keySet()) {
//            System.out.println(paramName + "=" + req.getParameter(paramName));
//        }
        req.setCharacterEncoding("UTF-8");
        String manufacturerName = req.getParameter("manufacturerName").toString();

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerName);

        storage.add(manufacturer);

        resp.sendRedirect("/list-manufacturer");
    }
}
