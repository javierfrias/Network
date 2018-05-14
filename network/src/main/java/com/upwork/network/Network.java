package com.upwork.network;

import java.util.HashMap;
import java.util.Map;

public class Network {

	private Integer size;
	private Map<Integer,Node> nodeSet;

	public Network(Integer amountElements){
		if (!NetworkValidator.inputValidation(amountElements)){
		      throw new IllegalArgumentException(EnumNetWorkMessages.NETWORK_CONNECT_INPUT_ERROR.toString());
		}
		this.nodeSet = new HashMap<Integer,Node>(amountElements);
		this.size = amountElements;
	}

	public void addNodeToNetwork(Node node) {
		if(!NetworkValidator.isNetworkAvailableForNode(this)) {
		      throw new NetWorkException(EnumNetWorkMessages.NETWORK_FULL_ERROR.toString());
		}
		nodeSet.put(node.getValue(), node);
	}

	public void connect(Integer element1, Integer element2) {
		if (!NetworkValidator.inputValidation(element1, element2)){
		      throw new IllegalArgumentException(EnumNetWorkMessages.NETWORK_CONNECT_INPUT_ERROR.toString());
		}
		if(!(this.nodeSet.isEmpty()) && this.nodeSet.containsKey(element1) && 
				this.nodeSet.containsKey(element2) ) {
			Node first = this.nodeSet.get(element1);
			Node next= this.nodeSet.get(element2);
			first.getConnections().add(next);
		}else {
		      throw new IllegalArgumentException(EnumNetWorkMessages.NETWORK_VALUES_NOT_FOUND_ERROR.toString());
		}
	}

	public boolean query(Integer element1, Integer element2) {
		if (!NetworkValidator.inputValidation(element1, element2)){
		      throw new IllegalArgumentException(EnumNetWorkMessages.NETWORK_QUERY_INPUT_ERROR.toString());
		}
		if (!this.nodeSet.containsKey(element1) && !this.nodeSet.containsKey(element2)){
		      throw new IllegalArgumentException(EnumNetWorkMessages.NETWORK_VALUES_NOT_FOUND_ERROR.toString());
		}
		Node first = this.nodeSet.get(element1);
		Node next= this.nodeSet.get(element2);
		return isConnected(first,next);
	}

	private boolean isConnected(Node first, Node next) {
		boolean result =false;
		for(Node node: first.getConnections()) {
			if(areEquals(node,next)) {
				result = true;
				break;
			}else {
				result = isConnected(node, next);
				if(result) {
					break;
				}
			}
		}
		return result;
	}

	private boolean areEquals(Node first, Node next) {
		if(first.equals(next)) {
			return true;
		}
		return false;
	}

	public Integer getSize() {
		return size;
	}

	public Map<Integer, Node> getNodeSet() {
		return nodeSet;
	}
}
