package Week1;
import edu.duke.*;

public class decryptCaeserCipher 
{

    public String halfOfString(String message,int pos)
    {
        String res="";
        for(int i=pos;i<message.length();i+=2)
        {
            res+=message.charAt(i);
        }
        return res;
    }

    public void testDecrypt() 
    {
        //FileResource fr=new FileResource();
        //String message=fr.asString();
        String oddString=halfOfString("Qbkm Zgis",0);
        String evenString=halfOfString("Qbkm Zgis",1);
        System.out.println("OddString: "+oddString);
        System.out.println("EvenString: "+evenString);
    }

    public static void main(String[] args) {
        decryptCaeserCipher dcc=new decryptCaeserCipher();
        dcc.testDecrypt();
    }
}