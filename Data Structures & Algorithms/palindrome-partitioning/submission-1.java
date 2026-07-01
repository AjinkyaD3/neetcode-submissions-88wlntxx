class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), s, 0);
        return ans;
    }

   private void backtrack(List<List<String>> ans,
                       List<String> current,
                       String s,
                       int index) {

    if (index == s.length()) {
        ans.add(new ArrayList<>(current));
        return;
    }

    for (int end = index; end < s.length(); end++) {
        if (isPalindrome(s, index, end)) {
            current.add(s.substring(index, end + 1));
            backtrack(ans, current, s, end + 1);
            current.remove(current.size() - 1);
        }
    }
}

    private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
}
