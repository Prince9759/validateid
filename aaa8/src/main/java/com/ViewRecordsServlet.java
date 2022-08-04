package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewRecordsServlet")
public class ViewRecordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		  int n=Integer.parseInt(request.getParameter("search"));
		  out.println("<table border=2>");
			out.println("<tr><th>Productid</th><th>ProductName</th><th>Price</th></tr>");
			
		try {
			
			Connection con=DBConnection.getMyConnection();
	       
			String str="select * from productdetails where Pid="+n;
			
			
			Statement  ps=con.createStatement();
			
			ResultSet ans =ps.executeQuery(str);
			
		
			
			  
			while(ans.next()) {
				out.println("<tr>");
				out.print("<td>"+ans.getInt("Pid")+"</td>");
				out.print("<td>"+ans.getString("Pname")+"</td>");
				out.print("<td>"+ans.getInt("Pprice")+"</td>");
				out.println("</tr>");
			}
			
			
		
		}
			
		
		catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</table>");
		
	}

	

}