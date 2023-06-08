import model.Graph;
import model.Persistence;
import pojo.Edge;
import pojo.Node;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Graph<Integer> graph = new Graph<>();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addEdge(new Edge<>(graph.getNodes().get(0), graph.getNodes().get(1), 1,Edge.ORIENTED));
        graph.addEdge(new Edge<>(graph.getNodes().get(0), graph.getNodes().get(2),2, Edge.NO_ORIENTED));
        graph.addEdge(new Edge<>(graph.getNodes().get(1), graph.getNodes().get(2),  3,Edge.BIDIRECTIONAL));
//        for (Node<Integer> node : graph.getNodes()) {
//            System.out.println("Node: " + node.getInformation());
//            for (Edge<Integer> edge : node.getEdges()) {
//                System.out.println("  Edge: " + edge.getSource().getInformation() + " -> " + edge.getDestination().getInformation() + " (weight: " + edge.getWeight() + ")");
//            }
//        }

        System.out.println(graph);
        ArrayList<Graph> graphs = new ArrayList<>();
        graphs.add(graph);
        Persistence persistence = new Persistence();
        persistence.loadData(graphs);

    }
}