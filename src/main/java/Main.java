import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter student data: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        /*
         * Scanner.nextInt method does not read the newline character.
         * To skip newline character add an optional scanner.nextLine()
         */
        scanner.nextLine();

        List<Student> studentList = new ArrayList();
        for (int i = 0; i < size; i++) {
            String input;
            String data[];
            input = scanner.nextLine();
            data = input.split("\\s");

            int id;
            String name;
            double cgpa;
            id = Integer.parseInt(data[0].trim().replaceFirst("^0*", ""));
            name = data[1].trim().toLowerCase();
            cgpa = Double.parseDouble(new DecimalFormat("#.##").format(Double.parseDouble(data[2].trim())));

            Student student = new Student();
            student.setId(id);
            student.setFirstName(name);
            student.setCgpa(cgpa);
            studentList.add(i, student);
        }
        Collections.sort(studentList, new CgpaComparator());
        Collections.sort(studentList, new CgpaNameComparator());
        Collections.sort(studentList, new NameIdComparator());

        for (Student stu : studentList) {
            System.out.println(stu.getFirstName());
        }
    }
}

