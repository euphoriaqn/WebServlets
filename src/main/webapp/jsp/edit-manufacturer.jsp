<%@ page import="com.annotationservlet.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.annotationservlet.entity.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Редактирование продукта</h2>
<% Manufacturer manufacturer = (Manufacturer) request.getAttribute("manufacturer");%>
<form action="/edit-manufacturer" method="POST">
    <h3>Имя производителя</h3>

    <input type="hidden" name="manufacturerId" value="<%=manufacturer.getId()%>">

    <input type="text" name="manufacturerName" value="<%=manufacturer.getName()%>"/>

    <br/>
    <%--<input type="checkbox" name="catSex" checked="<%=request.getAttribute("catSex")%>" /> <span>Мужчина</span>--%>

    <%--<br/>--%>

    <input type="submit" value="Сохранить производителя"/>
</form>

<a href="/list-manufacturer">Список производителей</a>