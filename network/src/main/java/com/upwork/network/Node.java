package com.upwork.network;

import java.util.ArrayList;
import java.util.List;

public class Node{
	
	private List<Node> connections = null;
	private Integer value;

	public Node(Integer value) {
		this.connections = new ArrayList<Node>();
		this.value= value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void addNode(Node node) {
		this.connections.add(node);
	}
	
	public List<Node> getConnections() {
		return connections;
	}

	public void setConnections(List<Node> connections) {
		this.connections = connections;
	}
}
