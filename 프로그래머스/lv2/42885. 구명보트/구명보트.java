import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        
        // ArrayList<Integer> list = new ArrayList<>();
        int n = people.length;
        
//         for(int i = 0; i < n; i++)list.add(people[i]);
//         list.sort((a,b) -> a-b);
        
//         while(!list.isEmpty()){
//             boolean flg = false;    
//             for(int j = list.size()-1; j > 0; j--){
//                 if(list.get(0) + list.get(j) <= limit){
//                     list.remove(j);
//                     flg = true;
//                     break;
//                 }    
//             }
//             if(!flg)return answer + list.size();
//             list.remove(0);
//             answer++;
//         }
        Arrays.sort(people);
        
        int j = n - 1;
        for(int i = 0; i < n; i++){
            if(people[i] == -999) continue;
            
            boolean flg = false;
            
            for(; j > 0; j--){
                if(people[j] != -999 && people[i] + people[j] <= limit){
                    people[j] = -999;
                    flg = true;
                    break;
                }    
            }
        
            people[i] = -999;
            answer++;
        }
        return answer;
    }
}