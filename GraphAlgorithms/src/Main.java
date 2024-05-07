import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import javax.swing.JFrame;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Vertex vA = new Vertex("A");
        Vertex vB = new Vertex("B");
        Vertex vC = new Vertex("C");
        Vertex vD = new Vertex("D");
        Vertex vE = new Vertex("E");
        Vertex vF = new Vertex("F");
        Vertex vG = new Vertex("G");
        Vertex vH = new Vertex("H");

        vA.addNeighbour(new Edge(vA,vB,4,5,0.5));
        vA.addNeighbour(new Edge(vA,vE,8,9, 0.3));
        vB.addNeighbour(new Edge(vB,vH,4, 5, 0.1));
        vB.addNeighbour(new Edge(vB,vC,12,9,0.4));
        vB.addNeighbour(new Edge(vB,vD,15, 12, 0.2));
        vC.addNeighbour(new Edge(vC,vD,3, 5, 0.6));
        vC.addNeighbour(new Edge(vC,vG,11, 12,0.4));
        vD.addNeighbour(new Edge(vD,vG,9, 11 , 0.8));
        vE.addNeighbour(new Edge(vE,vH,5, 10, 0.2));
        vE.addNeighbour(new Edge(vE,vF,4,5,0.6));
        vE.addNeighbour(new Edge(vE,vG,20, 18, 0.2));
        vF.addNeighbour(new Edge(vF,vC,1,5,0.3));
        vF.addNeighbour(new Edge(vF,vG,13, 12, 0.1));
        vH.addNeighbour(new Edge(vH,vC,7,9,0.4));
        vH.addNeighbour(new Edge(vH,vF,6,5,0.3));

        Dijkstra algorithm = new Dijkstra();
        algorithm.computeStatic(vA);
        System.out.println(vG.printDistance());
        algorithm.showPath(vG);



    }



}