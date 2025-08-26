package MovieTicketBookingApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import MovieTicketBookingApp.controllers.MovieController;
import MovieTicketBookingApp.controllers.TheatreController;
import MovieTicketBookingApp.enums.City;
import MovieTicketBookingApp.movies.Movie;
import MovieTicketBookingApp.theatre.Show;
import MovieTicketBookingApp.theatre.Theatre;
import MovieTicketBookingApp.utilities.BookingDataFactory;

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
    public void startBookingSession(){
        printHeader("Welcome to BookMyShow");
        boolean continueBooking = true;
        while (continueBooking){
            City userCity = selectCity();
            Movie selectedMovie = selectMovie(userCity);
            Show selectedShow = selectShow(userCity, selectedMovie);
            bookSeat(selectedShow);
            System.out.println("Do you want to book another ticket? (yes/no)");
            String response = scanner.next().trim().toLowerCase();
            continueBooking = response.equals("yes");
        }
        printSuccess("Thank you for using BookMyShow!");

    }
    private City selectCity(){
        printSection("Select Your City");
        for(City city : City.values()){
            System.out.println("  " + (city.ordinal() + 1) + ". " + city);
        }
        return City.values()[getUserChoice(1,City.values().length) - 1];
    }
    private Movie selectMovie(City city){
        List<Movie> movies = movieController.getMoviesByCity(city);
        printSection("Select Movie in " + city);
        for(int i=0; i<movies.size(); i++){
            System.out.println("  " + (i+1) + ". " + movies.get(i).getMovieName());
        }
        return movies.get(getUserChoice(1, movies.size()) - 1);
    }
    private Show selectShow(City city, Movie movie){
        Map<Theatre, List<Show>> showsMap = theatreController.getAllShow(movie, city);
        List<Show> availableShows = new ArrayList<>();
        printSection("Available Shows for " + movie.getMovieName() + " in " + city);
        int index = 1;
        for(Map.Entry<Theatre, List<Show>> entry : showsMap.entrySet()){
            for (Show show : entry.getValue()){
                System.out.println("  " + index + ". " + show.getShowStartTime() + " at " + entry.getKey().getTheatreName());
                availableShows.add(show);
                index ++;
            }
        }
        return availableShows.get(getUserChoice(1, availableShows.size()) - 1);
    }
    private void bookSeat(Show show) {
        printSection("💺 Select Your Seat (1-100)");
        int seatNumber = getUserChoice(1, 100);
        if (show.getBookedSeatIds().contains(seatNumber)) {
            System.out.println("❌ Seat already booked! Please try another seat.");
            bookSeat(show);
        } else {
            show.getBookedSeatIds().add(seatNumber);
            PaymentService paymentService = new PaymentService();
            boolean paymentSuccess = paymentService.processPayment(250); // Example amount

            if (paymentSuccess) {
                printSuccess("✅ Booking Successful! Enjoy your movie! 🍿");
                generateTicket(show, seatNumber);
            } else {
                System.out.println("❌ Payment failed! Please try again.");
                show.getBookedSeatIds().remove(seatNumber); // Revert seat booking
            }
        }
    }
    private void generateTicket(Show show, int seatNumber) {
        System.out.println("----- 🎟️ Your Ticket 🎟️ -----");
        System.out.println("Movie: " + show.getMovie().getMovieName());
        System.out.println("Screen: " + show.getScreen().getScreenId());
        System.out.println("Show Time: " + show.getShowStartTime());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("-----------------------------");
    }
    private int getUserChoice(int min, int max) {
        int choice;
        do {
            System.out.print("👉 Enter choice (" + min + "-" + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < min || choice > max);
        return choice;
    }

    private void printHeader(String text) {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("          " + text);
        System.out.println("══════════════════════════════════════════\n");
    }

    private void printSection(String text) {
        System.out.println("\n🔹 " + text);
        System.out.println("──────────────────────────────────────────");
    }

    private void printSuccess(String text) {
        System.out.println("\n🎉 " + text + "\n");
    }

    public void initialize() {
        BookingDataFactory.createMovies(movieController);
        BookingDataFactory.createTheatres(movieController, theatreController);
    }
}

