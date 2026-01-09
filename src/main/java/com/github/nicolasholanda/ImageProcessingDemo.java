package com.github.nicolasholanda;

import org.opencv.core.Mat;

import java.io.File;

public class ImageProcessingDemo {

    public static void run() {
        System.out.println("--- Image Processing ---");

        String workingDir = System.getProperty("user.dir");
        String inputPath = workingDir + File.separator + "sample-input.jpg";

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("sample-input.jpg not found: " + inputPath);
            return;
        }

        Mat originalImage = null;
        try {
            originalImage = ImageProcessor.loadImage(inputPath);
            System.out.println("Image was loaded!");
        } catch (Exception e) {
            System.err.println("Image loading failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.err.println("Releasing image resources");
            if (originalImage != null) originalImage.release();
        }
    }
}

