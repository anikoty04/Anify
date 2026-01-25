import java.time.Duration;
import java.time.LocalDate;

public class AnifyMain {
    public static void main(String[] args) {
        //Create server

        StreamingServer server = new StreamingServer();

        //Add songs
        Song song1 = new Song("Blinding Lights", "The Weeknd",Duration.ofSeconds(200), false);
        Song song2 = new Song("Bad Guy", "Billie Eilish", Duration.ofSeconds(180), true);
        Song song3 = new Song("Shape of You", "Ed Sheeran", Duration.ofSeconds(210), false);

        server.registerSong(song1);
        server.registerSong(song2);
        server.registerSong(song3);

        //Create users
        UserServer user1 = new UserServer("Ana","1234");
        UserServer user2 = new UserServer("Rafa", "1000");
        UserServer admin = new UserServer("Admin", "admin");

        server.userSign(user1);
        server.userSign(user2);
        server.userSign(admin);

        //Aply licenses
        License lic1 = new License("LIC001");
        lic1.setStart(LocalDate.now());
        lic1.setEnd(LocalDate.now().plusMonths(1));
        server.activateLicenses(lic1);

        //Active parental control
        server.parentalControlActive(true);

        //Log in
        try{
        server.login(user1.getName(),user1.getPassword());
        server.login(user2.getName(),user2.getPassword());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        //Create playlist
        Playlist playlist1 = new Playlist("Favoritas", false);
        playlist1.addSong(song1);
        playlist1.addSong(song1);
        
        StreamingClient client1 = new StreamingClient(user1, server);
        client1.setPlaylist(playlist1);

        //Play songs
        try{
            server.requestSong(user1, song1);
            server.recordViews(song1, song1.getDuration().toSecondsPart());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        //Pause and resume
        client1.pause();
        System.out.println("Player pause");

        client1.resume();
        System.out.println("Resume player");

        //Show history
        System.out.println("History of user: ");
        for (Song s : client1.getHistory()) {
            System.out.println("- " + s.getTitle());
        }
        //Show server stadistics
        server.globalStadistics();

        //Register logs
        server.getLog().showLogs();
    }
}