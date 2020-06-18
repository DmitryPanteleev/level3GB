package lesson3;

import java.io.Serializable;

public class Student implements Serializable {

    String name;
    String curs;
    String academy;

    public Student(String name, String curs, String academy) {
        this.name = name;
        this.curs = curs;
        this.academy = academy;
    }
    public void info(){
        System.out.println( name + " " + curs + " " + academy);
    }

}
