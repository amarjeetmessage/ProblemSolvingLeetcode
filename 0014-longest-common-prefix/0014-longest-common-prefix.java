class Solution {
    public String longestCommonPrefix(String[] strs) {
        //sort array string lexicographically 
        Arrays.sort(strs);

        //now loop through the arr and check if index 0 and last index are matching means same matching for all 

        StringBuilder ans = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length-1];

        for(int i = 0; i<first.length(); i++) {//
            if(i < last.length() && first.charAt(i) == last.charAt(i)) {
                ans.append(first.charAt(i));
            }else{
                break;
            }
        }
        return ans.toString();


    }
}