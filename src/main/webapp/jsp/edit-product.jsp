<%@ page import="com.annotationservlet.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Редактирование продукта</h2>
<% Product product = (Product) request.getAttribute("product");%>
<form action="/edit-product" method="POST">
    <h3>Имя продукта</h3>

    <input type="hidden" name="productId" value="<%=product.getId()%>">

    <input type="text" name="productName" value="<%=product.getName()%>"/>

    <br/>
    <h3>Цена продукта</h3>

    <input type="text" name="productPrice" value="<%=product.getPrice()%>"/>

    <br/>
    <%--<input type="checkbox" name="catSex" checked="<%=request.getAttribute("catSex")%>" /> <span>Мужчина</span>--%>

    <%--<br/>--%>

    <input type="submit" value="Сохранить продукт"/>
</form>

<a href="/all">Список продуктов</a>