import java.util.*;

public class red{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the maximum number of packets:");
        int maxpackets=sc.nextInt();
        System.out.println("Enter the queue size");
        int queuesize=sc.nextInt();
        System.out.println("Enter maximum probability");
        double maxp=sc.nextDouble();
        System.out.println("Enter minimum probability");
        double minp=sc.nextDouble();
        System.out.println("Enter the threshold");
        int threshold=sc.nextInt();

        simulatecongestion(maxpackets,queuesize,maxp,minp,threshold);
        sc.close();
    }
    
    private static void simulatecongestion(int maxpackets,int queuesize,double maxp,double minp,int threshold)
    {
        int queuelength=0;
        Random rand=new Random(System.currentTimeMillis());

        

        for(int i=0;i<maxpackets;i++){

            double dropprobability=calculateprobability(queuesize,queuelength,maxp,minp,threshold);

        if(queuelength>=threshold && rand.nextDouble()<dropprobability){
            System.out.println("Packet dropped [CONGESTION AVOIDANCE]");
        }

        else{
            System.out.println("Packet accepted "+ (i+1));
            queuelength++;
        }
    }
    }

    private static double calculateprobability(int queuesize,int currentqueuelength,double maxp,double minp,int threshold)
    {
        double slope=(maxp-minp)/(queuesize-threshold);
        return minp+slope*(currentqueuelength-threshold);
    }
}