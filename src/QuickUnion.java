public class QuickUnion {
    int id[];
    int sz[];

    public QuickUnion(int N){
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int getRoot(int i){
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean isConnected(int p, int q){
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q){
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);

        if (qRoot == pRoot)
            return;

        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
