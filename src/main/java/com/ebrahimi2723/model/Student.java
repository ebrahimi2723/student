package com.ebrahimi2723.model;

public class Student {
    private String fullName;
    private  Float mark;
    private  Integer year;
    private  Integer isDeleted;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "student{" +
                "fullName='" + fullName + '\'' +
                ", mark=" + mark +
                ", year=" + year +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
