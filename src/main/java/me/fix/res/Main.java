package me.fix.res;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = null;
        Scanner scanner =new Scanner(System.in);
        int opt;

        do {
            System.out.println("These are the features: ");
            if (user != null){

                System.out.println("  1) Add group.");
                System.out.println("  2) Add session to group.");
                System.out.println("  3) Print user data.");
                System.out.println("  4) Export user data.");
                System.out.println("  5) Print schedules.");
                System.out.println("  0) Exit.");
                System.out.print("Select an option: ");
                opt = scanner.nextInt();
                scanner.nextLine();

                switch (opt) {
                    case 0 -> System.out.println("Bye :D");
                    case 1 -> user.addGroup();
                    case 2 -> user.printGroups();
                    case 3 -> System.out.println(user);
                    case 4 -> user.exportUser();
                    case 5 -> user.printSchedules();
                }
            }else {
                System.out.println("  1) Create user.");
                System.out.println("  2) Import user.");
                System.out.println("  0) Exit.");
                System.out.print("Select an option: ");
                opt = scanner.nextInt();
                scanner.nextLine();

                switch (opt) {
                    case 0 -> System.out.println("Bye :D");
                    case 1 -> {
                        user = User.create();
                        user.addGroup();
                    }
                    case 2 -> {
                        user = User.importUser();
                    }
                }
            }
        }while (opt != 0);
    }
}