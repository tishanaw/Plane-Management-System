package com.company;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagementSystem {

    public static void main(String []args){
        Scanner input = new Scanner(System.in);

        // Welcome message
        System.out.println();
        System.out.println("Welcome to the Plane Management application!\n");

        // Create 4 integer arrays to use as a seat
        int[] A = new int[14];
        int[] B = new int[12];
        int[] C = new int[12];
        int[] D = new int[14];

        //Created integer array to use as tickets
        Ticket[] tickets = new Ticket[52];

        // create a boolean variable for control the while loop
        boolean flag = true;

        // Create the Menu
        while (flag){
            System.out.println("*******************************************************");
            System.out.println("           *          Menu Options          *          ");
            System.out.println("*******************************************************");
            System.out.println();
            System.out.println("\t1. Buy a Seat.");
            System.out.println("\t2. Cancel a Seat.");
            System.out.println("\t3. Find first available seat.");
            System.out.println("\t4. Show seating plan.");
            System.out.println("\t5. Print tickets information and the total sales.");
            System.out.println("\t6. Search the ticket.");
            System.out.println("\t0. End.");
            System.out.println();
            System.out.println("*******************************************************");
            System.out.println();
            System.out.println("Please select any other option: ");

            try{
                //Read the inputs as integers
                int option = input.nextInt();

                switch(option){
                    case 0:
                        System.out.println("Exited");
                        flag = false;
                        break;

                    case 1:
                        // Call buy_seat method and pass 4 integer arrays and tickets array as arguments.
                        buy_seat(A,B,C,D,tickets);
                        break;

                    case 2:
                        // Call cancel_seat method and pass 4 integer arrays and tickets array as arguments.
                        cancel_seat(A,B,C,D,tickets);
                        break;

                    case 3:
                        // Call find_first_available method and pass 4 integer arrays as arguments.
                        find_first_available(A, B, C, D,tickets);
                        break;

                    case 4:
                        // Call show_seating_plan method and pass 4 integer arrays as arguments.
                        show_seating_plan(A,B,C,D);
                        break;

                    case 5:
                        // Call show_seating_plan method and pass tickets array as arguments.
                        print_tickets_info(tickets);
                        break;

                    case 6:
                        search_ticket(tickets);
                        break;

                    default:
                        System.out.println("Invalid Input!!!");
                        System.out.println();
                }
            } catch (InputMismatchException | FileNotFoundException e){
                // Handle the case when a non-integer input is entered
                System.out.println("\nInvalid input. Please enter a valid integer option.\n");
                input.nextInt();

            }
        }
    }

    public static void buy_seat(int[] A, int[] B, int[] C, int[] D, Ticket[] tickets) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        // Create String variable for store the input row letter
        String row_letter = "";

        // Create String variable for store the input seat number
        int seat_number = 0;

        boolean flag = true;
        while (flag){
            System.out.println("Enter Row Letter(A/B/C/D): ");
            row_letter = input.next().toUpperCase();

            if(row_letter.equals("A")){
                while(true){
                    try{
                        System.out.println("Enter Seat Number (1 - 14): ");
                        seat_number = input.nextInt();

                        if(seat_number < 1 || seat_number > 14){
                            System.out.println("\nInvalid Seat Number!\n");
                        } else {
                            if (A[seat_number - 1] == 1){
                                System.out.println("A" + seat_number + "Seat not Available.");
                                break;
                            }
                            else{
                                A[seat_number -1] = 1;

                                flag = false;
                                break;
                            }
                        }
                    } catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            }
            else if(row_letter.equals("B")){
                while(true){
                    try{
                        System.out.println("Enter seat number(1-12): ");
                        seat_number = input.nextInt();

                        if(seat_number < 1 || seat_number > 12){
                            System.out.println("\nInvalid Seat Number!\n");
                        } else{
                            if(B[seat_number - 1] == 1){
                                System.out.println("B" + seat_number + "Seat not Available.");
                                break;
                            } else{
                                B[seat_number - 1] = 1;

                                flag = false;
                                break;
                            }
                        }
                    }catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            } else if(row_letter.equals("C")){
                while(true){
                    try{
                        System.out.println("Enter the seat number(1 - 12): ");
                        seat_number = input.nextInt();

                        if(seat_number < 1 || seat_number > 12){
                            System.out.println("\nInvalid Seat Number!\n");
                        } else{
                            if(C[seat_number - 1] == 1){
                                System.out.println("C" + seat_number + "Seat not Available.");
                                break;
                            } else{
                                C[seat_number - 1] = 1;

                                flag = false;
                                break;
                            }
                        }
                    }catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            } else if(row_letter.equals("D")){
                while(true){
                    try{
                        System.out.println("Enter the seat number(1 - 14): ");
                        seat_number = input.nextInt();

                        if(seat_number < 1 || seat_number > 14){
                            System.out.println("\nInvalid seat number!\n");
                        } else {
                            if(D[seat_number - 1] == 1){
                                System.out.println("D" + seat_number + "Seat not available.");
                                break;
                            } else{
                                D[seat_number - 1] = 1;

                                flag = false;
                                break;
                            }
                        }
                    } catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            } else {
                System.out.println("\nInvalid Row Letter!\n");
            }
        }
        // Gather information about the person
        System.out.println("Enter the name of passenger: ");
        String name = input.next();
        System.out.println("Enter the surname of passenger: ");
        String surname = input.next();
        System.out.println("Enter the email of passenger: ");
        String email = input.next();

        //Create a new Person object
        Person passenger = new Person();
        passenger.setName(name);
        passenger.setSurname(surname);
        passenger.setEmail(email);

        //Create a new Ticket object
        Ticket ticket = new Ticket();
        ticket.setRow(row_letter);
        ticket.setSeat(seat_number);
        ticket.setPrice(calculate_price(seat_number));
        ticket.setPassenger(passenger);

        int count = check_ticket(row_letter,seat_number);

        //Add the ticket to the array of Tickets
        tickets[count] = ticket;

        Ticket ticket1 = new Ticket();

        ticket1.save(row_letter, seat_number, tickets, count);

        System.out.println(row_letter + seat_number + " Seat booked Successfully!");
    }

    public static void cancel_seat(int[] A, int[] B, int[] C, int[] D, Ticket[] tickets){
        Scanner input = new Scanner(System.in);

        //Create a string variable for store the input row letter
        String row_letter;
        //Create a string variable for store the input seat number
        int seat_number;

        boolean flag = true;
        while(flag){
            System.out.println("Enter row letter (A/B/C/D): ");
            row_letter = input.next().toUpperCase();

            if(row_letter.equals("A")){
                while(true){
                    try{
                        System.out.println("Enter seat number(1 - 14): ");
                        seat_number = input.nextInt();

                        int count = check_ticket(row_letter, seat_number);

                        if(seat_number < 1 || seat_number > 14){
                            System.out.println("\nInvalid seat number!\n");
                        } else {
                            if(A[seat_number - 1] == 0){
                                System.out.println("A" + seat_number + "Seat Available.");

                                flag = false;
                                break;
                            }
                            else{
                                A[seat_number - 1] = 0;
                                tickets[count] = null;
                                System.out.println("A" + seat_number + "Seat cancelled Successfully!");

                                flag = false;
                                break;
                            }
                        }
                    } catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            }else if(row_letter.equals("B")){
                while(true){
                    try{
                        System.out.println("Enter the seat number(1 -12): ");
                        seat_number = input.nextInt();
                        int count = check_ticket(row_letter, seat_number);

                        if(seat_number < 1 || seat_number > 12){
                            System.out.println("\nInvalid Seat Number!\n");
                        }
                        else{
                            if(B[seat_number - 1] == 0){
                                System.out.println("B" + seat_number + "Seat Available.");
                                flag = false;
                                break;
                            }
                            else{
                                B[seat_number - 1] = 0;
                                tickets[count] = null;
                                System.out.println("B" + seat_number + "Seat cancelled successfully.");
                                flag = false;
                                break;
                            }
                        }
                    } catch(InputMismatchException e){
                        System.out.println("\nInvalid input. Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            } else if (row_letter.equals("C")){
                while(true){
                    try{
                        System.out.println("Enter seat number(1 - 12): ");
                        seat_number = input.nextInt();

                        int count = check_ticket(row_letter, seat_number);

                        if(seat_number < 1 || seat_number > 12){
                            System.out.println("\nInvalid seat number!\n");
                        }
                        else{
                            if(C[seat_number - 1] == 0){
                                System.out.println("C" + seat_number + "Seat available.");
                                flag = false;
                                break;
                            }
                        }
                    } catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            }else if(row_letter.equals("D")){
                while(true){
                    try{
                        System.out.println("Enter seat number(1 - 14): ");
                        seat_number = input.nextInt();
                        int count = check_ticket(row_letter, seat_number);
                        if(seat_number < 1 || seat_number > 14){
                            System.out.println("\nInvalid seat number!\n");
                        }
                        else{
                            if (D[seat_number - 1] == 0){
                                System.out.println("D" + seat_number + "Seat Available.");

                                flag = false;
                                break;
                            }
                            else{
                                D[seat_number - 1] = 0;
                                tickets[count] = null;
                                System.out.println("D" + seat_number + "Seat cancelled successfully!");
                                flag = false;
                                break;
                            }
                        }
                    }catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            }
            else{
                System.out.println("\nInvalid Row Letter!\n");
            }
        }
    }

    public static void find_first_available(int[] A, int[] B, int[] C, int[] D, Ticket[] tickets){
        int temp = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                System.out.println("A" + (i + 1) + "is Available.");
                temp = 0;
                break;
            }
        }

        if(temp != 1){
            for(int i = 0; i < B.length; i++){
                if(B[i] == 0){
                    System.out.println("B" + (i + 1) + "is Available.");
                    temp = 1;
                    break;
                }
            }
        }

        if(temp != 1){
            for (int i = 0; i < C.length; i++){
                if(C[i] == 0){
                    System.out.println("C" + (i + 1) + "is Available.");
                    temp = 1;
                    break;
                }
            }
        }

        if(temp != 1){
            for(int i = 0; i < D.length; i++){
                if(D[i] == 0){
                    System.out.println("D" + (i + 1) + "is Available.");
                    temp = 1;
                    break;
                }
            }
        }
        if(temp != 1){
            System.out.println("All seats Booked!");
        }
    }

    public static void show_seating_plan(int[] A, int[] B, int[] C, int[] D){
        System.out.println();

        System.out.print("A | ");
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0){
                System.out.print("O ");
            }else{
                System.out.print("X ");
            }
        }
        System.out.println();
        System.out.print("B | ");
        for (int i = 0; i < B.length; i++) {
            if(B[i] == 0){
                System.out.print("O ");
            }else{
                System.out.print("X ");
            }
        }
        System.out.println();
        System.out.print("C | ");
        for (int i = 0; i < C.length; i++) {
            if(C[i] == 0){
                System.out.print("O ");
            }else{
                System.out.print("X ");
            }
        }
        System.out.println();
        System.out.print("D | ");
        for (int i = 0; i < D.length; i++) {
            if(D[i] == 0){
                System.out.print("O ");
            }else{
                System.out.print("X ");
            }
        }
        System.out.println();
    }

    public static void print_tickets_info(Ticket[] tickets){
        double total_sales = 0.0;

        System.out.println("Tickets Information: ");
        for(Ticket ticket: tickets){
            if(ticket != null){
                System.out.println("Row:" + ticket.getRow() + ",Seat:" + ticket.getSeat() + ",Price:$" + ticket.getPrice());
                total_sales += ticket.getPrice();
            }
        }
        System.out.println("Total Sales: $" + total_sales);
    }

    public static void search_ticket(Ticket[] tickets){
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            System.out.println("Enter seat row(A|B|C|D): ");
            String row = input.next().toUpperCase();
            if(row.equals("A")){
                while(true){
                    try{
                        System.out.println("Enter seat number(1 - 14): ");
                        int seat_number = input.nextInt();
                        if(seat_number > 0 && seat_number < 15){
                            int temp = check_ticket(row, seat_number);

                            if(tickets[temp] != null){
                                System.out.println("This seat is Booked");
                                tickets[temp].ticket_information(tickets,temp);
                                flag = false;
                                break;

                            }else{
                                System.out.println("available");
                                flag = false;
                                break;
                            }

                        }else{
                            System.out.println("Invalid seat number!");
                            break;
                        }
                    } catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            }
            else if(row.equals("B")){
                while(true){
                    try{
                        System.out.println("Enter seat number (1 - 12): ");
                        int seat_number = input.nextInt();
                        if(seat_number > 0 && seat_number < 13){
                            int temp = check_ticket(row, seat_number);

                            if(tickets[temp] != null){
                                System.out.println("This seat is Booked");
                                tickets[temp].ticket_information(tickets,temp);
                                flag = false;
                                break;

                            }else{
                                System.out.println("available");
                                flag = false;
                                break;
                            }

                        }
                        else{
                            System.out.println("Invalid seat number!");
                            break;
                        }
                    }catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            } else if(row.equals("C")){
                while(true){
                    try{
                        System.out.println("Enter seat number (1 - 12): ");
                        int seat_number = input.nextInt();
                        if (seat_number>0 && seat_number<13){
                            int temp = check_ticket(row,seat_number);
                            if(tickets[temp] != null){
                                System.out.println("This seat is Booked");
                                tickets[temp].ticket_information(tickets,temp);
                                flag = false;
                                break;

                            }else{
                                System.out.println("available");
                                flag = false;
                                break;
                            }
                        }
                        else{
                            System.out.println("Invalid seat number!");
                            break;
                        }
                    } catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            }
            else if(row.equals("D")){
                while(true){
                    try{
                        System.out.println("Enter seat number (1 - 14): ");
                        int seat_number = input.nextInt();
                        if(seat_number > 0 && seat_number < 15){
                            int temp = check_ticket(row, seat_number);
                            if(tickets[temp] != null){
                                System.out.println("This seat is Booked");
                                tickets[temp].ticket_information(tickets,temp);
                                flag = false;
                                break;

                            }else{
                                System.out.println("available");
                                flag = false;
                                break;
                            }
                        }
                        else{
                            System.out.println("Invalid seat number!");
                            break;
                        }
                    }catch(InputMismatchException e){
                        System.out.println("\nInvalid input! Please enter a valid integer option.\n");
                        input.nextLine();
                    }
                }
            }
            else{
                System.out.println("Invalid row!");
            }
        }
    }

    private static int check_ticket(String row, int seat_number){
        int count = 0;
        if(row.equals("A")){
            count = seat_number;
            return count - 1;
        }
        else if(row.equals("B")){
            count = 14 + seat_number;
            return count - 1;
        }
        else if(row.equals("C")){
            count = 26 + seat_number;
            return count - 1;
        }
        else{
            count = 38 + seat_number;
            return count - 1;
        }
    }

    private static double calculate_price(int seat_number){
        if(seat_number < 6){
            return 200;
        }
        else if(seat_number < 10){
            return 150;
        }
        else{
            return 180;
        }
    }
}