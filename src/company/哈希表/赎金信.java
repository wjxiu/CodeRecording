package company.哈希表;

/**
 * @author xiu
 * @create 2023-07-11 10:30
 */
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        char[] chars = magazine.toCharArray();
        for(char c:chars){
            dict[c-'a']+=1;
        }
        for(char c:ransomNote.toCharArray()){
            dict[c-'a']-=1;
        }
        for(int i:dict){
            if (i<0){
                return false;
            }
        }
        return true;
    }
}
