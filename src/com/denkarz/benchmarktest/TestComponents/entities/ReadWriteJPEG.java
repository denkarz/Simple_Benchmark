/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.denkarz.benchmarktest.TestComponents.entities;

import static com.denkarz.benchmarktest.GUI.MainWindow.jBasicTable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 * @e-mail karzdenis@gmail.com
 * @nickname DenKarz
 */
public class ReadWriteJPEG extends javax.swing.JPanel{
    int iterator=10;
    BufferedImage img = null;
    long finalTimeoutRead,finalTimeoutWrite;
    
    File[] outputFile ={
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/0W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/1W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/2W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/3W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/4W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/5W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/6W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/7W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/8W.jpg"),
        new File("src/com/denkarz/benchmarktest/TestComponents/pics/write/9W.jpg")
    };
    String[] url ={
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/0.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/1.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/2.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/3.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/4.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/5.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/6.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/7.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/8.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/read/9.jpg"
    };
     String[] outUrl ={
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/0.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/1.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/2.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/3.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/4.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/5.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/6.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/7.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/8.jpg",
        "src/com/denkarz/benchmarktest/TestComponents/pics/write/9.jpg",

    };
    public void jpegFileRead(){
        try {
            for(int i=0;i<iterator;i++){
                long timeoutRead= System.currentTimeMillis();
                img = ImageIO.read(new File(url[i]));
                timeoutRead = System.currentTimeMillis() - timeoutRead;
                finalTimeoutRead+=timeoutRead;
                long timeoutWrite= System.currentTimeMillis();
                ImageIO.write(img, "JPEG", outputFile[i]);
                timeoutWrite = System.currentTimeMillis() - timeoutWrite;
                finalTimeoutWrite+=timeoutWrite;
            }
            jBasicTable.setValueAt(getTimeoutRead()+getTimeoutWrite(), 2, 3);
        } catch (IOException e) {
            System.err.println("IOError");
            }
    }
        
    public long getTimeoutRead(){
        return finalTimeoutRead;
    }
      public long getTimeoutWrite(){
        return finalTimeoutWrite;
    }
}
