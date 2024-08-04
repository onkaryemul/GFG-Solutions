//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Meeting {
    int start;
    int end;
    int pos;
    
    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}


class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        if(m1.end < m2.end) {
            return -1;
        }
        else if(m1.end > m2.end) {
            return 1;
        }
        else if(m1.pos < m2.pos) {
            return -1;
        }
        else {
            return 1;
        }
    }
}



class Solution {
    
    // TC : O(N + N*logN + N) ~ O(N*logN)
    // SC : O(N)
    
    // Function to find the maximum number of meetings that can be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        ArrayList<Meeting> meet = new ArrayList<>();
        
        for(int i=0; i < n; i++) {
            meet.add(new Meeting(start[i], end[i], i+1));
        }
        
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meet, mc);  // sort the meet arraylist according to end time
        
        ArrayList<Integer> meetingOrder = new ArrayList<>(); // stores the order in which the meetings will be performed
        meetingOrder.add(meet.get(0).pos); // adding 1st meeting from sorted meet
        
        int prevEndLimit = meet.get(0).end; // 1st meeting end limit
        
        for(int i=1; i < n; i++) {
            if(meet.get(i).start > prevEndLimit) {
                meetingOrder.add(meet.get(i).pos);
                prevEndLimit = meet.get(i).end;
            }
        }
        
        return meetingOrder.size();
    }
    
}

