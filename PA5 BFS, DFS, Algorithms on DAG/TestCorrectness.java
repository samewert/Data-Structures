package PA5;

import java.util.Arrays;

public class TestCorrectness {
    
    static final String UNWEIGHTED_GRAPH1_PATH = "src/PA5/unweighted1.txt";
    static final String UNWEIGHTED_GRAPH2_PATH = "src/PA5/unweighted2.txt";
    static final String UNDIRECTED_GRAPH1_PATH = "src/PA5/undirected1.txt";
    static final String UNDIRECTED_GRAPH2_PATH = "src/PA5/undirected2.txt";
    static final String DAG1_PATH = "src/PA5/dag1.txt";
    static final String DAG2_PATH = "src/PA5/dag2.txt";
    static final String MUTANT1_PATH = "src/PA5/mutant1.txt";
    static final String MUTANT2_PATH = "src/PA5/mutant2.txt";
    static final String MUTANT3_PATH = "src/PA5/mutant3.txt";
    
    private static void testBFS() throws Exception {
        String filePaths[] = { UNWEIGHTED_GRAPH1_PATH, UNWEIGHTED_GRAPH2_PATH };
        for (int i = 0; i < filePaths.length; i++) {
            System.out.printf("*** Test BFS on UnweightedGraph %d ***\n\n", i + 1);
            BFS bfs = new BFS(filePaths[i]);
            for (int j = 0; j < bfs.numVertices; j++) {
                bfs.executeBFS(j);
                System.out.println("Level array (from v" + j + "):   "
                                   + Arrays.toString(bfs.level).replaceAll("" + Integer.MAX_VALUE, "infty"));
            }
            System.out.println();
        }
    }
    
    private static void testComponent() throws Exception {
        String filePaths[] = { UNDIRECTED_GRAPH1_PATH, UNDIRECTED_GRAPH2_PATH };
        for (int i = 0; i < filePaths.length; i++) {
            System.out.printf("*** Test Component Counter on UndirectedGraph %d ***\n\n", i + 1);
            BFS cc = new BFS(filePaths[i]);
            System.out.println("Number of components is " + cc.countComponents());
            System.out.println();
        }
    }
    
    private static void testDFS() throws Exception {
        String filePaths[] = { UNWEIGHTED_GRAPH1_PATH, UNWEIGHTED_GRAPH2_PATH };
        for (int i = 0; i < filePaths.length; i++) {
            System.out.printf("*** Test DFS on UnweightedGraph %d ***\n\n", i + 1);
            DFS dfs = new DFS(filePaths[i]);
            for (int j = 0; j < dfs.numVertices; j++) {
                dfs.executeDFS(j);
                System.out.println("Level array (from v" + j + "):   "
                                   + Arrays.toString(dfs.level).replaceAll("" + Integer.MAX_VALUE, "infty"));
            }
            System.out.println();
        }
    }
    
    private static void testTransitiveClosure() throws Exception {
        
        String filePaths[] = { UNWEIGHTED_GRAPH1_PATH, UNWEIGHTED_GRAPH2_PATH, UNDIRECTED_GRAPH1_PATH,
            UNDIRECTED_GRAPH2_PATH };
        int numFiles = 2;
        for (int i = 0; i < numFiles; i++) {
            System.out.printf("*** Test Transitive Closure on UnweightedGraph %d ***\n\n", i + 1);
            DFS dfs = new DFS(filePaths[i]);
            boolean[][] tc = dfs.computeTransitiveClosure();
            for (int j = 0; j < dfs.numVertices; j++)
                System.out.println(Arrays.toString(tc[j]));
            System.out.println();
            ;
        }
        for (int i = 0; i < numFiles; i++) {
            System.out.printf("*** Test Transitive Closure on UndirectedGraph %d ***\n\n", i + 1);
            DFS dfs = new DFS(filePaths[i + 2]);
            boolean[][] tc = dfs.computeTransitiveClosure();
            for (int j = 0; j < dfs.numVertices; j++)
                System.out.println(Arrays.toString(tc[j]));
            System.out.println();
            ;
        }
    }
    
    private static void testDAG() throws Exception {
        String filePaths[] = { DAG1_PATH, DAG2_PATH };
        for (int i = 0; i < filePaths.length; i++) {
            System.out.printf("*** Test Longest Path on DAG %d ***\n\n", i + 1);
            DAG ag = new DAG(filePaths[i]);
            ag.longestPaths(0);
            System.out.println("Topological Order: " + Arrays.toString(ag.topoOrder));
            for (int j = 0; j < ag.numVertices; j++) {
                ag.longestPaths(j);
                System.out.printf("Longest Path Array (from v%d): %s\n", j,
                                  Arrays.toString(ag.distance).replaceAll("" + Integer.MIN_VALUE, "-infty"));
            }
            System.out.println();
        }
    }
    
    private static void testMutantLanguage() throws Exception {
        String filePaths[] = { MUTANT1_PATH, MUTANT2_PATH, MUTANT3_PATH };
        for (int i = 0; i < filePaths.length; i++) {
            System.out.printf("*** Test Mutant Language %d ***\n\n", i + 1);
            MutantLanguage mutant = new MutantLanguage(filePaths[i]);
            char topoOrder[] = mutant.getOrder();
            if (topoOrder != null)
                System.out.println("Alphabet order: " + Arrays.toString(topoOrder));
            else
                System.out.println("Unfortunately, this language has circular dependency.");
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws Exception {
        testBFS();
        testComponent();
        testDFS();
        testTransitiveClosure();
        testDAG();
        testMutantLanguage();
    }
}
