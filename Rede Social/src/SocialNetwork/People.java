package SocialNetwork;

public interface People {

    int FRIEND_LIST_SIZE = 50;

    int SOCIAL_NETWORK_SIZE = 500;

    void addPerson(Person friend);

    void initializeIterator();

    boolean hasNext();

    //Pre: hasNext();
    Person next();

    void removePerson();
}
