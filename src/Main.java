

import java.io.IOException;
import java.util.ArrayList;

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
		/*int count;
		try{
			count = (int) ses.getAttribute("c");
		}
		catch(NullPointerException e){
			count = 0;
		}*/
		if(check.equals("init")){
			next = initialize(request, response);
			ses.setAttribute("c", 0);
		}
		else if(check.equals("edu")){
			next = educate(request, response, false);
			ses.setAttribute("c", (int) ses.getAttribute("c") + 1);
		}
		else if(check.equals("edu2")){
			next = educate(request, response, true);
			ses.setAttribute("c", (int) ses.getAttribute("c") + 1);
		}
		else if(check.equals("educont")){// || (int) ses.getAttribute("c") == 10){
			next = "/work.jsp";
			ses.setAttribute("c", 0);
			request.setAttribute("msg3", "Please fill out the following input field for work experience and submit with the button when ready.<br>"
					+ "Or click the second button to continue to the next set of data fields.");
		}
		else if(check.equals("work")){
			next = work(request, response);
			ses.setAttribute("c", (int) ses.getAttribute("c") + 1);
		}
		else if(check.equals("workcont")){// || (int) ses.getAttribute("c") == 10){
			next = "/skill.jsp";
			ses.setAttribute("c", 0);
			request.setAttribute("msg4", "Please fill out the following input field for skills and submit with the button when ready.");
		}
		else if(check.equals("skill")){
			next = skills(response, request);
			ses.setAttribute("c", (int) ses.getAttribute("c") + 1);
		}
		else if(check.equals("skillcont")){// || (int) ses.getAttribute("c") == 10){
			setResults(request);
			
			next = "/cleanerResults.jsp";
		}
		getServletContext().getRequestDispatcher(next).forward(request, response);
	}

	private String skills(HttpServletResponse response, HttpServletRequest request) {
		HttpSession ses = ((HttpServletRequest) request).getSession();
		Person p = (Person) ses.getAttribute("p");	
		String skill = request.getParameter("skill");
		String proficiency = request.getParameter("proficiency");
		p.setSkill(skill, proficiency);
		ses.setAttribute("p", p);
		if(((int) ses.getAttribute("c") + 1) < 20 ){
			request.setAttribute("msg4", "Please fill out the following input field for skills and submit with "
					+ "the button when ready.<br>Or click the second button to continue to the results.");
			return "/skill2.jsp";
		}
		else{
			//request.setAttribute("msg4", "Please fill out the following input field for skills and submit with the button when ready.");
			ses.setAttribute("c", -1);
			setResults(request);
			return "/cleanerResults.jsp";
		}
	}
