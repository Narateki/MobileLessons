import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> keyReactions = new ArrayList<>();
        ArrayList<HashSet<Integer>> valReactions =new ArrayList<>();
        String[] strElements = sc.nextLine().split(" ");
        HashSet<Integer> elements = new HashSet<>();
        for (String str: strElements) {
            elements.add(Integer.parseInt(str));
        }
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split("->");
            String[] left = str[0].split("\\+");
            String[] right = str[1].split("\\+");
            ArrayList<Integer> key = new ArrayList<>();
            for(String s: left) {
                key.add(Integer.parseInt(s));
            }
            HashSet<Integer> value = new HashSet<>();
            for(String s: right) {
                value.add(Integer.parseInt(s));
            }
            keyReactions.add(key);
            valReactions.add(value);
        }


        int oldSize = elements.size();
        int newSize = -1;
        while (oldSize != newSize) {
            for (int i = 0; i < keyReactions.size(); i++) {

                boolean haveNeeded = true;
                for (Integer elem: keyReactions.get(i))
                    if (!elements.contains(elem)) {
                        haveNeeded = false;
                    }
                if (haveNeeded) {
                    HashSet<Integer> values = valReactions.get(i);
                    elements.addAll(values);
                }
            }
            oldSize = newSize;
            newSize = elements.size();
        }
        for (Integer elem: elements) {
            System.out.printf("%d ", elem);
        }

    }
}
