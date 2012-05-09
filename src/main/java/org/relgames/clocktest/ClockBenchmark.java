package org.relgames.clocktest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * @author relgames
 */
public class ClockBenchmark extends SimpleBenchmark {
    public void timeCurrentTimeMillis(int reps) {
        for (int i = 0; i < reps; i++) {
            System.currentTimeMillis();
        }
    }

    public void timeNanoTime(int reps) {
        for (int i = 0; i < reps; i++) {
            System.nanoTime();
        }
    }

    public static void main(String[] args) throws Exception {
        Runner.main(ClockBenchmark.class, args);
    }
}