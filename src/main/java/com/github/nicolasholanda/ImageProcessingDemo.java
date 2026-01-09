package com.github.nicolasholanda;

import org.opencv.core.Mat;

import java.io.File;

public class ImageProcessingDemo {

    public static void run() {
        System.out.println("--- Image Processing ---");

        String workingDir = System.getProperty("user.dir");
        String inputPath = workingDir + File.separator + "sample-input.jpg";
        String outputGrayPath = workingDir + File.separator + "output-grayscale.jpg";
        String outputBlurPath = workingDir + File.separator + "output-blur.jpg";
        String outputEdgesPath = workingDir + File.separator + "output-edges.jpg";

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("sample-input.jpg not found: " + inputPath);
            return;
        }

        Mat originalImage = null;
        Mat grayImage = null;
        Mat blurredImage = null;
        Mat edgesImage = null;

        try {
            originalImage = ImageProcessor.loadImage(inputPath);

            blurredImage = ImageProcessor.applyGaussianBlur(originalImage, 275);
            ImageProcessor.saveImage(outputBlurPath, blurredImage);

            grayImage = ImageProcessor.convertToGrayscale(originalImage);
            ImageProcessor.saveImage(outputGrayPath, grayImage);

            edgesImage = ImageProcessor.detectEdges(grayImage);
            ImageProcessor.saveImage(outputEdgesPath, edgesImage);

            System.out.println("Image processed!");
            System.out.println("Output files:");
            System.out.println("Gray - " + outputGrayPath);
            System.out.println("Blur - " + outputBlurPath);
            System.out.println("Edges - " + outputEdgesPath);

        } catch (Exception e) {
            System.err.println("Image loading failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.err.println("Releasing image resources");
            if (originalImage != null) originalImage.release();
            if (grayImage != null) grayImage.release();
            if (blurredImage != null) blurredImage.release();
            if (edgesImage != null) edgesImage.release();
        }
    }
}

