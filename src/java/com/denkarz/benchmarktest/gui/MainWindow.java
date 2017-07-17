package com.denkarz.benchmarktest.gui;
import com.denkarz.benchmarktest.utilClasses.PropertyReader;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
/**
 * Class describes the main window UI.
 * @author Karzykin Denis
 */
public class MainWindow extends javax.swing.JFrame {
    /**
     *Main window panel.
     */
    private javax.swing.JPanel mainPanel;
    /**
     *Start test button.
     */
    private javax.swing.JButton startButton;
    /**
     * Button for normalizing result table.
     */
    private javax.swing.JButton normalizeButton;
    /**
     * Scroll bar.
     */
    private javax.swing.JScrollPane jScrollPane1;
    /**
     * Table container.
     */
    public static javax.swing.JTable jBasicTable;
    /**
     * Table content.
     */
    public static  double[][] content;
    /**
     * Initialization of UI components.
     */
    private void initComponents() {
        content = new double[PropertyReader.ARRAY_ROWS][PropertyReader.ARRAY_COLUMNS];
        mainPanel = new javax.swing.JPanel(new GridBagLayout());
        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("BenchMark Test"));
        startButton = new javax.swing.JButton("Start Test");
        normalizeButton = new javax.swing.JButton("Normalize Table");
        jBasicTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane(jBasicTable);
        jBasicTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {
                {"1st computer", "772", "10236", "2361", (int) Math.pow((Double.parseDouble("772") * (Double.parseDouble("10236")) * (Double.parseDouble("2361"))), 1.0 / 3.0)},
                {"2nd computer", "953", "13245", "2901", (int) Math.pow((Double.parseDouble("953") * (Double.parseDouble("13245")) * (Double.parseDouble("2901"))), 1.0 / 3.0)},
                {"Tested computer", "NULL", "NULL", "NULL", "NULL"},
            },
            new String[] {"№", "ARITHMETIC TEST(ms)", "GRAPHIC TEST(ms)", "R+W TEST(ms)", "TOTAL"}
            ));
        jBasicTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jBasicTable);
        add(mainPanel, new GridBagConstraints(0, 0, 2, 1, .07, .1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(startButton, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, .15, .01,
                GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        add(normalizeButton, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, .15, .01,
                GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        mainPanel.add(jScrollPane1, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 4, 1,1.0, .01,
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
    /**
     * Starting test after clicking button.
     * @param evt mouse click event
     * @see java.awt.event.MouseEvent
     */
    private void startButtonMouseClicked(final java.awt.event.MouseEvent evt) {
        GraphicTestWindow startTest = new GraphicTestWindow();
    }
    /**
     * Normalizing result table after clicking button.
     * @param evt mouse click event
     * @see java.awt.event.MouseEvent
     */
    private void normalizeButtonMouseClicked(final java.awt.event.MouseEvent evt) {
        int[] cont2 = {953, 13245, 2901, (int) Math.pow((Double.parseDouble("953") * (Double.parseDouble("13245"))  * (Double.parseDouble("2901"))), 1.0 / 3.0)};
        for (int i = 0; i < PropertyReader.ARRAY_ROWS; i++) {
            for (int j = 0; j < PropertyReader.ARRAY_COLUMNS; j++) {
                content[i][j] /= cont2[j];
            }
        }
        for (int i = 0; i < PropertyReader.ARRAY_ROWS; i++) {
            for (int j = 0; j < PropertyReader.ARRAY_COLUMNS; j++) {
                jBasicTable.setValueAt(content[i][j], i, j + 1);
            }
        }
    }
    /**
     * Default constructor.
     */
    public MainWindow() {
        super();
        setTitle("BenchMark Test");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(PropertyReader.ICON_PATH));
        setSize(PropertyReader.MAIN_WINDOW_WIDTH, PropertyReader.MAIN_WINDOW_HEIGHT);
        java.awt.Dimension minimumSizeFrame = new java.awt.Dimension(PropertyReader.MAIN_WINDOW_WIDTH_MIN, PropertyReader.MAIN_WINDOW_HEIGHT_MIN);
        setMinimumSize(minimumSizeFrame);
        setLayout(new GridBagLayout());
        initComponents();
        setVisible(true);
    }
}
