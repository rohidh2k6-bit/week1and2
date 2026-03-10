import java.util.*;

public class week1and2 {

    static HashMap<String, Integer> stock = new HashMap<>();
    static LinkedList<Integer> waitingList = new LinkedList<>();

    public static int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public static String purchaseItem(String productId, int userId) {

        int currentStock = stock.getOrDefault(productId, 0);

        if(currentStock > 0){
            stock.put(productId, currentStock - 1);
            return "Success, " + (currentStock - 1) + " units remaining";
        }
        else{
            waitingList.add(userId);
            return "Added to waiting list, position #" + waitingList.size();
        }
    }

    public static void main(String[] args) {

        stock.put("IPHONE15_256GB", 5);

        System.out.println("Stock: " + checkStock("IPHONE15_256GB"));

        System.out.println(purchaseItem("IPHONE15_256GB",12345));
        System.out.println(purchaseItem("IPHONE15_256GB",67890));
        System.out.println(purchaseItem("IPHONE15_256GB",11111));
        System.out.println(purchaseItem("IPHONE15_256GB",22222));
        System.out.println(purchaseItem("IPHONE15_256GB",33333));
        System.out.println(purchaseItem("IPHONE15_256GB",44444));
    }
}