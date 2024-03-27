package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Ticket{

    private String row_letter;
    private int seat_number;
    private double price;
    private Person passenger;

    public Ticket(){
    }

    public String getRow(){
        return row_letter;
    }

    public void setRow(String row_letter){
        this.row_letter = row_letter;
    }

    public int getSeat() {
        return seat_number;
    }

    public void setSeat(int seat_number){
        this.seat_number = seat_number;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Person getPassenger(){
        return passenger;
    }

    public void setPassenger(Person passenger){
        this.passenger = passenger;
    }

    public void ticket_information(Ticket[] tickets, int count){
        System.out.println("Seat : " + tickets[count].getRow() + tickets[count].getSeat());
        System.out.println("Ticket price : $" + tickets[count].getPrice());

        tickets[count].getPassenger().printInfo();
    }

    public void save(String row_letter, int seat_number, Ticket[] tickets, int count){
        String file_name = row_letter + this.seat_number + ".txt";

        try{
            FileWriter writer = new FileWriter(file_name);

            writer.write("Ticket Information: \n");
            writer.write("Row number: " + row_letter +"\n");
            writer.write("Seat number: " + this.seat_number + "\n");
            writer.write("Price: $" + price + "\n");
            writer.write("\nPassenger Information: \n");

            writer.write("Name of the Passenger: " + tickets[count].getPassenger().getName());
            writer.write("Surname of the Passenger: " + tickets[count].getPassenger().getSurname());
            writer.write("Email of the Passenger: " + tickets[count].getPassenger().getEmail());

            writer.close();

            System.out.println("Ticket infortion saved to " + file_name);
        } catch(IOException e){
            System.out.println("An error occurred while saving the ticket information! ");
        }

    }
}
