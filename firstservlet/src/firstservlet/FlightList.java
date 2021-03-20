package firstservlet;

import java.io.*;
import java.util.*;

public class FlightList {
	ArrayList<Flight> flight_list;
	public ArrayList<ArrayList<Flight> > graph;
	private HashMap<String,Integer> id_map;
	ArrayList<ArrayList<Flight> > ans;
	public FlightList() {
		id_map = new HashMap<String,Integer> ();
		id_map.put("kolkata", 0);
		id_map.put("darjeeling", 1);
		id_map.put("siliguri", 2);
		id_map.put("bangalore", 3);
		id_map.put("mumbai", 4);
		id_map.put("pune", 5);
		id_map.put("shillong", 6);
		id_map.put("chennai", 7);
		id_map.put("delhi", 8);
		graph = new ArrayList<ArrayList<Flight> > ();
		for(int i=0;i<9;i++) {
			graph.add(new ArrayList<Flight> ());
			
		}
		ans = new ArrayList<ArrayList<Flight> > ();
		flight_list = new ArrayList<Flight> ();
		
	}
	public void insert(Flight fl){
		flight_list.add(fl);
		graph.get(id_map.get(fl.source)).add(fl);
	}
	
	public void dfs_visit(Flight f, String source, String destination ,ArrayList<Flight> till_now) {
		System.out.println(f);
		ArrayList<Flight> till_now_new = new ArrayList<Flight> (till_now);
		till_now_new.add(f);
		if(f.destination.equals(destination)) {
			ans.add(till_now_new);
			return;
		}
		for(Flight f1:graph.get(id_map.get(f.destination))) {
			System.out.println("Visiting");
			dfs_visit(f1,source,destination,till_now_new);
			
		}
	}
	
	public ArrayList<ArrayList<Flight> > dfs(String s_f, String d_f){
		ArrayList<ArrayList<Flight> > final_ans = new ArrayList<ArrayList<Flight> > ();
		for(Flight f: graph.get(id_map.get(s_f))) {
			ans = new ArrayList<ArrayList<Flight> > ();
			ArrayList<Flight> till_now = new ArrayList<Flight>();
			dfs_visit(f,s_f,d_f,till_now);
			for(ArrayList<Flight> arr:ans) {
				final_ans.add(arr);
			}
		}
		return final_ans;
		
	}
	
	
}
