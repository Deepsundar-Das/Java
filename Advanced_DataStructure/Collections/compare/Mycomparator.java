package Collections.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Mycomparator {

    public static void main(String[] arr) {
        // Comparator com = new Comparator<String>() {
        //     public int compare(String s1, String s2) {
        //         if (s1.length() >= s2.length()) return 1;
        //         else return -1;
        //     }
        // };

        List<String> list = new ArrayList<>();
        list.add("deep");
        list.add("bud");
        list.add("dipan");
        Collections.sort(list, (s1, s2) -> s1.length() >= s2.length() ? 1 : -1);
        // {
        //     // if (s1.length() >= s2.length()) return 1;
        //     // else return -1;

        //     // we can use tarnary operator

        // });
        System.out.println(list);
    }
}
