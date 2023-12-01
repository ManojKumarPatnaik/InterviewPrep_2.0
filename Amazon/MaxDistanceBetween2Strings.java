package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class BinaryTrieNode {
    private char ch;
    BinaryTrieNode left;
    BinaryTrieNode right;

    public BinaryTrieNode(char c) {
        ch = c;
    }

    public void set(char ch, BinaryTrieNode node) {
        if (ch == '0') {
            left = node;
        } else if (ch == '1') {
            right = node;
        }
    }

    public BinaryTrieNode get(char ch) {
        if (ch == '0') {
            return left;
        } else if (ch == '1') {
            return right;
        }
        return null;
    }
}

class BinaryTrie {
    private BinaryTrieNode root;
    private int maxDiff;

    public BinaryTrie(List<String> binaries) {
        root = new BinaryTrieNode('\0');
        maxDiff = 0;
        for (String str : binaries) {
            BinaryTrieNode curr = root;

            for (char ch : str.toCharArray()) {
                BinaryTrieNode child = curr.get(ch);

                if (child == null) {
                    child = new BinaryTrieNode(ch);
                    curr.set(ch, child);
                }

                curr = child;
            }
        }
    }

    public int getMaxDiff() {
        getMaxDepth(root);

        return maxDiff;
    }

    private int getMaxDepth(BinaryTrieNode root) {
        if (root == null)
            return 0;
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);

        if (leftDepth > 0 && rightDepth > 0) {
            maxDiff = Math.max(maxDiff, leftDepth + rightDepth);
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

public class MaxDistanceBetween2Strings {

    public static void main(String[] args) {
        List<String> binaries = new ArrayList<>(Arrays.asList("10100", "10111"));

        BinaryTrie trie = new BinaryTrie(binaries);

        System.out.println(trie.getMaxDiff()); // gives 10 (1011100, 1001111) differ by 10.

//        binaries = new ArrayList(Arrays.asList("101", "111", "000"));
//
//        trie = new BinaryTrie(binaries);
//
//        System.out.println(trie.getMaxDiff()); // return 6 (101, 000)
    }
}
