package school;

public class poa262 {
    static boolean isMatched = false;
    public static void main(String[] args) {
        String source = "aejfoieaijpggoifjwoiefj";
        System.out.println("source string : " + source);
        String pattern = "jpg";
        System.out.println("pattern string : " + pattern);
        int match = match(source, pattern, source.length(), pattern.length());
        System.out.println("matched At Index : " + match);
        System.out.println("is matched? : " + isMatched);
    }

    public static int match(String source, String pattern, int sourceLength, int patternLength ){
        boolean matched = false;
        int indexOfSource = 0;
        while(indexOfSource<=sourceLength-patternLength && !matched){
            int indexOfPattern = 0;
            matched = true;
            while(indexOfPattern<patternLength && matched){
                boolean patternMatch = pattern.charAt(indexOfPattern)==source.charAt(indexOfSource + indexOfPattern);
                matched = matched && patternMatch;
                indexOfPattern++;
            }
            if(indexOfPattern==patternLength){
                isMatched=true;
            }
            indexOfSource++;
        }
        return indexOfSource-1;
    }
}
