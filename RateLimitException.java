public class RateLimitException extends Exception{
    public RateLimitException() {
        super("Usage limit reached");
    }
}
