package cbook;

public interface ContactInterface {


    String getName();

    int getPhone();

    void setPhone(int phone);

    String getEmail();

    void setEmail(String email);

    //Pre: otherContact != null
    boolean equals(Contact otherContact);

}
