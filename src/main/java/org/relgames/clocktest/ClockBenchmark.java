package org.relgames.clocktest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * @author relgames
 */
public class ClockBenchmark extends SimpleBenchmark {
    public long timeCurrentTimeMillis(int reps) {
        long result = 0;
        for (int i = 0; i < reps; i++) {
            result ^= System.currentTimeMillis();
        }
        return result;
    }

    public long timeNanoTime(int reps) {
        long result = 0;
        for (int i = 0; i < reps; i++) {
            result ^= System.nanoTime();
        }
        return result;
    }

/*
    public long timeRdstc(int reps) {
        long result = 0;
        for (int i = 0; i < reps; i++) {
            result ^= NativeRdstc.rdstc();
        }
        return result;
    }
*/
    public static void main(String[] args) throws Exception {
        Runner.main(ClockBenchmark.class, args);
    }
}