
//Método que recibe una lista y devuelve el elemento mínimo
public static int  minimum(ArrayList<Integer> way)
{
        int i,position=0;
        int minimum=way.get(0);

        for (i=0;i<way.size();i++ ) {
            if(way.get(i)<minimum){
                minimum=way.get(i);;
            }
        }
        return minimum;
}



//Método BFS implementación tomada de roettacode
    ArrayList<Integer> BFS(int s) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        ArrayList<Integer> way= new ArrayList<Integer>();
        boolean visited[] = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            way.add(s);
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
        return way;
    } 

// Método principal que inicializa el grafo 
public static void main(String args[]) 
    { 
        int V=6;
        int [] w={2,3,6,1,4,5};
        ArrayList<Integer> cost= new ArrayList<Integer>();
        ArrayList<Integer> way;
        Graph g = new Graph(V); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(2, 4); 
        g.addEdge(2, 5); 
        g.addEdge(3, 4); 
        g.addEdge(3, 5);

        for (int i=0;i<V ;i++ ) {
            //Se calcula el BFS de cada nodo
            way= g.BFS(i);
            replace(way,w);
            //Se busca el vertice de menor valor
            cost.add(minimum(way));
        }
         

        for (int i=0;i<cost.size();i++ ) {
            System.out.println(i+":"+ cost.get(i));
        }           
    }
