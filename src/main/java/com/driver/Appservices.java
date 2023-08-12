package com.driver;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Appservices {
    repository repo=new repository();
    public void addStudent(Student student){
        repo.studentDB.put(student.getName(), student);
        //repo.setRollNo(repo.rollNo+1);

        return;
    }
    public void addTeacher(Teacher teacher){
        repo.teacherDB.put(teacher.getName(),teacher);
        //  repo.setTeacherId(repo.getTeacherId()+1);
    }

    public void addStudentTeacherPair(String student,String Teacher) {

        if (repo.StudentTeacherAssociationDB.containsKey(Teacher)) {
            Teacher t=repo.teacherDB.get(Teacher);
            repo.teacherDB.get(Teacher).setNumberOfStudents(t.getNumberOfStudents()+1);
            List<String> students = repo.StudentTeacherAssociationDB.get(Teacher);
            students.add(student);
            repo.StudentTeacherAssociationDB.put(Teacher, students);
            return;
        }
        List<String> Students = new LinkedList<>();
        Students.add(student);
        repo.teacherDB.get(Teacher).setNumberOfStudents(1);
        repo.StudentTeacherAssociationDB.put(Teacher, Students);

    }

    public Student getStudentbyName(String name){
        return repo.studentDB.get(name);
    }

    public Teacher getTeacherByName(String name){

        return repo.teacherDB.get(name);
    }
    public List<String> getStudentsbyTeacherName(String name){
        return repo.StudentTeacherAssociationDB.get(name);
    }

    public List<String> getAllStudents(){
        LinkedList<String> student=new LinkedList<>();
        for(String s:repo.studentDB.keySet()){
            student.add(s);
        }
        return student;
    }

    public void deleteTeacherByName(String name){

        if(repo.teacherDB.containsKey(name)){
            repo.teacherDB.remove(name);
        }
        if(repo.StudentTeacherAssociationDB.containsKey(name)){
            repo.StudentTeacherAssociationDB.remove(name);
        }
    }

    public void deleteAllTeachers(){
        repo.teacherDB.clear();
        repo.StudentTeacherAssociationDB.clear();
    }
}