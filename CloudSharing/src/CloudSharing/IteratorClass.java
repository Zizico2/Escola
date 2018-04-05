package CloudSharing;

public class IteratorClass<Element> implements Iterator<Element> {

    private Element[] array;
    private int counter;
    private int current;

    @SuppressWarnings("unchecked")
    public IteratorClass(){
        array = (Element[]) new Object[DEFAULT_SIZE];
        current = -1;
        counter = 0;

    }
    @SuppressWarnings("unchecked")
    private void resize(){
        Element[] temp = (Element[]) new Object[array.length * GROWTH_RATE];

        System.arraycopy(array,0,temp,0,counter);

        array = temp;
    }

    @Override
    public boolean hasNext() {
        return current < counter;
    }

    @Override
    public Element next() {
        return array[current++];
    }

    @Override
    public void add(Element object) {
        if(counter == array.length)
            resize();

        array[counter++] =  object;
    }

    @Override
    public void initialize() {
        current = 0;
    }


}
