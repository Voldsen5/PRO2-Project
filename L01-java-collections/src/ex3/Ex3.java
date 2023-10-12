package ex3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex3 {

    public static void main(String[] args) {
        System.out.println("Ex. 3");
        System.out.println();

        College college = new College("BAAA");

        Student jens = new Student(110, "Jens");
        for (var grade : List.of(4, 7, 2, 7)) {
            jens.addGrade(grade);
        }
        college.addStudent(jens);

        Student ulla = new Student(100, "Ulla");
        for (var grade : List.of(10, 7, 7, 12)) {
            ulla.addGrade(grade);
        }
        college.addStudent(ulla);

        Student hans = new Student(120, "Hans");
        for (var grade : List.of(7, 7, 4, 4)) {
            hans.addGrade(grade);
        }
        college.addStudent(hans);

        System.out.println(college.getStudents());
        System.out.println();

        System.out.printf("Average grade for students at %s college is %.1f\n",
                college.getName(), college.calcAverage());

        System.out.printf("Student with no. %d is %s\n", 110, college.findStudent(110));
        System.out.printf("Student with no. %d is %s\n", 90, college.findStudent(90));
        System.out.println();

        System.out.println("-----------------------------------------");

        //-------------------------------------------------

        System.out.println("Hans compared to Ulla on studentNo: " + hans.compareTo(ulla));
        System.out.println("Hans compared to new Hans object on studentNo? " +
                hans.compareTo(new Student(120, "Hans Jensen")));
        System.out.println();

        List<Student> list = college.getStudents();
        System.out.println("Before sorting: " + list);
        Collections.sort(list);
        System.out.println("After sorting on studentNo: " + list);
        System.out.println();

        System.out.println("-----------------------------------------");

        //-------------------------------------------------

        Comparator<Student> comp = new StudentNameComparator();

        System.out.println("Hans compared to Ulla on name: " + comp.compare(hans, ulla));
        System.out.println("Hans compared to new Hans object on name? " +
                comp.compare(hans, new Student(120, "Hans")));
        System.out.println();

        List<Student> list1 = college.getStudents();
        System.out.println("Before sorting: " + list1);
        Collections.sort(list1, comp);
        System.out.println("After sorting on name: " + list1);
        System.out.println();

        System.out.println("-----------------------------------------");

        //-------------------------------------------------

        System.out.println("Hans equal to Ulla on studentNo? " + hans.equals(ulla));
        System.out.println("Hans equal to new Hans object on studentNo? " +
                hans.equals(new Student(120, "Hans Jensen")));
        System.out.println();

        System.out.println("Hash code for Hans: " + hans.hashCode());
        System.out.println("Hash code for Ulla: " + ulla.hashCode());
        System.out.println(
                "Hash code for new Hans object: " + new Student(120, "Hans Jensen").hashCode());
        System.out.println();

        System.out.println("-----------------------------------------");

        //-------------------------------------------------

        System.out.println("College contains Hans? " + college.contains(hans));
        System.out.println("College contains student with studentNo 120? " +
                college.contains(new Student(120, "")));
        System.out.println();

        college.addStudent(new Student(120, "Hans Jensen"));
        List<Student> allStudents = college.getStudents();
        System.out.println("All students : " + allStudents);
        System.out.println();

        System.out.println("-----------------------------------------");

        //-------------------------------------------------

//        List<Student> list2 = college.getStudents();
//        System.out.println("Before sorting: " + list2);
//        Collections.sort(list2, (st1, st2) -> st1.getName().compareTo(st2.getName()));
//        System.out.println("After sorting on name: " + list2);   }
    }
}
