

class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
    }
    TrieNode root = new TrieNode();
    String[] words;

    void update(TrieNode node, int index){
        if (node.idx == -1 ||words[index].length() < words[node.idx].length() ||(words[index].length() == words[node.idx].length() &&index < node.idx)) {

            node.idx = index;
        }
    }

    void insert(String s, int index){
        TrieNode node = root;
        update(node, index);
        for (int i = s.length() - 1; i >= 0; i--){
            int c = s.charAt(i) - 'a';
            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }
            node = node.child[c];

            update(node, index);
        }
    }
        int search(String s) {

        TrieNode node = root;

        for (int i = s.length() - 1; i >= 0; i--) {

            int c = s.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        words = wordsContainer;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;



        
    }
}