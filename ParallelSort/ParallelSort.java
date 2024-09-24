import java.util.Scanner;
import java.io.*;

class ParallelSort
{  

	
	public static int[] numbers = new int[10000];
	public static String[] strings = new String[10000];

	public static void main(String args[])
	{ // main

		System.out.println("Reading in numbers");
		ReadNumbers();
		System.out.println("Reading in strings");
		ReadStrings();
		Arr();
		Outp();

		

	} 

	public static void ReadNumbers()
	{ // Read the numbers in from a file

		String s;
		int x;

		try{

			FileReader file = new FileReader("randnumbersparallel.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			x = -1;

			while ((s = br.readLine()) != null)
			{  // read in one sequence
				x++;
				if ((x % 100) == 0)
				{ System.out.print("."); }
				numbers[x] = Integer.parseInt(s);
			}  
		} catch (IOException ex) {};

		System.out.println("Numbers read!");

	

	} 

	public static void ReadStrings()
	{ // Read the strings in from a file

		String s;
		int x;

		try{

			FileReader file = new FileReader("randstrings.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			x = -1;

			while ((s = br.readLine()) != null)
			{  // read in one string
				x++;
				if ((x % 100) == 0)
				{ System.out.print("."); }
				strings[x] = s;
			}  
		} catch (IOException ex) {};

		System.out.println("Strings read!");

		

	} 

	public static void Arr()
	{
		for (int x = 0; x < numbers.length; x++)
		{
			int min = x;
			for (int y = x+1; y < numbers.length; y++)
			{
				if (numbers[y] < numbers[min])
				{
					min = y;
				}
			}
			if (min != x)
			{
				int temp = numbers[min];
				String temper = strings[min];
				numbers[min] = numbers[x];
				strings[min] = strings[x];
				numbers[x] = temp;
				strings[x] = temper;
			}
		}
	}

	public static void Outp()
	{
		for (int z = 0; z < numbers.length; z++)
		{
			System.out.println(numbers[z] + " " + strings[z]);
		}
	}

}  
