import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.jdi.Field;

public class Main extends JFrame {

    private Vis mainPanel;
    // default
    Node root;
	String filepath = "C:\\Users\\sethv\\OneDrive\\Desktop\\Job Application";
	File f;
	int colorScheme;

    public Main() {

        JMenuBar mb = setupMenu();
        setJMenuBar(mb);

        mainPanel = new Vis();
        setContentPane(mainPanel);
        colorScheme = 0;
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Put the title of your program here");
        setVisible(true);
        
        
    }

    //select count(*) from derbyDB


    private JMenuBar setupMenu() {
        //instantiate menubar, menus, and menu options
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu colorSchemeMenu = new JMenu("Color Scheme");
        JMenuItem item1 = new JMenuItem("Item 1");
        JMenuItem item2 = new JMenuItem("Item 2");
        JMenuItem item3 = new JMenuItem("File Type");
        JMenuItem item4 = new JMenuItem("Last Date Modified");
        JMenuItem item5 = new JMenuItem("Nothing");
        JMenuItem item6 = new JMenuItem("extra");
        JMenuItem item7 = new JMenuItem("extra");




        //setup action listeners
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked menu item 1");
                f = new File(filepath);
                root = new Node(f, colorScheme);
                mainPanel.setRoot(root);
                repaint();
//              mainPanel.file =f;

//                mainPanel.setFilePath(filepath);

            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked menu item 2");
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                // show open dialog method
                chooser.showDialog(mainPanel,"Open");
                File tf = chooser.getSelectedFile();
                root = new Node(tf, 0);
                filepath = tf.getAbsolutePath();
                mainPanel.setRoot(root);
           	 	repaint();
                // pass in
//                filepath = tf;
                System.out.println(tf);
            }
        });
        
        // change the the color scheme by file type
        item3.addActionListener(e -> {
        	 System.out.println("Just pressed 3");
             f = new File(filepath);
             root = new Node(f, 1);
             mainPanel.setRoot(root);
        	 repaint();
        	 
        });
        
        //change color by lastModified;
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f = new File(filepath);
                root = new Node(f, 2);
                mainPanel.setRoot(root);
                repaint();

            }
        });
        
        // Nothing
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f = new File(filepath);
                root = new Node(f, 0);
                mainPanel.setRoot(root);
                repaint();

            }
        });
        
        
        //Age vs GPA
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
        
        
        //# Credits Passed vs AGE
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	

            }
        });

        //now hook them all together
        fileMenu.add(item1);
        fileMenu.add(item2);
        fileMenu.add(colorSchemeMenu);
        colorSchemeMenu.add(item3);
        colorSchemeMenu.add(item4);
        colorSchemeMenu.add(item5);
        colorSchemeMenu.add(item6);
        colorSchemeMenu.add(item7); 
        
        menuBar.add(fileMenu);

        return menuBar;
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
