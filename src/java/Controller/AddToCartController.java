/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DvdCatalog;
import model.DvdCatalogTable;
import model.Quantity;
import model.QuantityTable;

/**
 *
 * @author warin
 */
public class AddToCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Quantity q = new Quantity();

        int id_dvdcatalog = Integer.parseInt(request.getParameter("idDvdCatalog"));
        DvdCatalog catalog = DvdCatalogTable.findDvd_CatalogById(id_dvdcatalog);

        List<Quantity> old_cart = QuantityTable.findQuantityByIdCatalog(catalog);
        if (old_cart == null) {
            q.setId(catalog);
            q.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            QuantityTable.insertQuantity(q);
        } else {
            q.setId(old_cart.get(0).getId());
            q.setId(catalog);
            q.setQuantity(old_cart.get(0).getQuantity() + Integer.parseInt(request.getParameter("quantity")));
           QuantityTable.updateQuantity(q);
        }
        request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
    }
}



