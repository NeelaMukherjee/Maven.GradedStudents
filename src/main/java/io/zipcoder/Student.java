package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;


public class Student implements Comparable<Student>{

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(){

    }

    public Student(String firstName, String lastName, Double[] examScore){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScore));
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getExamScores() {
        String examScoreInString = "Exam Scores:\n";
        int counter = 1;
        for(Double d : this.examScores){
            examScoreInString += "Exam " + counter + " -> "  + d + "\n";
            counter++;
        }
        return examScoreInString;
    }

    public Integer getNumberOfExamsTaken(){

        return examScores.size();
    }

    public void addExamScore(Double examScore){

        this.examScores.add(examScore);
    }

    public Double[] getExamScoresArray(){

        Double [] examScoreArray = examScores.toArray(new Double [this.examScores.size()]);

        return examScoreArray;
    }


//    public static void main(String[] args) {
//        Double[] scores = {100.0, 90.0, 80.0, 95.0};
//        Student s = new Student("cara", "eppes", scores);
//        System.out.println(s.getExamScores());
//    }

    public Double getAverageExamScore() {
        Double sumOfScores = 0.0;
        for (Double d : examScores){
            sumOfScores += d;
        }
        return sumOfScores / examScores.size();

    }

    public void setExamScore(int examToSet, Double scoreToSet) {


        examScores.set(examToSet - 1, scoreToSet);
    }

    @Override
    public String toString(){
        return "Student Name: " + firstName + " " + lastName +"\n> Average Score: " + getAverageExamScore() + "\n" +
               "> " + getExamScores();

//        return String.format("Student Name: %s %s\n> Average Score: %3.0f\n> ",firstName, lastName, getAverageExamScore(), );
//                "" +
//                "" +
//                "" + firstName + " " + lastName +"\n> Average Score: " + getAverageExamScore() + "\n" +
//                      "> " + getExamScores())
    }

    //@Override
    public int compareTo(Student student) {
        if (student.getAverageExamScore() - this.getAverageExamScore() != 0){
            if (student.getAverageExamScore() - this.getAverageExamScore() > 0){
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            return this.firstName.compareTo(student.firstName);
        }
    }
}