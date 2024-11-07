import java.util.Scanner;

/*
* I am a new record shop business owner.
* I want to create a successful record shop business.
* To do this, I must know what genres and artists are from are popular.
*/

public class UserStory {
  
  // Arrays to hold album names, artist names, and genres
  private String[] album;
  private String[] artist;
  private String[] genre;
  private String[] release;

 // No-argument constructor
  public UserStory() {
      // Initialize the arrays to empty arrays
      this.album = new String[0];
      this.artist = new String[0];
      this.genre = new String[0];
  }
  
  // Constructor that initializes the album, artist, and genre arrays
  public UserStory(String albumFile, String artistFile, String genreFile) {
    album = FileReader.toStringArray(albumFile);  // Load albums from file
    artist = FileReader.toStringArray(artistFile); // Load artists from file
    genre = FileReader.toStringArray(genreFile);   // Load genres from file
  }

  
  // User Input Prompt
  // This method prompts the user for input and returns their response
  private String promptUserInput(String prompt) {
      Scanner input = new Scanner(System.in); // Create a scanner for user input
      System.out.println(prompt); // Display the prompt message
      String userInput = input.nextLine(); // Read user input
      return userInput; // Return the input received from the user
    
  }
  
  // Prompt Methods
  // These methods prompt the user for specific types of information
  public String promptUserForAlbum() {
      return promptUserInput("What album are you looking for?"); // Ask for an album
  }

  public String promptUserForArtist() {
      return promptUserInput("What artist are you looking for?"); // Ask for an artist
  }

  public String promptUserForGenre() {
      return promptUserInput("What genre are you looking for?"); // Ask for a genre
  }

  // Search Methods

  // This method searches for albums by a specific artist
  public String findByArtist(String searchArtist) {
      String result = ""; // Initialize the result string
      int count = 0;
      boolean found = false; //   to indicate if any albums were found

      for (int i = 0; i < artist.length; i++) { // Loop through the artist array
          if (searchArtist.equalsIgnoreCase(artist[i])) { // Check if the artist matches
              // Append album and genre information to the result
            count++;
            result += "Album: " + album[i] + " - Genre: " + genre[i] + "\n";
            found = true; // Set found to true
          }
      }

      // If albums are found, return the result; otherwise, return not found message
      if (found) {
          System.out.println(count + " Albums by " + searchArtist + "\n");
          return result; 
      } else {
          return "We don't have any albums by " + searchArtist + " in store.";
      }
  }

  // This method searches for albums by genre
  public String findByGenre(String searchGenre) {
    String result = ""; // Initialize the result string
    int count = 0;
    boolean found = false; // to indicate if any albums were found

      for (int i = 0; i < genre.length; i++) { // Loop through the genre array
          if (checkGenreForWord(genre[i], searchGenre)) { // Check if the genre matches
              // Append album and genre information to the result
              count++;
              result += "Album: " + album[i] + " - Genre: " + genre[i] + "\n";
              found = true; // Set found to true
          }
      }

      // If albums are found, return the result; otherwise, return not found message
      if (found) {
          System.out.println(count + " " + searchGenre + " found" + "\n");
          return result; 
      } else {
          return "We don't have any albums with " + searchGenre + " in store.";
      }
  }

  // Helper method to check if a genre contains a specific word
  private boolean checkGenreForWord(String genre, String searchGenre) {
      return genre.toLowerCase().contains(searchGenre.toLowerCase()); // Return true if genre matches
  }

  // Combined Information Display
  // This method returns a string representation of all albums with their artists and genres
  public String toString() {
      String result = ""; // Initialize the result string
      
      for (int i = 0; i < album.length; i++) { // Loop through the album array
          // Append artist, album, and genre information to the result
          result += artist[i] + " -- " + album[i] + " (" + genre[i] + ")\n"; 
      }
      return result; // Return the complete result string
  }
}