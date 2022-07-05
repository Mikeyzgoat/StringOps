package StringOps;
// parts of speech analyser
import java .util.Scanner;   

public class pos {
    // input string
    String sent;
    // list of respective pos
    String art[] = {"a","an","the"};
    String[] adj,adv,con,verbs,prep,pro,nouns;
    int low =0 ;
    int high = 10;
    // parts of speech counters
    int adjective = 0; // 1
    int adverb = 0; // 2
    int articles = 0; // 3
    int conjunction = 0; // 4
    int noun = 0; // 8
    int preposition = 0; // 5
    int pronoun = 0; // 6
    int verb = 0; // 7
    // number of vowels and consonants
    int vowel =0,consonants =0;
    // binary search function
    int binpos(String val,String[] pos){
        int low = 0,high;
        high = pos.length -1;
        while(low <= high){
            int mid = (low + high)/2;
            int res = val.compareTo(pos[mid]); // compares the object string to the array string at 'mid' position
            if(res == 0) // element present at mid
                return 1;
            if(res > 0)
                low = mid + 1;
            else
                high = mid -1;
        }
        return -1;
    }
    // is type function value assigner
    int binsearch(String val){
        if(binpos(val,adj) == 1)
            return 1;
        if(binpos(val,adv) == 1)
            return 2;
        if(binpos(val,art) == 1)
            return 3;
        if(binpos(val,con) == 1)
            return 4;
        if(binpos(val,prep) == 1)
            return 5;
        if(binpos(val,pro) == 1)
            return 6;
        if(binpos(val,verbs) == 1)
            return 7;
        else
            return 8;
    }
    // type detection function
    void is_type(String val){
        /*
        uses switch case to check for the word's respective parts of speech 
        parts of speech are 8 in total : K value ranges from 1-8
         */
        int k;
        k = binsearch(val);
        switch(k){
            case 1 : adjective +=1;
            break;
            case 2 : adverb +=1;
            break;
            case 3 : articles +=1;
            break;
            case 4 : conjunction +=1;
            break;
            case 5 : preposition +=1;
            break;
            case 6 : pronoun +=1;
            break;
            case 7 : verb+=1;
            break;
            case 8 : noun+=1;
            break; 
        }
        
    }
    // vowel and consonant counter
    void chartype(String val1){
        if(val1 == "a" || val1 == "e" || val1 == "i" || val1 == "o" || val1 == "u"){
            vowel += 1;
        }
        else{
            consonants += 1;
        }
    }
    // splitter function
    void splitter(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string : ");
        sent = scan.nextLine();
        String mainsplit[] = sent.toLowerCase().split(" ");
        for(String val : mainsplit){
            is_type(val);
            String subsplit[] = val.split("");
            for(String val1 : subsplit){
                chartype(val1);
            }
        }
        scan.close();
    }
    public static void main(String args[]){
        pos obj = new pos();
        obj.splitter();
        System.out.println("String : " + obj.sent);
        System.out.println("Adjectives : " + obj.adjective);
        System.out.println("Adverbs : " + obj.adverb);
        System.out.println("Articles : " + obj.articles);
        System.out.println("Conjuctions : " + obj.conjunction);
        System.out.println("Prepositions : " + obj.preposition);
        System.out.println("Pronouns : " + obj.pronoun);
        System.out.println("Verbs : " + obj.verb);
        System.out.println("Nouns : " + obj.noun);
        System.out.println("Vowels in total : " + obj.vowel);
        System.out.println("Consonants in total : " + obj.consonants);
    }
}
/*
 String[] b
 string b[]
 */