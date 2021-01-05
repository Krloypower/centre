package rubbish.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ParallerTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/12/18
 * @Version 1.0
 **/
public class ParallelTest {

    public static void main(String[] args) {

        List<Student> lists = new ArrayList<>();

        Student student = new Student();
        student.setId(1L);

        Student student1 = new Student();
        student1.setId(2L);

        Student student2 = new Student();
        student2.setId(3L);

        Student student3 = new Student();
        student3.setId(4L);

        Student student4 = new Student();
        student4.setId(5L);

        Student student5 = new Student();
        student5.setId(6L);

        Student student6 = new Student();
        student6.setId(7L);

        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        lists.add(student4);
        lists.add(student5);
        lists.add(student6);

        List<Long> collect = lists.parallelStream().map(Student::getId).collect(Collectors.toList());


        lists.parallelStream().forEach(x->{

        });
        System.out.println(collect);


    }

    @Data

    static class Student {
        private Long id;

        private String name;
    }
}
