package servlets;

import beans.Student;
import service.Impl.StudentServiceImpl;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class addStudentServlet extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();
    Student student = new Student();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String major = req.getParameter("major");
        String hometown = req.getParameter("hometown");
        student.setId(id);
        student.setName(name);
        student.setSex(sex);
        student.setMajor(major);
        student.setHometown(hometown);
        studentService.insertDBStudents(student);
        resp.sendRedirect("/login");
    }
}
