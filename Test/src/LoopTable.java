

public class LoopTable {
    
    public void exampleProblem() {
        System.out.println("Example Problem:");
        String countValue = "Count Value: ";
        String sequence = "Sequence: ";
        for (int i = 1; i <= 6; i++) {
            int count = i;
            countValue +=  count + " ";
            // 2 * count;
            sequence +=  2 * count + " ";    
        }
        System.out.println(countValue);
        System.out.println(sequence);
        System.out.println();
    }
    
    public void problem1() {
        System.out.println("Problem #1:");
        String countValue = "Count Value: ";
        String sequence = "Sequence: ";
        for (int i = 1; i <= 6; i++) {
            int count = i;
            countValue +=  count + " ";
            sequence += 15 * count - 11 + " ";
        }
        System.out.println(countValue);
        System.out.println(sequence);
        System.out.println();
    }
    
    public void problem2() {
        System.out.println("Problem #2:");
        String countValue = "Count Value: ";
        String sequence = "Sequence: ";
        for (int i = 1; i <= 6; i++) {
            int count = i;
            countValue +=  count + " ";
            sequence += -10 * count + 40 + " ";
        }
        System.out.println(countValue);
        System.out.println(sequence);
        System.out.println();
    }
    
    public void problem3() {
        System.out.println("Problem #3:");
        String countValue = "Count Value: ";
        String sequence = "Sequence: ";
        for (int i = 1; i <= 6; i++) {
            int count = i;
            countValue +=  count + " ";
            sequence += 4 * count - 11 + " ";
        }
        System.out.println(countValue);
        System.out.println(sequence);
        System.out.println();
    }
    
    public void problem4() {
        System.out.println("Problem #4:");
        String countValue = "Count Value: ";
        String sequence = "Sequence: ";
        for (int i = 1; i <= 6; i++) {
            int count = i;
            countValue +=  count + " ";
            sequence += -3 * count + 100 + " ";
        }
        System.out.println(countValue);
        System.out.println(sequence);
        System.out.println();
    }
    
    public static void main(String[] args) {
        LoopTable lt = new LoopTable();
        lt.exampleProblem(); 
        lt.problem1();
        lt.problem2();
        lt.problem3();
        lt.problem4();
        
    }
}
