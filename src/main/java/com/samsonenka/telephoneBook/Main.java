package com.samsonenka.telephoneBook;

import com.samsonenka.telephoneBook.OperationContact.AddContact;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AddContact addContact = new AddContact();
        MenuOperation.getOperatoin();

    }
}