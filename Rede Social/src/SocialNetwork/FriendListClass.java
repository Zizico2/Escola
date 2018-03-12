package SocialNetwork;

public class FriendListClass implements FriendList {
    private Person[] friendList;
    private int counter,current;

    public FriendListClass(){
        friendList = new Person[50];

        counter = -1;
    }

    public void addFriend(Person friend){
        friendList[counter++] = friend;
    }

    public void removeFriend(){
        for (int i = current; i < counter; i++){
            friendList[i] = friendList[i + 1];
        }
    }

    public void initializeIterator(){
        current = 0;
    }

    public boolean hasNext(){
        return current < counter;
    }

    public Person next(){
        return friendList[current++];
    }
}
