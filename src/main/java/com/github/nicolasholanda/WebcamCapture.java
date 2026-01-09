package com.github.nicolasholanda;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class WebcamCapture {

    private VideoCapture camera;
    private boolean isOpen;

    public WebcamCapture() {
        this(0);
    }

    public WebcamCapture(int cameraIndex) {
        camera = new VideoCapture(cameraIndex);
        isOpen = camera.isOpened();

        if (!isOpen) {
            throw new RuntimeException("Failed to open camera " + cameraIndex);
        }

        System.out.println("Camera opened successfully");
    }

    public Mat captureFrame() {
        if (!isOpen) {
            throw new RuntimeException("Camera is not open");
        }

        Mat frame = new Mat();
        boolean success = camera.read(frame);

        if (!success || frame.empty()) {
            throw new RuntimeException("Failed to capture frame");
        }

        return frame;
    }

    public void release() {
        if (camera != null) {
            camera.release();
            isOpen = false;
            System.out.println("Camera released");
        }
    }

    public boolean isOpened() {
        return isOpen;
    }
}

