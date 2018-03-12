package SocialNetwork;

public class PersonClass implements Person {
    private String status,name,email;
    private FriendList FL;

    public PersonClass(String name, String email, String status){
        this.status = status;
        this.email = email;
        this.name = name;
        FL = new FriendListClass();
    }

    public void removeFriend(String name){
        FL.initializeIterator();

        while(FL.hasNext()){
            if(FL.next().getName().equals(name))

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
}