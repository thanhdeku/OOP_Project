package com.hust.edu.shared;

public class Project extends Course {
    private String topic;
    public Project(String courseId, String courseName, int credit,String topic) {
        super(courseId, courseName, credit);
        this.topic = topic;
    }

}
