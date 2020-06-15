package Week2.GladLib;
import edu.duke.*;
import java.util.*;

public class gladLib 
{

    private String getSubstitute(String label) 
    {
        return "";
    }

    private void printOut(String story,int lineWidth)
    {
        
    }

     private String processWords(String str)
     {
         int first=str.indexOf("<");
         int last=str.indexOf(">");
         if(first==-1 || last==-1)
         {
             return str;
         }
         String prefix=str.substring(0,first);
         String suffix=str.substring(last+1);
         String sub=getSubstitute(str.substring(first+1,last));
         return prefix+sub+suffix;
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