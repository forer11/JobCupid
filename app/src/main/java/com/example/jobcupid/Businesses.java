package com.example.jobcupid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Businesses {

    @SerializedName("Name")
    @Expose
    private String name;

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

    public String getJobPercentage() {
        return jobPercentage;
    }

    public void setJobPercentage(String jobPercentage) {
        this.jobPercentage = jobPercentage;
    }

    @SerializedName("job_percentage")
    @Expose
    private String jobPercentage;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}