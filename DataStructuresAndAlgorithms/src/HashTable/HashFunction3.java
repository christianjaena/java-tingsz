
package HashTable;

import java.util.Scanner;


public class HashFunction3 {
     WordList[] theArray;
     int arraySize;
     String[][] elementsToAdd = {/* insert words */};
     public int stringHashFunction(String wordToHash) {
         int hashKeyValue = 0;
         for (int i = 0; i < wordToHash.length(); i++) {
             int charCode = wordToHash.charAt(i) - 96;
             int hKVTemp = hashKeyValue;
             hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;
             System.out.println("Hash Key Value " + hKVTemp +
                     " * 27 + Character Code " + charCode +
                     " % arraySize " + arraySize + " = " + hashKeyValue);
         }
         System.out.println();
         return hashKeyValue;
     }
     
     HashFunction3(int size) {
         arraySize = size;
         theArray = new WordList[size];
         for (int i = 0; i < arraySize; i++) {
             theArray[i] = new WordList();
         }
         addTheArray(elementsToAdd);
     }
     
     public void insert(Word newWord) {
         String wordToHash = newWord.theWord;
         int hashKey = stringHashFunction(wordToHash);
         theArray[hashKey].insert(newWord, hashKey);
     }
     
     public Word find(String wordToFind) {
         int hashKey = stringHashFunction(wordToFind);
         Word theWord = theArray[hashKey].find(hashKey, wordToFind);
         return theWord;
     }
     
     public void addTheArray(String[][] elementsToAdd) {
         for (int i = 0; i < elementsToAdd.length; i++) {
             String word = elementsToAdd[i][0];
             String definition = elementsToAdd[i][1];
             Word newWord = new Word(word, definition);
             insert(newWord);
         }
     }
     
     public void displayTheArray() {
         for (int i = 0; i < arraySize; i++) {
             System.out.println("theArray Index " + i);
             theArray[i].displayWordList();
         }
     }
}

class Word {
    public String theWord;
    public String definition;
    public int key;
    public Word next;
    public Word(String theWord, String definition) {
        this.theWord = theWord;
        this.definition = definition;
    }
    
    public String toString() {
        return theWord + " : " + definition;
    }
}

class WordList {
    public Word firstWord = null;
    
    public void insert(Word newWord, int hashKey) {
        Word previous = null;
        Word current = firstWord;
        newWord.key = hashKey;
        while (current != null && newWord.key > current.key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) firstWord = newWord;
        else  previous.next = newWord;
        newWord.next = current;
    }
    
    public void displayWordList() {
        Word current = firstWord;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
    
    public Word find(int hashkey, String wordToFind) {
        Word current = firstWord;
        while (current != null && current.key <= hashkey) {
            if (current.theWord.equals(wordToFind)) return current;
            current = current.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashFunction3 wordHashTable = new HashFunction3(11);
        String wordLookUp = "a";
        while (!wordLookUp.equalsIgnoreCase("x")) {
            System.out.println(": ");
            wordLookUp = input.nextLine();
            System.out.println(wordHashTable.find(wordLookUp));
        }
    }
}
