import java.util.*;

public class sort{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of frames");
        int n=sc.nextInt();
        List<int[]> frame=new ArrayList<>();

        for(int i=0;i<n;i++){
            Random rand=new Random();
            int seqno=rand.nextInt(1000)+1;
            System.out.printf("Enter the data of frame %d\t",i+1);
            int data=sc.nextInt();
            frame.add(new int[]{seqno,data});
        }

        System.out.println("Before sorting");
        for(int i[]:frame)
        {
            System.out.printf("Seqnum:%d\tData:%d\n",i[0],i[1]);
        }

        frame=sortFrame(frame);

        System.out.println("After sorting");
        for(int i[]:frame)
        {
            System.out.printf("Seqnum:%d\tData:%d\n",i[0],i[1]);
        }

        sc.close();
    }
    public static List<int[]>sortFrame(List<int[]> frame){
        Collections.sort(frame,(a,b)->Integer.compare(a[0],b[0]));
        return frame;
    }
}
