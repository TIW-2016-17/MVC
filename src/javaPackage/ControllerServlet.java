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
	private static final String SHOW_INFO_JSP = "showInfo.jsp";
	private static final String ATTRIBUTE_DATA_MODEL_BEAN = "dataModelBean";
	private static final String SORRY_NOT_FOUND_JSP = "sorryNotFound.jsp";
	private static final String ENTER_NAME_JSP = "enterName.jsp";
	private static final String NAME = "name";
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
		System.out.println("request: " + sReq);

		// If the path is null show error message
		if (sReq == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else
		// COMPLETE 2.- Check if the path is "/showInfo.html" or "/login.html"
		/*
		 * switch(sReq){ case URL_SHOW_INFO :System.out.println(URL_SHOW_INFO);
		 * break; case URL_LOGIN_HTML: System.out.println(URL_LOGIN_HTML);
		 * break; default: response.sendError(HttpServletResponse.SC_NOT_FOUND);
		 * }
		 */
		if (sReq.equals(URL_SHOW_INFO) || sReq.equals(URL_LOGIN_HTML)) {
			String viewURL = null;
			String name;
			// COMPLETE 3.- Obtain the value of the name send in the request
			name = request.getParameter(NAME);
			System.out.println("Parameter " + NAME + "= ");

			// COMPLETE 4.- If the name is NULL we should redirect to the view
			// "entername.jsp"
			if (name == null) {
				viewURL = ENTER_NAME_JSP;
			} else {
				// COMPLETE 5.- If it is nt null:
				// - create a DataStore object
				// - call its method getInfo sending the name received as a
				// parameter
				DataStore almacen = new DataStore();
				DataModelBean beanUser = almacen.getInfo(name);

				// COMPLETE 6.- If no data has been found we should redirect to "sorryNotFound.jsp"
				if (beanUser == null) {
					viewURL = SORRY_NOT_FOUND_JSP;
				}
				else {
					// COMPLETE 7.- if data found:
					// - Load the object databean obtain as an attribute "dataModelBean" of
					// the request
					// - redirect to "showInfo.jsp"
					request.setAttribute(ATTRIBUTE_DATA_MODEL_BEAN, beanUser);
                	viewURL = SHOW_INFO_JSP;
				}
			}
			if (viewURL != null)
				request.getRequestDispatcher(viewURL).forward(request, response);

		}

		

	}
}
