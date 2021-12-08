/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int max = 0;
        int last = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
                System.out.println(s.charAt(i));
                hm.put(s.charAt(i),i);
                last++;
            
            }
            else{
                //count = -1;
                int t = hm.get(s.charAt(i));
                
                
                hm.put(s.charAt(i),i);
                max = Math.max(max,i-t);
                max = Math.max(last, max);
                last = 1;
                
                System.out.println(s.charAt(i));
                System.out.println("t: " + t);
                System.out.println("i: "+ i);
                System.out.println("max: "+ max);
                //count = 1;
            }
        }
        
        //return Math.max(max,count);
        max = Math.max(last, max);
        return max;
    }
}*/

class 3Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int left = 0;
        int right = 0;
        int max = 0;
        
        while(right < s.length()){
            /*if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }*/
            
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max = Math.max(set.size(), max);
                
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}