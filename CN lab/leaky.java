import java.util.*;

public class leaky {

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int rem=0,sent,recieved;
        System.out.println("Enter bucket capacity");
        int cap=sc.nextInt();
        System.out.println("Enter bucket rate");
        int rate=sc.nextInt();
        System.out.println("Enter number of packets");
        int n=sc.nextInt();
        System.out.println("Enter size of each packets");
        int buf[]=new int[30];
        for(int i=0;i<n;i++)
            buf[i]=sc.nextInt();

        System.out.println("Time\tPacket\trecieved\tsent\tremaining");
        
        for(int i=0;i<n;i++)
        {
            if(buf[i]!=0)
            {
                if(buf[i]+rem>cap)
                {
                    recieved=-1;
                }
                else{
                    recieved=buf[i];
                    rem+=buf[i];
                }
            }
            else{
                recieved=0;
            }

            if(rem!=0)
            {
                if(rem<rate)
                {
                    sent=rem;
                    rem=0;
                }
                else{
                    sent=rate;
                    rem-=rate;
                }
            }
            else{
                sent=0;
            }

        if(recieved==-1){
            System.out.printf("%d\t%d\tdropped\t\t%d\t%d\n",i+1,buf[i],sent,rem);
        }
        else
        {
            System.out.printf("%d\t%d\t%d\t\t%d\t%d\n",i+1,buf[i],recieved,sent,rem);
        }
        }
        sc.close();
    }
}

