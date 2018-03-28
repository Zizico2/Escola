package CloudSharing;

import CloudSharing.User.*;

public class CloudClass implements Cloud {

    Iterator users;

    public CloudClass(){
        users = new Users();
    }

    @Override
    public boolean addUser(String email, boolean premiumAccount) {
        User user;
        // eu sei que "premiumAccount == User.PREMIUM" é redundante mas n sei se assim ficaria mais claro já que temos as constantes
        if(premiumAccount == User.PREMIUM)
            user = new Premium(email);
        else
            user =  new Basic(email);
        if (!checkDuplicateUsers(user)) {
            users.add(user);
            return true;
        }
        return false;
    }

    @Override
    public int upload(String email, String fileName, int mb) {



        return 0;
    }

    @Override
    public int share(String emailOwner, String emailReceiver, String fileName) {
        return 0;
    }

    @Override
    public User minSpace() {
        return null;
    }

    @Override
    public Iterator listFiles(String email) {
        return null;
    }

    @Override
    public Iterator listAll() {
        return users;
    }

    public boolean checkDuplicateUsers(User user) {
        users.initializeIterator();
        User u;
        while(users.hasNext()){
              u = (User) users.next();
            if(u.getID().equals((user.getID())))
                return true;
        }
        return false;
    }
}
