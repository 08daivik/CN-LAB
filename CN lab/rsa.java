import java.io.*;
import java.util.*;
import java.math.*;
import java.nio.charset.*;

public class rsa{
    private BigInteger n,p,q,e,d,phi;
    private int bitlength=1024;
    private Random r;

    public rsa(){
        r=new Random();
        p=BigInteger.probablePrime(bitlength,r);
        q=BigInteger.probablePrime(bitlength, r);
        System.out.println("p = "+p);
        System.out.println("q = "+q);
        n=p.multiply(q);
        phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e=BigInteger.probablePrime(bitlength/2,r);

        while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0){
            e=e.add(BigInteger.ONE);
        }

        System.out.println("e = "+e);
        d=e.modInverse(phi);
        System.out.println("d = "+d);
    }

    public static void main(String args[]) throws IOException{
        rsa rsa=new rsa();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter plaintext:");
        String test=br.readLine();
        System.out.println("Encrypting the string - "+test);
        System.out.println("String in bytes : "+ bytestoString(test.getBytes()));
        byte encrypted[]=rsa.encrypt(test.getBytes());
        byte decrypted[]=rsa.decrypt(encrypted);
        System.out.println("Decrypting the bytes : "+ bytestoString(decrypted));
        System.out.println("Decrypted string : "+new String(decrypted,StandardCharsets.UTF_8));
    }

    private static String bytestoString(byte encrypted[]){
        StringBuilder res=new StringBuilder();
        for(byte b:encrypted){
            res.append(Byte.toString(b));
        }
        return res.toString();
    }

    public byte[] encrypt(byte message[]){
        return( new BigInteger(message)).modPow(e,n).toByteArray();
    }

    public byte[] decrypt(byte message[]){
        return (new BigInteger(message)).modPow(d,n).toByteArray();
    }
}