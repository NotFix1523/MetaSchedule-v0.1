package me.fix.res;

import java.util.ArrayList;
import java.util.Scanner;

public class Group {
    //Attributes
    private static int id = 0;
    private String name,subject,teacher,language;
    private ArrayList<Session> sessions;

    //Constructor
    public Group(String subject, String teacher, String language) {
        id++;
        this.name = String.valueOf(id);
        this.subject = subject;
        this.teacher = teacher;
        this.language = language;
        this.sessions = new ArrayList<>();
    }

    //Methods
    public void addSession(){
        Scanner scanner =new Scanner(System.in);
        char opt = 'y';

        do {
            System.out.print("Classroom: ");
            String inClassroom = scanner.nextLine();

            System.out.print("Day: ");
            int inDay = scanner.nextInt();

            System.out.print("Start: ");
            int inInitHour = scanner.nextInt();

            System.out.print("End: ");
            int inEndHour = scanner.nextInt();

            Session newSession = new Session(inClassroom,inDay,inInitHour,inEndHour);

            sessions.add(newSession);

            System.out.println("Session added successfully.");

            System.out.print("Do you want to add another session? y/n: ");
            opt = Character.toLowerCase(scanner.next().charAt(0));
            scanner.nextLine();
        }while (opt != 'n');
    }
    public void printSessions(){
        for (Session session : sessions){
            System.out.println("    Classroom: "+ session.getClassroom() + '.');
            System.out.println("    Day: "+ session.getDay() + '.');
            System.out.println("    Start: "+ session.getInit_hour() + ":00");
            System.out.println("    End: "+ session.getEnd_hour() + ":00");

        }
    }

    //Setters & Getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Group.id = id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public ArrayList<Session> getSessions() {
        return sessions;
    }
    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }
}
