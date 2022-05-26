package dao.Impl;

import beans.Student;
import dao.StudentDao;
import utils.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getStudentsFromDB() {
        List list = new ArrayList();
        Student student = null;
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from student";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                String major = resultSet.getString(4);
                String hometown = resultSet.getString(5);
                student = new Student(id, name, sex, major, hometown);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public void insertDBStudents(Student student) {
        String id = student.getId();
        String name = student.getName();
        String sex = student.getSex();
        String major = student.getMajor();
        String hometown = student.getHometown();
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into student(id,name,sex,major,hometown) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, sex);
            preparedStatement.setString(4, major);
            preparedStatement.setString(5, hometown);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, null);
        }
    }

    @Override
    public void deleteDBStudents(String id) {
        Connection connection = JDBCTools.getConnection();
        String sql = "delete from student where id = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, null);
        }
    }

    @Override
    public Student findById(String id) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select id,name,sex,major,hometown from student where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getString(1));
                student.setName(resultSet.getString(2));
                student.setSex(resultSet.getString(3));
                student.setMajor(resultSet.getString(4));
                student.setHometown(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return student;
    }

    @Override
    public void update(String id,String name, String sex, String major, String hometown) {
        Connection connection = JDBCTools.getConnection();
        String sql = "update student set name = ?,sex = ?,major = ?, hometown = ? where id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,sex);
            statement.setString(3,major);
            statement.setString(4,hometown);
            statement.setString(5,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,null);
        }
    }
}
