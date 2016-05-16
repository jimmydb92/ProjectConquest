﻿﻿using UnityEngine;
using System.Collections;

public class Node : IHeapItem <Node>{

	public bool walkable;
	public Vector3 gridPos;
	public int gridX;
	public int gridY;

	public int gCost;
	public int hCost;
	public Node parent;
	int heapIndex;


	public Node(bool _walkable, Vector3 _gridPos, int _gridX, int _gridY)
	{
		walkable = _walkable;
		gridPos = _gridPos;
		gridX = _gridX;
		gridY = _gridY;
	}
	public int fCost
	{
		get
		{
			return gCost + hCost;
		}
	}
	public int HeapIndex{
		get{
			return heapIndex;
		}
		set{
			heapIndex = value;
		}
	}

	public int CompareTo(Node nodeToCompare){
		int compare = fCost.CompareTo (nodeToCompare.fCost);
		if (compare == 0) {
			compare = hCost.CompareTo (nodeToCompare.hCost);
		}
		return -compare;
	}
}