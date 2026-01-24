public class NotLoggedException extends Exception{
    public NotLoggedException() {
        super("User is not logged in");
    }
}
