public class Attacher
{
	private String parent;
	private String child;
	
	private boolean hasChild;
	
	public Attacher(String s1, String s2)
	{
		parent = s1;
		child = s2;
		hasChild = true;
	}
	
	public String getParent() { return parent; }
	public String getChild() { return child; }
	public boolean hasChild() { return hasChild; }
	
}