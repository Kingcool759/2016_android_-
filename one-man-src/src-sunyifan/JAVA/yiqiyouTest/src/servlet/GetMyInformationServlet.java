package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User_detailsBean;
import dao.User_detailsDao;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class MyServle
 */
@WebServlet("/GetMyInformationServlet")
public class GetMyInformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletContext application = getServletContext();
        int user_id = (int)application.getAttribute("user_id");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        application.setAttribute("user_id", user_id);
        User_detailsBean udbean = new User_detailsBean();
        User_detailsDao uddao = new User_detailsDao();
        udbean = uddao.getDetails(user_id);
        JSONObject jo = new JSONObject();
        jo.put("user_nickname", udbean.getUser_nickname());
        jo.put("user_sex", udbean.getUser_sex());
        jo.put("user_age", udbean.getUser_age());
        jo.put("user_school", udbean.getUser_school());
        String jsonStr = jo.toString();
        PrintWriter out = response.getWriter();
        out.println(jsonStr);
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
