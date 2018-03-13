package SocialNetwork;

public interface SocialNetwork {

    int SUCCESSFUL_FRIENDSHIP = 0;
    int NO_REGISTRY = 1;
    int FRIENDSHIP_ALREADY_EXISTS = 2;
    int INVALID_FRIENDSHIP = 3;

    boolean checkPerson(String name);

    boolean register(String name, String email, String status);

    boolean checkFriendship(String name1, String name2);

    int friend(String name1, String name2);

    People checkFriendList(String name);

    void changeStatus(String name, String status);

    String checkStatus(String name);

    People getUsers();

}
