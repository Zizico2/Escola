package cbook;

public interface ContactBookInterface {
    int DEFAULT_SIZE = 100;

    boolean hasContact(String name);

    boolean hasContact(int phone);

    int getNumberOfContacts();

    //Pre: name!= null && !hasContact(name)
    void addContact(String name, int phone, String email);

    //Pre: name != null && hasContact(name)
    void deleteContact(String name);

    //Pre: name != null && hasContact(name)
    int getPhone(String name);

    //Pre: name != null && hasContact(name)
    String getEmail(String name);

    //Pre: phone != null && hasContact(phone)
    String getName(int phone);

    //Pre: name != null && hasContact(name)
    void setPhone(String name, int phone);

    //Pre: name != null && hasContact(name)
    void setEmail(String name, String email);

    int searchIndex(String name);

    int searchIndex(int phone);

    void initializeIterator();

    boolean hasNext();

    //Pre: hasNext()
    Contact next();

    boolean checkDuplicatePhone();
}
