package me.fix.res;

import java.util.ArrayList;

public class Schedule {
    //Attributes
    private Lesson[][] lessons = new Lesson[6][16];

    //Methods
    public static ArrayList<Schedule> createSchedule(ArrayList<Group> groups) {
        ArrayList<Schedule> horarios = new ArrayList<>();
        Schedule newSchedule = new Schedule();

        for (Group group : groups)
            for (Lesson lesson : group.getLessons())
                newSchedule.setSesion(lesson);
        horarios.add(newSchedule);
        return horarios;
    }

    public void setSesion(Lesson lesson) {
        this.lessons[lesson.getDay()][(lesson.getInit_hour()) - 7] = lesson;
    }

    enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }


    public Lesson[][] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[][] lessons) {
        this.lessons = lessons;
    }
}