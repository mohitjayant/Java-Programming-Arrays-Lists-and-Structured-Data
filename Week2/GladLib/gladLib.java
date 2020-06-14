package Week2.GladLib;

public class gladLib 
{

    private void printOut(String story,int lineWidth)
    {

    }

    public String fromTemplate(String source)
    {
        String story="";
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