<%@ page import="com.annotationservlet.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Все продукты</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for(Product product: products) {
        String link = product.getName();
//        String sex = product.getSex() ? "мужчина" : "женщина";
        String price = product.getPrice().toString();
        UUID id = product.getId();
        String strId = id.toString();
        String manName;
        try {
            manName = product.getManufacturer().getName();
        } catch (NullPointerException e){
            System.out.println(e);
            manName = "DEFAULT_NAME";
        }
        out.println("<span> Name: " + link + ", Price: " + price + ", Manufacturer: " + manName +"</span>");
        out.println("<a href=\"/delete-product?productId=" + strId + "\"> Удалить </a>");
        out.println("<a style=\"background: red;\" href=\"/edit-product?productId=" + strId + "\"> Редактировать </a>");
        out.println("</br>");
    }
%>

<a href="/add-product">Добавить продукт</a>
<br>
<a href="/list-manufacturer">Перейти к странице производителей</a>