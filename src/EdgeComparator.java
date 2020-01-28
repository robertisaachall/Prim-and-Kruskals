import java.util.Comparator;

class EdgeCompare implements Comparator<Edge>
{
	private boolean ascending;
	public EdgeCompare(boolean asc)
	{
		ascending = asc;
	}
	
   public int compare(Edge edge1, Edge edge2)
   {
      int edgeWeight1 = edge1.getDistance();
      int edgeWeight2 = edge2.getDistance();
	  int comp = 0;
	  
	  if (ascending)
	  {
		comp = edgeWeight1 - edgeWeight2; 
	  }
	  else
	  {
		  comp = edgeWeight2 - edgeWeight1; 
	  }

      return comp;
   }
}
