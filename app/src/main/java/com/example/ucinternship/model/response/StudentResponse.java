package com.example.ucinternship.model.response;

import com.example.ucinternship.model.local.Student;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentResponse {
    @SerializedName("data")
    private List<Student> student_data;

    public StudentResponse() {
    }

    public StudentResponse(List<Student> student_data) {
        this.student_data = student_data;
    }

    public List<Student> getStudent_data() {
        return student_data;
    }

    public void setStudent_data(List<Student> student_data) {
        this.student_data = student_data;
    }
}
