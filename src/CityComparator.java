import java.util.Comparator;

class CityCompare implements Comparator<City>
{
	private boolean ascending;
	public CityCompare(boolean asc)
	{
		ascending = asc;
	}
	
   public int compare(City city1, City city2)
   {
      int edgeWeight1 = city1.getWeight();
      int edgeWeight2 = city2.getWeight();
	  int comp = 0;
	  
	  if (edgeWeight1 > edgeWeight2)
	  {
		return 1;
	  }
	  else
	  {
		return -1;
	  }
   }
}