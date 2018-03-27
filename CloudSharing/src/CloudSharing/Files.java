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
    public boolean add(Object object) {
      if(!Has(object)){
          files[counter++] = (FileClass)object;
          return true;
      }
        return false;
    }

    @Override
    public boolean Has(Object object) {
        initializeIterator();
        File newFile = (FileClass)object;
        while(hasNext()){
            File f = (FileClass) next();
            if(f.getName().equals(newFile.getName()))
                return true;
        }
        return false;
    }
}
