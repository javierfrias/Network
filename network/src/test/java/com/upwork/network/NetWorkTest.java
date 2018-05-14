package com.upwork.network;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NetWorkTest {

	private Network network;
	
	@Before
	public void setUp() {
		network = new  Network(8);
		network.addNodeToNetwork(new Node(1));
		network.addNodeToNetwork(new Node(2));
		network.addNodeToNetwork(new Node(3));
		network.addNodeToNetwork(new Node(4));
		network.addNodeToNetwork(new Node(5));
		network.addNodeToNetwork(new Node(6));
		network.addNodeToNetwork(new Node(7));
		network.addNodeToNetwork(new Node(8));
	}

	@Test
    public void testConnectAndQuery() {	
		network.connect(1, 6);
		network.connect(1, 2);
		network.connect(6, 2);
		network.connect(2, 4);
		network.connect(5, 8);
		assertTrue(network.query(1, 6));
		assertTrue(network.query(6, 4));
		assertTrue(network.query(1, 2));
		assertFalse(network.query(7, 4));
		assertFalse(network.query(5, 6));
    }
	
	@Test
    public void testConnectAndQuery2() {
		network.connect(1, 6);
		network.connect(1, 2);
		network.connect(2, 4);
		network.connect(5, 8);
		network.connect(6, 8);
		assertTrue(network.query(1, 8));
	}
	
	@Test
    public void testConnectAndQuery3() {
		network.connect(1, 6);
		network.connect(6, 2);
		network.connect(2, 4);
		network.connect(4, 5);
		network.connect(5, 8);
		assertTrue(network.query(1, 8));
	}
	
	@Test
    public void testConnectAndQuery4() {
		network.connect(1, 6);
		network.connect(6, 2);
		network.connect(2, 4);
		network.connect(5, 8);
		assertFalse(network.query(1, 8));
	}
	
	@Test
    public void testConnectAndQuery5() {
		network.connect(1, 6);
		network.connect(1, 2);
		network.connect(2, 4);
		network.connect(2, 5);
		network.connect(5, 8);
		assertTrue(network.query(1, 8));
	}
	
	@Test
    public void testConnectAndQuery6() {
		network.connect(1, 6);
		network.connect(6, 2);
		network.connect(2, 4);
		network.connect(4, 6);
		network.connect(5, 8);
		assertTrue(network.query(1, 4));
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void negativeArgument() {	
		network = new  Network(-8);
    }
	
	@Test(expected = NetWorkException.class)
    public void netWorkFullOver() {	
		network.addNodeToNetwork(new Node(9));
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void connectNegativeValues() {	
		network.connect(-3,-4);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void connectValuesNotFound() {	
		network.connect(100,200);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void queryValuesNotFound() {	
		network.query(100,200);
    }
}