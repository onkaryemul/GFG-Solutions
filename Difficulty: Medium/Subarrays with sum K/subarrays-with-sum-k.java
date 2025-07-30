class Solution {
    
    // TC : O(n)
    // SC : O(n)

    // function to count the number of subarrays whose sum exactly equal to given number k    
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        int cnt = 0;
        
        // key: prefix sum till curr index
        // value: count of this prefix sum
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        
        int prefixSum = 0;
        
        for(int i=0; i < n; i++) {
            prefixSum += arr[i]; // prefix sum till curr index i
            
            int remove = prefixSum - k; 
            
            // appyling reverse engineering principle
            // need to find how many subarrays whose sum (prefixSum - k) have occurred previously to get no. of subarrays ending at curr index i and having sum is equal to k
            
            if(map.containsKey(remove)) {
                cnt += map.get(remove);
            }
            
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return cnt;
    }
    
}
