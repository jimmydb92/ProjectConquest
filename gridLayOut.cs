using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class gridLayOut : MonoBehaviour {

	public bool onlyDisplayPathGizmos;
	Node[,] grid;
	public Vector2 gridLayoutsize;
	public float radius;
	public LayerMask unwalkableMask;
	int gridSizeX, gridSizeY;
	float nodeDiameter;

	void Start()
	{
		nodeDiameter = radius * 2;
		gridSizeX = Mathf.RoundToInt(gridLayoutsize.x / nodeDiameter);
		gridSizeY = Mathf.RoundToInt(gridLayoutsize.y / nodeDiameter);
		CreateGrid();
	}

	public int MaxSize{
		get{
			return gridSizeX * gridSizeY;
		}
	}

	void CreateGrid()
	{
		grid = new Node[gridSizeX, gridSizeY];
		Vector3 layoutBottomLeft = transform.position - Vector3.right * gridLayoutsize.x / 2 - Vector3.forward
			* gridLayoutsize.y / 2;
		for (int x =0; x<gridSizeX; x++)
		{
			for(int y = 0; y < gridSizeY; y++)
			{
				Vector3 gridPoint = layoutBottomLeft + Vector3.right * (x * nodeDiameter + radius) + Vector3.forward * (y * nodeDiameter + radius);
				bool walkable = !(Physics.CheckSphere(gridPoint,radius,unwalkableMask));
				grid[x,y] = new Node(walkable, gridPoint,x , y);
			}
		}
	}

	public List<Node> getNeighbors(Node node)
	{
		List<Node> neighbors = new List<Node>();
		for (int x =-1; x <= 1; x++){
			for(int y = -1; y <= 1; y++)
			{
				if (x == 0 && y == 0)
				{
					continue;
				}
				int checkX = node.gridX + x;
				int checkY = node.gridY + y;

				if(checkX >= 0 && checkX < gridSizeX && checkY>=0 && checkY < gridSizeY)
				{
					neighbors.Add(grid[checkX, checkY]);
				}
			}
		}
		return neighbors;
	}

	public Node NodeFromgridPos(Vector3 gridPos)
	{
		float percentX = (gridPos.x + gridLayoutsize.x / 2) / gridLayoutsize.x;
		float percentY = (gridPos.z + gridLayoutsize.y / 2) / gridLayoutsize.y;
		percentX = Mathf.Clamp01(percentX);
		percentY = Mathf.Clamp01(percentY);

		int x = Mathf.RoundToInt((gridSizeX - 1) * percentX);
		int y = Mathf.RoundToInt((gridSizeY - 1) * percentY);
		return grid[x, y];

	}

	public List<Node> path;


	void OnDrawGizmos()
	{
		Gizmos.DrawWireCube(transform.position,new Vector3(gridLayoutsize.x,1,gridLayoutsize.y));

		if (onlyDisplayPathGizmos) {
			if (path != null) {
				foreach (Node n in path) {
					Gizmos.color = Color.black;
					Gizmos.DrawCube(n.gridPos, Vector3.one * (nodeDiameter-.1f));
				}
			}
		}
		else {

			if (grid != null) {
				foreach (Node n in grid) {
					Gizmos.color = (n.walkable)?Color.white:Color.red;
					if (path != null)
					if (path.Contains(n))
						Gizmos.color = Color.black;
					Gizmos.DrawCube(n.gridPos, Vector3.one * (nodeDiameter-.1f));
				}
			}
		}
	}
}