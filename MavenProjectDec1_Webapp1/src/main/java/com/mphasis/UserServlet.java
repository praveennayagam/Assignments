package com.mphasis;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read form data
        String id = request.getParameter("id");
        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Read action
        String action = request.getParameter("action");

        // Read DB config from web.xml
        ServletContext context = getServletContext();
        String url = context.getInitParameter("url");
        String dbUser = context.getInitParameter("uname");
        String dbPwd = context.getInitParameter("pwd");
        String driver = context.getInitParameter("driver");

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, dbUser, dbPwd);

            PreparedStatement ps = null;

            switch (action) {

                case "insert":
                    ps = con.prepareStatement(
                        "INSERT INTO users(username, password, email, phone, address) VALUES(?, ?, ?, ?, ?)");
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, email);
                    ps.setString(4, phone);
                    ps.setString(5, address);
                    ps.executeUpdate();
                    out.println("<h3>User inserted successfully</h3>");
                    break;

                case "update":
                    ps = con.prepareStatement(
                        "UPDATE users SET username=?, password=?, email=?, phone=?, address=? WHERE id=?");
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, email);
                    ps.setString(4, phone);
                    ps.setString(5, address);
                    ps.setInt(6, Integer.parseInt(id));
                    ps.executeUpdate();
                    out.println("<h3>User updated successfully</h3>");
                    break;

                case "delete":
                    ps = con.prepareStatement("DELETE FROM users WHERE id=?");
                    ps.setInt(1, Integer.parseInt(id));
                    ps.executeUpdate();
                    out.println("<h3>User deleted successfully</h3>");
                    break;

                case "read":
                    ps = con.prepareStatement("SELECT * FROM users WHERE id=?");
                    ps.setInt(1, Integer.parseInt(id));
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        out.println("<h3>User Details:</h3>");
                        out.println("ID: " + rs.getInt("id") + "<br>");
                        out.println("Username: " + rs.getString("username") + "<br>");
                        out.println("Email: " + rs.getString("email") + "<br>");
                        out.println("Phone: " + rs.getString("phone") + "<br>");
                        out.println("Address: " + rs.getString("address") + "<br>");
                    } else {
                        out.println("<h3>No user found</h3>");
                    }
                    break;

                default:
                    out.println("<h3>Invalid action</h3>");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        out.close();
    }
}
