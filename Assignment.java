import java.util.*;  

public class Assignment {
	
	int M=8,N=8;
	int cell =0;
	int[][] grid =  new int[10][10];
	Scanner sc= new Scanner(System.in); 
	
	void getdata() {
		 
		System.out.print("Enter first number: ");  
		M= sc.nextInt();  
		System.out.print("Enter second number: "); 
		N= sc.nextInt();  	
	}
	
	void calculate() {
			
		int[][] grid = {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
					};
		// Displaying the grid
		System.out.println("Original Generation");
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (grid[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		nextGeneration(grid, M, N);
	}

	// Function to print next generation
	static void nextGeneration(int grid[][], int M, int N)
	{
		int[][] future = new int[M][N];

		// Loop through every cell
		for (int l = 1; l < M - 1; l++)
		{
			for (int m = 1; m < N - 1; m++)
			{
				// finding no Of Neighbors that are alive
				int aliveNeighbours = 0;
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						aliveNeighbours += grid[l + i][m + j];

				// The cell needs to be subtracted from its neighbors as it was counted before
				aliveNeighbours -= grid[l][m];

				// Implementing the Rules of Life

				// Cell is y loneliness and dies
				if ((grid[l][m] == 1) && (aliveNeighbours < 2))
					future[l][m] = 0;

				// Cell dies due to over  overcrowding
				else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
					future[l][m] = 0;

				// A new cell comes to life
				else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
					future[l][m] = 1;

				// Remains the same
				else
					future[l][m] = grid[l][m];
			}
		}

		System.out.println("Next Generation");
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (future[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args)
	{
		
		Assignment obj = new Assignment();
		obj.getdata();
		obj.calculate();
	}	
			
}
