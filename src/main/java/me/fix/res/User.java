package me.fix.res;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    //Attributes
    private ArrayList<Schedule> schedules;
    private ArrayList<Group> groups;

    //Constructor
    private User() {
        this.groups = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    //Methods
    public void addGroup(){
        Scanner scanner =new Scanner(System.in);
        char opt = 'y';

        do {
            System.out.print("Subject: ");
            String inSubject = scanner.nextLine();

            System.out.print("Teacher: ");
            String inTeacher = scanner.nextLine();

            System.out.print("Language: ");
            String inLanguage = scanner.nextLine();

            Group newGroup = new Group(inSubject,inTeacher,inLanguage);

            newGroup.addSession();

            groups.add(newGroup);

            System.out.println("Group added successfully.");

            System.out.print("Do you want to add another group? y/n: ");
            opt = Character.toLowerCase(scanner.next().charAt(0));
            scanner.nextLine();
        }while (opt != 'n');
    }
    public void exportUser(){
        Gson gson = new Gson();
        String json = gson.toJson(this);

        try (FileWriter writer = new FileWriter("user.json")) {
            writer.write(json);
            System.out.println("Successful export.");
        } catch (IOException e) {
            System.out.println("Unsuccessful export.");
            e.printStackTrace();
        }

    }
    public void printGroups(){
        for (Group group : this.getGroups()){
            System.out.println("Group #"+ group.getName() + ")");
            System.out.println("  Subject: "+ group.getSubject() + ".");
            System.out.println("  Teacher: "+ group.getTeacher() + ".");
            System.out.println("  Language: "+ group.getLanguage() + ".");
            System.out.println("  Sessions:");
            group.printSessions();
        }
    }
    public void printSchedules(){

    }


    public static User importUser(){
        Gson gson = new Gson();
        User user = null;
        try (FileReader reader = new FileReader("user.json")) {
            user = gson.fromJson(reader, User.class);
            System.out.println("Successful import.");
        } catch (IOException e) {
            System.out.println("Unsuccessful import.");
            e.printStackTrace();
        }
        Group.setId(user.groups.size());
        return user;
    }
    public static User create(){
        User newUser = new User();
        return newUser;
    }


    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    //Setters & Getters
    public ArrayList<Group> getGroups() {
        return groups;
    }
    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
