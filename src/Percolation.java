import java.util.Arrays;

public class Percolation {

    private final int topTree;
    private final int bottomTree;

    private final boolean closed = false;
    private final boolean open = true;

    private final QuickUnion quickUnion;

    private boolean[][] sites;
    int size;
    private int openSites;

    public Percolation(int N){

        if (N <= 0){
            throw new IllegalArgumentException("Grid size must be greater than 0.");
        }

        this.size = N;
        this.openSites = 0;
        this.sites = new boolean[size][size];

        this.quickUnion = new QuickUnion(N * N + 2);

        this.topTree = N * N;
        this.bottomTree = N * N + 1;

        for (int i = 0; i < N; i++) {
            for (int j =0; j < N; j++){
                sites[i][j] = closed;
            }
        }
    }
    public void open(int index){

        int row = index / size;
        int col = index % size;

        sites[row][col] = open;
        openSites++;

        if (row == 0){
            quickUnion.union(index, topTree);
        }

        if (row == size - 1){
            quickUnion.union(index, bottomTree);
        }

        //top
        if (isValidIndex(row - 1, col) && isOpen(row - 1, col)) {
            quickUnion.union(index, get1DIndex(row - 1, col));
        }

        //bottom
        if (isValidIndex(row + 1, col) && isOpen(row + 1, col)) {
            quickUnion.union(index, get1DIndex(row + 1, col));
        }

        //left
        if (isValidIndex(row, col - 1) && isOpen(row, col - 1)) {
            quickUnion.union(index, get1DIndex(row, col - 1));
        }

        //right
        if (isValidIndex(row, col + 1) && isOpen(row, col + 1)) {
            quickUnion.union(index, get1DIndex(row, col + 1));
        }

    }
    private int get1DIndex(int row, int col) {
        return (row) * size + col;
    }
    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row <= size - 1 && col >= 0 && col <= size - 1;
    }
    public boolean isOpen(int row, int col){
        return sites[row][col] == open;
    }
    public boolean isFull(int row, int col){
        return quickUnion.isConnected(get1DIndex(row, col), topTree);
    }
    public boolean isClosed(int row, int col){
        return sites[row][col] == closed;
    }
    public boolean isPercolated(){
        return quickUnion.isConnected(topTree, bottomTree);
    }
    public int numberOfOpenSites(){
        return openSites;
    }
    private String getRepresentation(int row, int column){

        if(isClosed(row, column)){
            return "\u274C";
        }

        if(!isFull(row, column)){
            return "\u274E";
        }

        return "\u2705";
    }
    public void printPercolation(){
        for (int i = 0; i < sites.length; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                System.out.print(getRepresentation(i,j));
            }
            System.out.println();
        }
    }
}
