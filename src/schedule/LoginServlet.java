package schedule;

import java.io.IOException;

import java.sql.SQLException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.omg.CORBA.Request;

import conn.Connect;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

		String username = request.getParameter("uname");
		String pass = request.getParameter("pass");
				try {
					Connection conn =Connect.getConnection();
					Statement stmt = conn.createStatement();
		
					ResultSet rs = stmt.executeQuery("select * from login where uname = '"+ username +"' and pass = '"+ pass + "';");
					log("success");
					if(rs.next()) {
						log("Having");
						HttpSession session = request.getSession();
						session.setAttribute("user", rs.getString(2));
						log(rs.getString(4));
						if(rs.getString(4).toString().equals("student")) {
							log(rs.getString(1));
							
							RequestDispatcher rd= request.getRequestDispatcher("Stu");
							rd.forward(request,response);
			
						}
						if(rs.getString(4).toString().equals("staff")){
							response.sendRedirect("Staff_Acc.jsp");  
							
							
						}
						
					} 
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}



