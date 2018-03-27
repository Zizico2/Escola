package CloudSharing;

import CloudSharing.User.*;

public class Users implements Iterator {

    private User[] users;
    private int counter;
    private int current;

    public Users(){
        counter = 0;
        current = -1;
        users = new User[DEFAULT_SIZE];
    }

    @Override
    public boolean hasNext() {
        return current < counter;
    }

    @Override
    public Object next() {
        return users[current++];
    }

    @Override
    public void initializeIterator() {
        current = 0;
    }

    @Override
    public boolean add(Object object) {
        if(!Has(object)){
         users[counter++] = (User) object;
        }

        return false;
    }

    @Override
    public boolean Has(Object object) {
       initializeIterator();
       User user = (UserAbstract)object;
        while(hasNext()){
            User u = (UserAbstract) next();
            if(u.getID().equals((user.getID())))
                return true;
        }
        return false;
    }
}
