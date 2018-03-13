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

                case NEW_STATUS:break;

                case CHECK_STATUS:break;

                case PEOPLE: break;

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
        switch (SN.friend(in.nextLine(), in.nextLine())) {

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
                System.out.println("Amizade criada.");
        }
    }

    private static void checkFriendList(SocialNetwork SN, Scanner in){
        People friendList = SN.checkFriendList(in.nextLine());
        friendList.initializeIterator();
        if(friendList == null)
            System.out.println("Sem registo.");
        else if(!friendList.hasNext())
            System.out.println("Nao tem amigos registados.");
        else{
            System.out.println("Lista de amigos:");
            while(friendList.hasNext()){
                Person friend = friendList.next();
                System.out.println(friend.getName() + "; " + friend.getEmail());
            }
        }
    }
}
