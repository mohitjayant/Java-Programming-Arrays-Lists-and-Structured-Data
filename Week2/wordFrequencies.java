package Week2;
import java.util.*;
import edu.duke.*;

public class wordFrequencies 
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public wordFrequencies()
    {
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }

    public int findIndexOfMax() 
    {
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++) 
        {
            if (myFreqs.get(k) >max) 
            {
                max = myFreqs.get(k);
                maxIndex = k;
            }
            
        }
        return maxIndex;
    }


    public void findUnique() 
    {
        FileResource fr=new FileResource();
        for(String word:fr.words())
        {
            word=word.toLowerCase();
            int index=myWords.indexOf(word);
            if(index==-1)
            {
                myWords.add(word);
                myFreqs.add(1);
            }
            else
            {
                int value=myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }

    public void tester() 
    {
        findUnique();
        System.out.println("#Unique Words: "+myWords.size());
        for(int k=0;k<myWords.size();k++)
        {
            System.out.println(myFreqs.get(k)+ "\t" +myWords.get(k));
        }
        int index=findIndexOfMax();
        System.out.println("The word that occurs most often and its count are:: " +myWords.get(index)+" "+myFreqs.get(index));
    }

    public static void main(String[] args) 
    {
        wordFrequencies wf=new wordFrequencies();
        wf.tester();
    }
    
}