public class TwoStacks {
    private int[] array;
    private int top1;
    private int top2;
    private int size;

    public TwoStacks(int capacity) {
        array = new int[capacity];
        size = capacity;
        top1 = -1;
        top2 = size;
    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            array[++top1] = x;
        } else {
            System.out.println("Stack 1 overflow");
        }
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            array[--top2] = x;
        } else {
            System.out.println("Stack 2 overflow");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            return array[top1--];
        } else {
            System.out.println("Stack 1 underflow");
            return -1;
        }
    }

    public int pop2() {
        if (top2 < size) {
            return array[top2++];
        } else {
            System.out.println("Stack 2 underflow");
            return -1;
        }
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(6);
        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push1(3);
        twoStacks.push2(4);
        twoStacks.push2(5);
        twoStacks.push2(6);

        System.out.println("Popped from stack 1: " + twoStacks.pop1());
        System.out.println("Popped from stack 2: " + twoStacks.pop2());
        System.out.println("Popped from stack 1: " + twoStacks.pop1());
        System.out.println("Popped from stack 2: " + twoStacks.pop2());
        System.out.println("Popped from stack 1: " + twoStacks.pop1());
        System.out.println("Popped from stack 2: " + twoStacks.pop2());
    }
}
