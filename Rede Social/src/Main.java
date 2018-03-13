import java.util.Scanner;
import SocialNetwork.*;

public class Main {

    private static final String EXIT = "sair";
    private static final String CHECK_PERSON = "consultapessoa";
    private static final String REGISTER= "regista";
    private static final String CHECK_FRIENDSHIP = "consultaamizade";
    private static final String FRIENDS = "amigos";
    private static final String CHECK_FRIEND_LIST = "consultaamigos";
    private static final String NEW_STATUS = "novoestado";
    private static final String CHECK_STATUS = "consultaestado";
    private static final String PEOPLE = "pessoas";
    private static final String UNKNOWN_COMMAND = "Comando inexistente!";

    public static void main(String args[]){
        Scanner input =  new Scanner(System.in);
        SocialNetwork SN = new SocialNetworkClass();
        executeCommand(input,SN);
    }

    private static void executeCommand(Scanner in, SocialNetwork SN){
        String cmd = "";
        while(cmd.equals(EXIT)) {
            cmd = in.nextLine().toLowerCase();
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
        }
    }

    private static void checkPerson(SocialNetwork SN, Scanner in){
        String name = in.nextLine();
        if (SN.checkPerson(name))
            System.out.println("Pessoa registada.");
        else
            System.out.println("Sem registo.");
    }

    private static void register(SocialNetwork SN, Scanner in){
        if (SN.register(in.nextLine(), in.nextLine(), in.nextLine()))
            System.out.println("Pessoa registada com sucesso.");
        else
            System.out.println("Pessoa registada.");
    }

    private static void checkFriendship(SocialNetwork SN, Scanner in){
        if (SN.checkFriendship(in.nextLine(), in.nextLine()))
            System.out.println("Amizade existente.");
        else
            System.out.println("Amizade inexistente.");
    }

    private static void friends(SocialNetwork SN, Scanner in) {
       String name1 = in.nextLine();
       String name2 = in.nextLine();
        switch (SN.friend(name1, name2)){

            case SocialNetwork.NO_REGISTRY:
                System.out.println("Sem registo.");
                break;

            case SocialNetwork.INVALID_FRIENDSHIP:
                System.out.println("Amizade invalida.");
                break;

            case SocialNetwork.FRIENDSHIP_ALREADY_EXISTS:
                System.out.println("Amizade existente");
                break;

            case SocialNetwork.SUCCESSFUL_FRIENDSHIP:
                SN.friend(name1, name2);
                System.out.println("Amizade criada.");
        }
    }

    private static void checkFriendList(SocialNetwork SN, Scanner in){
        People friendList;
        String name = in.nextLine();
        if(SN.checkPerson(name))
            System.out.println("Sem registo.");
        else {
            friendList = SN.checkFriendList(name);
            friendList.initializeIterator();
            if (!friendList.hasNext())
                System.out.println("Nao tem amigos registados.");
            else{
                 System.out.println("Lista de amigos:");
                 while(friendList.hasNext()) {
                   Person friend = friendList.next();
                   System.out.println(friend.getName() + "; " + friend.getEmail());
                }
            }
        }
    }

    private static void newStatus(SocialNetwork SN, Scanner in){
        String name = in.nextLine();
        String status =  in.nextLine();
        if(SN.checkPerson(name))
            System.out.println("Sem registo.");
        else {
            SN.changeStatus(name, status);
            System.out.println("Estado alterado.");
        }
    }

    private static void checkStatus(SocialNetwork SN, Scanner in){
       String name = in.nextLine();
        if(!SN.checkPerson(name))
            System.out.println("Sem registo.");
        else
            System.out.println(SN.checkStatus(name));
    }

    private static void people(SocialNetwork SN){
        People users = SN.getUsers();
        users.initializeIterator();
        if(!users.hasNext())
            System.out.println("Rede social vazia.");
        else{
            System.out.println("Lista de pessoas registadas:");
            while(users.hasNext()) {
                Person jonhdoe = users.next();
                System.out.println(jonhdoe.getName() + "; " + jonhdoe.getEmail());
            }
        }
    }
}
