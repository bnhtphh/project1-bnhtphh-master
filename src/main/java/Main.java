import sortingSongCollection.songs.SongCollection;
import sortingSongCollection.sortingAlgorithms.*;

public class Main {
    public static void main(String[] args) {
        // Create a song collection of 12 songs:
        SongCollection collection = new SongCollection(12);
        collection.addSong("Unstoppable", "Sia");
        collection.addSong("Calm Down", "Rema");
        collection.addSong("Flowers", "Miley Cyrus");
        collection.addSong("What was I made for?","Billie Eilish");
        collection.addSong("Hero", "Enrique Iglesias");
        collection.addSong("Anti Hero", "Taylor Swift");
        collection.addSong("Blank Space", "Taylor Swift");
        collection.addSong("Only Girl", "Rihanna");
        collection.addSong("Vampire", "Olivia Rodrigo");
        collection.addSong("Piyala", "AIGEL");
        collection.addSong("Roar", "Katy Perry");
        collection.addSong("Last Friday Night", "Katy Perry");

        // Set the algorithm to be the Insertion sort
        collection.setSortingAlgorithm(new InsertionSort());
        collection.sortSongs(0, 11, true, "insertionResult1");
        // Intermediate results of sorting should be written to the file "insertionResult1"
        // TODO: run your code on other values of low and high

        // TODO: run other sorting algorithms
        // Also look at the provided tests under test/java

    }
}
