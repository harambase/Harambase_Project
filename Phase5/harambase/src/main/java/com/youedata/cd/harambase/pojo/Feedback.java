package com.youedata.cd.harambase.pojo;

import java.util.List;
import java.util.Map;

public class Feedback {
    private Integer itemid;

    private Double overallrating;

    private Double itemquality;

    private Double delivery;

    private String comments;

    private Integer numOfRec;

    private Double totalRate;

    private List<Map<Integer,Feedback>> feedbackList;

    public Integer getNumOfRec() {
        return numOfRec;
    }

    public void setNumOfRec(Integer numOfRec) {
        this.numOfRec = numOfRec;
    }

    public Double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Double totalRate) {
        this.totalRate = totalRate;
    }

    public List<Map<Integer, Feedback>> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Map<Integer, Feedback>> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Double getOverallrating() {
        return overallrating;
    }

    public void setOverallrating(Double overallrating) {
        this.overallrating = overallrating;
    }

    public Double getItemquality() {
        return itemquality;
    }

    public void setItemquality(Double itemquality) {
        this.itemquality = itemquality;
    }

    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}