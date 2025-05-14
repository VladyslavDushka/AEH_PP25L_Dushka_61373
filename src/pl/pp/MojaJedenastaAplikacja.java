package pl.pp;
 import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private String indexNumber;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double calculateAverage() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String toString() {
        return firstName + " " + lastName + " (" + indexNumber + ") - Average: " + String.format("%.2f", calculateAverage());
    }
}
public class MojaJedenastaAplikacja {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        Student topStudent = Collections.max(students, Comparator.comparingDouble(Student::calculateAverage));
        System.out.println("Student z najwyższą średnią: " + topStudent);

        students.sort(Comparator.comparing(Student::getLastName));
        System.out.println("Studenci posortowani według nazwisk:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
