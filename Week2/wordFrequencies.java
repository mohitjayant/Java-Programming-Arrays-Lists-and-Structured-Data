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
    }

    public static void main(String[] args) 
    {
        wordFrequencies wf=new wordFrequencies();
        wf.tester();
    }
    
}