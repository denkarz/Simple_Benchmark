package com.denkarz.benchmarktest;

import com.denkarz.benchmarktest.gui.MainWindow;
/**
 * The Simple BenchMark is the program that tests your computer performance.
 * There are 3 basic tests in it.
 * Time (in milliseconds) is a value of performance in all 3 tests.
 * 1. Arithmetic test. Result of this test is the time, which is needed for
 *  finding the solution of the system of equations by the Cramer method.
 * 2. 2D graphic test. Result of this test is the time which is needed for
 *  painting and moving one element over the window.
 * 3. Read/Write test. Result of this test is the time, which is needed for
 *  reading and then writing 10 JPEG pictures.
 * @author Karzykin Denis
 */
public final class StartBenchMarkTest {
    /**
     * Private constructor for utility class.
     */
    private StartBenchMarkTest() {
    }
    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        MainWindow startTest = new MainWindow();
    }
}