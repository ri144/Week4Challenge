

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession ses = ((HttpServletRequest) request).getSession();
		
		/*if(ses.getAttribute("flag") == null){
			p = new Person();
			p.setName("", "", "");
			//System.out.print("here\n");
			ses.setAttribute("pers", p);
			ses.setAttribute("flag", "set");
		}
		else{*/
			//p = (Person) ses.getAttribute("pers");
		String check = request.getParameter("act");
		String next ="";
		int count;
		try{
			count = (int) ses.getAttribute("c");
		}
		catch(NullPointerException e){
			count = 0;
		}
		if(check.equals("init")){
			next = initialize(request, response);
			ses.setAttribute("c", 0);
		}
		else if(check.equals("edu")){
			next = educate(request, response);
			ses.setAttribute("c", count + 1);
		}
		else if(check.equals("educont")){
			next = "/work.jsp";
			ses.setAttribute("c", 0);
		}
		getServletContext().getRequestDispatcher(next).forward(request, response);
	}

	@SuppressWarnings("unused")
	private String educate(HttpServletRequest request, HttpServletResponse response) {
		// check that year is an int
		HttpSession ses = ((HttpServletRequest) request).getSession();
		Person p = (Person) ses.getAttribute("p");	
		String degree = request.getParameter("degree");
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String year = request.getParameter("year");
		p.setEdu(degree, major, school, year);

		ses.setAttribute("p", p);
		if(((int) ses.getAttribute("c") + 1) < 10 ){
			request.setAttribute("msg2", "Please fill out the following input fields for education and submit with the button when ready.");
			return "/edu.jsp";
		}
		else{
			request.setAttribute("msg3", "Please fill out the following input field for work experience and submit with the button when ready.");
			ses.setAttribute("c", -1);
			return "/work.jsp";
		}
	}

	@SuppressWarnings("unused")
	private String initialize(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// check that mid init is 1 digit
		HttpSession ses = ((HttpServletRequest) request).getSession();
		Person p = new Person();	
		String first = request.getParameter("fname");
		String last = request.getParameter("lname");
		String mid = request.getParameter("mname");
		//System.out.printf("%s %s %s\n",first, mid, last);
		p.setName(first, mid, last);
		p.setemail(request.getParameter("email"), first, last);
		//}
		ses.setAttribute("p", p);
		if(false){
			request.setAttribute("msg", "There was an error with one of your inputs.<br>Please fill out the following input fields and submit with the button when ready.");
			//System.out.printf("%s\n", p.getName());
			return "/start.jsp";
		}
		else{
			request.setAttribute("msg2", "Please fill out the following input fields for education and submit with the button when ready.");
			//System.out.printf("%s\n", p.getName());
			return "/edu.jsp";
		}
	}

}
