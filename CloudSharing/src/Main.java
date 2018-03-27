import java.util.Scanner;
import CloudSharing.*;

public class Main {

    private enum Command{
        ADD ("ADD"),
        UPLOAD ("UPLOAD"),
        SHARE  ("SHARE"),
        MINSPACE  ("MINSPACE"),
        LISTFILES  ("LISTFILES"),
        LISTALL  ("LISTALL"),
        EXIT  ("EXIT"),
        UNKNOWN  ("Unknown command!");

        private final String cmd;
        Command(String cmd){
            this.cmd = cmd;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Cloud C = new CloudClass();
        executeCommand(input,C);

    }

    private static void executeCommand(Scanner in, Cloud Cloud ){
        String cmd = "";

        while(cmd.equals(Command.EXIT.cmd)){
            cmd = in.next().toUpperCase();
            try {
                Command command = Command.valueOf(cmd);
                switch(command){
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

                    case UNKNOWN:
                        break;
                    default:
                }
            } catch(IllegalArgumentException e){
                System.out.println(Command.UNKNOWN.cmd);
            }
        }
    }
}
