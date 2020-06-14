package Week2;
import edu.duke.*;

public class wordsWithArrays 
{
    StorageResource myWords;

    public wordsWithArrays()
    {
        myWords=new StorageResource();
    }
    public void readFile() 
    {
        myWords.clear();
        FileResource fr=new FileResource();
        for(String s:fr.words())
        {
            myWords.add(s.toLowerCase());
        }
    }

    public boolean contains(String[] list,String word,int number) 
    {
        for(int k=0;k<number;k++)
        {
            if(list[k].equals(word))
            {
                return true;
            }
        }
        return false;
    }

    public int numberOfUniqueWords() 
    {
        int numStored=0;
        String[] words=new String[myWords.size()];
        for(String s:myWords.data())
        {
            if(!contains(words,s,numStored))
            {
                words[numStored]=s;
                numStored++;
            }
        }
        return numStored;
    }

    public void tester() 
    {
        readFile();
        System.out.println("Number of words in file: "+myWords.size());
        int unique=numberOfUniqueWords();
        System.out.println("Unique Words: "+unique);
    }

    public static void main(String[] args) 
    {
        wordsWithArrays wwa=new wordsWithArrays();
        wwa.tester();
    }
}