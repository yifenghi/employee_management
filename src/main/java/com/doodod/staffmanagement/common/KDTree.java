package com.doodod.staffmanagement.common;

import java.util.LinkedList;
import java.util.Queue;

public class KDTree {

	private Node root = null;
	private int size = 0;

	//Get node with point closest to the given point by traversing tree
	private Node getClosestNodeOrNull(Point p, Node node) {
		if (node != null) {
			if (node.point.equals(p))
				return node;

			if (node.checkX) {
				if (p.x() >= node.point.x()) {
					if (node.rt != null)
						return getClosestNodeOrNull(p, node.rt);
				} else if (node.lb != null)
					return getClosestNodeOrNull(p, node.lb);
			} else {
				if (p.y() >= node.point.y()) {
					if (node.rt != null)
						return getClosestNodeOrNull(p, node.rt);
				} else if (node.lb != null)
					return getClosestNodeOrNull(p, node.lb);
			}
		}
		return node;
	}

	// Add the point to the tree
	public void insert(Point p) {

		if (isEmpty()) {
			Rectangle rect = new Rectangle(
					0, Double.MAX_VALUE, 0, Double.MAX_VALUE);
			root = new Node(p, true, rect);
			size++;
			return;
		}
		Node node = getClosestNodeOrNull(p, root);

		if (p.equals(node.point))
			return;

		if (node.checkX) {
			if (p.x() >= node.point.x()) {
				Rectangle rect = new Rectangle(
						node.point.x(), node.rect.maxX(),
						node.rect.minY(), node.rect.maxY());
				node.rt = new Node(p, !node.checkX, rect);
			} else {
				Rectangle rect = new Rectangle(
						node.rect.minX(), node.point.x(),
						node.rect.minY(), node.rect.maxY());
				node.lb = new Node(p, !node.checkX, rect);
			}
		} else {
			if (p.y() >= node.point.y()) {
				Rectangle rect = new Rectangle(
						node.rect.minX(), node.rect.maxX(),
						node.point.y(), node.rect.maxY());
				node.rt = new Node(p, !node.checkX, rect);
			} else {
				Rectangle rect = new Rectangle(
						node.rect.minX(), node.rect.maxX(),
						node.rect.minY(), node.point.y());
				node.lb = new Node(p, !node.checkX, rect);
			}
		}
		size++;
	}

	//Is tree contains given point?
	public boolean contains(Point point) {
		Node closestNode = getClosestNodeOrNull(point, root);
		return null != closestNode && closestNode.point.equals(point);
	}

	//Get point nearest to the given point
	public Point nearest(Point point) {
		if (isEmpty())
			return null;
		Node closest = getClosestNodeOrNull(point, root);
		double leastDistance = closest.point.getDistance(point);
		//System.out.println(closest.point);

		Node current;
		// search tree to find guaranteed closest point
		Queue<Node> toSearch = new LinkedList<Node>();
		toSearch.offer(root);
		while (!toSearch.isEmpty()) {
			current = toSearch.poll();
			double currentDistance = point.getDistance(current.point);
			if (currentDistance < leastDistance) {
				closest = current;
				leastDistance = currentDistance;
			}
			if (current.rt != null
					&& current.rt.rect.getDistance(point) < leastDistance)
				toSearch.offer(current.rt);
			if (current.lb != null
					&& current.lb.rect.getDistance(point) < leastDistance)
				toSearch.offer(current.lb);
		}
		return closest.point;
	}

	//Is this set empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	//Get size of the tree
	public int size() {
		return size;
	}

	private static class Node {		 
		private Point point;
		private Node lb;
		private Node rt;
		private Rectangle rect;

		//Coordinate to comparison. X or Y?
		private boolean checkX;

		public Node(Point point, boolean checkX, Rectangle rect) {
			this.point = point;
			this.lb = null;
			this.rt = null;
			this.checkX = checkX;
			this.rect = rect;
		}
	}

}
