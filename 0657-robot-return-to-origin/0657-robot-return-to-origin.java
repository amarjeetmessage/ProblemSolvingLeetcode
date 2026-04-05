class Solution {
    public boolean judgeCircle(String moves) {
        int countU = 0;
        int countD = 0;
        int countL = 0;
        int countR = 0;
        for(int i = 0; i<moves.length(); i++) {
            if(moves.charAt(i) == 'U') {
                countU++;
            }
            if(moves.charAt(i) == 'D') {
                countD++;
            }
            if(moves.charAt(i) == 'L') {
                countL++;
            }
            if(moves.charAt(i) == 'R') {
                countR++;
            }

            
        }
        if(countU == countD && countL == countR) {
                return true;
            }else return false;
        
    }
}