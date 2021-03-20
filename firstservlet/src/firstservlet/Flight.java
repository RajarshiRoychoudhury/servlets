package firstservlet;

public class Flight {
	public String source;
	public String destination;
	public int flight_id;
	public int duration;
	public int special_offer;
	public String departure;
	public int cost;
	public int slot;
	
	public Flight(int f_id,String s, String d ,String dep, int dur, int sp_of, int cost, int slot){
		this.flight_id = f_id;
		this.source = s;
		this.destination = d;
		this.departure  = dep;
		this.duration = dur;
		this.special_offer = sp_of;
		this.cost = cost;
		this.slot = slot;
	}
	public String toString() {
		return flight_id+" "+source+" "+destination+" "+departure+" "+duration+" "+special_offer+" "+cost+" "+slot;
	}
}

