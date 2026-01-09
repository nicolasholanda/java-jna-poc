package com.github.nicolasholanda;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageProcessor {

    public static Mat loadImage(String path) {
        Mat image = Imgcodecs.imread(path);
        if (image.empty()) {
            throw new RuntimeException("Failed to load image: " + path);
        }
        System.out.println("Loaded image: " + path + " [" + image.rows() + "x" + image.cols() + "]");
        return image;
    }

    public static void saveImage(String path, Mat image) {
        boolean success = Imgcodecs.imwrite(path, image);
        if (!success) {
            throw new RuntimeException("Failed to save image: " + path);
        }
        System.out.println("Saved image: " + path);
    }

    public static Mat convertToGrayscale(Mat colorImage) {
        Mat grayImage = new Mat();
        Imgproc.cvtColor(colorImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        System.out.println("Converted to grayscale");
        return grayImage;
    }

    public static Mat applyGaussianBlur(Mat image, int kernelSize) {
        Mat blurred = new Mat();
        org.opencv.core.Size ksize = new org.opencv.core.Size(kernelSize, kernelSize);
        Imgproc.GaussianBlur(image, blurred, ksize, 0);
        System.out.println("Applied Gaussian blur with kernel size: " + kernelSize);
        return blurred;
    }

    public static Mat detectEdges(Mat image) {
        Mat edges = new Mat();
        Imgproc.Canny(image, edges, 50, 150);
        System.out.println("Applied Canny edge detection");
        return edges;
    }
}

