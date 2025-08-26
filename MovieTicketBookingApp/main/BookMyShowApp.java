package MovieTicketBookingApp.main;

import MovieTicketBookingApp.services.BookingService;

public class BookMyShowApp {
    public static void main(String[] args) {
        System.out.println("Welcome to BookMyShow!");

        BookingService bookService = BookingService.getInstance();
        bookService.initialize();
        bookService.startBookingSession();
    }
    
}
