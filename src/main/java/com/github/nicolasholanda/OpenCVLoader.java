package com.github.nicolasholanda;

import nu.pattern.OpenCV;
import org.opencv.core.Core;

public class OpenCVLoader {

    private static boolean loaded = false;

    public static void load() {
        if (loaded) {
            System.out.println("OpenCV already loaded");
            return;
        }

        try {
            OpenCV.loadLocally();
            loaded = true;
            System.out.println("OpenCV Version: " + Core.getVersionString());
        } catch (Exception e) {
            throw new RuntimeException("Could not load OpenCV native library", e);
        }
    }

    public static boolean isLoaded() {
        return loaded;
    }
}

