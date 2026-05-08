import java.util.Scanner;
class Node {
    int data;
    int index;
    Node left, right;
    Node(int d, int i, Node l, Node r) {
        this.data = d;
        this.index = i;
        this.left = l;
        this.right = r;
    }
}
public class HuffmanCoding {
    static void getCodes(Node root, String curr, String[] codes, int n) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (curr.equals("")) curr = "0";
            codes[root.index] = curr;
            return;
        }
        getCodes(root.left, curr + "0", codes, n);
        getCodes(root.right, curr + "1", codes, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter characters (e.g., abcdef): ");
        String s = sc.next();
        int n = s.length();
        System.out.println("Enter frequencies for each character:");
        int[] freq = new int[n];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            System.out.print(s.charAt(i) + ": ");
            freq[i] = sc.nextInt();
            nodes[i] = new Node(freq[i], i, null, null);
        }
        int activeNodes = n;
        while (activeNodes > 1) {
            for (int i = 0; i < activeNodes - 1; i++) {
                for (int j = 0; j < activeNodes - i - 1; j++) {
                    if (nodes[j].data > nodes[j + 1].data ||
                       (nodes[j].data == nodes[j + 1].data && nodes[j].index > nodes[j + 1].index)) {
                        Node temp = nodes[j];
                        nodes[j] = nodes[j + 1];
                        nodes[j + 1] = temp;
                    }
                }
            }
            Node left = nodes[0];
            Node right = nodes[1];
            Node internal = new Node(
                left.data + right.data,
                Math.min(left.index, right.index),
                left,
                right
            );
            nodes[0] = internal;
            for (int i = 1; i < activeNodes - 1; i++) {
                nodes[i] = nodes[i + 1];
            }
            activeNodes--;
        }
        String[] resultCodes = new String[n];
        getCodes(nodes[0], "", resultCodes, n);
        System.out.println("\nHuffman Table:");
        for (int i = 0; i < n; i++) {
            System.out.println(s.charAt(i) + ": " + resultCodes[i]);
        }
        System.out.print("\nEnter string to encode: ");
        String inputStr = sc.next();
        StringBuilder encodedString = new StringBuilder();
        for (char c : inputStr.toCharArray()) {
            int charIndex = s.indexOf(c);
            if (charIndex != -1) {
                encodedString.append(resultCodes[charIndex]);
            } else {
                System.out.println("Warning: Character '" + c + "' skipped (not in initial set).");
            }
        }
        System.out.println("Final Encoded String: " + encodedString.toString());
        sc.close();
    }
}
