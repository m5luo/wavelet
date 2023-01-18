import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> strings = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Current Strings are: %s", strings.toString());
        } else if (url.getPath().contains("/add")) {

            System.out.println("Path: " + url.getPath());

            String[] parameters = url.getQuery().split("=");

            if (parameters[0].equals("s")) {
                strings.add(parameters[1]);
                return String.format("You've added %s! Strings now contain %s", parameters[1], strings.toString());
            }
        } else if (url.getPath().contains("/search")){

            ArrayList<Strings> output = new ArrayList<>();

            String[] parameters = url.getQuery().split("=");
            int size = parameter[1].length()

            for(int i = 0; i < strings.length; i++){
                str = strings.get(i);
                for(int j = 0; j < str.length(); j++){
                    if(str.substring(i, i + size) == parameter[1]){
                        output.add(str);
                    }
                }
                

            }
            
            return output.toString();
        }
    
        return "404 Not Found!";
        }
    }


class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}