package SocialNetwork;

public class PeopleClass implements People{
    private Person[] people;
    private int counter,current;

    public PeopleClass(int size){
        people = new Person[size];

        counter = -1;
    }

    public void addPerson(Person ){
        people[counter++] = friend;
    }

    public void removePerson(){
        for (int i = current; i < counter; i++){
            people[i] = people[i + 1];
        }
        counter--;
    }

    public void initializeIterator(){
        current = 0;
    }

    public boolean hasNext(){
        return current < counter;
    }

    public Person next(){
        return people[current++];
    }
}
