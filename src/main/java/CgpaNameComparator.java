import java.util.Comparator;

public class CgpaNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.cgpa == o2.cgpa)
            return o1.firstName.compareTo(o2.firstName);
        else
            return 0;
    }
}
