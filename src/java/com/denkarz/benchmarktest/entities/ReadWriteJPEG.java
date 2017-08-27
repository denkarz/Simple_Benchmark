package com.denkarz.benchmarktest.entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.denkarz.benchmarktest.gui.MainWindow.jBasicTable;

/**
 * Implementation of I/O test.
 *
 * @author Karzykin Denis
 */
public final class ReadWriteJPEG extends javax.swing.JPanel {
    /**
     * Time of writing files.
     */
    private long finalTimeoutRead;
    /**
     * Time of reading files.
     */
    private long finalTimeoutWrite;
    /**
     * Location of JPEG files for writing.
     */
    private File[] outputFile = {
            new File("src//resources///pics//write//0W.jpg"),
            new File("src//resources///pics//write//1W.jpg"),
            new File("src//resources///pics//write//2W.jpg"),
            new File("src//resources///pics//write//3W.jpg"),
            new File("src//resources///pics//write//4W.jpg"),
            new File("src//resources///pics//write//5W.jpg"),
            new File("src//resources///pics//write//6W.jpg"),
            new File("src//resources///pics//write//7W.jpg"),
            new File("src//resources///pics//write//8W.jpg"),
            new File("src//resources///pics//write//9W.jpg")
    };
    /**
     * Location of JPEG files for reading.
     */
    private String[] url = {
            "src//resources///pics//read//0.jpg",
            "src//resources///pics//read//1.jpg",
            "src//resources///pics//read//2.jpg",
            "src//resources///pics//read//3.jpg",
            "src//resources///pics//read//4.jpg",
            "src//resources///pics//read//5.jpg",
            "src//resources///pics//read//6.jpg",
            "src//resources///pics//read//7.jpg",
            "src//resources///pics//read//8.jpg",
            "src//resources///pics//read//9.jpg"
    };

    /**
     * Read JPEG files.
     */
    public void jpegFileRead() {
        BufferedImage img = null;
        int iterator = 10;
        try {
            for (int i = 0; i < iterator; i++) {
                long timeoutRead = System.currentTimeMillis();
                img = ImageIO.read(new File(url[i]));
                timeoutRead = System.currentTimeMillis() - timeoutRead;
                finalTimeoutRead += timeoutRead;
                long timeoutWrite = System.currentTimeMillis();
                ImageIO.write(img, "JPEG", outputFile[i]);
                timeoutWrite = System.currentTimeMillis() - timeoutWrite;
                finalTimeoutWrite += timeoutWrite;
            }
            jBasicTable.setValueAt(getTimeoutRead() + getTimeoutWrite(), 2, 3);
        } catch (IOException e) {
            System.err.println("IOError");
        }
    }

    /**
     * Get total timeout.
     *
     * @return time in milliseconds
     */
    private long getTimeoutRead() {
        return finalTimeoutRead;
    }

    /**
     * Get JPEG write timeout.
     *
     * @return time in milliseconds
     */
    private long getTimeoutWrite() {
        return finalTimeoutWrite;
    }
}
