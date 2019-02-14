package com.csvparser;

import com.opencsv.bean.CsvBindByName;

public class Student {
    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "studentNumber")
    private String studentNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

}
