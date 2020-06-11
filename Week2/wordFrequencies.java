package Week2;
import java.util.*;
import edu.duke.*;

public class wordFrequencies 
{
    private ArrayList<String> myWords;

    public wordFrequencies()
    {
        myWords=new ArrayList<String>();
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
            }
        }
    }

    public void tester() 
    {
        findUnique();
        System.out.println("#Unique Words: "+myWords.size());
    }

    public static void main(String[] args) 
    {
        wordFrequencies wf=new wordFrequencies();
        wf.tester();
    }
    
}