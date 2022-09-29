import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Data {

    protected ArrayList<String[]> users;
    protected ArrayList<String[]> students;
    protected ArrayList<String[]> books;
    protected ArrayList<String[]> magazines;

    public Data() {
        users = new ArrayList<String[]>();
        students = new ArrayList<String[]>();
        books = new ArrayList<String[]>();
        magazines = new ArrayList<String[]>();
    }

    public void loadUsers() {
        File file = new File("data/users.data");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, ",");
                String[] fields = new String[3];
                for (int i = 0; i < 4; i++) {
                    fields[i] = tokens.nextToken();
                }
                users.add(fields);
            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUsers() {
        try {
            FileWriter file = new FileWriter("data/users.data");
            for (String[] user : users) {
                String tokens = "";
                for (String field : user) {
                    tokens += field + ",";
                }
                file.write(tokens);
                file.write("\n");
            }
            file.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
