package sample.polymorphism;

import java.util.List;

public class Courses {
    public static void main(String[] args) {
        Teacher markus = new EnglishTeacher();
        Teacher hannah = new PhysicsTeacher();

        List<Student> twoStudents = List.of(new Student(), new Student());

        giveCourse(markus, twoStudents); // Valid
        giveCourse(hannah, twoStudents); // Also valid since hannah is a 'Teacher'
    }

    private static void giveCourse(Teacher teacher, List<Student> students) {
        // ...
        // Teacher have to plan courses
        teacher.planningLesson();

        // Speak to students (actually teaching)
        teacher.speak();

        // answer some questions
        teacher.answerQuestion(students);

        // ...
    }
}
