public class Test {

    public static boolean validAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int count : freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        String s = "example";
        String t = "elpmaxe";
        boolean result = validAnagram(s, t);
        System.out.println("Is valid anagram: " + result);
    }
}