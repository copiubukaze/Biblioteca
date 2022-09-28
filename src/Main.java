import New.NewBook;
import New.NewMagazine;
import New.NewStudent;
import New.NewUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JDesktopPane dp_m;
    private JMenuBar m;
    private JMenu user, students, books, magazines, reports;
    private JMenuItem nuser, ruser, nstudents, rstudents, nbook, nmagazines;
    private JMenuItem reuser, restudents, rebooks, remagazines;
    private JMenuItem lbook, lmagazine;

    public Main() {
        super("Library");
        setSize(600,500);
        launchWidgets();
        /*
        data = new Data();
        data.loadUsers();
        data.loadArticle();
        */
        launchEvents();
        setVisible(true);
    }

    private void launchWidgets() {
        dp_m = new JDesktopPane();
        m = new JMenuBar();
        user = new JMenu("Users");
        students = new JMenu("Students");
        books = new JMenu("Books");
        magazines = new JMenu("Magazines");
        reports = new JMenu("Reports");

        nuser = new JMenuItem("New User");
        ruser = new JMenuItem("Remove User");

        nstudents = new JMenuItem("New Student");
        rstudents = new JMenuItem("Remove Student");

        nbook = new JMenuItem("New Book");

        nmagazines = new JMenuItem("New Magazine");

        reuser = new JMenuItem("Users");
        restudents = new JMenuItem("Students");
        rebooks = new JMenuItem("Books");
        remagazines = new JMenuItem("Magazines");

        lbook = new JMenuItem("Lend Book");
        lmagazine = new JMenuItem("Lend Magazine");

        add(dp_m);

        setJMenuBar(m);

        m.add(user);
        m.add(students);
        m.add(books);
        m.add(magazines);
        m.add(reports);

        user.add(nuser);
        user.add(ruser);

        students.add(nstudents);
        students.add(rstudents);
        students.addSeparator();
        students.add(lbook);
        students.add(lmagazine);

        books.add(nbook);

        magazines.add(nmagazines);

        reports.add(reuser);
        reports.add(restudents);
        reports.add(rebooks);
        reports.add(remagazines);

    }

    private void launchEvents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        nuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewUser n = new NewUser();
                dp_m.add(n);
            }
        });
        nstudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewStudent n = new NewStudent();
                dp_m.add(n);
            }
        });
        nbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewBook n = new NewBook();
                dp_m.add(n);
            }
        });
        nmagazines.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewMagazine n = new NewMagazine();
                dp_m.add(n);
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}