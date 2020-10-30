package mins.study.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mins.study.board.app.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GenericsStudyTest {

    List<Student> students;
    List<Teacher> teachers;

    List<Person> personList;

    Node firstNode = new Node(null, 1);
    Node secondNode = new Node(firstNode, 1);

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

        personList = Arrays.asList(
                new Student("Mike", 20, "Man", "Seoul", 1L),
                new Student("Jhon", 21, "Man", "Gyeonggi-do", 2L),
                new Student("Candy", 22, "Woman", "Seoul", 3L),
                new Student("Jackson", 21, "Man", "Gyeonggi-do", 4L),
                new Student("Bon", 20, "Man", "Seoul", 5L),
                new Teacher("Jullia", 39, "Woman", "Seoul", 1L),
                new Teacher("Sofi", 59, "Woman", "Gyeonggi-do", 2L),
                new Teacher("Kim", 55, "Man", "Seoul", 3L)
        );
    }

    @Test
    void genericTest() {
        // TODO 서울에 사는 사람을 출력하기
        for (int i = 0; i < personList.size(); i++) {
            if("Seoul".equals(personList.get(i).getAddress())) {
                System.out.println(personList.get(i).getName());
            }
        }

        System.out.println();
        System.out.println();

        // TODO 나이가 40세 이하인 사람을 출력하기
        for (int i = 0; i < personList.size(); i++) {
            if(personList.get(i).getAge() <= 40) {
                System.out.println(personList.get(i).getName());
            }
        }

        // TODO 여자가 몇명 인지 확인하기
    }

    @Getter
    public class Person {
        private String name;
        private Integer age;
        private String gender;
        private String address;

        private List<NormalObjectStudyTest.Course> courseList;

        public Person(String name, Integer age, String gender, String address) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
        }
    }

    @Getter
    @Setter
    public class Student extends Person {
        private Long studentId;

        public Student(String name, Integer age, String gender, String address, Long studentId) {
            super(name, age, gender, address);
            this.studentId = studentId;
        }
    }

    @Getter
    @Setter
    public class Teacher extends Person {
        private Long teacherId;

        public Teacher(String name, Integer age, String gender, String address, Long teacherId) {
            super(name, age, gender, address);
            this.teacherId = teacherId;
        }
    }
}
