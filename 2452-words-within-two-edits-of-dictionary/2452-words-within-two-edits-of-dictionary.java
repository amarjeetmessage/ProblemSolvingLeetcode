// class Solution {
//     public List<String> twoEditWords(String[] queries, String[] dictionary) {
//         int n = queries.length;
//         int m = dictionary.length;
//         int wLen = queries[0].length();
//         String[] ans = new String[n];

//         int count;
//         for(int i = 0; i<n; i++){
//             count = 0;
//             for(int j = 0; j<wLen; j++){
//                 if(queries[i].charAt(j) != dictionary[i].charAt(j)){
//                     count++;
//                 }
//             }
//             if(count <= 2){
//                 ans[i] = queries[i];
//             }
//         }
//         return Arrays.asList(ans);
//     }
// }

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        int m = dictionary.length;
        int wLen = queries[0].length();

        List<String> ans = new ArrayList<>(); // ✅ changed from array

        for(int i = 0; i < n; i++) {

            for(int k = 0; k < m; k++) { // ✅ loop over dictionary
                int count = 0;           // ✅ reset per comparison

                for(int j = 0; j < wLen; j++) {
                    if(queries[i].charAt(j) != dictionary[k].charAt(j)) {
                        count++;
                        if(count > 2) break; // ✅ early break
                    }
                }

                if(count <= 2) {
                    ans.add(queries[i]); // ✅ add instead of storing in array
                    break;               // ✅ no need to check more dictionary words
                }
            }
        }

        return ans;
    }
}