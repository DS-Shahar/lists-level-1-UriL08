import java.util.Random;
import java.util.Scanner;

class IntNode {
    private int value;
    private IntNode next;
    
    public IntNode(int value) {
        this.value = value;
        this.next = null;
    }
    
    public IntNode(int value, IntNode next) {
        this.value = value;
        this.next = next;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public IntNode getNext() {
        return this.next;
    }
    
    public boolean hasNext() {
        return this.next != null;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void setNext(IntNode next) {
        this.next = next;
    }
}

public class NodeExercises {
    //Exercise 2
    public static int exc2(IntNode list1, int num) {
        int sequences = 0;
        boolean inSequence = false;
        
        while (list1 != null) {
            if (list1.getValue() == num) {
                if (!inSequence) {
                    sequences++;
                    inSequence = true;
                }
            } else {
                inSequence = false;
            }
            list1 = list1.getNext();
        }
        return sequences;
    }

    //Exercise 3
    public static void exc3(IntNode list1, int start, int end) {
        int index = 0;
        while (list1 != null) {
            if (index >= start && index <= end) {
                System.out.print(list1.getValue() + " ");
            }
            index++;
            list1 = list1.getNext();
        }
        System.out.println();
    }

    //Exercise 4
    public static char exc4(IntNode list1) {
        int even = 0, odd = 0;
        
        while (list1 != null) {
            if (list1.getValue() % 2 == 0) even++;
            else odd++;
            list1 = list1.getNext();
        }
        
        if (even > odd) {
            return 'z';
        }
        if (odd > even) {
            return 'e';
        }
        return 's';
    }

    //Exercise 5
    public static IntNode exc5(IntNode list1, int num) {
        if (list1 == null) return null;
        
        while (list1 != null && list1.getValue() == num) {
            list1 = list1.getNext();
        }
        
        IntNode current = list1;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getValue() == num) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
        return list1;
    }

    //Exercise 6
    public static IntNode exc6(IntNode list1) {
        if (list1 == null) return null;
        
        IntNode result = new IntNode(list1.getValue());
        IntNode current = result;
        list1 = list1.getNext();
        
        while (list1 != null) {
            boolean exists = false;
            IntNode check = result;
            while (check != null) {
                if (check.getValue() == list1.getValue()) {
                    exists = true;
                    break;
                }
                check = check.getNext();
            }
            if (!exists) {
                current.setNext(new IntNode(list1.getValue()));
                current = current.getNext();
            }
            list1 = list1.getNext();
        }
        return result;
    }

    //Exercise 7
    public static IntNode exc7() {
        IntNode result = null;
        Random rand = new Random();
        
        for (int i = 0; i < 50; i++) {
            int num = rand.nextInt(90) + 10; // generates numbers 10-99
            int digit1 = num / 10;
            int digit2 = num % 10;
            
            if (digit1 != digit2) {
                boolean exists = false;
                IntNode check = result;
                while (check != null) {
                    if (check.getValue() == num) {
                        exists = true;
                        break;
                    }
                    check = check.getNext();
                }
                if (!exists) {
                    result = new IntNode(num, result);
                }
            }
        }
        return result;
    }

    //Exercise 8
    public static boolean exc8(IntNode list1) {
        if (list1 == null || !list1.hasNext()) return true;
        
        while (list1.hasNext()) {
            if (list1.getValue() > list1.getNext().getValue()) return false;
            list1 = list1.getNext();
        }
        return true;
    }

    //Exercise 9
    public static void exc9(IntNode list1) {
        while (list1 != null && list1.hasNext()) {
            if (list1.getValue() > list1.getNext().getValue()) {
                System.out.print(list1.getValue() + " ");
            }
            list1 = list1.getNext();
        }
        System.out.println();
    }

    //Exercise 10
public static IntNode exc10(int beginner, int num) {
    if (num <= 0){
     return null;
    }
    
    IntNode result = new IntNode(beginner);
    IntNode current = result;
    
    for (int i = 1; i < num; i++) {
        current.setNext(new IntNode(beginner + i));
        current = current.getNext();
    }
    
    return result;
}

//Exercise 11
public static IntNode exc11(Scanner scanner) {  
    IntNode result = null;
    
    while (true) {
        int num = scanner.nextInt();
        if (num == -999) {
            break;
        }
        result = new IntNode(num, result);
    }
    
    return result;
}

}