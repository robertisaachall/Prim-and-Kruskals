import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import pqsort.*;
public class adjMatrix
{
  private double[][] adjMatrix;
  private ArrayList<Double> listWeight[];
  private final int verticies;
  private int vertexPoint;
  private ArrayList<City> cities;
  private ArrayList<City> cityKruskal;
  private ArrayList<Edge> edges;

  public adjMatrix(int numVerticies, ArrayList<City> cities)
  {
    this.adjMatrix = new double[numVerticies][numVerticies];
    this.cities = cities;
	cityKruskal = cities;
	listWeight = new ArrayList[numVerticies];
	for(int i = 0; i < numVerticies; i++)
	{
		listWeight[i] = new ArrayList<Double>();
	}
    for(int i = 0; i < numVerticies; i++)
    {
      for(int j = 0; j < numVerticies; j++)
      {
        adjMatrix[i][j] = 0.0;
      }
    }
    this.verticies = numVerticies;
	edges = new ArrayList<Edge>();
  }
  public void addVertex(City city)
  {

  }
  public void addEdge(int startLoc, int endLoc, double edgeSize, Edge e)
  {
      adjMatrix[startLoc][endLoc] = edgeSize;
      adjMatrix[endLoc][startLoc] = edgeSize;
	  listWeight[startLoc].add(edgeSize);
	  edges.add(e);
  }
  public ArrayList<Edge> prim()
  {
	ArrayList<Edge> primFinished = new ArrayList<Edge>();
	Comparator<Edge> ec = new EdgeCompare(true);
	PQBST<Edge> pqEdge = new PQBST<Edge>(ec);
	int isFirst = 0;
	do{
		if(isFirst == 0)
		{
			City cityCheck = cities.get(isFirst);
			cityCheck.setVisited();
			ArrayList<Edge> foundEdges = findEdges(cityCheck);
			Iterator iter = foundEdges.iterator();
			while(iter.hasNext())
			{
				Edge first = (Edge)iter.next();
				pqEdge.pqInsert(first);
			}
			isFirst++;
			continue;
		}
		if(pqEdge.pqIsEmpty())
		{
			break;
		}
		Edge e = pqEdge.pqRemove();
		City city = findCityFromPrim(e);
		boolean visitation = city.beenVisited();
		if(visitation)
		{
			continue;
		}
		else
		{
			city.setVisited();
			primFinished.add(e);
			ArrayList<Edge> foundEdges = findEdges(city);
			Iterator iter = foundEdges.iterator();
			while(iter.hasNext())
			{
				Edge newest = (Edge)iter.next();
				pqEdge.pqInsert(newest);
			}
		}
	}while(!pqEdge.pqIsEmpty());
	
	return primFinished;
	  
  }
  public ArrayList<Edge> kruskal()
  {
	resetVisitation();
	Comparator<Edge> ec = new EdgeCompare(true);
	PQBST<Edge> pqEdge = new PQBST<Edge>(ec);
	ArrayList<Edge> kruskals = new ArrayList<Edge>();
	ArrayList<Attacher> attachments = new ArrayList();
	for(int i = 0; i < edges.size(); i++)
	{
		Edge e = edges.get(i);
		pqEdge.pqInsert(e);
	}
	
	do
	{
		Edge e = pqEdge.pqRemove();
		boolean connection = checkKruskalVisitation(e);
		if(connection)
		{
			kruskals.add(e);
		}
		else
		{
			continue;	
		}
	}while(!pqEdge.pqIsEmpty());
	
	return kruskals;
	
  }
  
  public ArrayList<Edge> findEdges(City city)
  {
	  ArrayList<Edge> foundEdges = new ArrayList<Edge>();
	  for(int i = 0; i < edges.size(); i++)
	  {
		  String startName = city.getName();
		  Edge e = edges.get(i);
		  String edgeStart = e.returnTo();
		  if(startName.equals(edgeStart))
		  {
			foundEdges.add(e);
		  }
	  }
	  return foundEdges;
  }
  public City findCityFromPrim(Edge e)
  {
	  String from = e.returnFrom();
	  for(int i = 0; i < cities.size(); i++)
	  {
		  City city = cities.get(i);
		  String cityName = city.getName();
		  if(from.equals(cityName))
		  {
			 return city;
		  }	  
	  }
	  return null;
  }
  
  
   public City findCityFrom(Edge e)
  {
	  String from = e.returnFrom();
	  for(int i = 0; i < cityKruskal.size(); i++)
	  {
		  City city = cityKruskal.get(i);
		  String cityName = city.getName();
		  if(from.equals(cityName))
		  {
			 return city;
		  }	  
	  }
	  return null;
  }
  
  public City findCityTo(Edge e)
  {
	  String from = e.returnTo();
	  for(int i = 0; i < cityKruskal.size(); i++)
	  {
		  City city = cityKruskal.get(i);
		  String cityName = city.getName();
		  if(from.equals(cityName))
		  {
			 return city;
		  }	  
	  }
	  return null;
	  
  }
  
  
  
  public boolean check(Edge e, Attacher a)
  {
	  String toEdge = e.returnTo();
	  String fromEdge = e.returnFrom();
	  
	  String aParent = a.getParent();
	  String aChild = a.getChild();
	  
	  return false;
  }
  public boolean checkKruskalVisitation(Edge e)
  {
	City cityFrom = findCityFrom(e);
	City cityTo = findCityTo(e);
	boolean fromVisitation = cityFrom.beenVisited();
	boolean toVisitation = cityTo.beenVisited();
	int vertexTo = cityTo.getPoint();
	int vertexFrom = cityFrom.getPoint();
	
	
	if(fromVisitation == false && toVisitation == false) //Need to set both of them to be visited.
	{
		cityFrom.setVisited();
		cityTo.setVisited();
		return true;
	}
	else if(fromVisitation == true && toVisitation == false) //Set one or the other to be visited.
	{
		cityTo.setVisited();
		return true;
	}
	else if(fromVisitation == false && toVisitation == true)
	{
		cityFrom.setVisited();
		return true;		
	}
	else //No work here needs to be done.
	{
		return false;	
	}
  }
	public void resetVisitation() //Resets all cities to be not visited ( needed for kruskals, and dijktras)
	{
		for(int i = 0; i < cities.size(); i++)
		{
			City city1 = cities.get(i);
			city1.resetVisit();	
		}
	}
	  
  
}
