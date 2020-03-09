package fmi.informatics.HOMEWORK9;

import fmi.informatics.extending.Student;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamClassTest {

    @org.junit.Test
    public void taskOne() {
        ArrayList<Student> students = new ArrayList<Student>();
        Stream.of(Student.StudentGenerator.make(),
                Student.StudentGenerator.make(),
                Student.StudentGenerator.make())
                .filter(s -> s.getName().length() >= 5)
                .sorted((s2, s1) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);
        students.add(Student.StudentGenerator.make());
        Assert.assertEquals(students.get(0).toString(), "Ivan");
    }

    @org.junit.Test
    public void taskTwo() {
        String[] animals = {"cat", "dog", "cow", "bird"};
        Stream.of(animals)
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        Assert.assertEquals("cat", animals[0]);
    }

    @org.junit.Test
    public void taskThree() {
        List<Student> studs = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            studs.add(Student.StudentGenerator.make());
        }
        String studNames = studs.stream()
                .sorted((s2, s1) -> s1.getName().compareTo(s2.getName()))
                .map(s -> s.getName())
                .reduce((s1, s2) -> {
                    if (s2 != null) return s1 + ", " + s2;
                    return s1;
                })
                .get();
        System.out.println(studNames);
        Assert.assertEquals(studNames, "Lilly, Petya, Stoyan");
    }

    @org.junit.Test
    public void taskFour() {
        final int[] even = {0};
        IntStream.iterate(0, i -> i + 1)
                .skip(5)
                .limit(10)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        even[0] = i;
                        System.out.println(i);
                    }
                });
        Assert.assertEquals(14, even[0]);
    }
}