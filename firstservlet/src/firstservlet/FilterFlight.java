package firstservlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import firstservlet.Flight;
import firstservlet.FlightList;
import java.sql.*;



@WebServlet("/filterFlight")
public class FilterFlight extends HttpServlet{
		/**
		 * int f_id,String s, String d ,String dep, String dur, int sp_of, int cost, int slot
	 * 
	 */
	private Gson gson = new Gson();
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
			String source = req.getParameter("source");
			String destination = req.getParameter("destination");
			
			
			String url = "jdbc:postgresql://localhost:5432/flight";
			String username = "postgres";

			String password = "password";
			String query = "select * from flight_details.flights";
			FlightList fl = new FlightList();
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				Connection con = DriverManager.getConnection(url,username,password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					//System.out.println(rs.getInt("duration"));
					Flight f = new Flight(Integer.parseInt(rs.getString("flight_id")),rs.getString("source"),rs.getString("destination"),rs.getString("departure"),rs.getInt("duration"),rs.getInt("special_offer"),rs.getInt("cost"),rs.getInt("slot"));
					//System.out.println(f);
					fl.insert(f);
					//System.out.println(l.get(l.size()-1));
				}
				ArrayList<ArrayList<Flight> >  ans = fl.dfs(source, destination);
				res.setContentType("application/json");
				PrintWriter out = res.getWriter();
				//out.print(gson.toJson(l));
				out.print(gson.toJson(ans));
				out.flush();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//ArrayList<Flight> l = new ArrayList<Flight>();
			
			
		}
}
