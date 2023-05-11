package me.fix.res;

public class Session {
    //Attributes
    private String classroom;
    private int day,init_hour,end_hour;

    //Constructor
    public Session(String classroom, int day, int init_hour, int end_hour) {
        this.classroom = classroom;
        this.day = day;
        this.init_hour = init_hour;
        this.end_hour = end_hour;
    }

    //Setters & Getters
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getInit_hour() {
        return init_hour;
    }
    public void setInit_hour(int init_hour) {
        this.init_hour = init_hour;
    }
    public int getEnd_hour() {
        return end_hour;
    }
    public void setEnd_hour(int end_hour) {
        this.end_hour = end_hour;
    }
}
