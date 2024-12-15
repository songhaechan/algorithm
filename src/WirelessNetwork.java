import java.util.*;

public class WirelessNetwork {

    static class Point {
        int id;
        int x, y, z;

        public Point(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance(Point other) {
            return Math.sqrt(
                Math.pow(this.x - other.x, 2) +
                    Math.pow(this.y - other.y, 2) +
                    Math.pow(this.z - other.z, 2)
            );
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of points
        double r = 10.0; // Propagation range

        List<Point> points = Arrays.asList(
            new Point(0, 0, 0, 0),
            new Point(1, 0, 0, 0),
            new Point(2, 5, 5, 5),
            new Point(3, 5, 5, 5),
            new Point(4, 20, 20, 20)
        );

        // Initialize Union-Find
        UnionFind uf = new UnionFind(n);

        // Connect points within range r
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (points.get(i).distance(points.get(j)) <= r) {
                    uf.union(i, j);
                }
            }
        }

        // Group points by their root parent
        Map<Integer, List<Integer>> partitions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            partitions.putIfAbsent(root, new ArrayList<>());
            partitions.get(root).add(i);
        }

        // Print results
        System.out.println("Number of wireless networks: " + partitions.size());
        int partitionId = 1;
        for (Map.Entry<Integer, List<Integer>> entry : partitions.entrySet()) {
            System.out.println("Network " + partitionId + ": " + entry.getValue());
            partitionId++;
        }
    }
}
