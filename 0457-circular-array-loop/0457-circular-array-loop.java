// class Solution {
//     public static int calcNextIdx(int[] nums, int curr) {
//         int next = curr;
//         int seq = nums[curr];

//         if(seq > 0) {
//             next = (next + seq) % nums.length;
//         }
//         else {
//             int mod = seq % nums.length;
//             int forward = nums.length + mod;
//             next = (curr + forward) % nums.length;
//         }
//         return next;
//     }

//     public boolean circularArrayLoop(int[] nums) {
//         for(int i = 0; i< nums.length; i++) {
//             //check visited index and store
//             Set<Integer> set = new HashSet<>();
//             set.add(i);

//             //flag is positive 
//             boolean isPos = nums[i] > 0;//return true if positive

//             int curr = i;
//             int next = curr; // <<=== FIXED: declared here

//             //detect cycle
//             while(true) {
//                 next = calcNextIdx(nums, curr);//external function 

//                 if(isPos) {
//                     if(nums[next] < 0) {
//                         break;
//                     }
//                     else {
//                         if(set.contains(next)) {
//                             //cycle is there 
//                             //but check for k > 1
//                             if(curr != next) {// if curr != next means k > 1
//                                 return true;
//                             }else {
//                                 break;
//                             }
//                         }
//                     }
//                     set.add(next);
//                 }
//                 else {
//                     if(nums[next] > 0) {
//                         break;
//                     }
//                     else {
//                         if(set.contains(next)) {
//                             //cycle is there 
//                             //but check for k > 1
//                             if(curr != next) {// if curr != next means k > 1
//                                 return true;
//                             }else {
//                                 break;
//                             }
//                         }
//                     }
//                     set.add(next);
//                 }

//                 curr = next; // keep moving
//             }


//         }
//         return false;
//     }
// }














class Solution {
    public static int calcNextIdx(int[] nums, int curr) {
        int next = curr;
        int seq = nums[curr];

        if(nums[i] == 0) {
            continue;
        }

        if(seq > 0) {
            next = (next + seq) % nums.length;
        }
        else {
            int mod = seq % nums.length;
            int forward = nums.length + mod;
            next = (curr + forward) % nums.length;
        }
        return next;
    }

    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i< nums.length; i++) {
            //check visited index and store
            Set<Integer> set = new HashSet<>();
            set.add(i);

            //flag is positive 
            boolean isPos = nums[i] > 0;//return true if positive

            int curr = i;
            int next = curr; // <<=== FIXED: declared here

            //detect cycle
            while(true) {
                next = calcNextIdx(nums, curr);//external function 

                if(isPos) {
                    if(nums[next] < 0) {
                        break;
                    }
                    else {
                        if(set.contains(next)) {
                            //cycle is there 
                            //but check for k > 1
                            if(curr != next) {// if curr != next means k > 1
                                return true;
                            }else {
                                break;
                            }
                        }
                    }
                    set.add(next);
                }
                else {
                    if(nums[next] > 0) {
                        break;
                    }
                    else {
                        if(set.contains(next)) {
                            //cycle is there 
                            //but check for k > 1
                            if(curr != next) {// if curr != next means k > 1
                                return true;
                            }else {
                                break;
                            }
                        }
                    }
                    set.add(next);
                }

                curr = next; // keep moving
            }

            curr = i;
            if(isPos) {
                while(nums[curr] > 0) {
                    next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            }else {
                while(nums[curr] < 0) {
                    next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            }
        }
        return false;
    }
}
