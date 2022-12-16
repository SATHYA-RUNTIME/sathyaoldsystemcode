package javafiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet("/dserv")
public class doctserv extends HttpServlet {
    ArrayList<dmodel> mylist;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mylist = new ArrayList<dmodel>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
            
            PreparedStatement stat = con.prepareStatement("select * from doctortable");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
              
                mylist.add(new dmodel( rs.getString("D_user"), rs.getInt("password"), rs.getInt("D_ID"), rs.getString("D_NAME"),rs.getInt("APP_ID"),rs.getString("special") ));
            }
            Gson g = new Gson();
            String send = g.toJson(mylist);
            resp.getWriter().println(send);
            System.out.println("send successfully");
        } catch (Exception e) {
            System.err.println("ERROR" + e);
        }
    }
 
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "")) {
        PreparedStatement stat1 = con.prepareStatement("select * from patient where p_name=?");
        stat1.setString(1,req.getParameter("p_name"));
        ResultSet r=stat1.executeQuery();
        if (r.next()) {
            System.out.println("patient already exist");
           
                    req.setAttribute("checkname","name already exist" );
                    RequestDispatcher rd1 = req.getRequestDispatcher("register.jsp");
                    rd1.forward(req, resp);           
            
        } else {
            PreparedStatement stat = con.prepareStatement("insert into patient values(?,?,?,?,?,?)");
            stat.setInt(1, 0);
            stat.setString(2, req.getParameter("p_name"));
                    stat.setString(3,req.getParameter("psword"));
            stat.setString(4, req.getParameter("mail"));
            stat.setDouble(5,Double.parseDouble (req.getParameter("contact")) );
            stat.setString(6,req.getParameter("address"));
            stat.executeUpdate();
            System.out.println("register successfully");
            resp.sendRedirect("http://localhost:9090/");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
