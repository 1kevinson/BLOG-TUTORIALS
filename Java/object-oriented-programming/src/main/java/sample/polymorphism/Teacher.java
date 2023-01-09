package sample.polymorphism;

import java.util.List;

public interface Teacher {

    public void speak();
    public void planningLesson();
    public void answerQuestion(List<Student> students);
}
