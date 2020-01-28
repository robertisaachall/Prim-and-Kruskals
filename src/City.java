public class City
{
  private String name;
  private int vertexPoint;
  private boolean visited;
  private int weight;

  public City(String name, int vertextPoint, boolean visitation, int weight)
  {
    this.name = name;
    this.vertexPoint = vertextPoint;
	visited = visitation;
	this.weight = weight;
  }
  public String getName()
  {
    return name;
  }

  public int getPoint()
  {
    return vertexPoint;
  }
  public boolean beenVisited()
  {
	return visited;
  }
  public void setVisited()
  {
	visited = true;
  }
  public void resetVisit()
  {
	visited = false;
  }
  public int getWeight() { return weight; }
}
