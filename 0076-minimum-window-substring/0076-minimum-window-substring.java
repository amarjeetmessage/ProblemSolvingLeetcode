class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m>n) return "";

        int fre[] = new int[123];
        for(char ch : t.toCharArray()){
            fre[ch]++;
        }

        int left=0,right=0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int start = left;
        for(right=0 ; right<n ; right++){
            char ch = s.charAt(right);

            if(fre[ch]>0) count++;
                
            fre[ch]--;

            while(count == m){
                if(min>right-left+1){
                    min = right-left+1;
                    start = left;
                }
                fre[s.charAt(left)]++;
                if(fre[s.charAt(left)]>0) count--;
                left++;
            }
        }
        return min==Integer.MAX_VALUE ? "" : s.substring(start,start+min);
    }
}