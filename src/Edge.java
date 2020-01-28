public class Edge
{
	private String to;
	private String from;
	private int distance;
	
	public Edge(String to, String from, int distance)
	{
		this.to = to;
		this.from = from;
		this.distance = distance;
	}
	public int getDistance() { return distance; }
	public String returnTo() { return to; }
	public String returnFrom() { return from; }
	
	
}