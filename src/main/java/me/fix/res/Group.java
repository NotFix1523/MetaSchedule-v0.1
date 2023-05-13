package me.fix.res;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Group {
    //Attributes
    private static int id = 0;
    private String name,subject,teacher,language;
    private ArrayList<Lesson> lessons;

    //Constructor
    public Group(String subject, String teacher, String language) {
        id++;
        this.name = "Group #" + id;
        this.subject = subject;
        this.teacher = teacher;
        this.language = language;
        this.lessons = new ArrayList<>();
    }

    //Methods
    public void addLesson(){
        Scanner scanner =new Scanner(System.in);
        char opt = 0;

        do {
            System.out.println("\nCreating a new Lesson...");
            System.out.print("Classroom: ");
            String inClassroom = scanner.nextLine();

            int inDay = 0;
            boolean validDay = false;
            while(!validDay) {
                try {
                    System.out.print("Day: ");
                    inDay = (Integer.parseInt(scanner.nextLine()))-1;
                    if(inDay < 0 || inDay > 5) {
                        throw new IllegalArgumentException("\nInvalid input for day. Please enter a number between 1 and 6.\n");
                    }
                    validDay = true;
                } catch(NumberFormatException e) {
                    System.out.println("\nInvalid input. Please enter a valid integer.\n");
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            int inInitHour = 0;
            boolean validInitHour = false;
            while(!validInitHour) {
                try {
                    System.out.print("Start: ");
                    inInitHour = Integer.parseInt(scanner.nextLine());
                    if(inInitHour < 7 || inInitHour > 21) {
                        throw new IllegalArgumentException("\nInvalid input for start hour. Please enter a number between 7 and 21.\n");
                    }
                    validInitHour = true;
                } catch(NumberFormatException e) {
                    System.out.println("\nInvalid input. Please enter a valid integer.\n");
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            int inEndHour = 0;
            boolean validEndHour = false;
            while(!validEndHour) {
                try {
                    System.out.print("End: ");
                    inEndHour = Integer.parseInt(scanner.nextLine());
                    if(inEndHour < 8 || inEndHour > 22) {
                        throw new IllegalArgumentException("\nInvalid input for end hour. Please enter a number between 8 and 22.\n");
                    }
                    validEndHour = true;
                } catch(NumberFormatException e) {
                    System.out.println("\nInvalid input. Please enter a valid integer.\n");
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            Lesson newSession = new Lesson(inClassroom,inDay,inInitHour,inEndHour);

            lessons.add(newSession);
            System.out.println("\nNew lesson has been added.");

            boolean validOpt = false;
            while(!validOpt) {
                try {
                    System.out.print("Do you want to add another lesson? y/n: ");
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
        } while (opt != 'n');
    }
    public void printLessons(){
        int i = 0;
        for (Lesson lesson : lessons){
            i++;
            System.out.println("\n    Session #" + i);
            System.out.println("    Classroom: "+ lesson.getClassroom() + '.');
            System.out.println("    Day: "+ DayOfWeek.getDayOfWeek(lesson.getDay()) + ".");
            System.out.println("    Start: "+ _24to12(lesson.getInit_hour()) + ".");
            System.out.println("    End: "+ _24to12(lesson.getEnd_hour()) + ".");
        }
    }

    public enum DayOfWeek {
        LUNES(0),
        MARTES(1),
        MIERCOLES(2),
        JUEVES(3),
        VIERNES(4),
        SABADO(5);

        private int numDay;

        DayOfWeek(int numDay) {
        }

        public static DayOfWeek getDayOfWeek(int numDia) {
            for(DayOfWeek day : DayOfWeek.values()) {
                if(day.numDay == numDia) {
                    return day;
                }
            }
            throw new IllegalArgumentException("Invalid input for day. Please enter a number between 1 and 6.");
        }
    }

    public static String _24to12(int hora24) {
        try {
            SimpleDateFormat format24 = new SimpleDateFormat("HH:mm");
            SimpleDateFormat format12 = new SimpleDateFormat("hh:mm a");
            Date hora = format24.parse(String.format("%02d:00", hora24));
            return format12.format(hora);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid input for time. Please enter a number between 0 and 23.");
    }
    }



    //Setters & Getters

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Group.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
}
