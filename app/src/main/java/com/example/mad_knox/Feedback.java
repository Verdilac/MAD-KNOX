package com.example.mad_knox;

public class Feedback {
    private String name;
    private String email;
    private String review;
    private String quality;
    private String timelyResponse;
    private String oSatisfaction;

    public Feedback() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getTimelyResponse() {
        return timelyResponse;
    }

    public void setTimelyResponse(String timelyResponse) {
        this.timelyResponse = timelyResponse;
    }

    public String getoSatisfaction() {
        return oSatisfaction;
    }

    public void setoSatisfaction(String oSatisfaction) {
        this.oSatisfaction = oSatisfaction;
    }
}
