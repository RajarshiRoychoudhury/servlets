/**
 * 
 */
package firstservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
/**
 * @author rajarshi
 *
 */

class Number{
	public int num1;
	public int num2;
	public Number(int num1,int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	public int returnSum() {
		return this.num1 + this.num2;
	}
}

public class AddNumbers extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		int k = i+j;
//		PrintWriter out = res.getWriter();
//		out.println("result is "+k);
//	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//res.addHeader("Access-Control-Allow-Origin", "*");
		System.out.print(req.getAttribute("num1"));
		Enumeration<String> headerNames = req.getParameterNames();
		while(headerNames.hasMoreElements()) {
		  String headerName = headerNames.nextElement();
		  System.out.println("Header Name - " + headerName + ", Value - " + req.getParameter(headerName));
		}
		//res.addHeader("Access-Control-Allow-Origin", "*");
		//int i = Integer.parseInt(req.getParameter("num1"));
		//int j = Integer.parseInt(req.getParameter("num2"));
		//int k = i+j;
		PrintWriter out = res.getWriter();
		out.println("result is "+5);
		
	}	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		PrintWriter out = res.getWriter();
		out.println("result is "+5);
	}
}
