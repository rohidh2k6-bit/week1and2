import java.util.*;

public class week1and2 {

    static HashMap<String, Set<String>> ngramIndex = new HashMap<>();

    public static List<String> generateNgrams(String text, int n) {
        String[] words = text.split(" ");
        List<String> ngrams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder gram = new StringBuilder();
            for (int j = 0; j < n; j++) {
                gram.append(words[i + j]).append(" ");
            }
            ngrams.add(gram.toString().trim());
        }
        return ngrams;
    }

    public static void indexDocument(String docId, String text) {
        List<String> ngrams = generateNgrams(text, 3);

        for (String gram : ngrams) {
            ngramIndex.putIfAbsent(gram, new HashSet<>());
            ngramIndex.get(gram).add(docId);
        }
    }

    public static void analyzeDocument(String docId, String text) {

        List<String> ngrams = generateNgrams(text, 3);
        HashMap<String, Integer> matchCount = new HashMap<>();

        for (String gram : ngrams) {

            if (ngramIndex.containsKey(gram)) {
                for (String existingDoc : ngramIndex.get(gram)) {

                    if (!existingDoc.equals(docId)) {
                        matchCount.put(existingDoc,
                                matchCount.getOrDefault(existingDoc, 0) + 1);
                    }
                }
            }
        }

        for (String doc : matchCount.keySet()) {
            int matches = matchCount.get(doc);
            double similarity = (matches * 100.0) / ngrams.size();

            System.out.println("Matched with: " + doc);
            System.out.println("Similarity: " + similarity + "%");
        }
    }

    public static void main(String[] args) {

        String doc1 = "java is a programming language used for software development";
        String doc2 = "python is a programming language used for machine learning";
        String newDoc = "java is a programming language used for development";

        indexDocument("doc1", doc1);
        indexDocument("doc2", doc2);

        analyzeDocument("doc3", newDoc);
    }
}