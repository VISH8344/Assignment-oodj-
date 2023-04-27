package Student;
import Model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Student_DataIO {

    public static ArrayList<Student> stu = new ArrayList<>();

    public static void read() {
        try {
            BufferedReader r = new BufferedReader(new FileReader("student.txt"));
            String line;
            while ((line = r.readLine()) != null) {
                String[] data = line.split(";");
                String username = data[0];
                String pass = data[1];
                String name = data[2];
                int IC = Integer.parseInt(data[3]);
                String address = data[4];
                String gender = data[5];
                double balance = Double.parseDouble(data[6]);
//                stu.add(new Student(username,pass,name,IC,address,gender,balance ));
            }

        } catch (IOException e) {
            System.out.println("read error");
        }
    }

    public static void write() {
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter("student.txt"));
            for (Student s : stu) {
                String line
                        = s.getUsername() + ";"
                        + s.getPassword() + ";"
                        + s.getName() + ";"
                        + s.getNIC() + ";"
                        + s.getAddress() + ";"
                        + s.getGender() + ";"
                        + s.getBalance();
                w.write(line);
                w.newLine();
            }
            w.close();
        } catch (IOException e) {
            System.out.println("write error");
        }
    }

    public static Student checkusername(String newUsername) {
        Student found = null;
        for (int i = 0; i < stu.size(); i++) {
            Student c = stu.get(i);
            if (newUsername.equals(c.getUsername())) {
                found = c;
                break;
            }
        }
        return found;
    }

}
