import java.util.*;

public class Problem7_Autocomplete {

    static HashMap<String,Integer> queries = new HashMap<>();

    public static void addQuery(String q){
        queries.put(q, queries.getOrDefault(q,0)+1);
    }

    public static void search(String prefix){

        for(String q: queries.keySet()){
            if(q.startsWith(prefix)){
                System.out.println(q + " (" + queries.get(q) + ")");
            }
        }
    }

    public static void main(String[] args){

        addQuery("java tutorial");
        addQuery("javascript guide");
        addQuery("java download");

        search("jav");
    }
}