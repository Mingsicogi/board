package mins.study.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class NormalObjectStudyTest {

    List<Student> students;
    List<Teacher> teachers;

    @BeforeEach
    void init() {
        students = Arrays.asList(
                new Student("Mike", 20, "Man", "Seoul", 1L),
                new Student("Jhon", 21, "Man", "Gyeonggi-do", 2L),
                new Student("Candy", 22, "Woman", "Seoul", 3L),
                new Student("Jackson", 21, "Man", "Gyeonggi-do", 4L),
                new Student("Bon", 20, "Man", "Seoul", 5L)
        );

        teachers = Arrays.asList(
                new Teacher("Jullia", 39, "Woman", "Seoul", 1L),
                new Teacher("Sofi", 59, "Woman", "Gyeonggi-do", 2L),
                new Teacher("Kim", 55, "Man", "Seoul", 3L)
        );
    }

    @Test
    void normalObjectStudyTest() {
        // TODO 서울에 사는 사람을 출력하기
        for (int i = 0; i < students.size(); i++) {
            if("Seoul".equals(students.get(i).getAddress())) {
                System.out.println(students.get(i).getName());
            }
        }

        students.stream().map(Student::getAddress).filter("seoul"::equals).findFirst().orElseThrow();
        Integer integer = students.stream().map(Student::getAge).max(Comparator.comparing(Integer::intValue)).get();

        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < teachers.size(); i++) {
            if("Seoul".equals(teachers.get(i).getAddress())) {
                System.out.println(teachers.get(i).getName());
            }
        }

        // TODO 나이가 40세 이하인 사람을 출력하기

        // TODO 여자가 몇명 인지 확인하기

    }

    @Getter
    @Setter
    public class Student {
        private String name;
        private Integer age;
        private String gender;
        private String address;
        private List<Course> courseList;

        // ...
        private Long studentId;

        public Student(String name, Integer age, String gender, String address, Long studentId) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
            this.studentId = studentId;
        }
    }

    @Getter
    @Setter
    public class Teacher {
        private String name;
        private Integer age;
        private String gender;
        private String address;
        private List<Course> courseList = new ArrayList<>();

        // ...
        private Long teacherId;

        public Teacher(String name, Integer age, String gender, String address, Long teacherId) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
            this.teacherId = teacherId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class Course {
        private Long courseId;

        private String subjectName;
        private Integer score;
    }
}
