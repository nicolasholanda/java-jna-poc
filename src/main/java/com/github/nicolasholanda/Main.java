package com.github.nicolasholanda;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Main {

    public interface WindowsCLibrary extends Library {
        WindowsCLibrary INSTANCE = Native.load("msvcrt", WindowsCLibrary.class);

        int strlen(String s);

        int _getpid();
    }

    public interface UnixCLibrary extends Library {
        UnixCLibrary INSTANCE = Native.load("c", UnixCLibrary.class);

        int strlen(String s);

        int getpid();
    }

    static void main() {
        String testString = "Hello from JNA!";
        int length;
        int pid;

        if (Platform.isWindows()) {
            length = WindowsCLibrary.INSTANCE.strlen(testString);
            pid = WindowsCLibrary.INSTANCE._getpid();
        } else {
            length = UnixCLibrary.INSTANCE.strlen(testString);
            pid = UnixCLibrary.INSTANCE.getpid();
        }

        System.out.println("strlen(\"" + testString + "\") = " + length);
        System.out.println("Current PID: " + pid);
        try {
            OpenCVLoader.load();
        } catch (Exception e) {
            System.err.println("Failed to load OpenCV: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        ImageProcessingDemo.run();
    }
}
