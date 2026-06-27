class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put((long)i,map.getOrDefault((long)i,0)+1);
        }
        int ans=1;

        for (long x : map.keySet()) {
        
            if(x==1){
                continue;

            }

            long curr=x;
            int len=0;
            while(map.getOrDefault(curr,0)>=2 && map.containsKey(curr*curr)){
                len+=2;
                curr=curr*curr;
            }
            len+=1;
            ans=Math.max(ans,len);

        }

        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }
        
        return ans;


    }
}