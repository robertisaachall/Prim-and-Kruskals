import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
public class Graph
{
  //private adjList adjList;
  private adjacencyList adjList;
  private adjMatrix adjMatrix;
  private int verticies;
  private ArrayList<City> Cities;
  private ArrayList<Edge> edges;

  public Graph(int numVerticies, ArrayList<City> cities)
  {
    this.adjMatrix = new adjMatrix(numVerticies, cities);
    this.adjList = new adjacencyList(numVerticies, cities);
    this.verticies = numVerticies;
    this.Cities = cities;
    edges = new ArrayList<Edge>();
  }
  public void addVertex(City city)
  {
    adjMatrix.addVertex(city);
    adjList.addVertex(city);
  }
  public void addEdge(String startLoc, String endLoc, int distance)
  {
    Iterator iter = Cities.iterator();
    int index1 = 0;
    int index2 = 0;

    while(iter.hasNext())
    {
      City check = (City) iter.next();
      String cityName = check.getName();
      if(startLoc.equals(cityName))
      {
        index1 = check.getPoint();
      }
      if(endLoc.equals(cityName))
      {
        index2 = check.getPoint();
      }
    }
	Edge e = new Edge(startLoc, endLoc, distance);
	edges.add(e);
    adjMatrix.addEdge(index1, index2, distance, e);
  }
  public ArrayList<Edge> prim()
  {
	return adjMatrix.prim();
  }
  public ArrayList<Edge> kruskal()
  {
	 return adjMatrix.kruskal();
  }

}
