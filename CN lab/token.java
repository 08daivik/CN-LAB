import java.util.*;

public class token {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int rem=0,req,sent;
        System.out.println("Enter bucket capacity");
        int cap=sc.nextInt();
        System.out.println("Enter token generation rate");
        int rate=sc.nextInt();
        System.out.println("Enter number of cycles");
        int n=sc.nextInt();
        System.out.println("Time\tRequested\tSent\tRemaining");

        for(int i=0;i<n;i++){
            req=rate;
            if((req+rem)>cap){
                sent=cap-rem;
                rem=cap;
            }
            else
            {
                sent=req;
                rem+=req;
            }
            System.out.printf("%d\t%d\t\t%d\t%d\n",(i+1),req,sent,rem);
        }
        sc.close();
    }
}
