import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class LoginFormMysql extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String em2=req.getParameter("usrname");
		String pa2=req.getParameter("psw");
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/one","jashumysql","Satya@8686");
					PreparedStatement ps= con.prepareStatement("select * from reg1 where Email=? ");
					ps.setString(1,em2);
					ResultSet rs=ps.executeQuery();
					ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
				boolean status=rs.next();
				//boolean status1=rs1.next();
				if(status==true) {		
					String a=rs.getString(3);
					String b=rs.getString(4);
					if (em2.equals(a)  && pa2.equals(b)) {
							pw.println("<html>");
							pw.println("<body background=\"C:\\Users\\JASWNATH SATYA\\Desktop\\veg11.jpg\">");
							pw.print("<table width=25% border=1 align=center>");
							pw.print("<center><h1>Welcome</h1></center>");
							pw.print("<tr>");
							pw.print("<tr><td><a href='mysqle2.html'><b><u>Click Here Your Ready To Shop</u></b></a></td></tr>");
							pw.print("<tr>");
						    pw.print("<table>");
       						pw.print("</body>");
       						pw.print("</html>");
					}
					else {
						pw.println("<html>");
						pw.println("<body background=\"C:\\Users\\JASWNATH SATYA\\Desktop\\veg11.jpg\" >");
						pw.print("<table width=25% border=1 align=center>");
                        pw.print("<tr>");
			 			pw.print("<td>LOGIN FAILED PLEASE!!!</td>");
			            pw.print("</tr>");
						pw.print("<tr>");           
						pw.print("<tr><td><a href='log.html'><b><u><--BACK</u></b></a></td></tr>");
						pw.print("</tr>");
					    pw.print("</table>");
						pw.print("</body>");
						pw.print("</html>");
					}
					}
					else{
					pw.println("<html >");
					pw.println("<body background=\"C:\\Users\\JASWNATH SATYA\\Desktop\\veg11.jpg\">");	
					pw.print("<table bgcolor=\"white\" width=25% border=1 align=center>");	
                    pw.print("<tr>");    
			 	    pw.print("<td>LOGIN FAILED PLEASE!!!</td>");		
			        pw.print("</tr>");
					pw.print("<tr>");                
					pw.print("<tr><td><a href='log.html'><b><u><--BACK</u></b></a></td></tr>");	 			
					pw.print("</tr>");
					pw.print("</table>");
					pw.print("</body>");
					pw.print("</html>");
					}		
			} catch(Exception e) {
					System.out.println(e);}
		}		
}
