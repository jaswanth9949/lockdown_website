import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
public class VegForm extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//private static final String PreparedStatement = null;
		PrintWriter p=response.getWriter();
        response.setContentType("text/html");
       
       String n = request.getParameter("name");
       String n1 = request.getParameter("ph");
       String n2 = request.getParameter("allveg");
       String n3 = request.getParameter("totalcost");
    try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/one","jashumysql","Satya@8686");
           String s2=request.getParameter("ans");
           if(s2.equals("confirm"))
           {
           PreparedStatement ps=con.prepareStatement("insert into shop4 values(?,?,?,?)");
           ps.setString(1, n);
           ps.setString(2,n1);
           ps.setString(3, n2);
           ps.setString(4, n3);
           
           int i = ps.executeUpdate();
           if (i > 0) {
        	   p.println("<html>");
               p.println("<body background=\"C:\\Users\\JASWNATH SATYA\\Desktop\\veg12.jpg\"><div align='center'>");
               p.println("<h3>.....>>>You are successfully placed your order<<<.....</h3><br>"+n);
               p.println("<h4> .....THANKS FOR VISITING.....<br><a href='one.html'><b><u>Click Here To Logout</u></b></a></h4>");  
               p.println("</div></body>");
               p.println("</html>");
           }
         }
          else if(s2.equals("display"))
           {
           	PreparedStatement ps3 = con.prepareStatement("select * from shop4 where Phone_No=?");
           	String v = request.getParameter("number");
           	ps3.setString(1,v);                   
               p.print("<body background=\"C:\\Users\\JASWNATH SATYA\\Desktop\\veg11.jpg\"><div aling='center'>");
               p.print("<table width=25% border=1 cellpadding=5 align=center>");

               p.print("<center><h1>Result:</h1></center>");

               ResultSet rs=ps3.executeQuery();                

               /* Printing column names */

               ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
               while(rs.next())
               {
               p.print("<tr>");
               p.print("<td>"+rsmd.getColumnName(1)+"</td>");
                  p.print("<td>"+rs.getString(1)+"</td></tr>");
                  p.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                  p.print("<td>"+rs.getString(2)+"</td></tr>");
                  p.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
                  p.print("<td>"+rs.getString(3)+"</td></tr>");
               
               }
               p.print("</table>");
               p.print("<a href='one.html'><b><u>Click Here To Logout</u></b></a>");
               p.print("</div></body>");
              }
           
      else if(s2.equals("update"))
      {
    	    String b1 = request.getParameter("ph2");
    	    String b2 = request.getParameter("aaa");
    	    
      		String query = "update shop4 set Phone_No='"+b1+"' where Name='"+b2+"'";
      		Statement stmt=con.createStatement();
      		int j = stmt.executeUpdate(query);
      		//out.println("query" + query);
      		if(j>0) {
      			p.println("<html>");
                p.println("<body background=\"C:\\Users\\JASWNATH SATYA\\Desktop\\veg11.jpg\"><div align='center'>");
                p.println("<h3>.....>>>You Are Successfully Updated Your Data<<<.....</h3><br>"+n);
                
                p.println("</div></body>");
                p.println("</html>");
      		}
      		else {
      			p.println("<html>");
                p.println("<body background=\"C:\\Users\\JASWNATH SATYA\\Desktop\\veg11.jpg\"><div align='center'>");
      			p.println("<h3>.....>>>Your Data Not Updated<<<.....</h3><br>");
                //p.println("<h4> .....THANKS FOR VISITING.....<br><a href='one.html'><b><u>Click Here To Logout</u></b></a></h4>");  
                p.println("</div></body>");
                p.println("</html>");
      		}
      		
      }
          
    //String b3 = request.getParameter("del");
      else if(s2.equals("delete")) {
    	 String b2 = request.getParameter("aaa");
			Statement stmt=con.createStatement();
			//((PreparedStatement) ).setString(1, b2);
			String qu1="delete from shop4 where Name='"+b2+"' ";
			int k = stmt.executeUpdate(qu1);
			
  		if(k>0) {
  			p.println("<html>");
            p.println("<body><div align='center'>");
            p.println("<h3>.....>>>Your Data Is Cleared Totally<<<.....</h3><br>"+n);
            //p.println("<h4> .....THANKS FOR VISITING.....<br><a href='one.html'><b><u>Click Here To Logout</u></b></a></h4>");  
            p.println("</div></body>");
            p.println("</html>");
      	}
    }
    }catch (Exception e2) {}
   p.close();
   }
}