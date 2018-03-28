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
    public void add(Object object) {
         users[counter++] = (User) object;
    }
}
