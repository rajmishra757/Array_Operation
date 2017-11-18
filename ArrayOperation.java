public class ArrayOperation {
    private static int[][] masterArray;
    private static int[][] childArray;
    private static String[][] indices;
    private static boolean flag = false;
    
    public static void main(String args[]) {
        setArray();
        System.out.println("Master Array: ");
        printArray(masterArray);
        System.out.println("Child Array: ");
        printArray(childArray);
        locateChild();
        if(flag) {
            System.out.println("Child exists at following indices: ");
            for(int i = 0; i < indices.length; i++) {
                for(int j = 0; j < indices[i].length; j++) {
                    System.out.print(indices[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else
            System.out.println("Child does not exist");
    }
    
    private static void setArray() {
        int[][] master = {
            {7, 2, 8, 3, 4, 5, 5, 8, 6, 4},
            {6, 7, 3, 1, 1, 5, 8, 6, 1, 9},
            {8, 9, 8, 8, 2, 4, 2, 6, 4, 3},
            {3, 8, 3, 9, 5, 0, 5, 3, 2, 4},
            {9, 5, 0, 9, 5, 0, 5, 8, 1, 3},
            {3, 8, 4, 3, 8, 4, 5, 3, 8, 4},
            {6, 4, 7, 3, 5, 3, 0, 2, 9, 3},
            {7, 0, 5, 3, 1, 0, 6, 6, 0, 1},
            {0, 8, 3, 4, 2, 8, 2, 9, 5, 6},
            {4, 6, 0, 7, 9, 2, 4, 1, 3, 7}
        };
        
        int[][] child = {
            {9, 5, 0},
            {3, 8, 4},
            {3, 5, 3}
        };
        
        masterArray = master;
        childArray = child;
        indices = new String[child.length][child.length];
    }
    
    private static void printArray(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    private static void locateChild() {
        parentTester:
        for(int i = 0; i <= masterArray.length - childArray.length; i++) {
            for(int j = 0; j <= masterArray[i].length - childArray.length; j++) {
                tester:
                for(int x = 0; x < childArray.length; x++) {
                    for(int y = 0; y < childArray[x].length; y++) {
                        if(childArray[x][y] == masterArray[i + x][j + y]) {
                            indices[x][y] = "(" + (i +x) + ", " + (j + y) + ")";
                            flag = true;   
                        }
                        else {
                            flag = false;
                            break tester;   
                        }
                    }
                }
                
                if(flag)
                    break parentTester;
            }
        }
    }
}
