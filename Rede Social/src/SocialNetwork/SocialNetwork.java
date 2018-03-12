package SocialNetwork;

public interface SocialNetwork {

    boolean checkPerson(String name);

    void register(String name, String email, String status);

    boolean checkFriendship(String name1, String name2);

    void friend(String name1, String name2);

    FriendList checkFriendList(String name);

    void changeStatus(String name);

    String checkStatus(String name);

}
