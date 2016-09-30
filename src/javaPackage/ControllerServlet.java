package javaPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("*.html")
public class ControllerServlet extends HttpServlet {
	private static final String URL_LOGIN_HTML = "/login.html";
	private static final String URL_SHOW_INFO = "/showInfo.html";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// COMPLETE 1.- Obtain the path of the request
		String sReq;
		
	    sReq = request.getServletPath();
	    System.out.println("request: "+sReq);
		
	    // If the path is null show error message
	    if (sReq == null) {
	      response.sendError(HttpServletResponse.SC_NOT_FOUND);
	    }
	    else
		// COMPLETE 2.- Check if the path is  "/showInfo.html" or "/login.html"
	    	switch(sReq){
	    		case URL_SHOW_INFO :System.out.println(URL_SHOW_INFO);
	    		break;
	    		case URL_LOGIN_HTML: System.out.println(URL_LOGIN_HTML);
	    		break;
	    		default: response.sendError(HttpServletResponse.SC_NOT_FOUND);
	    	}
	    		
		// COMPLETE 3.- Obtain the value of the name send in the request

		// COMPLETE 4.- If the name is NULL we should redirect to the view  "entername.jsp"

	 	
		  // COMPLETE 5.- If it is nt null:
		  //				-  crearte a DataStore object
		  //				-  call its method getInfo sending the name received as a parameter


		  // COMPLETE 6.- If no data has been found we should redirect to "sorryNotFound.jsp"

				// COMPLETE 7.- if data found:
				//			- Load the object databean obtain as an attribute "dataModelBean" of the request
				//			- redirect to "showInfo.jsp"
	    
	}
}
