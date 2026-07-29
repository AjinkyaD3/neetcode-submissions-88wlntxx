class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        int len = beginWord.length();

        // Map of intermediate pattern -> list of words
        Map<String, List<String>> allComboDict = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                allComboDict.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < len; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                List<String> neighbors = allComboDict.getOrDefault(pattern, new ArrayList<>());

                for (String adjacent : neighbors) {
                    if (adjacent.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.contains(adjacent)) {
                        visited.add(adjacent);
                        queue.offer(new Pair<>(adjacent, level + 1));
                    }
                }

                // Optional optimization
                allComboDict.put(pattern, new ArrayList<>());
            }
        }

        return 0;
    }
}