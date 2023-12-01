package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/
class SearchSuggestionSystem {
    TrieSearch root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();

        //1. construct fill up the trie
        root = createFillTrieTree(products);

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            List<String> outputForPrefix = new ArrayList<>();
            prefix = prefix + c;
            outputForPrefix = searchString(prefix);
            result.add(outputForPrefix);
        }

        return result;

    }

    private TrieSearch createFillTrieTree(String[] products) {

        TrieSearch trieSearchNode = new TrieSearch();
        for (String product : products) {

            insertIntoTrie(product, trieSearchNode);
        }

        return trieSearchNode;
    }

    private void insertIntoTrie(String product, TrieSearch trieSearchNode) {

        for (int i = 0; i < product.length(); i++) {

            char c = product.charAt(i);


            int nodeIndex = c - 'a';
            TrieSearch searchNode;
            if (trieSearchNode.nodes[nodeIndex] == null) {
                searchNode = new TrieSearch();
                trieSearchNode.nodes[nodeIndex] = searchNode;
            }

            searchNode = trieSearchNode.nodes[nodeIndex];
            if (i == product.length() - 1) {
                searchNode.word = product;
            }

            trieSearchNode = searchNode;
        }
    }

    private List<String> searchString(String prefix) {

        TrieSearch searchStartNode = root;
        List<String> result = new ArrayList<>();

        for (char c : prefix.toCharArray()) {

            if (searchStartNode.nodes[c - 'a'] == null) {
                return result;
            }
            searchStartNode = searchStartNode.nodes[c - 'a'];
        }

        dfs(searchStartNode, result);
        return result;

    }

    private void dfs(TrieSearch rootNode, List<String> outputForPrefix) {

        if (outputForPrefix.size() == 3) {
            return;
        }
        if (rootNode.word != null) {
            outputForPrefix.add(rootNode.word);
        }

        for (int i = 0; i < 26; i++) {

            if (rootNode.nodes[i] != null) {
                dfs(rootNode.nodes[i], outputForPrefix);
            }
        }
    }

    class TrieSearch {

        String word;
        TrieSearch[] nodes = new TrieSearch[26];
    }
}


