import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;





public class Node {
	
	// the list of the children nodes
	private ArrayList<Node> children;
	
	String name =""; 
	double size = 0;
	double folderSize = 0;
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
			size =f.length();
			isFile = true;
//			System.out.println("Name: "+ name);
		}else {
			try {
//				System.out.println("*********************This is a folder*************");
//				folderSize = (int)f.length();
//				System.out.println("Folder Size is : "+folderSize);
				File[] kids = f.listFiles();
				for(var k: kids) {
					Node a = new Node(k);
					children.add(a);
					size+=a.size;
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
//				e.getMessage();
			}
			
		}
		test(f);
	}
	
	public void test(File tf) {
		if(isFile) {
			System.out.println("Name: "+ name);

		}else {
			String folderName= tf.getName();
			System.out.println("The folder name is "+ folderName);
			folderSize = tf.length();
			System.out.println("Folder Size is : "+folderSize);


//			folderName
		}
	}
	
	public void draw(Graphics g, double x, double y,double w, double h, Orientation o) {
		// to do later. 
		if (isFile) {
			g.fillRect((int)x, (int)y, (int)w, (int)h);
			System.out.println("Drawn at x: "+x+" and y: "+y);
		}else {
			try {
				if(o==horizontal) { 
//					double childWidth=0;
//					System.out.println(horizontal);
					double pixByte = w/size;
//					double pixByte = ;

//					System.out.println("The w is :"+w+" the folderSize is "+folderSize+"<<<<<<<<<<<<<<<<<<<<<After line 78>>>>>>>>>>");
					System.out.println("pixByte is: "+pixByte + " <<<<<<<<<<<<<<<<<Line 79>>>>>>>>>>>>>>>>>");

					for(var c: children) {
						double childWidth = pixByte*c.size;
						System.out.println("The name is :"+c.name+" pixByte is: "+pixByte + " c size is: "+ c.size+"ChilcWidth is :"+childWidth);
//						x+=childWidth;
						System.out.println(y);

						c.draw(g, x, y, childWidth, h, vertical);
						
//						Part of brother Draper's code
						x+=childWidth;
						 
						
						 
//						System.out.println("x is : "+x+ "y is: "+ y);
					}
				}else {
//					double childHeight=0;
//					System.out.println(horizontal);
					double pixByte = h/size; 
//					double pixByte = size/h; 

					for(var c: children) {
						double childHeight = pixByte*c.size;
						System.out.println("x is "+x +"and y is "+y);
//						y+=childHeight;
						System.out.println("Child height "+ childHeight);

						System.out.println(y);
						c.draw(g, x, y, w, childHeight, horizontal);
//						uncomment later
						y+=childHeight;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());

			}

			
		}
	}
	
//	public int getSize() {
//		return size;
//	}

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
