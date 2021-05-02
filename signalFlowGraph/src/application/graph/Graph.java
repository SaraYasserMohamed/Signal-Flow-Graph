package application.graph;

import java.util.ArrayList;

public class Graph {
	private ArrayList<BasicNode> graph;
	public Graph() {
		graph = new ArrayList<BasicNode>();
	}
	public void addNewBasicNode(int id) {
		graph.add(new BasicNode(id));
	}
	public void addNode(int BasicNodeID , int NodeID ,String gain) {
		graph.get(BasicNodeID).AddnewNode(new Node(NodeID,gain));
	}
	public String getGain (int BasicNodeID,int NodeID) {
		return graph.get(BasicNodeID).getNode(NodeID).getGain();
	}
	public ArrayList<BasicNode> getGraph() {
		return graph;
	}
}
