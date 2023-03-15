import java.util.Arrays;
import java.util.Scanner;

public class Flood {

	public Flood() {
	}

	private static void showGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (j == grid[i].length - 1) {
					System.out.print(grid[i][j]);
				} else {
					System.out.print(grid[i][j] + " ");
				}
			}
			System.out.println();
		}
	};

	private static int waterFlow(int num, int row, int col, int[][] terrain, int[][] waterQty, int[] bangkok) {
		int result = 0;
		while (true) {
			int[][] waterModel = Arrays.stream(waterQty).map(int[]::clone).toArray(int[][]::new);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					int current = terrain[i][j] + waterModel[i][j];
					int water = waterModel[i][j];
					int bottom = i == waterModel.length - 1 ? Integer.MAX_VALUE : terrain[i + 1][j] + waterModel[i + 1][j];
					int left = j == 0 ? Integer.MAX_VALUE : terrain[i][j - 1] + waterModel[i][j - 1];
					int right = j == col - 1 ? Integer.MAX_VALUE : terrain[i][j + 1] + waterModel[i][j + 1];
					int top = i == 0 ? Integer.MAX_VALUE : terrain[i - 1][j] + waterModel[i - 1][j];
					if (water == 0) {
					} else {
						for (int k = 0; k < 4; k++) {
							if (water == 0) break;
							if (k == 0 && current - bottom >= 2) {
								waterQty[i][j]--;
								waterQty[i + 1][j] += 1;
								current--;
								water--;
							}
							if (k == 1 && current - left >= 2) {
								waterQty[i][j]--;
								waterQty[i][j - 1] += 1;
								current--;
								water--;
							}
							if (k == 2 && current - right >= 2) {
								waterQty[i][j]--;
								waterQty[i][j + 1] += 1;
								current--;
								water--;
							}
							if (k == 3 && current - top >= 2) {
								waterQty[i][j]--;
								waterQty[i - 1][j] += 1;
								current--;
								water--;
							}
						}
					}
				}
			}
			boolean equal = Arrays.deepEquals(waterModel, waterQty);
			if (equal == true) break;
			if (num == 1) {
				System.out.println();
				showGrid(waterQty);
				System.out.print("-");
			}
		}
		result = waterQty[bangkok[0] - 1][bangkok[1] - 1];
		return result;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int row = sc.nextInt(), col = sc.nextInt();
			int[] bangkok = { sc.nextInt(), sc.nextInt() };
			int[][] terrain = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					terrain[i][j] = sc.nextInt();
				}
			}
			int[][] waterQty = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					waterQty[i][j] = sc.nextInt();
				}
			}
			int[][] waterModel = Arrays.stream(waterQty).map(int[]::clone).toArray(int[][]::new);
			int result = waterFlow(0, row, col, terrain, waterQty, bangkok);
			System.out.print(result);
			waterFlow(1, row, col, terrain, waterModel, bangkok);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
