package me.fix.res;

import java.util.ArrayList;

public class Schedule {
    //Attributes
    private static int id;
    private ArrayList<ArrayList<Session>> schedule;

    //Constructor
    public Schedule() {
        this.schedule = new ArrayList<>(6);
    }

    //Methods
    public void addSchedule(ArrayList<Group> groups){
        for (Group group: groups){ //
            for (Session session: group.getSessions()){
                Session hour = schedule.get(session.getDay()).get(session.getInit_hour());
                if (hour == null){
                    hour = session;
                }
            }

        }
    }

    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Schedule.id = id;
    }
    public ArrayList<ArrayList<Session>> getSchedule() {
        return schedule;
    }
    public void setSchedule(ArrayList<ArrayList<Session>> schedule) {
        this.schedule = schedule;
    }
}
