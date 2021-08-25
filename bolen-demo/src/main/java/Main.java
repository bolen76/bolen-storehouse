public class Main {
    
    public static void main(String[] args) {
        ListNode listNode = buildListNode(new Integer[] {1, 2, 3, 4, 5});
        
        Solution solution = new Solution();
        ListNode listNode1 = solution.deleteK(5, listNode);
        
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
        
    }
    
    private static ListNode buildListNode(Integer[] integers) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for (int i = 0; i < integers.length; i++) {
            listNode.next = new ListNode(integers[i]);
            listNode = listNode.next;
        }
        return head.next;
    }
    
    public static TreeNode createBT(Integer[] arr, int i) // 初始时,传入的i==0
    {
        
        if (i >= arr.length) // i >= arr.length 时,表示已经到达了根节点
        {
            return null;
        }
        TreeNode root = null; // 定义根节点
        if (arr[i] == null) {
            return null;
        } else {
            root = new TreeNode(arr[i]);
        }
        root.left = createBT(arr, 2 * i + 1); // 递归建立左孩子结点
        root.right = createBT(arr, 2 * i + 2); // 递归建立右孩子结点
        
        return root;
    }
}


class Solution {
    
    public ListNode deleteK(int k, ListNode head) {
        if (k <= 0) {
            return head;
        }
        ListNode front = new ListNode(-1);
        front.next = head;
        while (k > 0 && front.next != null) {
            
            front = front.next;
            k--;
        }
        if (k > 0) {
            return head;
        }
        
        ListNode behind = new ListNode(-1);
        behind.next = head;
        ListNode stub = behind;

        while (front.next != null) {
            front = front.next;
            behind = behind.next;
        }
        
        ListNode temp = behind.next;
        behind.next = behind.next.next;
        temp.next = null;
        
        return stub.next;
    }
}

class ListNode {
    
    int val;
    
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
    
    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

class TreeNode {
    
    int val;
    
    TreeNode left;
    
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
