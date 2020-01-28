import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class GraphDriver
{
  public static void main(String[] args)
  {
    if(args.length < 0)
    {
		System.out.println("No arguments have been submitted. Please enter arguments");
    }
    int argsLength = args.length;
    String fileName = args[0];
    String distFile = args[1];
    ArrayList<City> cities = readCities(fileName);
    Graph g = new Graph(cities.size(), cities);
    fileEdges(g, distFile);
	
	ArrayList<Edge> prim = g.prim();
	System.out.println(" Prims: ");
	System.out.println(" ");
	for(int i = 0; i < prim.size(); i++)
	{
		Edge e = prim.get(i);
		String city1 = e.returnTo();
		String city2 = e.returnFrom();
		int distance = e.getDistance();
		System.out.println("( " + city1 + " , " + city2 + " , " + distance + " )");
		
	}
	System.out.println(" ");
	ArrayList<Edge> kruskal = g.kruskal();
	
	System.out.println(" Kruskals: ");
	System.out.println(" ");
	for(int i = 0; i < kruskal.size(); i++)
	{
		Edge e = kruskal.get(i);
		String city1 = e.returnTo();
		String city2 = e.returnFrom();
		int distance = e.getDistance();
		System.out.println("( " + city1 + " , " + city2 + " , " + distance + " )");
		
	}
	
  }
  public static ArrayList readCities(String filename) //Reads in a list of vertex
  {
      ArrayList<City> listVertex = new ArrayList();
      ReadTextFile rf = new ReadTextFile(filename);
      String strVertex = rf.readLine();
      int vertex = 1;
      City cityAdd = new City(strVertex, vertex, false,0);
      listVertex.add(cityAdd);
      vertex++;
      while(!rf.EOF())
      {
        strVertex = rf.readLine();
        City city2Add = new City(strVertex, vertex, false,0);
        listVertex.add(city2Add);
        vertex++;
      }
      rf.close();
      return listVertex;
  }
  public static void fileEdges(Graph g, String fileName) //Reads in a file and adds the edges to a graph.
  {
    ReadTextFile rf = new ReadTextFile(fileName);
	
    ArrayList<String> fileContents = new ArrayList<String>();
    String line = rf.readLine();
    fileContents.add(line);
    while(!rf.EOF())
    {
		
      line = rf.readLine();
	  if(rf.EOF())
	  { break; }
      fileContents.add(line);
    }
    Iterator iter = fileContents.iterator();
    while(iter.hasNext())
    {
      line = (String) iter.next();
	  String[] parse = line.split(" ");
	  String city1 = parse[0];
	  String city2 = parse[1];
	  String readMilage = parse[2];
	  int realMilage = Integer.parseInt(readMilage);
      
       g.addEdge(city1, city2, realMilage);
    }


    
  }
}
