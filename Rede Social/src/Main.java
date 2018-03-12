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
                case CHECK_PERSON:break;

                case REGISTER:break;

                case CHECK_FRIENDSHIP:break;

                case FRIENDS: break;

                case CHECK_FRIEND_LIST:break;

                case NEW_STATUS:break;

                case CHECK_STATUS:break;

                case PEOPLE: break;

                case EXIT:;

                default:System.out.println(UNKNOWN_COMMAND);
            }
        }
    }
}
