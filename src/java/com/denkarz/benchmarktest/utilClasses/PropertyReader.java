package com.denkarz.benchmarktest.utilClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyReader is a utility class for reading information from .property file.
 *
 * @author Karzykin Denis
 */
public final class PropertyReader {
    /**
     * Property file location.
     */
    private static final String PROPERTIES_FILE = "src\\resources\\property\\config.properties";
    /**
     * PropertyReader instance.
     */
    private static PropertyReader instance;
    /**
     * Store the "main-window-width" parameter value from property.
     */
    public static final int MAIN_WINDOW_WIDTH = Integer.parseInt(getInstance().
            properties.getProperty("main-window-width"));
    /**
     * Store the "main-window-height" parameter value from property.
     */
    public static final int MAIN_WINDOW_HEIGHT = Integer.parseInt(getInstance().
            properties.getProperty("main-window-height"));
    /**
     * Store the "main-window-width-min" parameter value from property.
     */
    public static final int MAIN_WINDOW_WIDTH_MIN = Integer.parseInt(getInstance().
            properties.getProperty("main-window-width-min"));
    /**
     * Store the "main-window-height-min" parameter value from property.
     */
    public static final int MAIN_WINDOW_HEIGHT_MIN = Integer.parseInt(getInstance().
            properties.getProperty("main-window-height-min"));
    /**
     * Store the "graphic-window-width" parameter value from property.
     */
    public static final int GRAPHIC_WINDOW_WIDTH = Integer.parseInt(getInstance().
            properties.getProperty("graphic-window-width"));
    /**
     * Store the "graphic-window-height" parameter value from property.
     */
    public static final int GRAPHIC_WINDOW_HEIGHT = Integer.parseInt(getInstance().
            properties.getProperty("graphic-window-height"));
    /**
     * Location of the application icon.
     */
    public static final String ICON_PATH = getInstance().
            properties.getProperty("icon-path");
    /**
     * Store number of the array rows.
     */
    public static final int ARRAY_ROWS = Integer.parseInt(getInstance().
            properties.getProperty("array-rows"));
    /**
     * Store number of array columns.
     */
    public static final int ARRAY_COLUMNS = Integer.parseInt(getInstance().
            properties.getProperty("array-columns"));
    /**
     * Properties.
     *
     * @see Properties
     */
    private Properties properties;

    /**
     * Default constructor which tries to load .properties file.
     */
    private PropertyReader() {
        properties = new Properties();
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
        } catch (FileNotFoundException ex) {
            System.err.println("Properties config file not found");
        } catch (IOException ex) {
            System.err.println("Error while reading file");
        } finally {
            try {
                assert propertiesFile != null;
                propertiesFile.close();
            } catch (NullPointerException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Get PropertyReader instance.
     *
     * @return instance
     */
    private static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }
}
