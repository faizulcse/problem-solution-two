import java.util.Comparator;

public class CgpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.cgpa > o2.cgpa)
            return -1;
        if (o1.cgpa < o2.cgpa)
            return 1;
        return 0;
    }
}
