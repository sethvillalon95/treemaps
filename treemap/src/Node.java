import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.File;
import java.util.ArrayList;

import javax.swing.text.rtf.RTFEditorKit;








public class Node {
	
	// the list of the children nodes
	private ArrayList<Node> children;
	int colorScheme;
	
	
	String name =""; 
	double size = 0;
	double folderSize = 0;
	boolean isFile;
	Orientation horizontal = Orientation.HORIZONTAL;
	Orientation vertical = Orientation.VERTICAL;
	public Node() {
		System.out.println("from Node");
	}
	
	public Node(File f, int colorS) {
		colorScheme = colorS;
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
					Node a = new Node(k,colorScheme);
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
			System.out.println("Name: "+ name+" colorScheme " +colorScheme);

		}else {
			String folderName= tf.getName();
//			System.out.println("The folder name is "+ folderName);
			folderSize = tf.length();
//			System.out.println("Folder Size is : "+folderSize);


//			folderName
		}
	}
	
	public void draw(Graphics g, double x, double y,double w, double h, Orientation o) {
		// to do later. 
//		Graphics2D g = (Graphics2D)g1;
		System.out.println("Drawing");
		if (isFile) {//file
			Color myRedColor = Color.WHITE;
			
			// do for the file type;
			if(colorScheme==1) {
				System.out.println("Hello>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				myRedColor = fileScheme();
			}
			g.setColor(myRedColor);
			g.fillRect((int)x, (int)y, (int)w, (int)h);



		}else {//folder
			try {
				if(o==horizontal) { 
					double pixByte = w/size;
					for(var c: children) {
						double childWidth = pixByte*c.size;
						System.out.println(y);
						c.draw(g, x, y, childWidth, h, vertical);
						x+=childWidth+1;
					}
				}else {
					double pixByte = h/size; 

					for(var c: children) {
						double childHeight = pixByte*c.size;

						System.out.println(y);
						c.draw(g, x, y, w, childHeight, horizontal);
						y+=childHeight+1;
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
	public Color getColor() {
		Color color = null;
		if(colorScheme==1) {
			if(name.endsWith(".doc")) {
				color = Color.BLUE;
			}
		}
		return color;
	}
	
	
	
	public void setColorScheme(int sc) {
		colorScheme = sc;
		System.out.println("Color scheme from Node is " + colorScheme);
		
	}
	
	public Color fileScheme() {
		System.out.println("I was called");
		Color color = Color.white;
		if(name.endsWith(".doc")){
			color = Color.BLUE;			
		}else if(name.endsWith(".docx")) {
			color = Color.BLUE;
		}
		else if(name.endsWith(".pdf")) {
			color = Color.CYAN;
			
		}else if(name.endsWith(".JPG")) {
			color=Color.MAGENTA;
			
		}else if(name.endsWith(".xlsx")) {
			color = Color.ORANGE;
		}else if(name.endsWith(".zip")) {
			color = Color.GREEN;
		}else if(name.endsWith(".exe")) {
			color = Color.PINK;
		}else {
			color = Color.RED;
		}
		return color;
		
	}
}
