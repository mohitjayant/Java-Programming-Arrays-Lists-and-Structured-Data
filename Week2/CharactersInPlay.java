package Week2;
import java.util.*;
import edu.duke.*;

public class CharactersInPlay 
{
    private ArrayList<String> character;
    private ArrayList<Integer> count;

    public CharactersInPlay()
    {
        character=new ArrayList<String>();
        count=new ArrayList<Integer>();
    }

    public void update(String line) 
    {
        int idx=character.indexOf(line);
        if(idx==-1)
        {
            character.add(line);
            count.add(1);
        }
        else
        {
            int freq=count.get(idx);
            count.set(idx,freq+1);
        }
    }

    public void findAllCharacter() 
    {
        character.clear();
        count.clear();

        FileResource fr=new FileResource();
        for(String line:fr.lines())
        {
            if(line.contains("."))
            {
                int index=line.indexOf(".");
                String possible_name=line.substring(0,index);
                update(possible_name);
            }
        }
    }


    public void tester() 
    {
        findAllCharacter();
        for(int k=0;k<count.size();k++)
        {
            if(count.get(k)>1)
            {
                System.out.println("Main character: "+character.get(k)+"\t"+"No. Of speaking part: "+count.get(k));
            }
        }
    }

    public static void main(String[] args) 
    {
        CharactersInPlay cp=new CharactersInPlay();
        cp.tester();

    }
}