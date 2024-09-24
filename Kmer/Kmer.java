import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

class Kmer
{
	public static int[] seq = new int[255];
	public static String s;
	public static String sub = "";
	public static String rev;
	public static String tg = "";
	public static int window;
	public static HashMap<String, Integer> count = new HashMap<String, Integer>();
	public static HashMap<String, Integer> comp = new HashMap<String, Integer>();
	public static HashMap<String, Integer> tog = new HashMap<String, Integer>();

	public static void main(String [] args)
	{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a reading frame from 1-6");
		window = in.nextInt();
		ReadSequence();
		Parse(sub);
		Reverse(sub);
		Parser(rev);		
		Getter();		
		GetterTwo();
		tg = sub + rev;
		Parserer(tg);
		GetterThree();
		
	}
	public static void ReadSequence()
	{ // Read the sequence in from a file

		
		

		try{

			FileReader file = new FileReader("kmersample_Week14.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			int x = -1;
			String line;
			
			while((line = br.readLine()) != null)
			{
				Putter(line);
			}
			br.close();

		} catch (IOException ex) {};

		System.out.println("Sequence read!");

	} // Read the sequence in from a file
	
	public static void Putter(String x)
	{
		int z = 0;
		while (z!= x.length())
		{
			String st = x.substring(z,z+1);
			if (st.equals(null))
			{
				sub = sub;
				z++;
			}
			else
			{
				sub = sub + st;
				z++;
			}
		}
		
	}
	public static void Reverse(String x)
	{
		String z = "";
		rev = "";
		for(int i = 0; i<x.length();i++)
		{
			z = x.substring(i,i+1);
			if(z.equals("A"))
			{
				rev = "T" + rev;
			}
			if(z.equals("T"))
			{
				rev = "A" + rev;
			}
			if(z.equals("C"))
			{
				rev = "G" + rev;
			}
			if(z.equals("G"))
			{
				rev = "C" + rev;
			}
			
		}
	}
	public static void Parse(String j)
	{
		int spot;
		int kmer = window;
		String str = "";
		int len = j.length();
		for (int i = 0; i<=len-kmer;i++)
		{
			spot = 0;
			str = j.substring(i,i+kmer);
			for (int z = 0; z<=len-kmer;z++)
			{
				if (j.substring(z,z+kmer).equals(str))
				{
					spot++;
				}
			
			}
			count.put(str,spot);
			
		}
		
		
	}
	public static void Parser(String j)
	{
		int spot;
		int kmer = window;
		String str = "";
		int len = j.length();
		for (int i = 0; i<=len-kmer;i++)
		{
			spot = 0;
			str = j.substring(i,i+kmer);
			for (int z = 0; z<=len-kmer;z++)
			{
				if (j.substring(z,z+kmer).equals(str))
				{
					spot++;
				}
			
			}
			comp.put(str,spot);
			
		}
		
		
	}
	public static void Parserer(String j)
	{
		int spot;
		int kmer = window;
		String str = "";
		int len = j.length();
		for (int i = 0; i<=len-kmer;i++)
		{
			spot = 0;
			str = j.substring(i,i+kmer);
			for (int z = 0; z<=len-kmer;z++)
			{
				if (j.substring(z,z+kmer).equals(str))
				{
					spot++;
				}
			
			}
			tog.put(str,spot);
			
		}
		
		
	}
	public static void Getter()
	{
		System.out.println("The Main Sequence: ");	
		for(String x : count.keySet())
		{
			System.out.println(x + "       " + count.get(x));
		}
	}
	public static void GetterTwo()
	{
		System.out.println("Now For the Reverse Compliment: ");
		for(String x : comp.keySet())
		{
			System.out.println(x + "       " + comp.get(x));
		}
	}
	public static void GetterThree()
	{
		System.out.println("Now For the Both of Them Together: ");
		for(String x : tog.keySet())
		{
			System.out.println(x + "       " + tog.get(x));
		}
	}
	

	

}