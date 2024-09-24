import java.util.Scanner;

class GCContent
{ // GC Content calculator

	public static void main(String args[])
	{ // main
	Scanner in = new Scanner(System.in);
	System.out.println("Enter a nucleotide sequence: ");
	String sequence = in.nextLine();
	sequence = sequence.toUpperCase();
	System.out.println(sequence);
		// (**)asks for a nucleotide sequence and shows what was inputted
	
	
	
	int gc =0;
	int at =0;
	String x;
	boolean invalid = false;
	double gPercent;
	double aPercent;
	int i = 0;
	while (i < sequence.length())
	{
		x = sequence.substring(i, i+1);
		if (x.equals("A") || x.equals("T"))
		{		
			at++;
		}
		else if (x.equals("G")||x.equals("C"))
		{
			gc++;
		}
		else
		{
			System.out.println("Invalid Nucleotide");
			invalid = true;
		}
		i++;
	}
	int total = at +gc;
	gPercent = (gc*1.00)/(gc+at)*100;
	aPercent = 100 - gPercent;
	System.out.println("There were " + total + " nucleotides in your sequence");
	System.out.println("GC Percent Equals " + gPercent + "%");
	System.out.println("AT Percent Equals " + aPercent + "%");
	if (invalid == true)
	{
		System.out.println("Some of your given nucleotides were invalid");
	}	
	
		
	} 

}
