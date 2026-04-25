// /* The isBadVersion APi is defined in the parent class VersionControl.
//       boolean isBadVersion(int version); */

// public class Solution extends VersionControl {
//     public int firstBadVersion(int n) {
//         int i = 1;
//         int j = n;
//         int ans = -1;
//         while(i<=j){
//             int mid = i+(j-i)/2;//in this question make sure to use this otherwise (i+j)/2 will overflow due to large number

//             if(isBadVersion(mid) == true){
//                 ans = mid;
//                 j = mid -1;
//             }
//             else{
//                 i = mid+1;
//             }
//         }
//         return ans;
//     }
// }




//TYPE 2 METHOD
/* The isBadVersion APi is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left)/2;//in this question make sure to use this otherwise (i+j)/2 will overflow due to large number

            if(isBadVersion(mid) == true){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}