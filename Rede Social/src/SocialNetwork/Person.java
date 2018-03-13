package SocialNetwork;

    public interface Person {

        void addFriend(Person friend);

        String getName();

        String getStatus();

        String getEmail();

        void setStatus(String status);

        boolean checkFriend(String name);

        People getFriendList();
}
