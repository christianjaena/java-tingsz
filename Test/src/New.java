import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class New{
    int test;
    int friends;
    int deleteFriends;
    LinkedList<Integer> friendList = new LinkedList<Integer>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public New() throws Exception {
        test = Integer.parseInt(br.readLine());
    }
    
    private void displayFriends() {
        while (!friendList.isEmpty()) {
            System.out.print(friendList.removeFirst()+" ");
        }
        System.out.println();
    }
    
    private void removeFriends(String[] input) {
        for (int i = 0; i < friends; i++) {
            int popularity = Integer.parseInt(input[i]);
            while(!friendList.isEmpty() && deleteFriends!=0 && friendList.getLast() < popularity) {
                friendList.removeLast();
                deleteFriends--;         
            }
            friendList.addLast(popularity);
        }
    }
    
    private void getFriends() throws IOException {
        String input = br.readLine();
        friends = Integer.parseInt(input.split(" ")[0]);
        deleteFriends = Integer.parseInt(input.split(" ")[1]);
    }
    
    private String[] getPopularity() throws IOException {
        return br.readLine().split(" ");
    }
    
    public void start() throws IOException {
        while(test --> 0) {
            getFriends();
            removeFriends(getPopularity());
            displayFriends();		
        }
    }
        
    public static void main(String[] args) throws Exception {
	New exe = new New(); 
	exe.start();
    }
}
