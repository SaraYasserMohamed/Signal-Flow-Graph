package application.Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import application.graph.*;

public class LoopsDetctor {
	
	private Stack<Integer> path = new Stack<Integer>();
	
	public List<Integer[]> findLoops(Graph graph) {
		
		List<Integer[]> loops = new ArrayList<Integer[]>();
		
		for (BasicNode Bnode : graph.getGraph()) {
			for(Node node : Bnode.getNodes()) {
				
				HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
				path.clear();
				
				visited.put(Bnode.getId(), 0);
				path.add(Bnode.getId());
				
				traverse(node, Bnode.getId(), visited, graph, loops);
			}
		}
		//sort(loops);
		for(Integer[] list : loops) {
			System.out.println(Arrays.toString(list));
		}
		
		return loops;
	}
	
	private void traverse(Node current, int startID, HashMap<Integer, Integer> visited, Graph graph, List<Integer[]> loops)  {
		
		if(current.getId() == startID) {
			path.add(current.getId());
			loops.add(path.toArray(new Integer[path.size()]));
			path.pop();
			return;
		}
		if(visited.containsKey(current.getId())) return;
		
		BasicNode currentBasicNode = graph.getGraph().get(current.getId());
		if(currentBasicNode.getNodes().size() == 0) return;
		
		visited.put(current.getId(), 0);
		path.add(current.getId());
		
		for(Node node : currentBasicNode.getNodes()) {
			traverse(node, startID, visited, graph, loops);
		}
		visited.remove(current.getId());
		path.pop();
	}
	
	public void sort(List<Integer[]> loops) {
		for(Integer[] list : loops) {
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
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		LoopsDetctor m = new LoopsDetctor();
		
		Graph graph = m.makeGraph();
		List<Integer[]> loops = m.findLoops(graph);
		
		loops.toString();
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
		
		graph.addNode(0, 1, "1");
		graph.addNode(1, 6, "G4");
		graph.addNode(2, 3, "G1");
		graph.addNode(3, 4, "G2");
		graph.addNode(4, 3, "-H1");
		graph.addNode(4, 2, "H1");
		graph.addNode(4, 5, "G3");
		graph.addNode(5, 3, "-H2");
		graph.addNode(5, 6, "1");
		graph.addNode(6, 7, "1");
		
		return graph;
	}
}
