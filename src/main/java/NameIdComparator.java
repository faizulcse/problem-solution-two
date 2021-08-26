import java.util.Comparator;

public class NameIdComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.firstName.compareTo(o2.firstName) == 0)
            return o1.id - o2.id;
        else
            return 0;
    }
}
