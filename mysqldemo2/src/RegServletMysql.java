import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 public class RegServletMysql extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	PrintWriter pw=response.getWriter();
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         String n1 = request.getParameter("fn");
         String n2 = request.getParameter("ln");
         String n3 = request.getParameter("ea");
         String n4 = request.getParameter("psw");
         String n5 = request.getParameter("phone1");
         String n6= request.getParameter("Relocate");
         String n7= request.getParameter("Reference");
     try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/one", "jashumysql","Satya@8686");
            PreparedStatement ps = con.prepareStatement("insert into reg1 values(?,?,?,?,?,?,?)");
            ps.setString(1, n1);
            ps.setString(2, n2);
            ps.setString(3, n3);
            ps.setString(4, n4);
            ps.setString(5, n5);
            ps.setString(6, n6);
            ps.setString(7, n7);
            int i = ps.executeUpdate();
            if (i > 0) {
            	pw.println("<html>");
			pw.println("<body bgcolor=''>");
			
			pw.print("<table width=25% border=1 align=center>");

			pw.print("<center><h1>Welcome</h1></center>");

			pw.print("<tr>");
                        
			 			pw.print("<td><a href='log.html'><b><u>Click Here To Login</u></b></a></td>");
			 			
			pw.print("</tr>");
  
		    pw.print("</table>");

				pw.print("</body>");
				pw.print("</html>");}
        } catch (Exception e2) {
            System.out.println(e2);
        }
 out.close();
    }
}
 