package com.example.ucinternship.model.local;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Supervisor {

    @SerializedName("user_id")
    private int supervisor_user_id;
    @SerializedName("nip")
    private String supervisor_nip;
    @SerializedName("name")
    private String supervisor_name;
    @SerializedName("email")
    private String supervisor_email;
    @SerializedName("description")
    private String supervisor_desc;
    @SerializedName("photo")
    private String supervisor_photo;
    @SerializedName("gender")
    private String supervisor_gender;
    @SerializedName("phone")
    private String supervisor_phone;
    @SerializedName("line_account")
    private String supervisor_line;
    @SerializedName("department_name")
    private String supervisor_department_name;
    @SerializedName("department_initial")
    private String supervisor_department_initial;
    @SerializedName("title")
    private String supervisor_title;

    public Supervisor() {
    }

    public Supervisor(int supervisor_user_id, String supervisor_nip, String supervisor_name, String supervisor_email, String supervisor_desc, String supervisor_photo, String supervisor_gender, String supervisor_phone, String supervisor_line, String supervisor_department_name, String supervisor_department_initial, String supervisor_title) {
        this.supervisor_user_id = supervisor_user_id;
        this.supervisor_nip = supervisor_nip;
        this.supervisor_name = supervisor_name;
        this.supervisor_email = supervisor_email;
        this.supervisor_desc = supervisor_desc;
        this.supervisor_photo = supervisor_photo;
        this.supervisor_gender = supervisor_gender;
        this.supervisor_phone = supervisor_phone;
        this.supervisor_line = supervisor_line;
        this.supervisor_department_name = supervisor_department_name;
        this.supervisor_department_initial = supervisor_department_initial;
        this.supervisor_title = supervisor_title;
    }

    public int getSupervisor_user_id() {
        return supervisor_user_id;
    }

    public void setSupervisor_user_id(int supervisor_user_id) {
        this.supervisor_user_id = supervisor_user_id;
    }

    public String getSupervisor_nip() {
        return supervisor_nip;
    }

    public void setSupervisor_nip(String supervisor_nip) {
        this.supervisor_nip = supervisor_nip;
    }

    public String getSupervisor_name() {
        return supervisor_name;
    }

    public void setSupervisor_name(String supervisor_name) {
        this.supervisor_name = supervisor_name;
    }

    public String getSupervisor_email() {
        return supervisor_email;
    }

    public void setSupervisor_email(String supervisor_email) {
        this.supervisor_email = supervisor_email;
    }

    public String getSupervisor_desc() {
        return supervisor_desc;
    }

    public void setSupervisor_desc(String supervisor_desc) {
        this.supervisor_desc = supervisor_desc;
    }

    public String getSupervisor_photo() {
        return supervisor_photo;
    }

    public void setSupervisor_photo(String supervisor_photo) {
        this.supervisor_photo = supervisor_photo;
    }

    public String getSupervisor_gender() {
        return supervisor_gender;
    }

    public void setSupervisor_gender(String supervisor_gender) {
        this.supervisor_gender = supervisor_gender;
    }

    public String getSupervisor_phone() {
        return supervisor_phone;
    }

    public void setSupervisor_phone(String supervisor_phone) {
        this.supervisor_phone = supervisor_phone;
    }

    public String getSupervisor_line() {
        return supervisor_line;
    }

    public void setSupervisor_line(String supervisor_line) {
        this.supervisor_line = supervisor_line;
    }

    public String getSupervisor_department_name() {
        return supervisor_department_name;
    }

    public void setSupervisor_department_name(String supervisor_department_name) {
        this.supervisor_department_name = supervisor_department_name;
    }

    public String getSupervisor_department_initial() {
        return supervisor_department_initial;
    }

    public void setSupervisor_department_initial(String supervisor_department_initial) {
        this.supervisor_department_initial = supervisor_department_initial;
    }

    public String getSupervisor_title() {
        return supervisor_title;
    }

    public void setSupervisor_title(String supervisor_title) {
        this.supervisor_title = supervisor_title;
    }
}
