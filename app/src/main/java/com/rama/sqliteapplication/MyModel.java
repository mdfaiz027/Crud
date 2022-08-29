package com.rama.sqliteapplication;

public class MyModel {
    String name, className,imagePath, videoPath;

    public MyModel(String name, String className, String imagePath, String videoPath) {
        this.name = name;
        this.className = className;
        this.imagePath = imagePath;
        this.videoPath = videoPath;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
