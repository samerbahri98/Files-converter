package main.java.view;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class View extends JFrame {
    private JFileChooser inputFileChooser = new inputFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    
    public View(){
        JPanel viewPanel = new Jpanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        viewPanel.add(inputFileChooser);
        this.add(viewPanel);
    }

}
