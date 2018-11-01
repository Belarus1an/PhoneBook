package com.samsonenka.telephoneBook;

import com.samsonenka.telephoneBook.OperationContact.AddContact;
import com.samsonenka.telephoneBook.OperationContact.SearchContact;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuOperation {

    static Scanner scanner = new Scanner(System.in);

    public static void getOperatoin() throws SQLException {

        int operation = 0;

        do {
            getPrint();

            while (!scanner.hasNextInt()) {
                System.out.println("Błąd! Spróbuj ponownie");
                getPrint();
                scanner.next();
            }
                operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        AddContact.addContact();
                        break;
                    case 2:
                        SearchContact.searchContact();
                        break;
                    case 3:
                        SearchContact.allContacts();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Błąd! Spróbuj ponownie");
                        break;
                }
        } while (operation != 4);
    }

    public static void getPrint(){

        System.out.println("-----------------\nWybierz operację:\n1 - dodaj kontakt\n2 - wyszukaj / usuń\n3 - Pokaż wszystkie kontakty\n4 - wyjście\n-----------------");
    }
}