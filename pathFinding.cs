using UnityEngine;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;

public class pathFinding : MonoBehaviour {
	public Transform seeker, target;

	gridLayOut grid;

	void Awake()
	{
		grid = GetComponent<gridLayOut>();
	}

	void Update()
	{
		//if (Input.GetButtonDown ("Jump")) {//if you want more iterations from space bar
			FindPath (seeker.position, target.position);
		//}
	}

	void FindPath(Vector3 startPos, Vector3 targetPos)
	{
		Stopwatch sw = new Stopwatch ();
		sw.Start ();

		Node startNode = grid.NodeFromgridPos(startPos);
		Node targetNode = grid.NodeFromgridPos(targetPos);

		Heap<Node> openSet = new Heap<Node>(grid.MaxSize);
		HashSet<Node> closedSet = new HashSet<Node>();

		openSet.Add(startNode);

		while (openSet.Count > 0)
		{
			Node currentNode = openSet.RemoveFirst ();
			closedSet.Add(currentNode);

			if (currentNode == targetNode)
			{
				sw.Stop ();
				print ("Path found: " + sw.ElapsedMilliseconds + " ms");
				returnPath (startNode, targetNode);
				return;
			}

			foreach (Node neighbor in grid.getNeighbors(currentNode))
			{
				if (!neighbor.walkable || closedSet.Contains(neighbor))
				{
					continue;
				}
				int newMovementCostToNeighbor = currentNode.gCost + getDistance(currentNode, neighbor);
				if(newMovementCostToNeighbor<neighbor.gCost || !openSet.Contains(neighbor))
				{
					neighbor.gCost = newMovementCostToNeighbor;
					neighbor.hCost = getDistance(neighbor, targetNode);
					neighbor.parent = currentNode;

					if (!openSet.Contains (neighbor)) {
						openSet.Add (neighbor);
					} else
						openSet.UpdateItem (neighbor);
				}
			}
		}
	}

	void returnPath(Node startNode, Node endNode)
	{
		List<Node> path = new List<Node>();
		Node currentNode = endNode;

		while(currentNode != startNode)
		{
			path.Add(currentNode);
			currentNode = currentNode.parent;

		}
		path.Reverse();

		grid.path = path;
	}
	int getDistance(Node node1, Node node2){
		int distX = Mathf.Abs(node1.gridX - node2.gridX);
		int distY = Mathf.Abs(node1.gridY - node2.gridY);

		if (distX < distY)
		{
			return 14*distY +10*(distX-distY);
		}
		else      
			return 14 * distX + 10 * (distY - distX);
	}
}

