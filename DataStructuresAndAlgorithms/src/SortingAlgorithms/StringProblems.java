package SortingAlgorithms;





public class StringProblems {
    
    public void printFirstWord(String string) {
        String word = string;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ' && (i == 0 || charArray[i - 1] == ' ')) {
                System.out.println(charArray[i]);
            }
        }
    }
    
    public void trimString(String string) {
        String word = string;
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        int count;
        
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                start = i;
                break;
            }
        }
        
        for (int i = charArray.length - 1; i > start - 1; i--) {
            if (charArray[i] != ' ') {
                end = i;
                break;
            }
        }
        
        count = end - start + 1;
        //String result = new String(word, start, count);
        //System.out.println(result);
        
    }
    
    public static void main(String[] args) {
        StringProblems s = new StringProblems();
        s.printFirstWord("Hello World");
    }
    
}
