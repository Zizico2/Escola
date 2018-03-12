package SocialNetwork;

public interface FriendList {

    void addFriend(Person friend);



    void initializeIterator();

    boolean hasNext();

    //Pre: hasNext();
    Person next();
}
