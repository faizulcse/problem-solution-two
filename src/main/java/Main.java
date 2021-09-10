import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter total students number: ");
        Scanner scanner = new Scanner(System.in);
        int totalStudent = scanner.nextInt();
        scanner.nextLine();     //skip newline character

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < totalStudent; i++) {
            Student student = new Student();
            String info = scanner.nextLine();
            String data[] = info.split("\\s+");

            student.setId(Integer.parseInt(data[0].replaceFirst("^0+", "").trim()));
            student.setFirstName(data[1].toLowerCase().trim());
            student.setCgpa(Double.parseDouble(new DecimalFormat(".##").format(Double.parseDouble(data[2].trim()))));
            studentList.add(i, student);
        }
        scanner.close();

        // Sorted CGPA in decreasing order
        studentList.sort(Comparator.comparingDouble(Student::getCgpa).reversed());

        // Sorted first name in alphabetical order
        studentList.sort((o1, o2) ->
                o1.getCgpa() == o2.getCgpa() ? o1.getFirstName().compareTo(o2.getFirstName()) : 0);

        // Sorted id in ascending order
        studentList.sort((o1, o2) ->
                o1.getFirstName().compareTo(o2.getFirstName()) == 0 ? o1.getId() - o2.getId() : 0);

        studentList.forEach(stu -> {
            char first = stu.getFirstName().charAt(0);
            System.out.println(stu.getFirstName().replace(first, Character.toUpperCase(first)));
        });
    }
}

