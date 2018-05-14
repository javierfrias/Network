package com.upwork.network;

public class NetworkValidator {

	public static boolean  inputValidation(Integer size) {
		if (size < 0){
			return false;
		}
		return true;
	}

	public static boolean  inputValidation(Integer first, Integer second) {
		if (first < 0 || second <0){
			return false;
		}
		return true;
	}

	public static boolean isNetworkAvailableForNode(Network network) {
		if(network.getNodeSet().size()<network.getSize()) {
			return true;
		}
		return false;
	}
}
