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
}

