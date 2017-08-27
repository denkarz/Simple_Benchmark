package com.denkarz.benchmarktest.entities;

import com.denkarz.benchmarktest.utilClasses.PropertyReader;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static com.denkarz.benchmarktest.gui.MainWindow.content;
import static com.denkarz.benchmarktest.gui.MainWindow.jBasicTable;

/**
 * Implementation of GPU test.
 *
 * @author Karzykin Denis
 */
public final class MoveSqr extends javax.swing.JPanel implements java.awt.event.ActionListener {
    private int i = 0;
    /**
     * Speed square relocation.
     */
    private int speedByYAxis = 10;
    /**
     * Position of square by Y Axis.
     */
    private int yPosition = 10;
    /**
     * Timer.
     */
    private javax.swing.Timer timer = new javax.swing.Timer(50, this);
    /**
     * Total time value.
     */
    private long timeout = System.currentTimeMillis();

    @Override
    public void paintComponent(final java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D square = new Rectangle2D.Double(180, yPosition, 90, 90);
        g2d.setColor(new java.awt.Color(241, 116, 2));
        g2d.fill(square);
        timer.start();
    }

    /**
     * Move square 3 times.
     */
    public void moveUpDown() {
        this.setVisible(true);
        actionPerformed(null);
    }

    @Override
    public void actionPerformed(final java.awt.event.ActionEvent e) {
        int iterator = 3;
        if (yPosition < 0 || yPosition > 490)
            speedByYAxis = -speedByYAxis;
        yPosition += speedByYAxis;
        if (yPosition == 0)
            i++;
        repaint();
        if (i == iterator) {
            timer.stop();
            timeout = System.currentTimeMillis() - timeout;
            jBasicTable.setValueAt(getTimeout(), 2, 2);
            jBasicTable.setValueAt((int) Math.pow(Double.parseDouble(jBasicTable.getValueAt(2, 1).toString()) * (Double.parseDouble(jBasicTable.getValueAt(2, 2).toString())) * (Double.parseDouble(jBasicTable.getValueAt(2, 3).toString())), 1.0 / 3.0), 2, 4);
            setVisible(false);
            this.copyArray();
        }
    }

    /**
     * Get timeout.
     *
     * @return time in milliseconds
     */
    private long getTimeout() {
        return timeout;
    }

    /**
     * Coping array of data.
     */
    private void copyArray() {
        for (int k = 0; k < PropertyReader.ARRAY_ROWS; k++)
            for (int j = 0; j < PropertyReader.ARRAY_COLUMNS; j++)
                content[k][j] = Double.parseDouble(jBasicTable.getValueAt(k, j + 1).toString());
    }
}