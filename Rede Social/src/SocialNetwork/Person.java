package SocialNetwork;

    public interface Person {

        void addFriend(Person friend);

        String getName();

        String getStatus();

        void setStatus(String status);

        boolean checkFriend(String name);

        People getFriendList();
}
