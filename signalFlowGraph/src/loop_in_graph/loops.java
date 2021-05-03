package loop_in_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import application.graph.*;

public class loops {
	public static void main(String[] args) {
		loops m = new loops();
		
		Graph graph = m.makeGraph();
		List<String[]> loops = m.findLoops(graph);
		
		System.out.println(loops.toString());
	}
	
	private Stack<String> path = new Stack<String>();
	
	public List<String[]> findLoops(Graph graph) {
		
		List<String[]> loops = new ArrayList<String[]>();
		
		for (BasicNode Bnode : graph.getGraph()) {
			for(Node node : Bnode.getNodes()) {
				
				HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
				path.clear();
				
				visited.put(Bnode.getId(), 0);
				traverse(node, Bnode.getId(), visited, graph, loops);
			}
		}
		sort(loops);
		return loops;
	}
	
	public void sort(List<String[]> loops) {
		for(String[] list : loops) {
			Arrays.sort(list);
		}
		for(int i=0 ; i<loops.size();i++) {
			for(int j=i+1 ; j<loops.size();j++) {
				if(Arrays.equals(loops.get(i),loops.get(j))) {
					loops.remove(j);
					j--;
				}
			}
		}
		for(String[] list : loops) {
			System.out.println(Arrays.toString(list));
		}
	}
	
	private void traverse(Node current, int startID, HashMap<Integer, Integer> visited, Graph graph, List<String[]> loops)  {
		
		if(current.getId() == startID) { 
			path.add(current.getGain());
			loops.add(path.toArray(new String[path.size()]));
			path.pop();
			return;
		}
		if(visited.containsKey(current.getId())) return;
		
		BasicNode currentBasicNode = graph.getGraph().get(current.getId());
		if(currentBasicNode.getNodes().size() == 0) return;
		
		visited.put(current.getId(), 0);
		path.add(current.getGain());
		
		for(Node node : currentBasicNode.getNodes()) {
			traverse(node, startID, visited, graph, loops);
		}
		visited.remove(current.getId());
		path.pop();
	}
	
	private Graph makeGraph() {
		Graph graph = new Graph();
		
		graph.addNewBasicNode(0);
		graph.addNewBasicNode(1);
		graph.addNewBasicNode(2);
		graph.addNewBasicNode(3);
		graph.addNewBasicNode(4);
		graph.addNewBasicNode(5);
		graph.addNewBasicNode(6);
		graph.addNewBasicNode(7);
		
		graph.addNode(0, 1, "G1");
		graph.addNode(1, 2, "G2");
		graph.addNode(2, 1, "-H1");
		graph.addNode(2, 3, "G3");
		graph.addNode(3, 4, "G4");
		graph.addNode(4, 3, "-H2");
		graph.addNode(4, 5, "G5");
		graph.addNode(5, 6, "G6");
		graph.addNode(6, 7, "G7");
		graph.addNode(7, 6, "-H4");
		graph.addNode(7, 1, "G8");
		
		return graph;
	}
}