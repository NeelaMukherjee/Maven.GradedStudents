package io.zipcoder;

import java.util.*;

public class Classroom {

    private Student[] students;

    Integer maxNumberOfStudents;


    public Classroom(int maxNumberOfStudents){

        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students){

        this.students = students;
    }

    public Classroom(){
        this.students = new Student[30];
        this.maxNumberOfStudents = 30;
    }

    public Student[] getStudents(){

        return students;
    }

    public Double getAverageExamScore() {

        Double sumOfGrades = 0.0;
        for(Student s : students){
            sumOfGrades += s.getAverageExamScore();
        }
        return sumOfGrades / students.length;
    }

    public void addStudent(Student student) {

        ArrayList <Student> newStudents = new ArrayList<>();

        for (Student student1: students) {

            newStudents.add(student1);
        }
        newStudents.add(student);
        this.students = newStudents.toArray(new Student[students.length+1]);

    }

    public void removeStudent(String firstName, String lastName) {

        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        Student studentToRemove = null;
        for (Student s : studentList){
            if ((s.getLastName().equals(lastName)) && (s.getFirstName().equals(firstName))){
                studentToRemove = s;
            }
        }
        if (studentToRemove != null){
            studentList.remove(studentToRemove);
        }
       this.students = studentList.toArray(new Student[students.length-1]);
    }


    public Student[] getStudentsByScore() {
        Arrays.sort(students);
        return students;
    }


    public Map<Student,String> getGradebook(){
        Map<Student, String> gradeBook = new TreeMap<>();
        Student[] studentGrades = getStudentsByScore();
        Double classSize = new Double(studentGrades.length);

        for (int i = 0; i < studentGrades.length; i++){
            Double percentile = (((classSize - i) / classSize) * 100.0);
            if (percentile >= 90){
                gradeBook.put(studentGrades[i], "A");
            }
            else if(percentile >= 71){
                gradeBook.put(studentGrades[i], "B");
            }
            else if(percentile >= 50){
                gradeBook.put(studentGrades[i], "C");
            }
            else if(percentile >= 11){
                gradeBook.put(studentGrades[i], "D");
            }
            else{
                gradeBook.put(studentGrades[i], "F");
            }
        }
        return gradeBook;
    }
}

