import java.io.File;
import java.util.ArrayList;

public class AllNodes {
	private ArrayList<Node> Nodes;
	
	// constructor
	public AllNodes() {
		Nodes = new ArrayList<>();	
	}
	
	public void newNode(File f) {
		Node n = new Node(f);
		Nodes.add(n);
	}
	
	public void clearNodes() {
		if(!Nodes.isEmpty()) {
			Nodes.clear();
		}
	}
	
}
