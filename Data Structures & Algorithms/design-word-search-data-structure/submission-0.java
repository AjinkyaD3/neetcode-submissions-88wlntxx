class WordDictionary {

    class TrieNode {
        boolean isComplete;
        TrieNode[] children;

        TrieNode() {
            isComplete = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }

            node = node.children[c - 'a'];
        }

        node.isComplete = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isComplete;
        }

        char c = word.charAt(index);

   
        if (c == '.') {

            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        return dfs(word, index + 1, node.children[c - 'a']);
    }
}