import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;


import javax.swing.JPanel;




public class Vis extends JPanel implements MouseListener, MouseMotionListener {

    private String textToDisplay;
    private String filepath;
//    AllNodes nodes;
    Node root; 
    Orientation orientation;
    File file;
//    private List<Point2D> scatterData;

    


    public Vis() {
        super();
//        textToDisplay = "There's nothing to see here.";
        addMouseListener(this);
        addMouseMotionListener(this);
        filepath = "";
//        nodes = new AllNodes();
        Orientation orientation = Orientation.HORIZONTAL;
        
        if(orientation == Orientation.VERTICAL) {
            System.out.println(orientation);

        }

        file = new File(filepath);
    }
    
    public void setFilePath(String fp) {
    	filepath = fp;
    	System.out.println(fp);
    	
    }
    // this is used for hover effects 
 

    @Override
    public void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;
        
        
//        nodes.newNode(f);
//        nodes.printAll();
        
        
        

        //draw blank background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        //render visualization
        g.setColor(Color.BLACK);

        final double h = getHeight();
        final double w = getWidth();
//        File f = new File(filepath);
        root = new Node(file);
        root.draw(g, 0, 0, w, h, orientation.HORIZONTAL);
//        nodes.draw(g, 0, 0, w, h, orientation.HORIZONTAL);
//        nodes.printSize();
//        nodes.clearNodes();


    }

    @Override
    public void mouseClicked(MouseEvent e) {
 
    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
//        String s =dots.attributes(x,y);
//        setToolTipText(s);
    }
    
    



    

}
