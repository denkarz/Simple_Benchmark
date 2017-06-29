package com.denkarz.benchmarktest.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * @author Denis
 * @e-mail karzdenis@gmail.com
 * @nickname DenKarz
 */
public class MainWindow extends javax.swing.JFrame {
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton normalizeButton;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jBasicTable;
    public static  double[][] content;   
    private void initComponents() {
        content= new double [3][4];
        mainPanel = new javax.swing.JPanel(new GridBagLayout());
        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("BenchMark Test"));
        startButton = new javax.swing.JButton("Start Test");
        normalizeButton = new javax.swing.JButton("Normolize Table");
        jBasicTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane(jBasicTable);
        jBasicTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1st computer","772","10236","2361",(int)Math.pow((Double.parseDouble("772")*(Double.parseDouble("10236"))*(Double.parseDouble("2361"))), 1.0/3.0)},
                {"2nd computer","953","13245","2901",(int)Math.pow((Double.parseDouble("953")*(Double.parseDouble("13245"))*(Double.parseDouble("2901"))), 1.0/3.0)},
                {"Tested computer","NULL","NULL","NULL","NULL"},
            },
            new String [] {
                "№","ARITHMETIC TEST(ms)","GRAPHIC TEST(ms)","R+W TEST(ms)","TOTAL"
            }
        ));
        jBasicTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jBasicTable);
        add(mainPanel, new GridBagConstraints(0, 0, 2, 1, 0.07, 0.1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(startButton, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, 0.15, 0.01,
                GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        add(normalizeButton, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, 0.15, 0.01,
                GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(jScrollPane1, new GridBagConstraints(0,GridBagConstraints.RELATIVE, 4, 1,1.0, 0.01,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        normalizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                normalizeButtonMouseClicked(evt);
            }
        });
    }
    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {
        GraphicTestWindow startTest = new GraphicTestWindow();
        }
    private void normalizeButtonMouseClicked(java.awt.event.MouseEvent evt) {
        int cont2[]={953,13245,2901,(int)Math.pow((Double.parseDouble("953")*(Double.parseDouble("13245"))*(Double.parseDouble("2901"))), 1.0/3.0)};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                content[i][j]/=cont2[j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                jBasicTable.setValueAt(content[i][j], i, j+1);
            }
        }
    }
    public MainWindow(){
        super();
        setTitle("BenchMark Test");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/com/denkarz/benchmarktest/TestComponents/pics/icon/ICON.png"));
        setSize(1000, 600);
        java.awt.Dimension minimumSizeFrame=new java.awt.Dimension(800,480);
        setMinimumSize(minimumSizeFrame);
        setLayout(new GridBagLayout());
        initComponents();   
        setVisible(true);
    }
}
