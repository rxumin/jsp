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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();
    List list = new ArrayList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.getStudentsFromDB();
        req.setAttribute("list",students);
        req.getRequestDispatcher("dataOperation.jsp").forward(req,resp);
//        int i = 0;
    }
}
