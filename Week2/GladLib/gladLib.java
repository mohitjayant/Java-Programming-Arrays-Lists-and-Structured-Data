package Week2.GladLib;
import edu.duke.*;
import java.util.*;

public class gladLib 
{

    private void printOut(String story,int lineWidth)
    {
        
    }

    private String fromTemplate(String source)
    {
        String story="";
        if(source.startsWith("http"))
        {
            URLResource resource=new URLResource(source);
            for(String word:resource.words())
            {
                story+=processWords(word)+" ";
            }
        }
        else
        {
            FileResource resource=new FileResource(source);
            for(String word:resource.words())
            {
                story+=processWords(word)+" ";
            }
        }
        return story;
    }

    public void makeStory() 
    {
        System.out.println("\n");
        String story=fromTemplate("data/madTemplate.txt");
        printOut(story,60);
    }

    public static void main(String[] args) 
    {
        gladLib gl=new gladLib();
        gl.makeStory();
    }
}