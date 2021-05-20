package com.example.jobcupid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Candidate {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public String getPreviousExperience() {
        return previousExperience;
    }

    public void setPreviousExperience(String previousExperience) {
        this.previousExperience = previousExperience;
    }

    public String getJobPercentage() {
        return jobPercentage;
    }

    public void setJobPercentage(String jobPercentage) {
        this.jobPercentage = jobPercentage;
    }

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Age")
    @Expose
    private int age;

    @SerializedName("img")
    @Expose
    private String imageUrl;

    @SerializedName("Phone")
    @Expose
    private Integer phone;

    @SerializedName("Location")
    @Expose
    private String location;

    @SerializedName("Salary")
    @Expose
    private String Salary;

    @SerializedName("job_title")
    @Expose
    private String jobTitle;

    @SerializedName("Email")
    @Expose
    private String email;

    @SerializedName("Free_Text")
    @Expose
    private String freeText;


    @SerializedName("previous_experience")
    @Expose
    private String previousExperience;

    @SerializedName("job_percentage")
    @Expose
    private String jobPercentage;



}