public class Edge {
    Vertex start;
    Vertex end;
    double weight; //вес ребра
    double k1;
    double k2;

    String name;
    double[] weightOfTime;
    double[] valuesOfTime;

    public Edge(Vertex start, Vertex end, double k1, double k2) {
        this.start = start;
        this.end = end;
        this.k1 = k1;
        this.k2 = k2;
    }


    public Edge(String name,Vertex start, Vertex end, double weight) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Edge(Vertex start, Vertex end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //для статического алгоритма
    public Edge(Vertex start, Vertex end, double w1, double w2, double koef1) {
        this.start = start;
        this.end = end;
        this.weight = w1*koef1 + w2*(1-koef1);
    }

    //для динамического алгоритма
    public Edge(Vertex start, Vertex end, double[] weightOfTime, double[] valuesOfTime) {
        this.start = start;
        this.end = end;
        this.weightOfTime = weightOfTime;
        this.valuesOfTime = valuesOfTime;
    }

    public Edge(Vertex start, Vertex end,
                double[] weightOfTime1, double[] weightOfTime2, double koef1) {
        this.start = start;
        this.end = end;
        this.weightOfTime = new double[24];
        for (int i=0;i<24;i++){
            this.weightOfTime[i] = weightOfTime1[i]*koef1 + weightOfTime2[i]*(1-koef1);
        }
        this.valuesOfTime = weightOfTime2; //массив 2 отвечает за время
    }
    public double getK1(){
        return k1;
    }
    public double getK2(){
        return k2;
    }
    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeightOfTime(int time) {
        return weightOfTime[time];
    }
    public double getTimeOfEdge(int time) {
        return valuesOfTime[time];
    }
    @Override
    public String toString(){
        return (" " + start.getName() + " - " + end.getName());
    }

}
