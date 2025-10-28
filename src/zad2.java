public class zad2 {
    record Student(String name, double grade){}

    public static void main(String[] args) {
        Student[] students = {
                new Student ("Krzysztof", 5.0),
                new Student ("Mohamed", 3.0),
                new Student ("Ivan", 2.0),
                new Student ("Maria", 4.0),
                new Student("Mikhail", 5.0)
        };
        double suma = 0;
        double min = 5.0;
        double max = 0;


        for (Student s : students) {
            suma += s.grade;
            if (s.grade < min)
                min = s.grade;
            if (s.grade > max)
                max = s.grade;
        }

        double average = suma / students.length;

        System.out.println("Lista studentow:");

        for (Student s : students){
            System.out.println(s.name + " - " + s.grade );
        }

        System.out.println("Srednia ocen: " + average);
        System.out.println("Najwyzsza ocena: " + max);
        System.out.println("Najnizsza ocena: " + min);
    }
}
