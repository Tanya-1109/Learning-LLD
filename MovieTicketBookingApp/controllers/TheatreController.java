package MovieTicketBookingApp.controllers;

import java.util.*;

import MovieTicketBookingApp.enums.City;
import MovieTicketBookingApp.theatre.Show;
import MovieTicketBookingApp.theatre.Theatre;
import MovieTicketBookingApp.movies.Movie;


public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatres;
    List<Theatre> allTheatres;

    public TheatreController(){
        cityVsTheatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city){
        allTheatres.add(theatre);
        List<Theatre> theatres = cityVsTheatres.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatres.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city){
        Map<Theatre , List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatres.get(city);
        for(Theatre theatre : theatres){
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();
            for(Show show : shows){
                if(show.getMovie().getMovieId() == movie.getMovieId()){
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()){
                theatreVsShows.put(theatre, givenMovieShows);
            }

        }
        return theatreVsShows;
    }
}