package MovieTicketBookingApp.services;

import java.util.Scanner;

import MovieTicketBookingApp.contollers.MovieController;
import MovieTicketBookingApp.contollers.TheatreController;

public class BookingService {
    private static BookingService instance;

    private final MovieController movieController;
    private final TheatreController theatreController;
    private final Scanner scanner;

    private BookingService(){
        movieController = new MovieController();
        theatreController = new TheatreController();
        scanner = new Scanner(System.in);
    }
    public static BookingService getInstance(){
        if(instance == null){
            instance = new BookingService();
        }
        return instance;
    } 
    
}
