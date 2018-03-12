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

    public void removeFriend(String name){
        friendList.initializeIterator();
        boolean aux = false;
        while(friendList.hasNext() || !aux){
            if(friendList.next().getName().equals(name))
                friendList.removePerson();
            aux = true;
            }
    }

    public void addFriend(Person friend){

    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public boolean checkFriend(String name){
        friendList.initializeIterator();
        boolean found = false;
        while(friendList.hasNext() || !found){
            found = friendList.next().getName().equals(name);
        }
        return found;
    }
}