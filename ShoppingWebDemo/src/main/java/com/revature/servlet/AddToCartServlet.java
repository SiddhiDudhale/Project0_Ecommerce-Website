package com.revature.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.revature.model.Cart;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<>();
			
			int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			if(cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				out.print("Session Created and added to the list");			
			}else {
				cartList = cart_list;
				boolean exist = false;
				
//				cartList.contains(cm) this inbuild method will not work here as it will check id by id
				
				for(Cart c:cartList) {
					if(c.getId() == id) {
						exist = true;
						out.println("<h3 style='text-align:center'>Item already exist in the cart .<a href='cart.jsp'> Go to Cart Page</a><h3>");
					}
				}
				if(!exist) {
					cartList.add(cm);
					response.sendRedirect("index.jsp");
					out.println("Product Added");
				}
				
			}
			for(Cart c:cart_list) {
				out.println(c.getId());
			}
		}
		
	}

	
}
