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

    public int[] countLetters(String message,String alpha)
    {
        int[] counts=new int[26];
        for(int i=0;i<message.length();i++)
        {
            char ch=Character.toLowerCase(message.charAt(i));
            int idx=alpha.indexOf(ch);
            if(idx!=-1)
            {
                counts[idx]+=1;
            }
        }
        return counts;
    }

    public int getKey(String message)
    {

        String alpha="abcdefghijklmnopqrstuvwxyz";
        int[] counts=countLetters(message,alpha);
        int maxIndex=Integer.MIN_VALUE;
        int pos=0;
        int idx;
        for(int i=0;i<message.length();i++)
        {
            idx=alpha.indexOf(Character.toLowerCase(message.charAt(i)));
            if((idx!=-1) && (counts[idx]>maxIndex))
            {
                maxIndex=counts[idx];
                pos=idx;
            }
        }
        int key=pos-4;
        if(pos<4)
        {
            key=26-(4-pos);
        }
        return key;

    }

    public String decrypt(String message,int key)
    {
        StringBuilder decrypted=new StringBuilder(message);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted=alphabet.substring(key)+alphabet.substring(0,key);

        for(int i=0;i<decrypted.length();i++)
        {
            char currentChar=decrypted.charAt(i);
            if('a'<= currentChar && currentChar <= 'z')
            {
                alphabet=alphabet.toLowerCase();
                shifted=shifted.toLowerCase();
            }
            if('A'<= currentChar && currentChar <= 'Z')
            {
                alphabet=alphabet.toUpperCase();
                shifted=shifted.toUpperCase();
            }
            int idx=alphabet.indexOf(currentChar);

            if(idx!=-1)
            {
                char newChar=shifted.charAt(idx);
                decrypted.setCharAt(i, newChar);
            }
        }

        return decrypted.toString();
    }


    public String combine(String odd,String even)
    {
        String res="";
        int totLength=odd.length()+even.length();
        int oddPos=0;
        int evenPos=0;
        for(int i=0;i<totLength;i++)
        {
            if(i%2==0)
            {
                res+=odd.charAt(oddPos);
                oddPos+=1;
            }
            else
            {
                res+=even.charAt(evenPos);
                evenPos+=1;
            }
        }
        return res;
    }

    public void testDecrypt() 
    {
        FileResource fr=new FileResource();
        String message=fr.asString();
        String oddString=halfOfString(message,0);
        String evenString=halfOfString(message,1);
        int key1=getKey(oddString);
        int key2=getKey(evenString);
        String oddDecrypt=decrypt(oddString,26-key1);
        String evenDecrypt=decrypt(evenString,26-key2);
        String twoKeyDecrypt=combine(oddDecrypt,evenDecrypt);
        int key=getKey(message);
        String decryptedMessage=decrypt(message,26-key);
        System.out.println("Decrypted Message: "+decryptedMessage);
        System.out.println("Decrypted using TwoKeys: "+twoKeyDecrypt);
        System.out.println("key1: "+key1+" Key2: "+key2);
    }

    public static void main(String[] args) {
        decryptCaeserCipher dcc=new decryptCaeserCipher();
        dcc.testDecrypt();
    }
}