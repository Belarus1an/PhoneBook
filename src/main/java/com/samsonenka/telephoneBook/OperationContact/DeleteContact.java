package com.samsonenka.telephoneBook.OperationContact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteContact extends ConnectionJDBC {

    static Scanner scanner = new Scanner(System.in);

    private static int idContact;

    public DeleteContact() throws SQLException, ClassNotFoundException {
    }

    public static void deleteContact() throws SQLException {

        int idContactDelete = getIdContact();

        String QUERY = ("SELECT idContact FROM telephonebook.contacts WHERE idContact = (?)");
        PreparedStatement prst1 = getConnection().prepareStatement(QUERY);
        prst1.setInt(1, idContactDelete);
        prst1.execute();

        ResultSet rs = prst1.executeQuery();
        if (!rs.next()) {
            System.out.println("Kontakt o tym identyfikatorze nie istnieje!");
        } else {

            String DELETE = ("DELETE FROM telephonebook.contacts WHERE idContact = (?)");
            PreparedStatement prst2 = getConnection().prepareStatement(DELETE);
            prst2.setInt(1, idContactDelete);
            prst2.execute();

            System.out.println("Kontakt został usunięty");

        }
    }

    public static int getIdContact(){

        System.out.print("Wprowadź identyfikator: ");
        while (!scanner.hasNextInt()){
            System.out.println("Błąd! Spróbuj ponownie: ");
            scanner.next();
        }
        idContact = scanner.nextInt();
        return idContact;
    }
}
