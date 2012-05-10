package org.relgames.clocktest;

/**
 * @author Oleg Poleshuk
 */
public class NativeRdstc {
    public static native long rdstc();

    static {
        System.loadLibrary("rdstc");
    }
}
