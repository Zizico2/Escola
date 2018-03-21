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
        users.initializeIterator();
        while (users.hasNext())
            if(users.next().getName().equals(name))
                return true;

        return false;
    }

    @Override
    public boolean register(String name, String email, String status){
        Person jonhdoe;
        if (!checkPerson(name)) {
            jonhdoe = new PersonClass(name, email, status);
            users.add(jonhdoe);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean checkFriendship(String name1, String name2){
        users.initializeIterator();
        Person jonhdoe;
        while(users.hasNext()) {
            jonhdoe = users.next();
            if (jonhdoe.getName().equals(name1) && jonhdoe.checkFriend(name2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int friend(String name1, String name2){
        Person jonhdoe1;
        Person jonhdoe2;

        if(!checkPerson(name1) || !checkPerson(name2))
            return NO_REGISTRY;
        else if(checkFriendship(name1,name2))
            return FRIENDSHIP_ALREADY_EXISTS;
        else if (name1.equals(name2))
            return INVALID_FRIENDSHIP;
        else {
            jonhdoe1 = getUser(name1);
            jonhdoe2 = getUser(name2);

            jonhdoe1.addFriend(jonhdoe2);
            jonhdoe2.addFriend(jonhdoe1);

            return SUCCESSFUL_FRIENDSHIP;
        }
    }

    @Override
    public People checkFriendList(String name){
        Person jonhdoe;
        users.initializeIterator();
        while(users.hasNext()){
            jonhdoe =  users.next();
            if(jonhdoe.getName().equals(name)){
                return jonhdoe.getFriendList();
            }
        }
        return null;
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
        users.initializeIterator();
        while(users.hasNext()){
            jonhdoe =  users.next();
            if(jonhdoe.getName().equals(name))
                return jonhdoe.getStatus();
        }
        return null;
    }

    @Override
    public People getUsers() {
        return users;
    }

    @Override
    public Timeline getTimeline(String user, String Subject){
        return getUser(user).getTimeline();
    }

    @Override
    public boolean addPost(String author, String post){
        if(!checkPerson(author))
            return false;
        else{
            getUser(author).addPost(post, author);
            return true;
        }
    }

    @Override
    public int addPost(String author, String subject, String post){
        if(!checkPerson(author))
            return NO_REGISTRY;
        else if(!checkFriendship(author,subject))
            return FRIENDSHIP_NOT_EXISTENT;
        else{
            getUser(subject).addPost(post,author);
            return SUCCESSFUL_POST;
        }
    }



    /*
      Retorna o utilizador com o mesmo nome que o do argumento, se nao existir retorna null.
      @returns -
                 Person jonhdoe
     */
    public Person getUser(String name){
       Person jonhdoe =  null;

       users.initializeIterator();
       while(users.hasNext()){
           jonhdoe = users.next();
           if(jonhdoe.getName().equals(name))
               return jonhdoe;
       }
       return jonhdoe;
    }

}
