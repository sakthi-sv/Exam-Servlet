package schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.Connect;

/**
 * Servlet implementation class StuServlet
 */
@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Connection conn =Connect.getConnection();
		Statement stmt = conn.createStatement();

		HttpSession session = request.getSession();
		String user = session.getAttribute("user").toString();
		
			ResultSet rs = stmt.executeQuery("select * from stud where uname = '"+ user +"';");
			log("success");
			
			if(rs.next()) {
	
			PrintWriter out = response.getWriter();
			
			out.println("ID:"+rs.getString(1));
			out.println("Subject:"+rs.getString(2));
			out.println("HallNO:"+rs.getString(3));
			out.println("Uname:"+rs.getString(4));
			out.println("Date:"+rs.getString(5));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
