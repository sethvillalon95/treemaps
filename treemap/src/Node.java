import java.io.File;
import java.util.ArrayList;

public class Node {
	
	// the list of the children nodes
	private ArrayList<Node> children;
	
	String name =""; 
	int size = 0;
	public Node() {
		System.out.println("from Node");
	}
	
	public Node(File f) {
		name = f.getName();
		children = new ArrayList<>();
		
	
		
	}
}
