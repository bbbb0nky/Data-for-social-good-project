import java.util.Scanner; // Import the Scanner class for reading user input

public class DataRunner {
  public static void main(String[] args) {
    // Create a Scanner object to take input from the user
    Scanner input = new Scanner(System.in);
      
    // Create an instance of UserStory, loading data from the specified text files
    UserStory userStory = new UserStory("Album.txt", "Artist.txt", "Genre.txt");
        
    // Display a welcome message and prompt the user for their choice
    System.out.println("What are you looking for? \n1: Artist \n2: Genre \n3: Leave \n(Type 1, 2, or 3)");

    // Read the user's choice as an integer
    int choice = input.nextInt();

    // Check the user's choice and execute the corresponding action
    if(choice == 1) {
        // If the user chooses 1, prompt for an artist name
        String artist = userStory.promptUserForArtist();
        System.out.println("\n--------------New List--------------\n");
        // Find and display information about the artist
        System.out.println(userStory.findByArtist(artist));
      
    } else if (choice == 2) {
        // If the user chooses 2, prompt for a genre
        String genre = userStory.promptUserForGenre();
        System.out.println("\n--------------New List--------------\n");
        // Find and display information about the genre
        System.out.println(userStory.findByGenre(genre));   
      
    } else if (choice == 3) {
        System.out.println("\n----------------------------\n");
        System.out.println("Goodbye!");
            
    }
        
    // Close the Scanner to release the resources
    input.close();
    }
}