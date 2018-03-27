package CloudSharing;

public interface Iterator {

    boolean hasNext();

    Object next();

    void initializeIterator();

    boolean add(Object object);

}
