import java.io.BufferedReader;
import java.io.InputStreamReader;
class BreakupApp {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weightFor21 = 0;
        int weightFor19 = 0;
        int numberOfLines = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfLines; i ++) {
            String chat = br.readLine();
            if (chat.startsWith("G")) {
                if (chat.contains("19")) {
                weightFor19 += 2;
                } if (chat.contains("21")) {
                weightFor21 += 2;
                }
            } else if (chat.startsWith("M")) {
                if (chat.contains("19")) {
                weightFor19++;
                } 
                if (chat.contains("21")) {
                weightFor21++;
                }
            }
        }
        if (weightFor19 > weightFor21) {
        System.out.println("Date");
        }
        else {
        System.out.println("No Date"); 
        }
    }
}