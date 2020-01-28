import java.util.ArrayList;
import java.util.LinkedList;
public class adjacencyList
{
  private ArrayList<LinkedList<Double>> adjList;
  private final int verticies;
  private ArrayList<City> cities;

  public adjacencyList(int numVerticies, ArrayList<City> cities)
  {
    this.adjList = new ArrayList<LinkedList<Double>>(numVerticies);
    for(int i = 0; i < numVerticies; i++)
    {
      adjList.add(new LinkedList<Double>());
    }
    this.verticies = numVerticies;
    this.cities = cities;
  }
  public void addVertex(City city)
  {

  }
  public void addEdge(int startLoc, int endLoc, double edgeSize)
  {
    adjList.get(startLoc).add(edgeSize);
  }
  public LinkedList bfs()
  {
    return null;
  }
}
