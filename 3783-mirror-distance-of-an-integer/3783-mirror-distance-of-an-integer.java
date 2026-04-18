class Solution {
    public int mirrorDistance(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        int num = Integer.valueOf(sb.toString());
        int result = Math.abs(n - num);

        return result;
    }
}