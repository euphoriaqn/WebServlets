<%@ page import="com.annotationservlet.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.annotationservlet.entity.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Все производители</h2>

<%
    List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");
    for(Manufacturer manufacturer: manufacturers) {
        String link = manufacturer.getName();
        UUID id = manufacturer.getId();
        String strId = id.toString();

        out.println("<span> Name: " + link + "</span>");
        out.println("<a href=\"/delete-manufacturer?manufacturerId=" + strId + "\"> Удалить </a>");
        out.println("<a style=\"background: red;\" href=\"/edit-manufacturer?manufacturerId=" + strId + "\"> Редактировать </a>");

        out.println("</br>");
    }
%>

<a href="/add-manufacturer">Добавить производителя</a>
<br>
<a href="/all">Перейти к странице продуктов</a>