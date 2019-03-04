
package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void StudentConstructorTest() {
        // Given
        String actualFirstName = "Neela";
        String actualLastName = "Das";
        Double[] actualExamScores = {90.0, 95.0, 97.0, 92.0};

        // When
        Student student = new Student(actualFirstName, actualLastName, actualExamScores);
        String expectedFirstName = student.getFirstName();
        String expectedLastName = student.getLastName();
        Double[] expectedExamScores = student.getExamScoresArray();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertArrayEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void GetExamScoresTest() {
        // Given
        Double[] examScores = {92.0, 90.0, 85.0, 95.0};
        Student student = new Student("Leon", "Hunter", examScores);
        String expected = "Exam Scores:\nExam 1 -> 92.0\nExam 2 -> 90.0\nExam 3 -> 85.0\nExam 4 -> 95.0\n";

        // When
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetExamScoresTest2() {
        // Given
        Double[] examScores = {};
        Student student = new Student("Leon", "Hunter", examScores);
        String expected = "Exam Scores:\n";

        // When
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getNumberOfExamsTakenTest() {
        // Given
        Double[] examScores = {10.0, 20.0, 30.0, 40.0};
        Student student = new Student("Leon", "Hunter", examScores);
        Integer expected = examScores.length;


        // When
        Integer actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getNumberOfExamsTakenTest2() {
        // Given

        Double[] examScores = {};
        Student student = new Student("Leon", "Hunter", examScores);

        Integer expected = examScores.length;

        // When
        Integer actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void addExamScoreTest() {
        // Given
        Double[] examScores = {92.0, 90.0, 85.0, 95.0};
        Student student = new Student("Leon", "Hunter", examScores);
        Double scoreToAdd = 80.0;
        Double[] expected = {92.0, 90.0, 85.0, 95.0, scoreToAdd};


        // When
        student.addExamScore(scoreToAdd);
        Double[] actual = student.getExamScoresArray();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest2() {
        // Given

        Double[] examScores = {};
        Student student = new Student("Leon", "Hunter", examScores);
        Double scoreToAdd = 80.0;
        Double[] expected = {scoreToAdd};

        // When
        student.addExamScore(scoreToAdd);
        Double[] actual = student.getExamScoresArray();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void setExamTest() {
        // Given
        Double[] examScores = {100.0, 90.0, 80.0, 95.0};
        Student student = new Student("Leon", "Hunter", examScores);
        int examToSet = 2;
        Double scoreToSet = 1000.0;
        Double[] expected = {100.0, 1000.0, 80.0, 95.0};

        // When
        student.setExamScore(examToSet, scoreToSet);
        Double[] actual = student.getExamScoresArray();


        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void getAverageExamScoreTest() {
        // Given
        Double[] examScores = {100.0, 90.0, 80.0};
        Student student = new Student("Leon", "Hunter", examScores);
        Double expected = 90.0;

        // When
        Double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAverageExamScoreTest2() {
        // Given

        Double[] examScores = {50.0};
        Student student = new Student("Leon", "Hunter", examScores);
        Double expected = 50.0;

        // When
        Double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // Given
        Double[] examScores = {100.0, 95.0, 90.0};
        Student student = new Student("Leon", "Hunter", examScores);
        String expected = "Student Name: Leon Hunter\n> Average Score: 95.0\n> Exam Scores:\nExam 1 -> 100.0\nExam 2 -> 95.0\nExam 3" + " -> 90.0\n";

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);

    }
}
