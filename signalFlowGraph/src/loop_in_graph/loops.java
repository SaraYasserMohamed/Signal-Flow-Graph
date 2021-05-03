package loop_in_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import application.graph.BasicNode;
import application.graph.Graph;
import application.graph.Node;

public class loops {
	
	public static List<List<BasicNode>> loop_list=new LinkedList<>();
	private static Graph helper ;
	
	public static List<List<BasicNode>> Cycles(Graph graph) {
		helper=graph;
		List<BasicNode>whiteSet=new LinkedList<>();
		List<BasicNode>graySet=new LinkedList<>();
		List<BasicNode>blackSet=new LinkedList<>();
		
		for (BasicNode vertex : graph.getGraph()) {
            whiteSet.add(vertex);
        }
		
		for (int i = 0; i < whiteSet.size(); i++) { 
			BasicNode current = whiteSet.get(i);
            //System.out.print(current.getId() + " ");
            
            if(dfs(current, whiteSet, graySet, blackSet)){
            	for (BasicNode vertex : graySet) {
                    System.out.println(vertex.getId());
                }
            	break;
            }
        }

		return loop_list;
	}
	
	
	 private static boolean dfs(BasicNode current, List<BasicNode> whiteSet, List<BasicNode> graySet,List<BasicNode> blackSet) {
		 
		moveVertex(current, whiteSet, graySet);
		/*for (BasicNode vertex : whiteSet) {
			System.out.print(vertex.getId() + " ");
        }
		System.out.print("\n");*/
		
		ArrayList<Node> nodes =current.getNodes();
		List<BasicNode>current_neighbors=new LinkedList<>();
		List<BasicNode>graph_basicnodes=helper.getGraph();
		//System.out.println("nodes size="+nodes.size());
		for (Node n : nodes) {
			current_neighbors.add(graph_basicnodes.get(n.getId()));
		}
		
		/*for (BasicNode vertex : current_neighbors) {
			System.out.print(vertex.getId() + " ");
        }
		
		System.out.print("\n");*/
		
        for(BasicNode neighbor : current_neighbors) {
            //if in black set means already explored so continue.
            if (blackSet.contains(neighbor)) {
                continue;
            }
            //if in gray set then cycle found.
            if (graySet.contains(neighbor)) {
                return true;
            }
            if(dfs(neighbor, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        //move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);
        return false;
	 }

	private static void moveVertex(BasicNode current, List<BasicNode> sourceSet, List<BasicNode> destinationSet) {
		// TODO Auto-generated method stub
		sourceSet.remove(current);
		destinationSet.add(current);
	}


	public static void main(String args[]){
		 Graph graph1 =new Graph();
		 graph1.addNewBasicNode(0); 
		 graph1.addNewBasicNode(1);
		 graph1.addNewBasicNode(2);
		 graph1.addNewBasicNode(3);
		 graph1.addNewBasicNode(4);
		 graph1.addNewBasicNode(5);
		 graph1.addNewBasicNode(6);
		 graph1.addNode(0, 1, "5");
		 graph1.addNode(0, 2, "5");
		 graph1.addNode(1, 2, "5");
		 graph1.addNode(2, 1, "5");
		 graph1.addNode(3, 4, "5");
		 graph1.addNode(4, 5, "5");
		 graph1.addNode(5, 3, "5");
		 graph1.addNode(6, 6, "5");
		 Cycles(graph1);
	 }
	
}
