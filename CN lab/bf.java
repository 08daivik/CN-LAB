import java.util.*;

public class bf{
    private static int N;
    private static int graph[][];

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        N=sc.nextInt();
        System.out.println("Enter the weight of the matrix");
        graph=new int[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                graph[i][j]=sc.nextInt();
        System.out.println("Enter source vertex");
        int source=sc.nextInt();
        bellmanford(source-1);
        sc.close();
    }

    public static void bellmanford(int source){
        int dist[]=new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        for(int i=0;i<N;i++){
            for(int u=0;u<N;u++){
                for(int v=0;v<N;v++){
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                        dist[v]=dist[u]+graph[u][v];
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int u=0;u<N;u++){
                for(int v=0;v<N;v++){
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                        System.out.println("Negative cycle detected");
                        return;
                    }
                }
            }
        }

        print(dist);
    }

    public static void print(int dist[])
    {
        System.out.println("Vertex\tDistance from source");
        for(int i=0;i<N;i++)
            System.out.printf("%d\t%d\n",i+1,dist[i]);
    }
}