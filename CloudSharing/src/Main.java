import java.util.Scanner;
import CloudSharing.*;

public class Main {



    private static final String ADD = "ADD";
    private static final String UPLOAD = "UPLOAD";
    private static final String SHARE = "SHARE";
    private static final String MINSPACE = "MINSPACE";
    private static final String LISTFILES = "LISTFILES";
    private static final String LISTALL = "LISTALL";
    private static final String EXIT = "EXIT";

    private static final String UNKNOWN_CMD = "Unknown command!";

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Cloud C = new CloudClass();
        executeCommand(input,C);

    }

    private static void executeCommand(Scanner in, Cloud C ){
        String cmd = "";

        while(!cmd.equals(EXIT)){
            cmd = in.next().toUpperCase();

            switch(cmd){
                case ADD:
                    break;

                case UPLOAD:
                    break;

                case SHARE:
                    break;

                case MINSPACE:
                    break;

                case LISTFILES:
                    break;

                case LISTALL:
                    break;

                case EXIT:
                    break;

                default:System.out.println(UNKNOWN_CMD);
            }
        }
    }
}
