package com.samsonenka.telephoneBook.OperationContact;

import com.samsonenka.telephoneBook.MenuOperation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchContact extends ConnectionJDBC {

    static Scanner scanner = new Scanner(System.in);

    public SearchContact() throws SQLException, ClassNotFoundException {
    }

    public  static void searchContact() throws SQLException{

        String QUERY = ("SELECT * FROM telephonebook.contacts WHERE lastName = (?)");
        PreparedStatement prst = getConnection().prepareStatement(QUERY);
        prst.setString(1, AddContact.getLastName());

        ResultSet resultSet = prst.executeQuery();

        if (resultSet.next()) {

            do {
                System.out.println(resultSet.getInt("idContact") + " | " + resultSet.getString("firstName")
                        + " | " + resultSet.getString("lastName") + " | " + resultSet.getInt("number"));
            }while (resultSet.next());
        } else {
            System.out.println("Kontakt nie został znaleziony!");
            MenuOperation.getOperatoin();
        }

        int operation = 0;

        do {
            getPrint();

            while (!scanner.hasNextInt()) {
                System.out.println("Błąd! Spróbuj ponownie!");
                getPrint();
                scanner.next();
            }

            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    DeleteContact.deleteContact();
                    MenuOperation.getOperatoin();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Błąd! Spróbuj ponownie!");
            }
        }while (operation != 2);

        prst.close();
    }

    public static void allContacts () throws SQLException {

        String QUERY = ("SELECT * FROM telephonebook.contacts");
        PreparedStatement prst = getConnection().prepareStatement(QUERY);
        ResultSet resultSet = prst.executeQuery();

         while (resultSet.next()){
             System.out.println(resultSet.getInt("idContact") + " | " + resultSet.getString("firstName") +
                     " | " + resultSet.getString("lastName") + " | " + resultSet.getInt("number"));
         }
        prst.close();
    }


    public static void getPrint(){

        System.out.println("\"-----------------\nWybierz operację:\n1 - usuń\n2 - wyjście");
    }

}
