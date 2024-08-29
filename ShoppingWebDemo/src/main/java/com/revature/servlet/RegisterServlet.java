package com.revature.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.revature.connection.DbCon;

@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection con = DbCon.getConnection(); // Assuming DbCon is your database connection class

            // Check if the email already exists
            String checkQuery = "SELECT * FROM admin_users WHERE email = ?";
            PreparedStatement checkPst = con.prepareStatement(checkQuery);
            checkPst.setString(1, email);
            ResultSet rs = checkPst.executeQuery();

            if (rs.next()) {
                // Email already exists
                response.sendRedirect("register.jsp?error=Email already registered");
            } else {
                // Insert new user into the database
                String insertQuery = "INSERT INTO admin_users (name, email, password) VALUES (?, ?, ?)";
                PreparedStatement insertPst = con.prepareStatement(insertQuery);
                insertPst.setString(1, name);
                insertPst.setString(2, email);
                insertPst.setString(3, password); // Remember to hash the password for security

                int result = insertPst.executeUpdate();
                if (result > 0) {
                    response.sendRedirect("login.jsp?success=Account created successfully");
                } else {
                    response.sendRedirect("register.jsp?error=Account creation failed");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=Database error");
        }
    }
}
