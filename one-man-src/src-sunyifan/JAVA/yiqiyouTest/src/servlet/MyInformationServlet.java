package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_detailsDao;

/**
 * Servlet implementation class MyInformationServlet
 */
@WebServlet("/MyInformationServlet")
public class MyInformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub

        ServletContext application = getServletContext();
        int user_id = (int)application.getAttribute("user_id");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String user_nickname = request.getParameter("unickname");
        String user_sex = request.getParameter("usex");
        int user_age = Integer.parseInt(request.getParameter("uage"));
        String user_school = request.getParameter("uschool");
        System.out.println(user_nickname);
        System.out.println(user_sex);
        System.out.println(user_age);
        System.out.println(user_school);
        application.setAttribute("user_id", user_id);
        User_detailsDao uddao = new User_detailsDao();
        uddao.saveDetails(user_id, user_nickname, user_sex, user_age, user_school);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
