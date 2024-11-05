import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String newPassword = request.getParameter("newPassword");

        if (UserDAO.updatePassword(username, newPassword)) {
            response.sendRedirect("profile.jsp?message=Password updated successfully");
        } else {
            response.sendRedirect("profile.jsp?error=Update failed");
        }
    }
}
