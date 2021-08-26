import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Enter student number Array List: ");
        scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Student> studentList = new ArrayList();

        for (int i = 0; i < size; i++) {
            Student student = new Student();
            student.setId(scanner.nextInt());
            scanner.nextLine();
            student.setFirstName(scanner.nextLine().toLowerCase().trim());
            student.setCgpa(Double.parseDouble(new DecimalFormat("##.##").format(scanner.nextDouble())));
            studentList.add(student);
        }

        Collections.sort(studentList, new CgpaComparator());
        Collections.sort(studentList, new IdComparator());
        Collections.sort(studentList, new NameComparator());

        for (Student student : studentList) {
            System.out.println(student.getFirstName());
        }
    }
}
