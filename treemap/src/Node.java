import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;


public class Node {
	
	// the list of the children nodes
	private ArrayList<Node> children;
	
	String name =""; 
	int size = 0;
	boolean isFile;
	Orientation horizontal = Orientation.HORIZONTAL;
	Orientation vertical = Orientation.VERTICAL;
	public Node() {
		System.out.println("from Node");
	}
	
	public Node(File f) {
//		name = f.getName();
		children = new ArrayList<>();
		isFile = false;
		
		if(f.isFile()) {
			name = f.getName();
			size =(int)f.length();
			isFile = true;
//			System.out.println("Name: "+ name);
		}else {
			try {
				System.out.println("*********************This is a folder*************");

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
		test();
	}
	
	public void test() {
		if(isFile) {
			System.out.println("Name: "+ name);

		}
	}
	
	public void draw(Graphics g, double x, double y,int w, int h, Orientation o) {
		// to do later. 
		if (isFile) {
			g.fillRect((int)x, (int)y, w, h);
		}else {
			if(o==horizontal) {
				double childWidth=0;
				System.out.println(horizontal);
				double pixByte = w/size;
				for(var c: children) {
					childWidth = pixByte*c.getSize();
					c.draw(g, x, pixByte, w, h, vertical);
					x+=childWidth;
				}
			}else {
				double childHeight=0;
//				System.out.println(horizontal);
				double pixByte = w/size;
				for(var c: children) {
					childHeight = pixByte*c.getSize();
					c.draw(g, x, pixByte, w, h, vertical);
					y+=childHeight;
				}
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
