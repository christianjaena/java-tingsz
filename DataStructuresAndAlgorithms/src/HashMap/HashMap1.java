
package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HashMap1 {
    public static void main(String[] args) {
        Map<String, String> pb = new HashMap<>();
        pb.put("Christian", "18");
        pb.put("Harden", "13");
        pb.put("Westbrook", "0");
        
//        System.out.println(pb.get("Christian"));
//        Set<String> keys = pb.keySet();
//        for (String i : keys) System.out.println(i + " : " + pb.get(i));
        Set<Map.Entry<String, String>> values = pb.entrySet();
        for (Map.Entry<String, String> e : values) {
            System.out.println(e.getKey() + " : " + e.getValue());
            e.setValue("III");
        }
    }
}
