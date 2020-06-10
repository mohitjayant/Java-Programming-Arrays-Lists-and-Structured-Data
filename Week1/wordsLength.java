package Week1;
import edu.duke.*;

public class wordsLength 
{


    public void countWordLength(FileResource fr,int[] counts)
    {
        for(String word : fr.words())
        {  	
            word=word.replaceAll("\\p{Punct}", "");
            int wordlength = word.length();     	
            if (wordlength >= counts.length) {  	    	   
                 wordlength = counts.length - 1;  	  	
            }  	
            if (wordlength > 0 ) {  	   	   
                 counts[wordlength] ++;  	  	
            }
       }
    }

    public void testCountWordLengths() 
    {
        FileResource fr=new FileResource();
        int[] counts=new int[31];
        countWordLength(fr,counts);
        int maxVal=Integer.MIN_VALUE;
        int wordLength=0;
        for(int i=0;i<counts.length;i++)
        {
            if(maxVal<counts[i])
            {
                maxVal=counts[i];
                wordLength=i;
            }
        }
        System.out.println("most common Word length: "+wordLength);
    }

    public static void main(String[] args) {
        wordsLength wl=new wordsLength();
        wl.testCountWordLengths();
    }
}