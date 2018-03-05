import cbook.Contact;
import cbook.ContactBook;

import java.util.Scanner;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

public class Main {
    //Constantes que definem os comandos
    private static final String ADD_CONTACT = "AC";
    private static final String REMOVE_CONTACT = "RC";
    private static final String GET_PHONE = "GP";
    private static final String GET_EMAIL = "GE";
    private static final String GET_NAME = "GN";
    private static final String SET_PHONE = "SP";
    private static final String SET_EMAIL = "SE";
    private static final String EQUAL_PHONE = "EP";
    private static final String LIST_CONTACTS = "LC";
    private static final String QUIT = "Q";

    //Constantes que definem as mensagens para o utilizador
    private static final String CONTACT_EXISTS = "Contact already exists.";
    private static final String NAME_NOT_EXIST = "Contact does not exist.";
    private static final String PHONE_NOT_EXIST = "Phone number does not exist.";
    private static final String CONTACT_ADDED = "Contact added.";
    private static final String CONTACT_REMOVED = "Contact removed.";
    private static final String CONTACT_UPDATED = "Contact updated.";
    private static final String DUPLICATE_PHONE_NOT_EXIST = "All contacts have different phone numbers.";
    private static final String DUPLICATE_PHONE_EXIST = "There are contacts that share phone numbers.";
    private static final String BOOK_EMPTY = "Contact book empty.";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ContactBook cBook = new ContactBook();
        String comm = getCommand(in);

        while (!comm.equals(QUIT)) {
            switch (comm) {
                case ADD_CONTACT:
                    addContact(in, cBook);
                    break;
                case REMOVE_CONTACT:
                    deleteContact(in, cBook);
                    break;
                case GET_PHONE:
                    getPhone(in, cBook);
                    break;
                case GET_EMAIL:
                    getEmail(in, cBook);
                    break;
                case GET_NAME:
                    getName(in, cBook);
                    break;
                case SET_PHONE:
                    setPhone(in, cBook);
                    break;
                case SET_EMAIL:
                    setEmail(in, cBook);
                    break;
                case EQUAL_PHONE:
                    checkDuplicatePhone(cBook);
                    break;
                case LIST_CONTACTS:
                    listAllContacts(cBook);
                    break;
                default:
                    System.out.println("ERRO");
            }
            System.out.println();
            comm = getCommand(in);
        }
        System.out.println("Goodbye!");
        System.out.println();
        in.close();
    }

    private static String getCommand(Scanner in) {
        String input;

        input = in.nextLine().toUpperCase();
        return input;
    }

    private static void addContact(Scanner in, ContactBook cBook) {
        String name, email;
        int phone;

        name = in.nextLine();
        phone = in.nextInt();
        in.nextLine();
        email = in.nextLine();
        if (!cBook.hasContact(name)) {
            cBook.addContact(name, phone, email);
            System.out.println(CONTACT_ADDED);
        } else System.out.println(CONTACT_EXISTS);
    }

    private static void deleteContact(Scanner in, ContactBook cBook) {
        String name;
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.deleteContact(name);
            System.out.println(CONTACT_REMOVED);
        } else System.out.println(NAME_NOT_EXIST);
    }

    private static void getPhone(Scanner in, ContactBook cBook) {
        String name;
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getPhone(name));
        } else System.out.println(NAME_NOT_EXIST);
    }

    private static void getEmail(Scanner in, ContactBook cBook) {
        String name;
        name = in.nextLine();
        if (cBook.hasContact(name)) {
            System.out.println(cBook.getEmail(name));
        } else System.out.println(NAME_NOT_EXIST);
    }

    private static void getName(Scanner in, ContactBook cBook) {
        int phone;
        phone = in.nextInt();
        in.nextLine();
        if (cBook.hasContact(phone)) {
            System.out.println(cBook.getName(phone));
        } else System.out.println(PHONE_NOT_EXIST);
    }

    private static void setPhone(Scanner in, ContactBook cBook) {
        String name;
        int phone;
        name = in.nextLine();
        phone = in.nextInt();
        in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.setPhone(name, phone);
            System.out.println(CONTACT_UPDATED);
        } else System.out.println(NAME_NOT_EXIST);
    }

    private static void setEmail(Scanner in, ContactBook cBook) {
        String name;
        String email;
        name = in.nextLine();
        email = in.nextLine();
        if (cBook.hasContact(name)) {
            cBook.setEmail(name, email);
            System.out.println(CONTACT_UPDATED);
        } else System.out.println(NAME_NOT_EXIST);
    }

    private static void checkDuplicatePhone(ContactBook cBook) {
        if (cBook.checkDuplicatePhone())
            System.out.println(DUPLICATE_PHONE_EXIST);
        else System.out.println(DUPLICATE_PHONE_NOT_EXIST);

    }

    private static void listAllContacts(ContactBook cBook) {
        if (cBook.getNumberOfContacts() != 0) {
            cBook.initializeIterator();
            while (cBook.hasNext()) {
                Contact c = cBook.next();
                System.out.println(c.getName() + "; " + c.getEmail() + "; " + c.getPhone());
            }
        } else System.out.println(BOOK_EMPTY);
    }
}
