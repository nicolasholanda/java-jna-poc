package com.github.nicolasholanda;

import org.opencv.core.Mat;

public class WebcamDemo {

    public static void run() {
        System.out.println("Webcam Capture");

        WebcamCapture webcam = null;
        Mat frame = null;

        try {
            webcam = new WebcamCapture();

            frame = webcam.captureFrame();
            System.out.println("Frame captured: " + frame.cols() + "x" + frame.rows());

            String outputPath = System.getProperty("user.dir") + "\\webcam-frame.jpg";
            ImageProcessor.saveImage(outputPath, frame);

        } catch (Exception e) {
            System.err.println("Webcam capture failed: " + e.getMessage());
        } finally {
            if (frame != null) frame.release();
            if (webcam != null) webcam.release();
        }
    }
}

