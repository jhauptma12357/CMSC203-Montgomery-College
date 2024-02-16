import java.util.Scanner;
public class MovieDriver{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Movie movie = new Movie();
        while(true) {
            System.out.println("Enter the name of a movie");
            movie.setTitle(sc.nextLine());
            System.out.println("Enter the rating of the movie");
            movie.setRating(sc.nextLine());
            System.out.println("Enter the number of tickets sold for this movie");
            movie.setSoldTickets(sc.nextInt());
            sc.nextLine();
            System.out.println(movie.getTitle() + " (" + movie.getRating() + "): Tickets Sold: " + movie.getSoldTickets());
            System.out.println("Do you want to enter another (Y/N)");
            if(sc.nextLine().equalsIgnoreCase("n")){
                break;
            }
        }
        System.out.println("Goodbye");
    }
}