private void setResults(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession ses = ((HttpServletRequest) request).getSession();
		Person p = (Person) ses.getAttribute("p");
		ArrayList<ArrayList<String>> x = p.getEdu2();
		request.setAttribute("name", p.getName());
		request.setAttribute("email",p.getEmail());
		for(int i = 0; i<x.size();i++){
			request.setAttribute(("deg" + String.valueOf(i)),x.get(i).get(0));
			request.setAttribute(("maj" + String.valueOf(i)),x.get(i).get(1));
			request.setAttribute(("uni" + String.valueOf(i)),x.get(i).get(2));
			request.setAttribute(("year" + String.valueOf(i)),x.get(i).get(3));
		}
		request.setAttribute("edspace",x.size());
		request.setAttribute("edu", p.getEdu().replace("\n", "<br>"));
		request.setAttribute("exp", p.getExp().replace("\n", "<br>"));
		request.setAttribute("skill", p.getSkills().replace("\n", "<br>"));
	}

	private String work(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession ses = ((HttpServletRequest) request).getSession();
		Person p = (Person) ses.getAttribute("p");	
		String position = request.getParameter("position");
		String company = request.getParameter("company");
		String startmonth = request.getParameter("startmonth");
		String startyear = request.getParameter("startyear");
		String endmonth = request.getParameter("endmonth");
		String endyear= request.getParameter("endyear");
		String duty1= request.getParameter("duty1");
		String duty2 = request.getParameter("duty2");
		if(!isInteger(startyear) || !isInteger(endyear)){
			request.setAttribute("msg3", "There was an error with one of your inputs. (Year not an int)<br>Please fill out the following input fields and submit with the button when ready.");
			ses.setAttribute("c", (int) ses.getAttribute("c") - 1);
			return "/work.jsp";
		}
		else if(startmonth.length() > 15 || endmonth.length() > 15){
			request.setAttribute("msg3", "There was an error with one of your inputs. (Month size too large)<br>Please fill out the following input fields and submit with the button when ready.");
			ses.setAttribute("c", (int) ses.getAttribute("c") - 1);
			return "/work.jsp";
		}
		p.setWork(position, company, startmonth, startyear, endmonth, endyear, duty1, duty2);
		//'position', 'company', 'startmonth', "
		//+ "'startyear', 'endmonth', 'endyear', 'duty1', 'duty2' 
		ses.setAttribute("p", p);
		if(((int) ses.getAttribute("c") + 1) < 10 ){
			request.setAttribute("msg3", "Please fill out the following input field for work experience and submit with the button when ready.<br>"
					+ "Or click the second button to continue to the next set of data fields.");
			return "/work.jsp";
		}
		else{
			request.setAttribute("msg4", "Please fill out the following input field for skills and submit with the button when ready.");
			ses.setAttribute("c", -1);
			return "/skill.jsp";
		}
	}

	private boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	private String educate(HttpServletRequest request, HttpServletResponse response, boolean flag) {
		// check that year is an int
		HttpSession ses = ((HttpServletRequest) request).getSession();
		Person p = (Person) ses.getAttribute("p");	
		String degree = request.getParameter("degree");
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String year = request.getParameter("year");
		if(!isInteger(year)){
			request.setAttribute("msg2", "There was an error with one of your inputs. (Year not an int)<br>Please fill out the following input fields and submit with the button when ready.");
			ses.setAttribute("c", (int) ses.getAttribute("c") - 1);
			if(flag){
				return "/edu2.jsp";
			}
			else{
				return "/edu.jsp";
			}
		}
		else if(degree.length() > 10){
			request.setAttribute("msg2", "There was an error with one of your inputs. (Degree input too long)<br>Please fill out the following input fields and submit with the button when ready.");
			ses.setAttribute("c", (int) ses.getAttribute("c") - 1);
			if(flag){
				return "/edu2.jsp";
			}
			else{
				return "/edu.jsp";
			}
		}
		p.setEdu(degree, major, school, year);
		ses.setAttribute("p", p);
		if(((int) ses.getAttribute("c") + 1) < 10 ){
			request.setAttribute("msg2", "Please fill out the following input fields for education and submit with the button when ready.");
			return "/edu2.jsp";
		}
		else{
			request.setAttribute("msg3", "Please fill out the following input field for work experience and submit with the button when ready.<br>"
					+ "Or click the second button to continue to the next set of data fields.");
			ses.setAttribute("c", -1);
			return "/work.jsp";
		}
	}

	private String initialize(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// check that mid init is 1 digit
		HttpSession ses = ((HttpServletRequest) request).getSession();
		Person p = new Person();	
		String first = request.getParameter("fname");
		String last = request.getParameter("lname");
		String mid = request.getParameter("mname");
		//System.out.printf("%s %s %s\n",first, mid, last);
		if(mid.length() > 1){
			request.setAttribute("msg", "There was an error with one of your inputs. (middle initial size greater than 1)<br>Please fill out the following input fields and submit with the button when ready.");
			//System.out.printf("%s\n", p.getName());
			return "/start.jsp";
		}
		else{
			p.setName(first, mid, last);
			p.setemail(request.getParameter("email"), first, last);
			//}
			ses.setAttribute("p", p);
			request.setAttribute("msg2", "Please fill out the following input fields for education and submit with the button when ready.");
			//System.out.printf("%s\n", p.getName());
			return "/edu.jsp";
		}
	}

}
