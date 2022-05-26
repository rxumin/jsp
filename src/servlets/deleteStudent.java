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

@WebServlet("/delete")
public class deleteStudent extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        studentService.deleteDBStudents(id);
        resp.sendRedirect("/login");
    }
}
