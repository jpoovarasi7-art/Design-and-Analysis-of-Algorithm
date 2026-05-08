import java.util.Scanner;
class Item {
    float weight;
    int value;
    int id;
    Item(float weight, int value, int id) {
        this.weight = weight;
        this.value = value;
        this.id = id;
    }
}
class Node {
    int level, profit, bound;
    float weight;
    boolean[] selected;
    Node(int level, int profit, float weight, int n) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
        this.selected = new boolean[n];
    }
}
public class KnapsackBranchAndBound {
    static int bound(Node u, int n, int W, Item[] arr) {
        if (u.weight >= W) return 0;
        int profitBound = u.profit;
        int j = u.level + 1;
        float totalWeight = u.weight;
        while (j < n && totalWeight + arr[j].weight <= W) {
            totalWeight += arr[j].weight;
            profitBound += arr[j].value;
            j++;
        }
        if (j < n)
            profitBound += (int) ((W - totalWeight) * arr[j].value / arr[j].weight);
        return profitBound;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value for item " + (i + 1) + ": ");
            float w = sc.nextFloat();
            int v = sc.nextInt();
            arr[i] = new Item(w, v, i + 1);
        }
        System.out.print("Enter maximum capacity: ");
        int W = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((double)arr[j].value/arr[j].weight < (double)arr[j+1].value/arr[j+1].weight) {
                    Item temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
            }
        }
        Node[] queue = new Node[1000];
        int head = 0, tail = 0;
        Node bestNode = new Node(-1, 0, 0, n);
        queue[tail++] = new Node(-1, 0, 0, n);
        int maxProfit = 0;
        while (head < tail) {
            Node u = queue[head++];
            if (u.level == n - 1) continue;
            int nextLvl = u.level + 1;
            Node v = new Node(nextLvl, u.profit + arr[nextLvl].value, u.weight + arr[nextLvl].weight, n);
            System.arraycopy(u.selected, 0, v.selected, 0, n);
            v.selected[nextLvl] = true;
            if (v.weight <= W) {
                if (v.profit > maxProfit) {
                    maxProfit = v.profit;
                    bestNode = v;
                }
                v.bound = bound(v, n, W, arr);
                if (v.bound > maxProfit) queue[tail++] = v;
            }
            Node v2 = new Node(nextLvl, u.profit, u.weight, n);
            System.arraycopy(u.selected, 0, v2.selected, 0, n);
            v2.bound = bound(v2, n, W, arr);
            if (v2.bound > maxProfit) queue[tail++] = v2;
        }
        System.out.println("\n--- Final Results ---");
        System.out.println("Maximum Profit: " + maxProfit);
        System.out.println("Items Selected:");
        for (int i = 0; i < n; i++) {
            if (bestNode.selected[i]) {
                System.out.println("- Item (Original Index " + arr[i].id + "): Weight " + arr[i].weight + ", Value " + arr[i].value);
            }
        }
        sc.close();
    }
}
