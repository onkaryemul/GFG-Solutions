class Solution {
    
    // TC : O(n)
    // SC : O(26+26) ~ O(1)
    
    public ArrayList<Integer> asciirange(String s) {
        // code here
        ArrayList<Integer> asciiRangeSum = new ArrayList<Integer>();
        
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];
        
        Arrays.fill(firstOccurrence, -1);
        Arrays.fill(lastOccurrence, -1);
        
        int n = s.length();
        
        for(int i=0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            
            if(firstOccurrence[idx] == -1) {
                firstOccurrence[idx] = i;
            }
            
            lastOccurrence[idx] = i;
        }
        
        for(int i=0; i < 26; i++) {
            if(firstOccurrence[i] != -1 && firstOccurrence[i] < lastOccurrence[i]) {
                int sum = 0;
                for(int j=firstOccurrence[i]+1; j < lastOccurrence[i]; j++) {
                    sum += s.charAt(j);
                }
                if(sum > 0) {
                    asciiRangeSum.add(sum);
                }
            }
        }
        
        return asciiRangeSum;
    }
    
}
