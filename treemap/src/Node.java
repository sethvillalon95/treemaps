import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.io.File;
import java.util.ArrayList;

public class Node {
	
	// the list of the children nodes
	private ArrayList<Node> children;
	int colorScheme;
	File rootFile;
	
	
	String name =""; 
	double size = 0;
	double folderSize = 0;
	boolean isFile;
	long lastModified;
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
		rootFile = f;
		
		
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
		lastModified =rootFile.lastModified()%10;

		test(f);
	}
	
	public void test(File tf) {
		if(isFile) {
			int test = (int)lastModified;
			

			System.out.println(test+" Name: "+ name+" colorScheme " +colorScheme);
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
			Color myColor = Color.WHITE;
			
			// do for the file type;
			if(colorScheme==1) {
				System.out.println(name+" Hello>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				myColor = fileScheme();
			}else if(colorScheme ==2) {
				myColor = fileAgeScheme();
			}else if(colorScheme==3) {
				myColor = randomScheme();
			}
			else {
				 myColor = Color.WHITE;
			}
			g.setColor(myColor);
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
		
	public Color randomScheme() {
		double r = Math.random()*10;
		int n =(int) r;
		Color color = Color.white;

		switch (n) {
			case 1:
				//
				color = Color.BLUE;	
				return color;
//				break;
			case 2:
				//
				color = Color.CYAN;
				return color;
//				break;
			case 3:
				// 
				color=Color.MAGENTA;
				return color;
//				break;
			case 4:
				//
				color = Color.ORANGE;
				return color;
//				break;
			case 5:
				//
				color = Color.GREEN;
				return color;
//				break;
			case 6:
				//
				color = Color.PINK;
				return color;
//				break;
			case 7:
				//
				color = Color.RED;
				return color;
//				break;
			case 8:
				//
				color = Color.YELLOW;
				return color;
//				break;
			case 9:
				//
				color = Color.GRAY;
				return color;
//				break;
			default:
				//
				color = Color.darkGray;
				return color;
		}
	}
	public Color fileScheme( ) {
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
	public Color fileAgeScheme() {
		int n = (int)lastModified;
		Color color = Color.white;

		switch (n) {
			case 1:
				//
				color = Color.BLUE;	
				return color;
//				break;
			case 2:
				//
				color = Color.CYAN;
				return color;
//				break;
			case 3:
				// 
				color=Color.MAGENTA;
				return color;
//				break;
			case 4:
				//
				color = Color.ORANGE;
				return color;
//				break;
			case 5:
				//
				color = Color.GREEN;
				return color;
//				break;
			case 6:
				//
				color = Color.PINK;
				return color;
//				break;
			case 7:
				//
				color = Color.RED;
				return color;
//				break;
			case 8:
				//
				color = Color.YELLOW;
				return color;
//				break;
			case 9:
				//
				color = Color.GRAY;
				return color;
//				break;
			default:
				//
				color = Color.darkGray;
				return color;

					
		}
		
	}

}
