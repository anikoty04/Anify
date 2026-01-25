import java.util.ArrayList;

public class CircularHistory {
     private ArrayList<Song> history; //Songs you heard
    private int maxSize; //Maximum history size

    //Makes the main constructor

    public CircularHistory(int maxSize) {
        history = new ArrayList<>();
        this.maxSize = maxSize;
    }
    //We add the last song we heard and remove the older
    public void addSong(Song s) {
        if (history.size() == maxSize) {
            history.remove(0);
        }
        history.add(s);
    }
    //To get the history of songs
    public ArrayList<Song> getHistory() {
        return history;
    }
    //Show the history of songs you heard
    public void ShowHistory() {
        System.out.println("History of reproductions: ");

        for (Song s : history) {
            System.out.println("- " + s.getTitle());
        }
    }
}
