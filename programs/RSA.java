// Ex 5
import java.io.*;
import java.util.*;
import java.math.*;
public class RSA{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Enter a Prime Number");
		BigInteger p=sc.nextBigInteger();
		System.out.println("Enter another Prime Number");
		BigInteger q=sc.nextBigInteger();
		BigInteger n=p.multiply(q);
		BigInteger n2=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		BigInteger e=generateE(n2);
		BigInteger d=e.modInverse(n2);
		System.out.println("Encryption keys are: "+e+", "+n);
		System.out.println("Decryption keys are: "+d+", "+n);
	}
	public static BigInteger generateE(BigInteger fiofn){
		int y,intGCD;
		BigInteger e;
		BigInteger gcd;
		Random x=new Random();
		do{
			y=x.nextInt(fiofn.intValue()-1);
			String z=Integer.toString(y);
			e=new BigInteger(z);
			gcd=fiofn.gcd(e);
			intGCD=gcd.intValue();
		}
		while(y<=2||intGCD!=1);
		return e;
	}
}