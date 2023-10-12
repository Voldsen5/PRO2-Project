package Ex04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ex04 {
    public static void main(String[] args) {
        String path = "L01-Collections/src/Ex04/Gjoengehoevdingen.txt";
        //8730 unikke ord ud af 93555 total antal ord
//        useTreeSet(path);
//        useTreeMap(path);
        useLinkedHashMap(path);

    }

    public static void useTreeSet(String path){
        File in = new File(path);
        String w;
        Set<Word> treeSet = new TreeSet<>();
        int uniqueCounter = 0;
        int wordCounter = 0;
        try(Scanner scanner = new Scanner(in)){
            while(scanner.hasNext()){
                w = scanner.next().toLowerCase().replaceAll("[^a-zåøæ’\\-]","");
                wordCounter++;
                if(!w.equals("") && !w.equals("-")){
                    boolean found = false;
                    for (Word e : treeSet) {
                        if (e.getWord().equals(w)) {
                            found = true;
                            e.addAmount();
                            break;
                        }
                    }
                    if(!found){
                        Word word = new Word(w);
                        treeSet.add(word);
                        uniqueCounter++;
                    }
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("Hej jeg er en fejl");
        }
        System.out.println(treeSet);
        System.out.printf("%d unikke ord ud af %d total antal ord\n", uniqueCounter, wordCounter);
    }

    public static void useTreeMap(String path){
        File in = new File(path);
        String w;
        Map<String, Integer> treeMap = new TreeMap<>();
        int uniqueCounter = 0;
        int wordCounter = 0;
        try(Scanner scanner = new Scanner(in)){
            while(scanner.hasNext()){
                w = scanner.next().toLowerCase().replaceAll("[^a-zæøå’\\-]","");
                wordCounter++;
                if(!w.equals("") && !w.equals("-")){
                    if(treeMap.containsKey(w)){
                        treeMap.replace(w,treeMap.get(w)+1);
                    }else{
                        treeMap.put(w,1);
                        uniqueCounter++;
                    }
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("Hej jeg er en fejl");
        }

        for(String key : treeMap.keySet()){
            if(treeMap.get(key) >= 1000){
                System.out.println(key+": " + treeMap.get(key));
            }
        }
        System.out.printf("%d unikke ord ud af %d total antal ord\n", uniqueCounter, wordCounter);
    }

    public static void useLinkedHashMap(String path){
        File in = new File(path);
        String w;
        Map<Integer, HashSet<String>> linkedHashMap = new LinkedHashMap<>();
        int uniqueCounter = 0;
        int wordCounter = 0;
        try(Scanner scanner = new Scanner(in)){
            while(scanner.hasNext()){
                w = scanner.next().toLowerCase().replaceAll("[^a-zæøå’\\-]","");
                wordCounter++;
                if(!w.equals("") && !w.equals("-")){
                    int wHash = w.hashCode();
                    if(!linkedHashMap.containsKey(wHash)){
                        HashSet<String> hashSet = new HashSet<>();
                        hashSet.add(w);
                        linkedHashMap.put(wHash, hashSet);
                        uniqueCounter++;
                    } else {
                        linkedHashMap.get(wHash).add(w);
                    }
                }
            }
        } catch(FileNotFoundException ex){
            System.out.println("Hej jeg er en fejl");
        }

        for (Integer key : linkedHashMap.keySet()) {
            HashSet<String> value = linkedHashMap.get(key);
            if (value.size() > 1) {
                System.out.println(key + ": " + value);
            }
        }
        System.out.printf("%d unikke ord ud af %d total antal ord\n", uniqueCounter, wordCounter);
    }
}
