//{ Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}


// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
          StringBuilder sb = new StringBuilder();
          
          int len = str.length();
          int count = 0;
          
          for(int i=0; i<len; i++) {
              count = 1;
              
              while(i<len-1 && str.charAt(i) == str.charAt(i+1)) {
                  count++;
                  i++;
              }
              
              sb.append(str.charAt(i));
              sb.append(count);
          }
          
          return sb.toString();
	}
	
 }