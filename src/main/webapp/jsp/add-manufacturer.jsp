<%@ page import="com.annotationservlet.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.annotationservlet.entity.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Добавление производителя</h2>

<form action="/add-manufacturer" method="POST">
    <h3>Имя производителя</h3>
    <input type="text" name="manufacturerName"/>

    <input type="submit" value="Добавить производителя"/>
</form>

<a href="/list-manufacturer">Список производителей</a>