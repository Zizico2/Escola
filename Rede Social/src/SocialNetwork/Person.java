package SocialNetwork;

    public interface Person {

        void removeFriend(String name);

        void addFriend(Person friend);

        String getName();

        String getStatus();

        void setStatus(String status);

        boolean checkFriend(String name);
}
