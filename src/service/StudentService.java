package service;

import beans.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudentsFromDB();
    public void insertDBStudents(Student student);
    public void deleteDBStudents(String id);
    public Student findById(String id);
    public void update(String id,String name,String sex, String major,String hometown);
}
