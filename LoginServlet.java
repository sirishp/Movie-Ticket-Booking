package com.niit.sirish;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/RegistrationServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
       PreparedStatement pst;
       Statement st;
       int uid;
       String pwd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String firstName=request.getParameter("firstname");
		//String address=request.getParameter("address");
	    //String lastName=request.getParameter("lastname");
	//	String dateOfBirth=request.getParameter("date");
		//String userName=request.getParameter("username");
		//String emailID=request.getParameter("usermail");
		String password=request.getParameter("upwd");
		//long contactNumber=Long.parseLong(request.getParameter("usertel"));
		int userID=Integer.parseInt(request.getParameter("usid"));
		/*System.out.println("========");
		System.out.println("========"+firstName);
		System.out.println("========"+lastName);
		System.out.println("========"+address);
		System.out.println("========"+dateOfBirth);
		System.out.println("========"+emailID);
		System.out.println("========"+userName);
		System.out.println("========"+password);
		System.out.println("========"+contactNumber);
		System.out.println("========"+userId);*/

		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("========1");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			//String sql="insert into customerdetails(firstname,lastname,dateofbirth,username,emailid,password,address,contactnumber,userid) values('"+firstName+"','"+lastName+"','"+dateOfBirth+"','"+userName+"','"+emailID+"','"+password+"', '"+address+"',"+contactNumber+","+userId+")" ;
		st=con.createStatement();
		System.out.println("========2");
		
		String sql1="select userid, password from customer1 where userid="+userID+"";
		System.out.println("----------");
		
		/*pst=con.prepareStatement(sql1);
		pst.getInt(1,userId);
		pst.getString(2,password);*/
		
		ResultSet rs=st.executeQuery(sql1);
		System.out.println("========3");
		while(rs.next())
		{
			
			uid=rs.getInt(1);
			pwd=rs.getString(2);
			
		}
		System.out.println("----------11");
		if((userID==uid)&&(password.equals(pwd)))
		{
			pw.println("<h1>Login successful</h1>");
			
		}
		else{
			pw.println("<h1>Login unsuccessful</h1>");
		pw.println("<a href='login.html'>try again?</a>");
		}
		}
		catch(Exception e)
		{}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
