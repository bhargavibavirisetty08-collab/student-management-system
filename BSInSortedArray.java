import java.util.Arrays;
public class BSInSortedArray {




        public static void main(String[] args) {
            int[][] arr = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.println(Arrays.toString(search(arr, 9)));
        }

        // Search the target in the whole matrix, return its (row, col) or {-1,-1} if not found
        static int[] search(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length; // assume matrix is non-empty

            // If there's only one row, just binary search that row
            if (rows == 1) {
                return binarySearch(matrix, 0, 0, cols - 1, target);
            }

            int rStart = 0;
            int rEnd = rows - 1;
            int cMid = cols / 2;

            // Run until only two rows remain (rStart and rStart+1)
            while (rStart < (rEnd - 1)) { // while more than 2 rows are in the search space
                int mid = rStart + (rEnd - rStart) / 2;

                // If target found at middle column of mid row
                if (matrix[mid][cMid] == target) {
                    return new int[]{mid, cMid};
                }

                // Decide which half of rows to keep based on value at middle column
                if (matrix[mid][cMid] < target) {
                    rStart = mid; // target in lower half of rows
                } else {
                    rEnd = mid;   // target in upper half of rows
                }
            }

            // Now we have two rows: rStart and rStart + 1
            // Check middle column of both rows first
            if (matrix[rStart][cMid] == target) {
                return new int[]{rStart, cMid};
            }
            if (matrix[rStart + 1][cMid] == target) {
                return new int[]{rStart + 1, cMid};
            }

            // Search in 4 partitions:
            // 1) left part of rStart
            if (target <= matrix[rStart][cMid - 1]) {
                return binarySearch(matrix, rStart, 0, cMid - 1, target);
            }
            // 2) right part of rStart
            if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
                return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
            }
            // 3) left part of rStart+1
            if (target <= matrix[rStart + 1][cMid - 1]) {
                return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
            }
            // 4) right part of rStart+1
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }

        // Binary search inside one row between columns cStart and cEnd (inclusive)
        static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
            while (cStart <= cEnd) {
                int mid = cStart + (cEnd - cStart) / 2;
                if (matrix[row][mid] == target) {
                    return new int[]{row, mid};
                }
                if (matrix[row][mid] < target) {
                    cStart = mid + 1;
                } else {
                    cEnd = mid - 1;
                }
            }
            return new int[]{-1, -1};
        }
    }

