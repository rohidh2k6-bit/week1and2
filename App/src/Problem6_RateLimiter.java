import java.util.*;

public class Problem6_RateLimiter {

    static class Client {
        int requests = 0;
        long startTime = System.currentTimeMillis();
    }

    static HashMap<String, Client> clients = new HashMap<>();
    static int LIMIT = 5;

    public static void checkRateLimit(String clientId) {

        Client c = clients.getOrDefault(clientId, new Client());

        if(System.currentTimeMillis() - c.startTime > 3600000){
            c.requests = 0;
            c.startTime = System.currentTimeMillis();
        }

        if(c.requests < LIMIT){
            c.requests++;
            System.out.println("Allowed. Remaining: " + (LIMIT - c.requests));
        } else {
            System.out.println("Denied. Limit reached.");
        }

        clients.put(clientId, c);
    }

    public static void main(String[] args) {

        checkRateLimit("abc123");
        checkRateLimit("abc123");
        checkRateLimit("abc123");
        checkRateLimit("abc123");
        checkRateLimit("abc123");
        checkRateLimit("abc123");
    }
}