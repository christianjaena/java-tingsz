
package hashfunction;


public class HashFunction {
    
    String[] array;
    int arraySize;
    
    HashFunction(int size) {
        arraySize = size;
        array = new String[size];
        java.util.Arrays.fill(array, "-1");
    }
    
    public void hashFunction1(String[] stringArray, String[] array) {
        for (String stringValue : stringArray) {
            array[Integer.parseInt(stringValue)] = stringValue;
        }
    }
    
    public void hashFunction2(String[] stringArray, String[] array) {
        for (String stringValue : stringArray) {
            int index = Integer.parseInt(stringValue) % 29;
            while (!"-1".equals(array[index])) {
                ++index;
                index %= arraySize;
            }
            array[index] = stringValue;
        }
    }
    
    public String find(String key) {
        int hashIndex = Integer.parseInt(key) % 29;
        while (!"-1".equals(array[hashIndex])) {
            if (array[hashIndex].equals(key)) {
                return "Found at " + hashIndex + " Value: " + array[hashIndex];
            }
            ++hashIndex;
            hashIndex %= arraySize;
        }
        return null;
    }
    
    public void displayTable() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + "->" + array[i]);
        }
    }
  
    public static void main(String[] args) {
//       HashFunction h = new HashFunction(10);
//       String[] stringArray = {"1", "3", "4", "6", "7", "9"};
       HashFunction h = new HashFunction(30);
       String[] stringArray = {"100", "510", "170", "214", "268", "398", "235", "802", "900",
       "723", "699", "1", "16", "999", "890", "725", "998", "978", "988", "990", "989", "984", "320", "321",
       "400", "415", "450", "50", "660", "624"};
       h.hashFunction2(stringArray, h.array);
        System.out.println(h.find("660"));
       h.displayTable();

    }

}
