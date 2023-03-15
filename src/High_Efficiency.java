import java.util.Scanner;

public class High_Efficiency {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int row = sc.nextInt(), col = sc.nextInt();
			int[][] arr = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					int current = arr[i][j];
					int top = i == 0 ? Integer.MIN_VALUE : arr[i - 1][j];
					int bottom = i == arr.length - 1 ? Integer.MIN_VALUE : arr[i + 1][j];
					int left = j == 0 ? Integer.MIN_VALUE : arr[i][j - 1];
					int right = j == arr[i].length - 1 ? Integer.MIN_VALUE : arr[i][j + 1];

					int topLeft = (i == 0 || j == 0) ? Integer.MIN_VALUE : arr[i - 1][j - 1];
					int topRight = (i == 0 || j == arr[i].length - 1) ? Integer.MIN_VALUE : arr[i - 1][j + 1];
					int bottomLeft = (i == arr.length - 1 || j == 0) ? Integer.MIN_VALUE : arr[i + 1][j - 1];
					int bottomRight = (i == arr.length - 1 || j == arr[i].length - 1) ? Integer.MIN_VALUE : arr[i + 1][j + 1];

					if (current > top && current > bottom && current > left && current > right && current > topLeft && current > topRight && current > bottomLeft && current > bottomRight) {
						count++;
					}
				}
			}
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//
