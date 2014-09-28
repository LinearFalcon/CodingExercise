package edu.nyu.liangfang.leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// definition of graph
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

/*
 * Attention: nodes can have itself in neighbors list, meaning self circle
 * And there could be more than 1 edges between two nodes
 */

public class cloneGraph {
	
	// my solution
	public UndirectedGraphNode cloneGraphSol(UndirectedGraphNode node) {
        if (node == null)
            return null;
        
        Queue<UndirectedGraphNode> oldQ = new LinkedList<UndirectedGraphNode>();	// old queue is used for BFS traversal
        Queue<UndirectedGraphNode> newQ = new LinkedList<UndirectedGraphNode>();	// new queue stores new nodes during BFS traversal
        
        // hashtable stores nodes already created for clone graph, avoiding creating nodes repeatedly
        Hashtable<Integer, UndirectedGraphNode> hashtable = new Hashtable<Integer, UndirectedGraphNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        oldQ.add(node);
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        newQ.add(start);
        visited.add(node.label);
        hashtable.put(start.label, start);
        
        while (!oldQ.isEmpty()) {
            UndirectedGraphNode old = oldQ.poll();
            UndirectedGraphNode newNode = newQ.poll();
            for (UndirectedGraphNode oldNeighbor : old.neighbors) {                
                if (oldNeighbor.label == old.label) {
                    newNode.neighbors.add(newNode);
                    continue;
                }
                
                UndirectedGraphNode newNeighbor;
                if (!visited.contains(oldNeighbor.label)) {
                    newNeighbor = new UndirectedGraphNode(oldNeighbor.label);
                    oldQ.add(oldNeighbor);
                    newQ.add(newNeighbor);
                    
                    visited.add(oldNeighbor.label);
                    hashtable.put(newNeighbor.label, newNeighbor);
                } else {
                    newNeighbor = hashtable.get(oldNeighbor.label);		// if visited, means we already created the node, so just get from hashtable
                } 
                newNode.neighbors.add(newNeighbor);
            }
        }
        return start;
    }
	
	// clean solution
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null)
            return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        map.put(node, start);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode old = queue.poll();
            for (UndirectedGraphNode oldNeighbor : old.neighbors) {
                if (!map.containsKey(oldNeighbor)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(oldNeighbor.label);
                    queue.add(oldNeighbor);
                    map.put(oldNeighbor, copy);
                    map.get(old).neighbors.add(copy);
                } else {
                    map.get(old).neighbors.add(map.get(oldNeighbor));
                } 
            }
        }
        return start;
    }
}	
