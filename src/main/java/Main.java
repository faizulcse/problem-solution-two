import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            student.setfName(data[1].toLowerCase().trim());
            student.setCgpa(Double.parseDouble(new DecimalFormat(".##").format(Double.parseDouble(data[2].trim()))));
            studentList.add(i, student);
        }
        scanner.close();

        studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getCgpa).reversed())                                // Sorted by cgpa
                .sorted((o1, o2) -> o1.getCgpa() == o2.getCgpa() ? o1.getfName().compareTo(o2.getfName()) : 0)  // Sorted by first name
                .sorted((o1, o2) -> o1.getfName().equals(o2.getfName()) ? o1.getId() - o2.getId() : 0)          // Sorted by id
                .collect(Collectors.toList())                                                                   // print sorted student info
                .forEach(stu -> {
                    char first = stu.getfName().charAt(0);
                    System.out.println(stu.getfName().replace(first, Character.toUpperCase(first)));
                });
    }
}

