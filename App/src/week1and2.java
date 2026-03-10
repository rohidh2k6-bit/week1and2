import java.util.*;

public class week1and2 {

    static class DNSEntry {
        String ip;
        long expiryTime;

        DNSEntry(String ip, int ttl) {
            this.ip = ip;
            this.expiryTime = System.currentTimeMillis() + (ttl * 1000);
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    static HashMap<String, DNSEntry> cache = new HashMap<>();
    static int hits = 0;
    static int misses = 0;

    public static String resolve(String domain) {

        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);

            if (!entry.isExpired()) {
                hits++;
                return "Cache HIT → " + entry.ip;
            }
        }

        misses++;
        String newIP = "172.217.14." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(newIP, 5));

        return "Cache MISS → New IP: " + newIP;
    }

    public static void getStats() {
        int total = hits + misses;
        double hitRate = total == 0 ? 0 : (hits * 100.0 / total);

        System.out.println("Hits: " + hits);
        System.out.println("Misses: " + misses);
        System.out.println("Hit Rate: " + hitRate + "%");
    }

    public static void main(String[] args) {

        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
        System.out.println(resolve("facebook.com"));

        getStats();
    }
}