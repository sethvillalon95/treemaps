import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;

public class AllNodes {
	private ArrayList<Node> Nodes;
	
	// constructor
	public AllNodes() {
		Nodes = new ArrayList<>();	
	}
	
	public void newNode(File f) {
//		Node n = new Node(f);
//		Nodes.add(n);
	}
	
	public void clearNodes() {
		if(!Nodes.isEmpty()) {
			Nodes.clear();
		}
	}
	public void printSize() {
		System.out.println("The size in the AllNodes is "+Nodes.size());
	}
	public void printAll() {
		for(var n : Nodes) {
			n.printAll();
		}
	}
	public void draw(Graphics g, double x, double y,int w, int h, Orientation o) {
		for(var n: Nodes) {
			n.draw(g, x, y, w, h, o);
		}
	}
	
	
}
