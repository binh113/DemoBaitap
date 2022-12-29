import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Smith", 30);
        treeMap.put("Anderson", 31);
        treeMap.put("Lewis", 29);
        treeMap.put("Cook", 29);
        System.out.println("display entries in ascending order of key");
        System.out.println(treeMap);
        Map<String, Integer> LinkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        LinkedHashMap.put("Smith", 30);
        LinkedHashMap.put("Anderson", 31);
        LinkedHashMap.put("Lewis", 29);
        LinkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + LinkedHashMap.get("Lewis"));
    }
}

