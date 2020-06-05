package Week1;
import edu.duke.*;

public class caeserCipher 
{

    public String encrypt(String message,int key)
    {
        StringBuilder encrypted=new StringBuilder(message);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted=alphabet.substring(key)+alphabet.substring(0,key);

        for(int i=0;i<encrypted.length();i++)
        {
            char currentChar=encrypted.charAt(i);
            int idx=alphabet.indexOf(currentChar);

            if(idx!=-1)
            {
                char newChar=shifted.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }

        return encrypted.toString();
    }

    public String decrypt(String message,int key)
    {
        StringBuilder decrypted=new StringBuilder(message);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted=alphabet.substring(key)+alphabet.substring(0,key);

        for(int i=0;i<decrypted.length();i++)
        {
            char currentChar=decrypted.charAt(i);
            int idx=alphabet.indexOf(currentChar);

            if(idx!=-1)
            {
                char newChar=shifted.charAt(idx);
                decrypted.setCharAt(i, newChar);
            }
        }

        return decrypted.toString();
    }

    public void testCaeser() {
        int key=17;
        FileResource fr=new FileResource();
        String message=fr.asString();
        String encrypted=encrypt(message,key);
        System.out.println("Encrypted: "+encrypted);
        String decrypted=decrypt(encrypted,26-key);
        System.out.println("Decrypted: "+decrypted);
    }

    public static void main(String[] args) {
        caeserCipher cc=new caeserCipher();
        cc.testCaeser();
    }
    
}