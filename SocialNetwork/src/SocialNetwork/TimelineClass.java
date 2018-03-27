package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

public class TimelineClass implements Timeline {

    private String[][] timeline;
    private int counter;
    private int current;

    public TimelineClass(){
        counter = 0;
        current = -1;
        timeline =  new String[DEFAULT_SIZE][DIMENSIONS];
    }

    @Override
    public void add(String post, String author) {
        if (counter == timeline.length - 1)
            resize();
        timeline[counter][POST] = post;
        timeline[counter++][AUTHOR] = author;
    }
    @Override
    public void initializeIterator(){
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return current < counter;
    }

    @Override
    public String[] next() {
        return timeline[current++];
    }

    private void resize(){
        String tmp[][] = new String[2 * timeline.length][DIMENSIONS];
        System.arraycopy(timeline, 0,tmp,0,counter);
        timeline = tmp;
    }
}
