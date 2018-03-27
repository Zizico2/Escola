package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

public class PeopleClass implements People{

//        VARIAVEIS
    private Person[] people;
    private int counter,current;

//     CONSTRUTOR
    public PeopleClass(int size){
        people = new Person[size];
        counter = 0;
        current = -1;
    }

    @Override
    public void add(Person  person){
        people[counter++] = person;
    }

    @Override
    public void initializeIterator(){
        current = 0;
    }

    @Override
    public boolean hasNext(){
        return current < counter;
    }

    @Override
    public Person next(){
        return people[current++];
    }
}