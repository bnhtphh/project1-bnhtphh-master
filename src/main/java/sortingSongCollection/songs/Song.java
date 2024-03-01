package sortingSongCollection.songs;

/** A class representing a song with the given title and artist.
 *  FILL IN CODE in the compareTo method to compare "this" song to another song by title.  */
public class Song implements Comparable<Song> {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }


    public String toString() {
        return title + ", " + artist + ";";
    }

    /**
     *
     * @param o another song to compare with "this" one
     * @return
     *  0, if the title of "this" song is the same as the title of o,
     *  a negative value if the title of "this" song is alphabetically smaller than the title of o,
     *  a positive value if the title is this song is "larger" than the title of the other song.
     *
     */
    @Override
    public int compareTo(Song o) {
        // FILL IN CODE: compare songs by title
        return this.title.compareTo(o.title);
    }
}

