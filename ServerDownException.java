public class ServerDownException extends Exception{
    public ServerDownException() {
        super("Server is offline");
    }
}
