import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter total students number: ");
        Scanner scanner = new Scanner(System.in);
        int totalStudent = scanner.nextInt();
        /*
         * Scanner.nextInt method does not read the newline character.
         * To skip newline character add an optional scanner.nextLine()
         */
        scanner.nextLine();

        String input;
        String data[];
        List<Student> studentList = new ArrayList();

        for (int i = 0; i < totalStudent; i++) {
            input = scanner.nextLine();
            data = input.split("\\s");

            Student student = new Student();
            student.setId(Integer.parseInt(data[0].trim().replaceFirst("^0*", "")));
            student.setFirstName(data[1].trim().toLowerCase());
            student.setCgpa(Double.parseDouble(new DecimalFormat("#.##").format(Double.parseDouble(data[2].trim()))));
            studentList.add(i, student);
        }

        // Sorting base on CGPA number in decreasing order
        Collections.sort(studentList, (o1, o2) -> {
            if (o1.cgpa > o2.cgpa)
                return -1;
            if (o1.cgpa < o2.cgpa)
                return 1;
            return 0;
        });

        // Sorting base on firstname using alphabetical order
        Collections.sort(studentList, (o1, o2) -> {
            if (o1.cgpa == o2.cgpa)
                return o1.firstName.compareTo(o2.firstName);
            else
                return 0;
        });

        //Sorting base on their ID
        Collections.sort(studentList, (o1, o2) -> {
            if (o1.firstName.compareTo(o2.firstName) == 0)
                return o1.id - o2.id;
            else
                return 0;
        });

        // Print sorted student list
        for (Student stu : studentList) {
            System.out.println(stu.getFirstName().substring(0, 1).toUpperCase() + stu.getFirstName().substring(1));
        }
    }
}

