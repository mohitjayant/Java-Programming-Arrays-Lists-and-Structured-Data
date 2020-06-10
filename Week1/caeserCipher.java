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
                encrypted.setCharAt(i, newChar);
            }
        }

        return encrypted.toString();
    }

    public String encryptTwoKeys(String message,int key1,int key2)
    {
        StringBuilder twoKeys=new StringBuilder(message);
        String  alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String firstShifted=alphabet.substring(key1)+alphabet.substring(0,key1);
        String secondShifted=alphabet.substring(key2)+alphabet.substring(0,key2);
        for(int i=0;i<twoKeys.length();i++)
        {
            char currentChar=twoKeys.charAt(i);
            if(i%2==0)
            {
                if('a'<= currentChar && currentChar <= 'z')
                {
                    alphabet=alphabet.toLowerCase();
                    firstShifted=firstShifted.toLowerCase();
                }
                if('A'<= currentChar && currentChar <= 'Z')
                {
                    alphabet=alphabet.toUpperCase();
                    firstShifted=firstShifted.toUpperCase();
                }
                int idx=alphabet.indexOf(currentChar);

                if(idx!=-1)
                {
                    char newChar=firstShifted.charAt(idx);
                    twoKeys.setCharAt(i, newChar);
                }
            }
            else
            {
                if('a'<= currentChar && currentChar <= 'z')
                {
                    alphabet=alphabet.toLowerCase();
                    secondShifted=secondShifted.toLowerCase();
                }
                if('A'<= currentChar && currentChar <= 'Z')
                {
                    alphabet=alphabet.toUpperCase();
                    secondShifted=secondShifted.toUpperCase();
                }
                int idx=alphabet.indexOf(currentChar);

                if(idx!=-1)
                {
                    char newChar=secondShifted.charAt(idx);
                    twoKeys.setCharAt(i, newChar);
                }
            }
        }
        return twoKeys.toString();
    }

    public void testCaeser() {
        int key=17;
        FileResource fr=new FileResource();
        String message=fr.asString();
        String encrypted=encrypt(message,key);
        System.out.println("Encrypted: "+encrypted);
        String decrypted=encrypt(encrypted,26-key);
        System.out.println("Decrypted: "+decrypted);
        String twoKeyEncrypt=encryptTwoKeys(message,2,20);
        System.out.println("Encrypted using two keys: "+twoKeyEncrypt);
        String twoKeyDecrypt=encryptTwoKeys(message,26-2,26-20);
        System.out.println("Decrypted using two keys: "+twoKeyDecrypt);
    }

    public static void main(String[] args) {
        caeserCipher cc=new caeserCipher();
        cc.testCaeser();
    }
    
}