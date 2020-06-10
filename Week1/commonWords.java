package Week1;
import edu.duke.*;
public class commonWords 
{

    public String[] getCommon()
    {
        FileResource fr=new FileResource("Week1/data/common.txt");
        String[] common=new String[20];
        int index=0;
        for(String s:fr.words())
        {
            common[index]=s;
            index++;
        }
        return common;
    }

    public int indexOf(String[] common,String word) 
    {
        for(int i=0;i<common.length;i++)
        {
            if(common[i].equals(word))
            {
                return i;
            }
        }
        return -1;
    }

    public void countWords(FileResource fr,String[] common,int[] counts) 
    {
        for(String word:fr.words())
        {
            word=word.toLowerCase();
            int index=indexOf(common,word);
            if(index!=-1)
            {
                counts[index]+=1;
            }
        }
    }

    public void countShakespeare() 
    {
        String[] plays={"caesar.txt", "errors.txt", "hamlet.txt","likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] common=getCommon();
        int[] counts=new int[common.length];
        for(int k=0;k<plays.length;k++)
        {
            FileResource fr=new FileResource("Week1/data/"+plays[k]);
            countWords(fr,common,counts);
            System.out.println("Done with "+plays[k]);
        }

        for(int k=0; k < common.length; k++)
        {
			System.out.println(common[k] + "\t" + counts[k]);
		}
    }

    public static void main(String[] args) {
        commonWords cw=new commonWords();
        cw.countShakespeare();
    }
}