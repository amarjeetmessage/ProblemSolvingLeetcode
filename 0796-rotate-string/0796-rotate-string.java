class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String sb=s+s;
        if(sb.contains(goal)){
            return true;
        }
        else{
            return false;
        }
        
    }
}