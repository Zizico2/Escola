package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

public class PersonClass implements Person {

//    VARIAVEIS
    private String status,name,email;
    private People friendList;

//    CONSTRUTOR
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
    public String getEmail(){
        return email;
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