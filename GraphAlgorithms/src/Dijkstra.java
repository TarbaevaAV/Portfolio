import java.util.*;

public class Dijkstra {
    PriorityQueue<Vertex> query;  //хранение вершин, которые сортируются по расстоянию
    List<Vertex> altWayVertex;

    HashMap<String, Double[]> loadEdgesOfTime;

    public Dijkstra() {
        this.query = new PriorityQueue<>();
        this.altWayVertex = new ArrayList<>();
        this.loadEdgesOfTime = new HashMap<>();
    }
    public void computeStatic(Vertex source){

        source.setDistance(0);
        query.add(source);

        while(!query.isEmpty()){
            Vertex curr = query.poll();  //берем текущую вершину
            for(Edge e : curr.getNeighbours()){
                Vertex end = e.getEnd();
                double w = e.getWeight();

                if(!end.isVisited()){ //если еще не был в вершине
                    if(curr.getDistance() + w < end.getDistance()){
                        end.setDistance(curr.getDistance() + w);
                        if (query.contains(end)){
                            query.remove(end);
                        }
                        query.add(end);
                        end.setPred(curr);
                    }
                }
            }
            curr.setVisited(true);
        }
    }

    public void computeWithRestriction(Vertex source, double maxK2){
        source.setDistance(0);
        source.setDistance2(0);
        query.add(source);
        while(!query.isEmpty()){
            Vertex curr = query.poll();  //берем текущую вершину
            for(Edge e : curr.getNeighbours()){
                Vertex end = e.getEnd();
                double w1 = e.getK1();
                double w2 = e.getK2();
                System.out.print(e + " ");
                if(!end.isVisited()){ //если еще не был в вершине
                    if (curr.getDistance2()+w2 < maxK2){  //если не превышает ограничение
                        if(((curr.getDistance()+w1 < end.getDistance())
                                && (curr.getDistance2()+w2 > end.getDistance2()))
                                || ((curr.getDistance2()+w2 < end.getDistance2()))
                        ){
                            end.setDistance(curr.getDistance() + w1);
                            end.setDistance2(curr.getDistance2() + w2);
                            if (query.contains(end)){query.remove(end);}
                            query.add(end);
                            end.setPred(curr);
                        }
                    }
                }
            }
            curr.setVisited(true);
        }
    }



    public void computeDinamic(Vertex source, int currHour){
        source.setDistance(0);
        source.setTime(currHour); //в начальной вершине устанавливаем начальное время
        query.add(source);

        while(!query.isEmpty()){
            Vertex curr = query.poll();  //берем текущую вершину
            for(Edge e : curr.getNeighbours()){
                Vertex end = e.getEnd();
                //определяем установленное время в текущей вершине
                currHour = (int)curr.getTime();
                if (currHour>23){
                  currHour=0;
                }
                double w = e.getWeightOfTime(currHour); //по времени вычисляем для ребра вес
                double t = e.getTimeOfEdge(currHour);  //по времени вычисляем для ребра время в пути
                if(!end.isVisited()){ //если еще не были в вершине
                    if(curr.getDistance() + w < end.getDistance()){
                        end.setDistance(curr.getDistance() + w);
                        end.setTime(curr.getTime() + t);
                        if (query.contains(end)){
                            query.remove(end);
                        }
                        query.add(end);
                        end.setPred(curr);
                    }
                }
            }
            curr.setVisited(true);
        }
    }

    public void showPath(Vertex end){
        while(end != null){
            System.out.print(end.getName() + " ");
            end = end.getPred();
        }

    }
}
