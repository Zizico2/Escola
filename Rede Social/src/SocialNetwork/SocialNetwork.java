package SocialNetwork;

public interface SocialNetwork {

    boolean checkPerson(String name);

    boolean register(String name, String email, String status);

    boolean checkFriendship(String name1, String name2);

    int friend(String name1, String name2);

    People checkFriendList(String name);

    void changeStatus(String name);

    String checkStatus(String name);

}
