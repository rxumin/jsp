package servlets;

import service.Impl.StudentServiceImpl;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/update")
public class modifyStudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = (String)session.getAttribute("stuid");
//        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String major = req.getParameter("major");
        String hometown = req.getParameter("hometown");
        studentService.update(id,name,sex,major,hometown);
        resp.sendRedirect("/login");
    }
}
