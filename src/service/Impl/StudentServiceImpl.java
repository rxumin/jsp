package service.Impl;

import beans.Student;
import dao.Impl.StudentDaoImpl;
import dao.StudentDao;

import java.util.List;

public class StudentServiceImpl implements service.StudentService {

    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> getStudentsFromDB() {
        return studentDao.getStudentsFromDB();
    }

    @Override
    public void insertDBStudents(Student student) {
        studentDao.insertDBStudents(student);
    }

    @Override
    public void deleteDBStudents(String id) {
        studentDao.deleteDBStudents(id);
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public void update(String id,String name,String sex, String major,String hometown) {
        studentDao.update(id,name,sex,major,hometown);
    }
}
