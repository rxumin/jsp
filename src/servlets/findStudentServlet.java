package servlets;

import beans.Student;
import service.Impl.StudentServiceImpl;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/find")
public class findStudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        String id = req.getParameter("id");
        HttpSession session = req.getSession();
        session.setAttribute("stuid",id);
        switch (method){
            case "find":
                Student student = studentService.findById(id);
                req.setAttribute("student",student);
                req.getRequestDispatcher("modifyStudent.jsp").forward(req,resp);
                break;
//            case "updateById":

        }

    }
}
