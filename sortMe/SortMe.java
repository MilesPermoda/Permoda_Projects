
import java.util.Scanner;
import java.io.*;

class SortMe
{  

        
        public static int[] numbers = new int[10000];

        public static void main(String args[])
        { // main

            System.out.println("Reading in numbers");
            ReadNumbers();
			Arr();
			Spacing();
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
				numbers[min] = numbers[x];
				numbers[x] = temp;
			}
		}
	}
	
	public static void Spacing()
	{
		for (int z = 0; z < numbers.length; z++)
		{
			if (numbers[z] < 10)
			{
				System.out.print("    " + numbers[z] + " ");
			}
			else if (numbers[z] < 100)
			{
				System.out.print("   " + numbers[z] + " ");
			}
			else if (numbers[z] < 1000)
			{
				System.out.print("  " + numbers[z] + " ");
			}
			else if (numbers[z] < 10000)
			{
				System.out.print(" " + numbers[z] + " ");
			}
			else
			{
				System.out.print(numbers[z] + " ");
			}
		}
	}		
	
        public static void ReadNumbers()
        { // Read the numbers in from a file

                String s;
                int x;

                try{

                        FileReader file = new FileReader("randnumbers.txt");
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

}  
