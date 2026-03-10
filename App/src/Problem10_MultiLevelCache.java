import java.util.*;

public class Problem10_MultiLevelCache {

    static HashMap<String,String> L1 = new HashMap<>();
    static HashMap<String,String> L2 = new HashMap<>();

    public static void addVideo(String id,String data){
        L2.put(id,data);
    }

    public static void getVideo(String id){

        if(L1.containsKey(id)){
            System.out.println("L1 Cache HIT");
        }
        else if(L2.containsKey(id)){
            System.out.println("L2 Cache HIT -> Promoted to L1");
            L1.put(id,L2.get(id));
        }
        else{
            System.out.println("Video not found in cache");
        }
    }

    public static void main(String[] args){

        addVideo("video123","MovieData");

        getVideo("video123");
        getVideo("video123");
    }
}