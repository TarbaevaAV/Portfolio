import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {  //вершина
    String name;
    boolean visited;
    List<Edge> neighbours;
    double distance = Double.MAX_VALUE;
    double distance2 = Double.MAX_VALUE;
    double time = 0;
    Vertex pred = null;
    List<Vertex> predList;
    public Vertex(String name){
        this.name = name;
        neighbours=new ArrayList<Edge>();
        predList = new ArrayList<>();
    }
    public void addNeighbour(Edge edge){
        neighbours.add(edge);

    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getNeighbours() {
        return neighbours;
    }

    public double getDistance() {
        return distance;
    }
    public String printDistance() {
        return String.format("%.3f", distance);
    }
    public double getDistance2() {
        return distance2;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setDistance2(double distance) {
        this.distance2 = distance;
    }

    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        this.time = time;
    }

    public Vertex getPred() {
        return pred;
    }

    public void setPred(Vertex pred) {
        this.pred = pred;
    }

    public int compareTo(Vertex o){
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
