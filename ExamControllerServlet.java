import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class ExamControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String questionId = request.getParameter("questionId");
        String selectedOption = request.getParameter("selectedOption");

        HashMap<String, String> answers = (HashMap<String, String>) session.getAttribute("answers");
        if (answers == null) {
            answers = new HashMap<>();
        }
        answers.put(questionId, selectedOption);
        session.setAttribute("answers", answers);

        // Redirect to next question or submit page
    }
}
