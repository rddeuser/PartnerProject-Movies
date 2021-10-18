package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/editMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
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
		
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		double rating = Double.parseDouble(request.getParameter("rating"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Movie toUpdate = helper.searchForMovieById(id);
		
		toUpdate.setTitle(title);
		toUpdate.setGenre(genre);
		toUpdate.setRating(rating);
		toUpdate.setReleaseDate(ld);
		
		helper.updateMovie(toUpdate);
		
		getServletContext().getRequestDispatcher("/viewMoviesServlet").forward(request, response);
	}

}
