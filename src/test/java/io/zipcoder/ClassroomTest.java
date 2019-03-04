package io.zipcoder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class ClassroomTest {

    @Test
    public void ClassroomMaxStudentsConstructor() {
        // Given
        Integer maxStudents = 10;

        // When
        Classroom classroom = new Classroom(maxStudents);
        Integer actual = classroom.getStudents().length;

        // Then
        Assert.assertEquals(maxStudents, actual);
    }


    @Test
    public void ClassroomStudentsConstructor() {
        // Given
        Student[] expected = {new Student(), new Student(), new Student()};

        // When
        Classroom classroom = new Classroom(expected);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void nullaryConstructorTest() {
        // Given
        Student[] expected = new Student[30];

        // When
        Classroom classroom = new Classroom();
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void getAverageExamScoreTest() {
        // Given
        Double[] scores1 = {100.0, 95.0, 90.0};
        Double[] scores2 = {70.0, 65.0, 60.0};
        Student student1 = new Student("Leon", "Hunter", scores1);
        Student student2 = new Student("Nhu", "Nyugen", scores2);
        Student[] students = {student1, student2};
        Classroom classroom = new Classroom(students);
        Double expected = 80.0;

        // When
        Double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest() {
        // Given
        Student[] students = {};
        Classroom classroom = new Classroom(students);
        Double[] examScores = {100.0};
        Student student = new Student("Leon", "Hunter", examScores);
        Student[] expected = {student};

        // When
        classroom.addStudent(student);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeStudentTest() {
        // Given

        Double[] examScores1 = {90.0, 85.0};
        Double[] examScores2 = {80.0, 70.0};
        Student student2 = new Student("Brian", "Wong", examScores1);
        Student student3 = new Student("Nhu", "Nyugen", examScores2);
        Student[] students = {student2, student3};
        Classroom classroom = new Classroom(students);

        // When
        classroom.removeStudent("Mike", "Miller");

        // Then
        Assert.assertArrayEquals(students, classroom.getStudents());

    }

    @Test
    public void removeStudentTest1() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {90.0};
        Double[] examScores1 = {90.0, 85.0};
        Double[] examScores2 = {80.0, 70.0};
        Student student = new Student(firstName, lastName, examScores);
        Student student2 = new Student("Brian", "Wong", examScores1);
        Student student3 = new Student("Nhu", "Nyugen", examScores2);
        Student[] students = {student, student2, student3};
        Classroom classroom = new Classroom(students);

        // When
        classroom.removeStudent("Brian", "Wong");
        Student[] expectedStudents = {student, student3};

        // Then
        Assert.assertArrayEquals(expectedStudents, classroom.getStudents());

    }


    @Test
    public void removeStudentTest2() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0};
        Student student1 = new Student(firstName, lastName, examScores);
        Student student2 = new Student("Brian", "Wong", examScores);
        Student student3 = new Student("Nhu", "Nyugen", examScores);
        Student[] students = {student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student2, student3};


        // When
        classroom.removeStudent(firstName, lastName);

        // Then
        Assert.assertArrayEquals(expected, classroom.getStudents());
    }

    @Test
    public void getStudentsByScoreTest() {
        // Given
        Double[] scores1 = {100.0, 80.0};
        Double[] scores2 = {100.0, 100.0};
        Double[] scores3 = {90.0, 90.0};
        Double[] scores4 = {50.0, 30.0};
        Student student1 = new Student("Mike", "Miller", scores1);
        Student student2 = new Student("Leon", "Hunter", scores2);
        Student student3 = new Student("Brian", "Wong", scores3);
        Student student4 = new Student("Sean", "Cho", scores4);
        Student[] students = {student1, student2, student3, student4};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student2, student3, student1, student4};

        // When
        Student[] actual = classroom.getStudentsByScore();

        // Then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void getGradebookTest() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then
        Assert.assertEquals(expected.get(student1), actual.get(student1));
        Assert.assertEquals(expected.get(student2), actual.get(student2));
        Assert.assertEquals(expected.get(student3), actual.get(student3));
        Assert.assertEquals(expected.get(student4), actual.get(student4));
        Assert.assertEquals(expected.get(student5), actual.get(student5));
        Assert.assertEquals(expected.get(student6), actual.get(student6));
        Assert.assertEquals(expected.get(student7), actual.get(student7));
        Assert.assertEquals(expected.get(student8), actual.get(student8));
        Assert.assertEquals(expected.get(student9), actual.get(student9));
        Assert.assertEquals(expected.get(student10), actual.get(student10));

    }

    @Test
    public void getGradebookTest2() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student2), actual.get(student2));
    }

    @Test
    public void getGradebookTest3() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student3), actual.get(student3));
    }

    @Test
    public void getGradebookTest4() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student4), actual.get(student4));
    }

    @Test
    public void getGradebookTest5() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student5), actual.get(student5));

    }

    @Test
    public void getGradebookTest6() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student6), actual.get(student6));
    }

    @Test
    public void getGradebookTest7() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student7), actual.get(student7));
    }

    @Test
    public void getGradebookTest8() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student8), actual.get(student8));
    }

    @Test
    public void getGradebookTest9() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then


        Assert.assertEquals(expected.get(student9), actual.get(student9));
    }
    @Test
    public void getGradebookTest10() {
        // Given
        Double[] grade1 = {100.0};
        Double[] grade2 = {90.0};
        Double[] grade3 = {80.0};
        Double[] grade4 = {70.0};
        Double[] grade5 = {60.0};
        Double[] grade6 = {50.0};
        Double[] grade7 = {40.0};
        Double[] grade8 = {30.0};
        Double[] grade9 = {20.0};
        Double[] grade10 = {10.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student2 = new Student("Neela", "Das", grade2);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student5 = new Student("Nhu", "Nyugen", grade5);
        Student student6 = new Student("Sayan", "Ghatak", grade6);
        Student student7 = new Student("Abhi", "Das", grade7);
        Student student8 = new Student("Sai", "Sankar", grade8);
        Student student9 = new Student("Dam", "Umm", grade9);
        Student student10 = new Student("Sam", "Ims", grade10);
        Student[] students = {student8, student3, student2, student4, student5, student10, student7, student1, student9, student6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student2, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student5, "C");
        expected.put(student6, "C");
        expected.put(student7, "D");
        expected.put(student8, "D");
        expected.put(student9, "D");
        expected.put(student10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then

        Assert.assertEquals(expected.get(student10), actual.get(student10));
    }






        @Test
    public void getGradebookTest11() {
        // Given
        Double[] grade1 = {100.0, 90.0};
        Double[] grade3 = {80.0, 80.0};
        Double[] grade4 = {70.0, 70.0};
        Double[] grade8 = {11.0, 11.0};
        Student student1 = new Student("Leon", "Hunter", grade1);
        Student student3 = new Student("Mike", "Miller", grade3);
        Student student4 = new Student("Joe", "Walsh", grade4);
        Student student8 = new Student("Sam", "Ims", grade8);
        Student[] students = {student1, student3, student4, student8};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(student1, "A");
        expected.put(student3, "B");
        expected.put(student4, "C");
        expected.put(student8, "D");


        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then
        Assert.assertEquals(expected.get(student1), actual.get(student1));
        Assert.assertEquals(expected.get(student3), actual.get(student3));
        Assert.assertEquals(expected.get(student4), actual.get(student4));
        Assert.assertEquals(expected.get(student8), actual.get(student8));

    }
}


