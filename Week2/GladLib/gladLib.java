package Week2.GladLib;
import edu.duke.*;
import java.util.*;

public class gladLib 
{
    private ArrayList<String> adjectiveList;
	private ArrayList<String> nounList;
	private ArrayList<String> colorList;
	private ArrayList<String> countryList;
	private ArrayList<String> nameList;
	private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    
    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public gladLib()
    {
        initializeFromSource(dataSourceDirectory);
        myRandom=new Random();
    }

    public gladLib(String source)
    {
        initializeFromSource(source);
        myRandom=new Random();
    }

    private ArrayList<String> readIt(String source)
    {
        ArrayList<String> list=new ArrayList<String>();
        if(source.startsWith("http"))
        {
            URLResource resource=new URLResource(source);
            for(String line:resource.lines())
            {
                list.add(line);
            }
        }
        else
        {
            FileResource resource=new FileResource(source);
            for(String line:resource.lines())
            {
                list.add(line);
            }

        }
        return list;
    }

    private void initializeFromSource(String source)
    {
        adjectiveList= readIt(source+"/adjective.txt");	
		nounList = readIt(source+"/noun.txt");
		colorList = readIt(source+"/color.txt");
		countryList = readIt(source+"/country.txt");
		nameList = readIt(source+"/name.txt");		
		animalList = readIt(source+"/animal.txt");
		timeList = readIt(source+"/timeframe.txt");
    }

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