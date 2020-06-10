package Week1;
import java.util.Random;
public class diceRolling {

    public void simpleSimulate(int rolls) 
    {
        Random rand=new Random();
        int twos=0;
        int twelves=0;
        for(int i=0;i<rolls;i++)
        {
            int v1=rand.nextInt(6)+1;
            int v2=rand.nextInt(6)+1;
            if(v1+v2==2)
            {
                twos=twos+1;
            }
            else if(v1+v2==12)
            {
                twelves=twelves+1;
            }
        }

        System.out.println("2's=\t"+twos+"\t"+100.0*twos/rolls);
        System.err.println("12's=\t" + twelves + "\t"+100.0*twelves/rolls);
    }

    public void simulate(int rolls) 
    {
        Random rand=new Random();
        int[] counts=new int[13];

        for(int i=0;i<rolls;i++)
        {
            int v1=rand.nextInt(6)+1;
            int v2=rand.nextInt(6)+1;

            counts[v1+v2]+=1;
        }
        for(int k=2;k<=12;k++)
        {
            System.out.println(k+"'s=\t"+counts[k]+"\t"+counts[k]*100.0/rolls);
        }
    }
    
    public static void main(String[] args) {
        diceRolling dr=new diceRolling();
        dr.simpleSimulate(1000);
        dr.simulate(1000);
    }
}