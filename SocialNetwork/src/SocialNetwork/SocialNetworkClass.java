package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

public class SocialNetworkClass implements SocialNetwork{

    // VARIAVEIS
    private People users;

    // CONSTRUTOR
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
        Person jonhdoe;
        while(users.hasNext() && !found) {
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
        Person jonhdoe1;
        Person jonhdoe2;

        if(!checkPerson(name1) || !checkPerson(name2))
            res = NO_REGISTRY;
        else if(checkFriendship(name1,name2))
            res = FRIENDSHIP_ALREADY_EXISTS;
        else if (name1.equals(name2))
            res = INVALID_FRIENDSHIP;
        else {
            jonhdoe1 = getPerson(name1);
            jonhdoe2 = getPerson(name2);

            jonhdoe1.addFriend(jonhdoe2);
            jonhdoe2.addFriend(jonhdoe1);

            res = SUCCESSFUL_FRIENDSHIP;
        }
        return res;
    }

    @Override
    public People checkFriendList(String name){
        Person jonhdoe;
        People friendlist = null;
        boolean found = false;
        users.initializeIterator();
        while(users.hasNext() && !found){
            jonhdoe =  users.next();
            if(jonhdoe.getName().equals(name)){
                found = true;
                friendlist = jonhdoe.getFriendList();
            }
        }
        return friendlist;
    }

    @Override
    public void changeStatus(String name,String status){
        Person jonhdoe;
        users.initializeIterator();
        boolean found = false;
        while(users.hasNext() && !found){
            jonhdoe = users.next();
            if(jonhdoe.getName().equals(name)){
                found = true;
                jonhdoe.setStatus(status);
            }
        }
    }

    @Override
    public String checkStatus(String name){
        Person jonhdoe;
        String status = "";
        users.initializeIterator();
        while(users.hasNext()){
            jonhdoe =  users.next();
            if(jonhdoe.getName().equals(name))
                status = jonhdoe.getStatus();
        }
        return status;
    }

    @Override
    public People getUsers() {
        return users;
    }

    public Timeline getTimeline(String user, String Subject){
            return getPerson(user).getTimeline();
    }

    public boolean addPost(String author, String post){
        if(!checkPerson(author))
            return false;
        else{
            getPerson(author).addPost(post, author);
            return true;
        }

    }

    public int addPost(String author, String subject, String post){
        if(!checkPerson(author))
            return NO_REGISTRY;
        else if(!checkFriendship(author,subject))
            return FRIENDSHIP_NOT_EXISTENT;
        else{
            getPerson(subject).addPost(post,author);
            return SUCCESSFUL_POST;
        }
    }



    /*
      Retorna o utilizador com o mesmo nome que o do argumento, se nao existir retorna null.
      @returns -
                 Person jonhdoe
     */
    private Person getPerson(String name){
       Person jonhdoe =  null;
       boolean found = false;
       users.initializeIterator();
       while(users.hasNext() && !found){
           jonhdoe = users.next();
           if(jonhdoe.getName().equals(name)){
               found = true;
           }
       }
        return jonhdoe;
    }

}
