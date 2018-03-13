package SocialNetwork;


public class SocialNetworkClass implements SocialNetwork{

    private People users;

    public SocialNetworkClass(){
        users = new PeopleClass(People.SOCIAL_NETWORK_SIZE);
    }

    @Override
    public boolean checkPerson(String name){
        boolean found = false;
        users.initializeIterator();
        while (users.hasNext() && !found)
            found = users.next().getName().equals(name);
        return found;
    }

    @Override
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

    @Override
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

    @Override
    public int friend(String name1, String name2){
        int res;
        if(checkPerson(name1) || checkPerson(name2))
            res = NO_REGISTRY;
        else if(checkFriendship(name1,name2))
            res = FRIENDSHIP_ALREADY_EXISTS;
        else if (name1.equals(name2))
            res = INVALID_FRIENDSHIP;
        else
            res = SUCCESSFUL_FRIENDSHIP;
        return res;
    }

    @Override
    public People checkFriendList(String name){
        Person user = null;
        People friendlist = null ;
        boolean found = false;
        users.initializeIterator();
        while(users.hasNext() && !found){
            user =  users.next();
            if(user.getName().equals(name)){
                found = true;
                friendlist = user.getFriendList();
            }
        }
        return friendlist;
    }

    @Override
    public void changeStatus(String name){

    }

    @Override
    public String checkStatus(String name){
        return null;
    }

}
