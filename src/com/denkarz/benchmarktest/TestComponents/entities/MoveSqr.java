/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.denkarz.benchmarktest.TestComponents.entities;

import static com.denkarz.benchmarktest.GUI.MainWindow.content;
import static com.denkarz.benchmarktest.GUI.MainWindow.jBasicTable;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Denis
 * @e-mail karzdenis@gmail.com
 * @nickname DenKarz
 */
public class MoveSqr extends javax.swing.JPanel implements java.awt.event.ActionListener {
    double  y=10,speedByYAxis=10;
    int iterator=3,i=0;
    javax.swing.Timer timer = new javax.swing.Timer (50,this); 
    long timeout = System.currentTimeMillis();
         
   @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        Rectangle2D square = new Rectangle2D.Double(180, y, 90, 90);
        g2d.setColor(new java.awt.Color (241,108,0));
        g2d.fill(square);
        timer.start();
    }
    
    public void moveUpDown(){
        this.setVisible(true);
        actionPerformed(null);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(y<0||y>490){
            speedByYAxis= -speedByYAxis;
        }
        y+=speedByYAxis; 
        if(y==0){
            i++;
        } 
        repaint();
        if(i==iterator){
           timer.stop();
           timeout = System.currentTimeMillis() - timeout;
           jBasicTable.setValueAt(getTimeout(), 2, 2);
           jBasicTable.setValueAt((int)Math.pow(Double.parseDouble(jBasicTable.getValueAt(2, 1).toString())*(Double.parseDouble(jBasicTable.getValueAt(2, 2).toString()))*(Double.parseDouble(jBasicTable.getValueAt(2, 3).toString())), 1.0/3.0), 2, 4);
           this.setVisible(false);
           this.copyArray();
        }
    }
    
    public long getTimeout(){
        return timeout;
    }
    public void copyArray(){
        for(int k=0;k<3;k++){
            for(int j=0;j<4;j++){
                content[k][j]=Double.parseDouble(jBasicTable.getValueAt(k, j+1).toString());
            }
        }
        
    }
    
}
