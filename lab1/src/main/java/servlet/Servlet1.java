package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trees.Trees;
import trees.Mock;

import java.io.IOException;
import java.util.List;

import crud.Lab2CrudInterface;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Trees> lu = new Mock().getTreesList();

	ServletConfigInterface servletConfig;
	Lab2CrudInterface lab2Crud;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
        this.servletConfig = new ServletConfig();
        this.lab2Crud =servletConfig.getCrud();
    }
        
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		response.getWriter().println(lu);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Trees trees = Helpers.treesParse(request);
		trees.setId(Helpers.getNextId(lu));
		lu.add(trees);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Trees trees = Helpers.treesParse(request);
		int Id = Integer.parseInt(request.getPathInfo().substring(1));
		System.out.println(Id);
		response.setContentType("application/json");
		int index = Helpers.getIndexBytreesId(Id,lu);
		lu.set(index,trees);
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		int Id = Integer.parseInt(request.getPathInfo().substring(1));
		System.out.println(Id);
		response.setContentType("application/json");
		int index = Helpers.getIndexBytreesId(Id,lu);
		lu.remove(index);
		doGet(request, response);
	}
	
		
		protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			setAccessControlHeaders(response);
			response.setStatus(HttpServletResponse.SC_OK);

		}
		
		private void setAccessControlHeaders(HttpServletResponse resp) {
			
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setHeader("Access-Control-Allow-Methods", "*");
			resp.setHeader("Access-Control-Allow-Headers", "*");
		
	}

}
