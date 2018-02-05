<%@ page import="com.annotationservlet.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.annotationservlet.entity.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Добавление продукта</h2>

<form action="/add-product" method="POST">
    <h3>Имя продукта</h3>
    <input type="text" name="productName"/>
    <br/>
    <h3>Цена продукта</h3>
    <input type="text" name="productPrice"/>

    <br/>
    <h3>Производитель</h3>

    <select name="manufacturer" id="item_id">
   <%
       try{
       List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
       for (Manufacturer value: manufacturers)
       {
            out.println("<option value=" +value.getId()+">" + value.getName() + "</option>");
       }
       } catch (NullPointerException e){
           System.out.println(e);
       }

   %>

    <input type="submit" value="Добавить продукт"/>
</form>

<a href="/all">Список продуктов</a>