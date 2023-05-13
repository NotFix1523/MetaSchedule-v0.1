package me.fix.res;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    //Attributes
    private ArrayList<Schedule> schedules;
    private  ArrayList<Group> groups;

    //Constructor
    private User() {
        schedules = new ArrayList<>();
        groups = new ArrayList<>();
    }

    //Methods
    public static void startSession(){
        User user = null;
        Scanner scanner =new Scanner(System.in);
        int opt = -1;

        do {
            System.out.println("\nThese are the features: ");
            if (user != null){
                System.out.println("  1) Add group.");
                System.out.println("  2) Add session to group.");
                System.out.println("  3) Print user data.");
                System.out.println("  4) Export user data.");
                System.out.println("  5) Print schedules.");
                System.out.println("  0) Exit.");
                System.out.print("Select an option: ");
                try {
                    opt = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\nPlease enter a valid option (0-5).");
                    opt = -1;
                    scanner.nextLine();
                }

                switch (opt) {
                    case 0 -> System.out.println("Bye :D");
                    case 1 -> user.addGroup();
                    case 2 -> user.printGroups();
                    case 3 -> System.out.println(user);
                    case 4 -> user.exportUser();
                    case 5 -> user.printSchedules();
                    default ->{
                        if (opt != -1) {
                            System.out.println("\nPlease enter a valid option (0-5).");
                        }
                    }
                }
            }else {
                System.out.println("  1) Create user.");
                System.out.println("  2) Import user.");
                System.out.println("  0) Exit.");
                System.out.print("Select an option: ");
                try {
                    opt = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("\nPlease enter a valid option (0-2).");
                    opt = -1;
                    scanner.nextLine();
                }

                switch (opt) {
                    case 0 -> System.out.println("\nBye :D");
                    case 1 -> {
                        user = User.create();
                        System.out.println("\nWelcome unknown user.");
                        user.addGroup();
                        System.out.println("\nUser created.");
                    }
                    case 2 -> user = User.importUser();
                    default ->{
                        if (opt != -1) {
                            System.out.println("\nPlease enter a valid option (0-2).");
                        }
                    }
                }
            }
        }while (opt != 0);
    }
    public void addGroup(){
        Scanner scanner = new Scanner(System.in);
        char opt = 0;

        do {
            System.out.println("\nCreating a new group...");
            System.out.print("Subject: ");
            String inSubject = scanner.nextLine();

            System.out.print("Teacher: ");
            String inTeacher = scanner.nextLine();

            System.out.print("Language: ");
            String inLanguage = scanner.nextLine();

            Group newGroup = new Group(inSubject,inTeacher,inLanguage);
            newGroup.addLesson();

            groups.add(newGroup);
            System.out.print("\nNew group has been added.");

            boolean validOpt = false;
            while(!validOpt) {
                try {
                    System.out.print("\nDo you want to add another group? y/n: ");
                    opt = Character.toLowerCase(scanner.next().charAt(0));
                    if(opt != 'y' && opt != 'n') {
                        throw new IllegalArgumentException("\nInvalid input. Please enter 'y' or 'n'.\n");
                    }
                    validOpt = true;
                    scanner.nextLine();
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
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
    public static User importUser(){
        Gson gson = new Gson();
        User user = null;
        try (FileReader reader = new FileReader("user.json")) {
            user = gson.fromJson(reader, User.class);
            System.out.println("\nSuccessful import.");
            Group.setId(user.getGroups().size());
        } catch (IOException e) {
            System.out.println("\nUnsuccessful import.");
            e.printStackTrace();
        }
        return user;
    }
    public void printGroups(){
        for (Group group : groups){
            System.out.println("\n" + group.getName() + ")");
            System.out.println("  Subject: "+ group.getSubject() + ".");
            System.out.println("  Teacher: "+ group.getTeacher() + ".");
            System.out.println("  Language: "+ group.getLanguage() + ".");
            System.out.print("  Sessions");
            group.printLessons();
        }
    }
    public void printSchedules(){

    }
    public static User create(){
        return new User();
    }
    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }


    //Setters & Getters
    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
    public ArrayList<Group> getGroups() {
        return groups;
    }
    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}