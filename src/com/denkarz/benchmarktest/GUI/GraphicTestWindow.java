/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.denkarz.benchmarktest.GUI;
import com.denkarz.benchmarktest.TestComponents.entities.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Denis
 * @e-mail karzdenis@gmail.com
 * @nickname DenKarz
 */
public class GraphicTestWindow extends javax.swing.JFrame {
    private final KramerSystem kramerSystemTest = new KramerSystem();
    private final MoveSqr moveSqrTest = new MoveSqr();
    private final ReadWriteJPEG readWriteJPEGTest = new ReadWriteJPEG();    
    
    private void initComponents() {
        add(readWriteJPEGTest, new GridBagConstraints(0, 0, 2, 1, 0.07, 0.1,
                    GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        add(moveSqrTest, new GridBagConstraints(0, 0, 2, 1, 0.07, 0.1,
                    GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
       readWriteJPEGTest.setVisible(false);
       moveSqrTest.moveUpDown();
       kramerSystemTest.solutionOfKramerSystem(); 
       readWriteJPEGTest.jpegFileRead();
    }
    public GraphicTestWindow(){
        super();
        setTitle("Test");
        setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/com/denkarz/benchmarktest/TestComponents/pics/icon/ICON.png"));
        setSize(600, 600);
        setResizable(false);
        java.awt.Dimension minimumSizeFrame=new java.awt.Dimension(600,600);
        setMinimumSize(minimumSizeFrame);
        setLayout(new GridBagLayout());
        initComponents();   
        setVisible(true);
    }
}
