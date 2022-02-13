import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AutorisationService autorisationService = new AutorisationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/log.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password").toString();
        User user = autorisationService.auth(login, password);
        if (user == null) {
            req.getRequestDispatcher("/jsp/log.jsp").forward(req, resp);
        } else {
            req.setAttribute("name",user.getName());
            req.getRequestDispatcher("/jsp/hello.jsp").forward(req, resp);
        }


    }
}
