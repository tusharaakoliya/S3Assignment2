package com.example.s3assignment2.model;

public class FdaFoodRecall {

    private String code_info, product_description, product_quantity, reason_for_recall,
            country, city, state, address_1,  address_2, report_date, center_classification_date,
             distribution_pattern, recall_firm, recall_number, initial_firm_notification,
            product_type, event_id, more_code_info, recall_initiation_date,
            postal_code, voluntary_mandated, status;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getReason_for_recall() {
        return reason_for_recall;
    }

    public void setReason_for_recall(String reason_for_recall) {
        this.reason_for_recall = reason_for_recall;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getCode_info() {
        return code_info;
    }

    public void setCode_info(String code_info) {
        this.code_info = code_info;
    }

    public String getCenter_classification_date() {
        return center_classification_date;
    }

    public void setCenter_classification_date(String center_classification_date) {
        this.center_classification_date = center_classification_date;
    }

    public String getDistribution_pattern() {
        return distribution_pattern;
    }

    public void setDistribution_pattern(String distribution_pattern) {
        this.distribution_pattern = distribution_pattern;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public String getRecall_firm() {
        return recall_firm;
    }

    public void setRecall_firm(String recall_firm) {
        this.recall_firm = recall_firm;
    }

    public String getRecall_number() {
        return recall_number;
    }

    public void setRecall_number(String recall_number) {
        this.recall_number = recall_number;
    }

    public String getInitial_firm_notification() {
        return initial_firm_notification;
    }

    public void setInitial_firm_notification(String initial_firm_notification) {
        this.initial_firm_notification = initial_firm_notification;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getMore_code_info() {
        return more_code_info;
    }

    public void setMore_code_info(String more_code_info) {
        this.more_code_info = more_code_info;
    }

    public String getRecall_initiation_date() {
        return recall_initiation_date;
    }

    public void setRecall_initiation_date(String recall_initiation_date) {
        this.recall_initiation_date = recall_initiation_date;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getVoluntary_mandated() {
        return voluntary_mandated;
    }

    public void setVoluntary_mandated(String voluntary_mandated) {
        this.voluntary_mandated = voluntary_mandated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", product_description, product_quantity, status);
    }


}