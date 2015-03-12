import java.util.*;
public class Main
{
	public static char[][] map = new char[100][100];
	public static boolean[][] wasCounted = new boolean[100][100];
	public static int m;
	public static int n;
	public static final char OIL = '@';
	public static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		while (m != 0)
		{
			// System.out.print(m);
			for(int i = 0; i < m; i++)
			{
				map[i] = input.next().toCharArray();
			}
			
			System.out.println(countBlobs());
			
			cleanUp();
			m = input.nextInt();
			n = input.nextInt();
		}
		
		
	}
	
	static void cleanUp()
	{
		for (int i = 0; i < m; i++)
		{
			Arrays.fill(wasCounted[i], false);
		}
	}
	
	public static int countBlobs()
	{
		int blobCount = 0;
		
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (map[i][j] == OIL && !wasCounted[i][j])
				{
					blobCount++;
					markNeighborsCounted(i, j);
				}
			}
			
		}
		
		return blobCount;
	}
	
	public static void markNeighborsCounted(int row, int column)
	{
		wasCounted[row][column] = true;
		
		for (int i = 0; i < 8; i++)
		{
			if  (row + dx[i] < 0
				|| row + dx[i] >= m
				|| column + dy[i] < 0
				|| column + dy[i] >= n
				|| wasCounted[row + dx[i]][column + dy[i]]
				|| map[row + dx[i]][column + dy[i]] != OIL)
				continue;
			
			markNeighborsCounted(row + dx[i], column + dy[i]);
		}
	}
}