import java.util.Scanner;
import SocialNetwork.*;

public class Main {

    // Constantes para o interpretador
    private static final String EXIT = "SAIR";
    private static final String CHECK_PERSON = "CONSULTAPESSOA";
    private static final String REGISTER= "REGISTA";
    private static final String CHECK_FRIENDSHIP = "CONSULTAAMIZADE";
    private static final String FRIENDS = "AMIGOS";
    private static final String CHECK_FRIEND_LIST = "CONSULTAAMIGOS";
    private static final String NEW_STATUS = "NOVOESTADO";
    private static final String CHECK_STATUS = "CONSULTAESTADO";
    private static final String PEOPLE = "PESSOAS";
    private static final String UNKNOWN_COMMAND = "Comando inexistente!";

    // Constantes para os metodos privados da main
    private static final String END_MSG = "Adeus." + "\n" + "\n";
    private static final String PERSON_REGISTERED = "Pessoa registada.";
    private static final String NO_REGISTRY = "Sem registo.";
    private static final String SUCCESSFUL_REGISTRY = "Pessoa registada com sucesso.";
    private static final String FRIENDSHIP_NON_EXISTENT = "Amizade inexistente.";
    private static final String FRIENDSHIP_EXISTS = "Amizade existente.";
    private static final String INVALID_FRIENDSHIP = "Amizade invalida.";
    private static final String FRIENDSHIP_CREATED = "Amizade criada.";
    private static final String EMPTY_FRIENDLIST = "Nao tem amigos registados.";
    private static final String FRIENDLIST_MSG = "Lista de amigos:";
    private static final String STATUS_CHANGED = "Estado alterado.";
    private static final String EMPTY_SOCIAL_NETWORK = "Rede Social vazia.";
    private static final String SOCIAL_NETWORK_USERS_MSG = "Lista de pessoas registadas:";
    private static final int SN_MSG = 0;
    private static final int FL_MSG = 1;

    // Metodo main
    public static void main(String args[]){
        Scanner input =  new Scanner(System.in);
        SocialNetwork SN = new SocialNetworkClass();
        executeCommand(input,SN);
        input.close();
    }

    // Interpretador de commandos
    private static void executeCommand(Scanner in, SocialNetwork SN){
        String cmd = "";
        while(!cmd.equals(EXIT)) {
            cmd = in.nextLine().toUpperCase();
            switch(cmd){
                case CHECK_PERSON:
                    checkPerson(SN, in);
                    break;

                case REGISTER:
                    register(SN, in);
                    break;

                case CHECK_FRIENDSHIP:
                    checkFriendship(SN, in);
                    break;

                case FRIENDS:
                    friends(SN, in);
                    break;

                case CHECK_FRIEND_LIST:
                    checkFriendList(SN, in);
                    break;

                case NEW_STATUS:
                    newStatus(SN, in);
                    break;

                case CHECK_STATUS:
                    checkStatus(SN, in);
                    break;

                case PEOPLE:
                    people(SN);
                    break;

                case EXIT: break;

                default:System.out.println(UNKNOWN_COMMAND);
            }
            if(!cmd.equals(EXIT))
                 System.out.println();
            else
                System.out.print(END_MSG);
        }
    }

    // Verifica se a pessoa existe e escreve na consola a mensagem respetiva.
    private static void checkPerson(SocialNetwork SN, Scanner in){
        String name = in.nextLine();
        if (!SN.checkPerson(name))
            System.out.println(NO_REGISTRY);
        else
            System.out.println(PERSON_REGISTERED);
    }

    // Tenta registar uma pessoa, recebe o resultado e escreve na consola a mensagem respetiva.
    private static void register(SocialNetwork SN, Scanner in){
        if (SN.register(in.nextLine(), in.nextLine(), in.nextLine()))
            System.out.println(SUCCESSFUL_REGISTRY);
        else
            System.out.println(PERSON_REGISTERED);
    }

    // Verifica se existe amizade entre duas pessoas na rede social e escreve a mensagem respetiva na consola.
    private static void checkFriendship(SocialNetwork SN, Scanner in){
        if (SN.checkFriendship(in.nextLine(), in.nextLine()))
            System.out.println(FRIENDSHIP_EXISTS);
        else
            System.out.println(FRIENDSHIP_NON_EXISTENT);
    }

    // Tenta criar uma amizade entre duas pessoas recebe o resultado e escreve na consola a mensagem respetiva.
    private static void friends(SocialNetwork SN, Scanner in) {
       String name1 = in.nextLine();
       String name2 = in.nextLine();
        switch (SN.friend(name1, name2)){

            case SocialNetwork.NO_REGISTRY:
                System.out.println(NO_REGISTRY);
                break;

            case SocialNetwork.INVALID_FRIENDSHIP:
                System.out.println(INVALID_FRIENDSHIP);
                break;

            case SocialNetwork.FRIENDSHIP_ALREADY_EXISTS:
                System.out.println(FRIENDSHIP_EXISTS);
                break;

            case SocialNetwork.SUCCESSFUL_FRIENDSHIP:
                SN.friend(name1, name2);
                System.out.println(FRIENDSHIP_CREATED);
        }
    }

    // Verifica se existe a pessoa, se sim escreve a sua lista de amigos, se nao escreve a mensagem respetiva na consola
    private static void checkFriendList(SocialNetwork SN, Scanner in){
        People friendList;
        String name = in.nextLine();
        if(!SN.checkPerson(name))
            System.out.println(NO_REGISTRY);
        else {
            friendList = SN.checkFriendList(name);
            friendList.initializeIterator();
           listPeople(friendList, FL_MSG);
        }
    }

    // Verifica se existe a pessoa, se sim atualiza o seu estado, se nao escreve a mensagem respetiva na consola.
    private static void newStatus(SocialNetwork SN, Scanner in){
        String name = in.nextLine();
        String status =  in.nextLine();
        if(!SN.checkPerson(name))
            System.out.println(NO_REGISTRY);
        else {
            SN.changeStatus(name, status);
            System.out.println(STATUS_CHANGED);
        }
    }

    // Verifica se a pessoa existe, se sim escreve o seu estado, se nao escreve a mensagem respetiva na consola.
    private static void checkStatus(SocialNetwork SN, Scanner in){
       String name = in.nextLine();
        if(!SN.checkPerson(name))
            System.out.println(NO_REGISTRY);
        else
            System.out.println(SN.checkStatus(name));
    }

    // Escreve na consola os utilizadores da rede social na consola
    private static void people(SocialNetwork SN){
        People users = SN.getUsers();
        users.initializeIterator();
        listPeople(users, SN_MSG);
    }

    // Recebe o objeto People e o tipo de lista, escrevendo a mensagem respetiva em caso de lista vazia ou
    // escreve a lista na consola.
    private static void listPeople(People people, int type){
        if(!people.hasNext()) {
            if(type == SN_MSG)
                System.out.println(EMPTY_SOCIAL_NETWORK);
            else
                System.out.println(EMPTY_FRIENDLIST);
        }
        else{
            if(type == SN_MSG)
                System.out.println(SOCIAL_NETWORK_USERS_MSG);
            else
                System.out.println(FRIENDLIST_MSG);
            while(people.hasNext()) {
                Person jonhdoe = people.next();
                System.out.println(jonhdoe.getName() + "; " + jonhdoe.getEmail());
            }
        }
    }
}
