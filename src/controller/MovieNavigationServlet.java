package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class MovieNavigationServlet
 */
@WebServlet("/movieNavigationServlet")
public class MovieNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieHelper helper = new MovieHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/index.html";
		int id;
		
		if (act.equals("edit")) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
				Movie toEdit = helper.searchForMovieById(id);
				request.setAttribute("toEdit", toEdit);
				path= "/edit_movies.jsp";
			} catch (Exception e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if (act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
