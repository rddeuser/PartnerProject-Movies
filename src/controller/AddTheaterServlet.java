package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;
import model.Theater;

/**
 * Servlet implementation class AddTheaterServlet
 */
@WebServlet("/addTheaterServlet")
public class AddTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTheaterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieHelper helper = new MovieHelper();
		TheaterHelper tHelper = new TheaterHelper();
		
		String theaterName = request.getParameter("theaterName");
		String location = request.getParameter("location");
		
		String[] selectedMovies = request.getParameterValues("allMoviesToAdd");
		List<Movie> selectedMoviesInList = new ArrayList<Movie>();
		
		if(selectedMovies != null && selectedMovies.length > 0) {
			for (int i = 0; i < selectedMovies.length; i++) {
				Movie m = helper.searchForMovieById(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(m);
			}//end for
		}//end if
		
		Theater theater = new Theater(theaterName, location, selectedMoviesInList);
		tHelper.insertTheater(theater);
		
		getServletContext().getRequestDispatcher("/viewTheatersServlet").forward(request, response);
	}

}
