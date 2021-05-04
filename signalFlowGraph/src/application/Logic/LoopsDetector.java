package application.Logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import application.graph.*;

public class LoopsDetector {
	
	public Integer[][] findLoops(Graph graph) {
		List<Integer[]> loops = new LinkedList<Integer[]>();
		Stack<Integer> visited = new Stack<Integer>();
		
		for (BasicNode Bnode : graph.getGraph()) {
			for(Node node : Bnode.getNodes()) {
				visited.clear();
				visited.add(Bnode.getId());
				traverse(node, Bnode.getId(), visited, graph, loops);
			}
		}
		return loops.toArray(new Integer[loops.size()][]);
	}
	
	private void traverse(Node current, int startID, Stack<Integer> visited, Graph graph, List<Integer[]> loops)  {
		
		if(current.getId() == startID) {
			if(!isExist(visited, loops))
				loops.add(visited.toArray(new Integer[visited.size()]));
			return;
		}
		if(visited.contains(current.getId())) return;
		
		BasicNode currentBasicNode = graph.getGraph().get(current.getId());
		if(currentBasicNode.getNodes().size() == 0) return;
		
		visited.add(current.getId());
		for(Node node : currentBasicNode.getNodes()) {
			traverse(node, startID, visited, graph, loops);
		}
		visited.pop();
	}
	
	private boolean isExist(List<Integer> path, List<Integer[]> loop) {
		for(Integer[] oldPath : loop) 
		{
			if(path.size() == oldPath.length) {
				List<Integer> checkList = new LinkedList<Integer>();
				
				for(Integer num : oldPath) checkList.add(num);
				for(Integer num : path) checkList.remove(Integer.valueOf(num));
				if(checkList.isEmpty()) return true;
			}
		}
		return false;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		LoopsDetector m = new LoopsDetector();
		
		Graph graph = m.makeGraph();
		Integer[][] loops = m.findLoops(graph);
		
		for(Integer[] list : loops) {
			for(Integer num : list) System.out.print(num +" ");
			System.out.println("");
		}
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
