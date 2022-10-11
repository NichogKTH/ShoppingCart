<%@ page import="ui.ItemInfoHandler" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h1><%= "Shopping cart" %>
</h1>
<br/>
<form action="test" method="post">
    Username : <input type="text" name="num1">
    Password : <input type="text" name="num2">
    <input type="submit">
</form>
<table border="1" cellpadding="5" cellspacing="5">
    <tbody>
    <tr>
        <th colspan="4">Items in store</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th colspan="2">Description</th>
    </tr>
    <%
        ItemInfoHandler itemInfoHandler = new ItemInfoHandler();
        boolean authenticated = false;
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("authenticated"))
                    if (cookies[i].getValue().equals("yes"))
                        authenticated = true;
            }
        }
        if (authenticated) {
            for (int i = 0; i < itemInfoHandler.noOfItemsInStore(); i++) {
                out.println("<tr>");
                int storeId = itemInfoHandler.getItemInStore(i).getId();
                String storeName = itemInfoHandler.getItemInStore(i).getName();
                String storeDescription = itemInfoHandler.getItemInStore(i).getDescription();
                out.print("<td>" + storeId + "</td>");
                out.print("<td>" + storeName + "</td>");
                out.print("<td>" + storeDescription + "</td>");
                out.print("<td><a class=\"actionButton\" href=\"add?id=" +
                        storeId + "&name=" + storeName + "&description=" + storeDescription + "\" data-bean-id=\"3\">Add</a></td>");
                out.println("</tr>");
            }
        }
    %>
    </tbody>
</table>
<br>
<br>
<table border="1" cellpadding="5" cellspacing="5">
    <tbody>
    <tr>
        <th colspan="4">Items in cart</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th colspan="2">Description</th>
    </tr>
    <%
        if (authenticated) {
            for (int i = 0; i < itemInfoHandler.noOfItemsInCart(); i++) {
                out.println("<tr>");
                int cartId = itemInfoHandler.getItemInCart(i).getId();
                String cartName = itemInfoHandler.getItemInCart(i).getName();
                String cartDescription = itemInfoHandler.getItemInCart(i).getDescription();
                out.print("<td>" + cartId + "</td>");
                out.print("<td>" + cartName + "</td>");
                out.print("<td>" + cartDescription + "</td>");
                out.print("<td><a class=\"actionButton\" href=\"delete?id=" +
                        cartId + "&name=" + cartName + "&description=" + cartDescription + "\" data-bean-id=\"3\">Delete</a></td>");
                out.println("</tr>");
            }
        }
    %>
    </tbody>
</table>
</body>
</html>