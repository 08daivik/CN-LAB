import java.util.*;

public class crc{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Sender Side");
        System.out.println("Enter message");
        String message=sc.nextLine();
        System.out.println("Enter generator");
        String generator=sc.nextLine();

        int data[]=new int[message.length()+generator.length()-1];
        int divisor[]=new int[generator.length()];

        for(int i=0;i<message.length();i++)
        {
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
        for(int i=0;i<generator.length();i++)
        {
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        }

        for(int i=0;i<message.length();i++)
        {
            if(data[i]==1)
            {
                for(int j=0;j<divisor.length;j++)
                {
                    data[i+j]^=divisor[j];
                }
            }
        }

        for(int i=0;i<message.length();i++)
        {
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }

        System.out.println("The checksum generated is:");
        for(int i=0;i<data.length;i++)
        {
            System.out.print(data[i]);

        }
        System.out.println("");

        System.out.println("Reciever's side");
        System.out.println("Enter checksum");
        message=sc.nextLine();
        System.out.println("Enter generator");
        generator=sc.nextLine();

        data=new int[message.length()+generator.length()-1];
        divisor=new int[generator.length()];

        for(int i=0;i<message.length();i++)
        {
            data[i]=Integer.parseInt(message.charAt(i)+"");
        }
        for(int i=0;i<generator.length();i++)
        {
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        }

        for(int i=0;i<message.length();i++)
        {
            if(data[i]==1)
            {
                for(int j=0;j<divisor.length;j++)
                {
                    data[i+j]^=divisor[j];
                }
            }
        }

        boolean valid=true;
        for(int i=0;i<data.length;i++)
        {
            if(data[i]==1)
            {
                valid=false;
                break;
            }
        }

        if(valid)
            System.out.println("Accepted");
        else
            System.out.println("Rejected");
        sc.close();
    }
}