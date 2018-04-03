package CloudSharing;

import CloudSharing.User.*;

public class Files implements Iterator {

    private File[] files;
    private int counter;
    private int current;

    public Files(){
        files = new File[2];
        counter = 0;
        current = -1;
    }

    @Override
    public boolean hasNext() {
        return current < counter;
    }

    @Override
    public Object next() {
        return files[current++];
    }

    @Override
    public void initializeIterator() {
        current = 0;
    }

    @Override
    public void add(Object object) {
        files[counter++] = (FileClass) object;
    }
}
