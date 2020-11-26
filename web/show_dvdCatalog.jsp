<%-- 
    Document   : show_dvdCatalog
    Created on : Nov 26, 2020, 7:07:56 PM
    Author     : warin
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.DvdCatalogTable"%>
<%@page import="model.DvdCatalog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show DVD Catalog</title>
    </head>
    <style>
        body {
            background-color: #00FFCC;
            text-align: center;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            background-color: #fff;
            text-align: center;
        }

        td, th {
            border: 1px solid #000000;
            text-align: left;
            padding: 8px;
        }
        .btn-secondary {
            border: none;
            color: #000000;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            background: #87CEEB;
            cursor: pointer;
        }

    </style>
    <jsp:useBean id="dvd" class="model.DvdCatalog" scope="request"/>
    <%

        List<DvdCatalog> dvdcatalogList = DvdCatalogTable.findAllDvd_Catalog();
        Iterator<DvdCatalog> itr = dvdcatalogList.iterator();
    %>
    <body>
    <center>
        <h1>DVD Catalog</h1>
        <table class="table1" border="1">
            <tr>
                <th>DVD Names</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>AddCart</th>
            </tr>
            <%              while (itr.hasNext()) {
                    dvd = itr.next();
                    out.println("<tr>");
                    out.println("<td hidden><input type=\"number\" name=\"idDvdCatalog\" value=" + dvd.getId() + "></input></td>");
                    out.println("<td> " + dvd.getDvdNames() + "</td>");
                    out.println("<td> " + dvd.getRate() + "</td>");
                    out.println("<td> " + dvd.getYear() + "</td>");
                    out.println("<td> " + dvd.getPrice() + "</td>");
                    out.println("<form name=\"AddToCart\" method=\"post\" action=\"AddToCartController\">");
                    out.println("<td><input type=\"text\" name=\"Quantity\" value=\"\" size=\"10\" /></td>");
                    out.println("<td><button class=\"btn-secondary\" type=\"submit\" name=\"addtocart\" id=\"button\"><i\"></i>AddToCart</button></td>");
                    out.println("</form>");
                    out.println("<tr>");

                }
            %>
        </table>
    </center>
</body>
</html>
