package Week12;
// import java.util.*;

public class Main {

   public static void main(String[] args) {
   
       System.out.println("Part 1: The Graph With Adjacency Matrix:");
       String [] label = {"A", "B", "C", "D"};
       Graph g = new Graph(4, label);
       g.addEdge(0,1);
       g.addEdge(0,2);
       g.addEdge(1,3);
       g.addEdge(2,3);
       
       System.out.println(g);
       
       System.out.println("Part 2: The Graph With Adjacency List:");
       GraphM g2 = new GraphM();
       
       g2.addEdge("A","B");
       g2.addEdge("A","C");
       g2.addEdge("A","D");
       g2.addEdge("A","F");
       g2.addEdge("B","C");
       g2.addEdge("B","D");
       g2.addEdge("B","E");
       g2.addEdge("C","E");
       g2.addEdge("C","F");
       g2.addEdge("C","G");
       g2.addEdge("D","E");
       g2.addEdge("F","G");
       
       System.out.println(g2);
       
       System.out.println("Part 3: Graph Traversal Algorithms:");
       
       System.out.println("DFS:");
       g2.dfs("A");
       
       System.out.println(" ");
       
       
       System.out.println("BFS:");
       g2.bfs("B");
       
       System.out.println();
       System.out.println("Part 4: Graph Traversal Algorithms:");
       
       GraphM g3 = new GraphM();
       g3.addEdge("A","C");
       g3.addEdge("A","B");
       g3.addEdge("A","D");
       g3.addEdge("C","D");
       
       g3.addEdge("B","D");
       g3.addEdge("B","F");
       g3.addEdge("D","E");
       g3.addEdge("D","G");
       
       g3.addEdge("E","G");
       g3.addEdge("E","F");
       g3.addEdge("F","H");
       g3.addEdge("G","H");
       
       System.out.println("DFS:");
       
       g3.dfs("H");
       System.out.println(" ");
       
       System.out.println("BFS:");
       
       g3.bfs("F");
       System.out.println(" ");
       
       System.out.println();
       System.out.println("Part 5: Graph Traversal Algorithms:");
       GraphM g4 = new GraphM();
       
       g4.addEdge("A","B"); //e1
       g4.addEdge("B","C");
       g4.addEdge("B","D");
       g4.addEdge("B","F"); //e4
       
       g4.addEdge("A","C"); //e5
       g4.addEdge("A","E");
       g4.addEdge("C","E");
       g4.addEdge("C","D"); //e8
       
       g4.addEdge("D","F"); //e9
       g4.addEdge("C","F");
       g4.addEdge("E","F");
       g4.addEdge("F","G"); //e12
       
       g4.addEdge("F","H"); //e13
       g4.addEdge("E","G");
       g4.addEdge("E","I");
       g4.addEdge("G","I"); //e16
       
       g4.addEdge("G","H"); //e17
       g4.addEdge("H","I");
       
       
       
   }
}

