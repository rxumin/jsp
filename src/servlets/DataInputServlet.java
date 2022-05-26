package servlets;

import dao.DataInputDao;
import dao.Impl.DataInputDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/upload")
public class DataInputServlet extends HttpServlet {
    DataInputDao dataInputDao = new DataInputDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tableName = "student";
        String path = "D:\\keshe\\data\\student.txt";
        try {
            dataInputDao.ReadFile(tableName,path);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/login");
    }
}
