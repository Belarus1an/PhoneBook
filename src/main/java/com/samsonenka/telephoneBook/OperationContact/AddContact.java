package com.samsonenka.telephoneBook.OperationContact;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddContact extends ConnectionJDBC {

    static Scanner scanner = new Scanner(System.in);

    static String firstName;
    static String lastName;
    static int number;

    public AddContact() throws SQLException, ClassNotFoundException {
    }

    public static void addContact() throws SQLException {

        String INSERT = ("INSERT INTO telephonebook.contacts (firstName, lastName, number) VALUES (?, ?, ?)");
        PreparedStatement prst = getConnection().prepareStatement(INSERT);
        prst.setString(1, getFirstName());
        prst.setString(2,getLastName());
        prst.setInt(3,getNumber());
        prst.execute();

        System.out.println("Kontakt został dodany");
    }

    public static String getFirstName(){

        System.out.print("Wpisz imię: ");
        if (scanner.hasNext()){
            firstName = scanner.next();
        } else {
            getFirstName();
    }
    return firstName;
    }

    public static String getLastName(){

        System.out.print("Wpisz nazwisko: ");
        if (scanner.hasNext()){
            lastName = scanner.next();
        } else {
            getLastName();
        }
        return lastName;
    }

    public static int getNumber(){

        System.out.print("Wprowadź numer: ");
        while (!scanner.hasNextInt()){
            System.out.println("Błąd! Spróbuj ponownie: ");
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }
}
