import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


	
class myinterface implements ActionListener
{
	int[][] arr = new int[20][20];
	myPanel pan = new myPanel();
	JFrame jfrm = new JFrame("Game of Life");
	JLabel jlab = new JLabel("Turn 0");
	
	int turn = 0;
	public class myPanel extends JPanel
	{
		public myPanel()
		{
			setBorder(BorderFactory.createLineBorder(Color.black) ); 
			
		}
		public Dimension getPreferredSize()
		{return new Dimension(500,500);}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			int dim = 20;
			g.setColor(Color.black);
			g.drawRect(0,0,500,500);
			for (int y = 0; y < arr.length; y++)
			{
				for (int z = 0; z < arr[y].length; z++)
				{
					if (arr[y][z] == 0)
					{
						g.setColor(Color.black);
					}
					else if (arr[y][z] == 1)
					{
						g.setColor(Color.white);
					}
					else if (arr[y][z] == 2)
					{
						g.setColor(Color.red);
					}
					g.fillRect(y*dim,z*dim,dim,dim);
				}
			}
		}
	}
	
	 myinterface()
	{
		jfrm.setSize(1000,1000);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton left = new JButton("Next Generation");
		left.addActionListener(this);
		jfrm.add(left,BorderLayout.WEST);
		JButton right = new JButton("Reset");
		right.addActionListener(this);
		jfrm.add(right,BorderLayout.EAST);
		jfrm.add(jlab,BorderLayout.NORTH);
		jfrm.setVisible(true);
		reset();
		
		
		jfrm.add(pan, BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		jfrm.remove(pan);
		if (ae.getActionCommand().equals("Next Generation"))
		{
			nextGeneration();
			turn ++;
			jlab.setText("Turn " + turn);
		}
		else if (ae.getActionCommand().equals("Reset"))
		{
			reset();
			turn = 0;
			jlab.setText("Turn " + turn);
		}
	}
	public void nextGeneration()
	{ 
		for (int y = 0; y < arr.length; y++)
		{
			for (int z = 0; z < arr[y].length; z++)
			{
				generate(y,z);
			}
		}
		standardize();
		
		
		myPanel pane = new myPanel();
		jfrm.add(pane, BorderLayout.CENTER);
		jfrm.validate();
		

	}
	public void standardize()
	{
		for (int y = 0; y < arr.length; y++)
		{
			for (int z = 0; z < arr[y].length; z++)
			{
				if (arr[y][z] == 0)
				{
					arr[y][z] = 2;	
				}
				else if (arr[y][z] == 1)
				{
					arr[y][z] = 0;
				}
				else if (arr[y][z] == 3)
				{
					arr[y][z] = 1;
				}
			}
		}
	}
	public void generate(int y, int z)
	{
		int count = 0;
		if (y ==0 &&z ==0)
		{
			for (int row = y; row <= y+1; row++)
			{
				for (int col = z; col <= z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}
		else if (y == 19 && z == 0)
		{
			for (int row = y-1; row <= y; row++)
			{
				for (int col = z; col <= z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}
		else if (y == 0 && z == 19)
		{
			for (int row = y; row <= y+1; row++)
			{
				for (int col = z-1; col <= z; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}
		else if (y == 19 && z == 19)
		{
			for (int row = y-1; row < y+1; row++)
			{
				for (int col = z-1; col < z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}	
		else if ( y == 0)
		{
			for (int row = y; row <= y+1; row++)
			{
				for (int col = z-1; col <= z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}
		else if ( y == 19)
		{
			for (int row = y-1; row < y+1; row++)
			{
				for (int col = z-1; col <= z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}
		else if (z == 0)
		{
			for (int row = y-1; row <= y+1; row++)
			{
				for (int col = z; col <= z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}
		else if (z == 19)
		{
			for (int row = y-1; row <= y+1; row++)
			{
				for (int col = z-1; col < z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
		}
		else
		{
			for (int row = y-1; row <= y+1; row++)
			{
				for (int col = z-1; col <= z+1; col++)
				{
					if (row == y && col == z)
					{
						count += 0;
					}
					else if (arr[row][col] == 1)
					{
						count ++;
					}
				}
			}
			
		}
		counter(count,y,z);
	}
	public void counter(int x, int y, int z)
	{
		if (arr[y][z] == 2)
		{
			if (x==2)
			{
			 	arr[y][z] = 3;
			}
		}
		
	}
	
	public void reset()
	{ 
		for (int row = 0; row < arr.length; row++)
		{
			for (int col = 0; col < arr[row].length; col++)
			{
				arr[row][col] = 2;
			}
		}
		arr[11][12] = 1;
		arr[12][12] = 1;
		arr[13][12] = 1;
		arr[13][11] = 1;
		arr[12][10] = 1;
		myPanel pane = new myPanel();
		jfrm.add(pane, BorderLayout.CENTER);
		jfrm.validate();
	}
	public static void main(String [] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() {new myinterface();}
		});
		
		
		
	}
	


}