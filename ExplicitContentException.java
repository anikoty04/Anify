public class ExplicitContentException extends Exception{
    public ExplicitContentException() {
        super("Explicit content blocked by parental control");
    }
}
