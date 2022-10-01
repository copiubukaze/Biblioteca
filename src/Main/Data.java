package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
                for (int i = 0; i < 3; i++) {
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

    public void addUser(String id,String name, String pass) {
        String[] user = {id,name,pass};
        users.add(user);
    }

    public void removeUser(String id) {
        users.removeIf(fields -> fields[0].equals(id));
    }

    public String getUser(String id) {
        for (String[] user : users) {
            if (user[0].equals(id)) {
                return  "Id: "+user[0] + "\n" +
                        "Name: " + user[1] + "\n" +
                        "Password: " + user[2];
            }
        }
        return "";
    }

    public ArrayList<String[]> getUsers() {
        return users;
    }

    public void loadStudents() {
        File file = new File("data/students.data");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, ",");
                String[] fields = new String[2];
                for (int i = 0; i < 2; i++) {
                    fields[i] = tokens.nextToken();
                }
                students.add(fields);
            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveStudents() {
        try {
            FileWriter file = new FileWriter("data/students.data");
            for (String[] student : students) {
                String tokens = "";
                for (String field : student) {
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

    public void addStudent(String id, String name) {
        String[] student = {id,name};
        students.add(student);
    }

    public void removeStudent(String id) {
        students.removeIf(field -> field[0].equals(id));
    }
    public String getStudent(String id) {
        for (String[] student : students) {
            if (student[0].equals(id)) {
                return  "Id: " + student[0] + "\n" +
                        "Name: "+ student[1];
            }
        }
        return "";
    }

    public ArrayList<String[]> getStudents() {
        return students;
    }

    public void loadBooks() {
        File file = new File("data/books.data");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, ",");
                String[] fields = new String[3];
                for (int i = 0; i < 2; i++) {
                    fields[i] = tokens.nextToken();
                }
                books.add(fields);
            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveBooks() {
        try {
            FileWriter file = new FileWriter("data/books.data");
            for (String[] book : books) {
                String tokens = "";
                for (String field : book) {
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

    public void addBook(String id, String name, String state) {
        System.out.println("Books"+state);
        String[] book = {id,name,(state.equals("0") ? "Free" : "Borrowed")};
        books.add(book);
    }

    public ArrayList<String[]> getBooks() {
        return books;
    }

    public void loadMagazines() {
        File file = new File("data/magazines.data");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer tokens = new StringTokenizer(line, ",");
                String[] fields = new String[3];
                for (int i = 0; i < 2; i++) {
                    fields[i] = tokens.nextToken();
                }
                magazines.add(fields);
            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveMagazines() {
        try {
            FileWriter file = new FileWriter("data/magazines.data");
            for (String[] magazine : magazines) {
                String tokens = "";
                for (String field : magazine) {
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

    public void addMagazine(String id, String name, String state) {
        String[] magazine = {id,name,(state.equals("0") ? "Free" : "Borrowed")};
        System.out.println(Arrays.toString(magazine));
        magazines.add(magazine);

    }

    public ArrayList<String[]> getMagazines() {
        return magazines;
    }
}
