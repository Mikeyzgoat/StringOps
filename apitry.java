// Dictionary and key value holding libraries
/*import java.util.Dictionary;
import java.util.Hashtable;
*/
// Scanner class
import java.util.Scanner;
// libraries that read data from the webpage
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
//libraries that handle the url creation and connection
import java.net.URL;
import java.net.URLConnection;

// class declaration
public class apitry{
    // simplified print statement
    static void print(Object line){
        System.out.println(line);
    }
    void web_data_reader(){
        // define the dictionary object
        //Dictionary<String,String> dict = new Hashtable<String,String>();
        // Scanner class
        String base_url = "https://api.dictionaryapi.dev/api/v2/entries/en/";
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        String inp = (new StringBuilder()).append(base_url).append(in).toString();
        // define the url based on the string input from user
        try{
            URL url = new URL(inp);
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line = br.readLine())!= null){
                print(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }    
        scan.close();
    }
}