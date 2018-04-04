import java.util.Scanner;
import CloudSharing.*;

public class Main {


    private static final String PREMIUM = "Premium";
    private static final String BASIC = "Basic";

    private enum Message{

        ACCOUNT_ADDED ("Account was added."),
        INVALID_ACCOUNT ("Account already exists."),
        FILE_UPLOAD_SUCCESS ("File uploaded into account."),
        ACCOUNT_NOT_EXIST ("Account does not exist."),
        FILE_ALREADY_EXISTS ("File already exists in the account."),
        TOO_BIG ("File size exceeds account capacity.");


        private final String msg;
        Message(String msg){
            this.msg = msg;
        }
    }
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

        while(!cmd.equals(Command.EXIT.cmd)){
            cmd = in.next().toUpperCase();
            try {
                Command command = Command.valueOf(cmd);
                switch(command){
                    case ADD:
                        add(in, Cloud);
                        break;

                    case UPLOAD:
                        upload(in, Cloud);
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

    private static void add(Scanner in, Cloud cloud){
        String email = in.next().trim();
        String type = in.nextLine().trim();
        System.out.println(email  + "" + type);
        boolean premium = type.equals(PREMIUM.toLowerCase());

           if(cloud.addUser(email,premium))
               System.out.println(Message.ACCOUNT_ADDED.msg);
           else
               System.out.println(Message.INVALID_ACCOUNT.msg);
    }

    private static void upload(Scanner in, Cloud cloud){
        String email = in.next().trim();
        String fileName = in.next().trim();
        int fileSize = in.nextInt();
        int result = cloud.upload(email,fileName,fileSize);

        if(result == Cloud.ACCOUNT_NOT_EXIST)
            System.out.println(Message.ACCOUNT_NOT_EXIST.msg);

        else if(result == Cloud.FILE_ALREADY_EXISTS)
            System.out.println(Message.FILE_ALREADY_EXISTS.msg);

        else if(result == Cloud.TOO_BIG)
            System.out.println(Message.TOO_BIG.msg);

        else
            System.out.println(Message.FILE_UPLOAD_SUCCESS.msg);
    }
}
