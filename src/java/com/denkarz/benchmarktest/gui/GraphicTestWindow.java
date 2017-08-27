package com.denkarz.benchmarktest.gui;

import com.denkarz.benchmarktest.entities.CramerSystem;
import com.denkarz.benchmarktest.entities.MoveSqr;
import com.denkarz.benchmarktest.entities.ReadWriteJPEG;
import com.denkarz.benchmarktest.utilClasses.PropertyReader;

import java.awt.*;

/**
 * Class describes the graphic test window.
 *
 * @author Karzykin Denis
 */
class GraphicTestWindow extends javax.swing.JFrame {
    /**
     * Arithmetic test object.
     *
     * @see CramerSystem
     */
    private final CramerSystem cramerSystemTest = new CramerSystem();
    /**
     * Graphic test object.
     *
     * @see com.denkarz.benchmarktest.entities.MoveSqr
     */
    private final MoveSqr moveSqrTest = new MoveSqr();
    /**
     * I/O test object.
     *
     * @see com.denkarz.benchmarktest.entities.ReadWriteJPEG
     */
    private final ReadWriteJPEG readWriteJPEGTest = new ReadWriteJPEG();

    /**
     * Default constructor.
     */
    GraphicTestWindow() {
        super();
        setTitle("Test");
        setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(PropertyReader.ICON_PATH));
        setSize(PropertyReader.GRAPHIC_WINDOW_WIDTH, PropertyReader.GRAPHIC_WINDOW_HEIGHT);
        setResizable(false);
        java.awt.Dimension minimumSizeFrame = new java.awt.Dimension(PropertyReader.GRAPHIC_WINDOW_WIDTH, PropertyReader.GRAPHIC_WINDOW_HEIGHT);
        setMinimumSize(minimumSizeFrame);
        setLayout(new GridBagLayout());
        initComponents();
        setVisible(true);
    }

    /**
     * Initialization of components.
     */
    private void initComponents() {
        add(readWriteJPEGTest, new GridBagConstraints(0, 0, 2, 1, .07, .1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(moveSqrTest, new GridBagConstraints(0, 0, 2, 1, .07, .1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        readWriteJPEGTest.setVisible(false);
        moveSqrTest.moveUpDown();
        cramerSystemTest.solutionOfCramerSystem();
        readWriteJPEGTest.jpegFileRead();
    }
}
