package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;
import model.Theater;

/**
 * Servlet implementation class TheaterNavigationServlet
 */
@WebServlet("/theaterNavigationServlet")
public class TheaterNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheaterNavigationServlet() {
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
		TheaterHelper helper = new TheaterHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/index.html";
		int id;
		
		if (act.equals("delete")) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
				Theater toDelete = helper.searchForTheaterById(id);
				helper.deleteTheater(toDelete);
				path = "/viewTheatersServlet";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else if (act.equals("add")) {
			path = "/addMoviesToTheaterServlet";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
