package SocialNetwork;

public class PersonClass implements Person {
    private String status,name,email;
    private People friendList;

    public PersonClass(String name, String email, String status){
        this.status = status;
        this.email = email;
        this.name = name;
        friendList = new PeopleClass(People.FRIEND_LIST_SIZE);
    }

    @Override
    public void addFriend(Person friend){
        friendList.addPerson(friend);
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getStatus(){
        return status;
    }

    @Override
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public boolean checkFriend(String name){
        friendList.initializeIterator();
        boolean found = false;
        while(friendList.hasNext() && !found){
            found = friendList.next().getName().equals(name);
        }
        return found;
    }
    @Override
    public People getFriendList(){
        return friendList;
    }
}