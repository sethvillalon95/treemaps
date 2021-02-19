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
		
		if(f.isFile()) {
			size =(int)f.length();
		}else {
			try {
				File[] kids = f.listFiles();
				for(var k: kids) {
					Node a = new Node(k);
					children.add(a);
					size+=a.getSize();
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
//				e.getMessage();
			}
			
		}
		
	}
	
	public int getSize() {
		return size;
	}

	public void printAll() {
		// TODO Auto-generated method stub
	System.out.println("name: "+name + " size: "+ size);
	if(!children.isEmpty()) {
		for(var n:children) {
			n.printAll();
		}
	}
		
	}
}
