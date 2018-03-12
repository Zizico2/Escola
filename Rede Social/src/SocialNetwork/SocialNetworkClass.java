package SocialNetwork;

public class SocialNetworkClass implements SocialNetwork{

    People users;

    public SocialNetworkClass(){
        users = new PeopleClass(People.SOCIAL_NETWORK_SIZE);
    }

    public boolean checkPerson(String name){
        boolean found = false;
        users.initializeIterator();
        while (users.hasNext() || !found)
            found = users.next().getName().equals(name);
        return found;
    }

    public boolean register(String name, String email, String status){
        boolean aux = true;
        Person jonhdoe;

        if (!checkPerson(name)) {
            jonhdoe = new PersonClass(name, email, status);
            users.addPerson(jonhdoe);
        }
        else
            aux = false;
        return aux;
    }

    public boolean checkFriendship(String name1, String name2){
        boolean found = false;
        boolean found2 = false;
        users.initializeIterator();
        Person jonhdoe = null;
        while(users.hasNext() || !found) {
            jonhdoe = users.next();
            if (jonhdoe.getName().equals(name1)) {
                found2 = jonhdoe.checkFriend(name2);
                found = true;
            }
        }

        return found2;
    }

    public int friend(String name1, String name2){
        return 2;
    }

    public People checkFriendList(String name){
        return null;
    }

    public void changeStatus(String name){

    }

    public String checkStatus(String name){
        return null;
    }

}
