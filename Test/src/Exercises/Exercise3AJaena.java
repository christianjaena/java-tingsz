import java.io.BufferedReader;
import java.io.InputStreamReader;
public class MonkTakesAWalk {
    public static void main(String[] args) throws Exception {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i ++) {
            String chars = br.readLine();
            char[] charArray = chars.toLowerCase().toCharArray();
            int count = 0;
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == 'a' || charArray[j] == 'e' || charArray[j] == 'i' || charArray[j] == 'o' || charArray[j] == 'u') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}