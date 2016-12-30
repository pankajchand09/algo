package Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Node {
	int value, rank;
	Node left, right;

	public Node(int value) {
		super();
		this.value = value;
	}

}

public class BinarySearchTree {
	static Node root = null;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("BST.txt"));
		String str;
		while ((str = reader.readLine()) != null) {
			root = insert(root, Integer.parseInt(str));
		}

		System.out.println("value 60 exist:" + getKey(root, 90));
		
		print(root);
		delete(root, null, 10);
		
		print(root);
		delete(root, null, 40);
		print(root);
		
		//delete(root, null, );

	}
public static void print(Node parent){
	ArrayList<Node> allNodes=new ArrayList<Node>();
	InorderTraversal(parent, allNodes);
	for(Node node:allNodes)
		System.out.print(node.value+":"+node.rank+"\t");
	System.out.println();
}
	public static Node insert(Node parent, int value) {
		if (parent == null) {
			Node node = new Node(value);
			node.left = null;
			node.right = null;
			node.rank = 1;
			parent = node;

		} else {
			if (parent.value > value) {
				parent.left = insert(parent.left, value);
			} else if (parent.value < value) {
				parent.right = insert(parent.right, value);
			} else {
				System.out.println("key already there");
			}
			parent.rank = 1 + (parent.left == null ? 0 : parent.left.rank)
					+ (parent.right == null ? 0 : parent.right.rank);
		}

		return parent;
	}

	public static Node getMax(Node parent) {
		if (parent.right == null)
			return parent;
		return getMax(parent.right);

	}

	public static Node getMin(Node parent) {
		if (parent.left == null)
			return parent;
		return getMax(parent.left);

	}

	public static Node getKey(Node parent, int value) {
		if (parent == null)
			return null;
		if (parent.value == value)
			return parent;
		else if (value < parent.value)
			return getKey(parent.left, value);
		else
			return getKey(parent.right, value);

	}

	public static void InorderTraversal(Node parent, ArrayList<Node> inorder) {
		if (parent == null)
			return;
		InorderTraversal(parent.left, inorder);
		inorder.add(parent);
		InorderTraversal(parent.right, inorder);
	}

	public static void delete(Node child, Node parent, int value) {
		if (child == null)
			return;
		else {
			if (child.value == value) {
				if (child.left == null && child.right == null) {
					deleteWithoutChild(child, parent, value);
				} else if (child.left != null && child.right != null) {
					deleteWithTwoChild(child, parent, value);
				} else {
					deleteWithOneChild(child, parent, value);
				}
				
			} else if (value < child.value) {
				delete(child.left, child, value);
				
			} else
				delete(child.right, child, value);

			child.rank = 1 + (child.left == null ? 0 : child.left.rank)
					+ (child.right == null ? 0 : child.right.rank);
		}
		

	}

	public static boolean isLeftChildofParent(Node child, Node parent, int value) {
		if (parent.left != null && parent.left.value == child.value) {
			return true;

		} else {
			return false;
		}
	}

	public static void deleteWithoutChild(Node child, Node parent, int value) {
		if (isLeftChildofParent(child, parent, value))
			parent.left = null;
		else
			parent.right = null;

		child = null;
	}

	public static void deleteWithOneChild(Node child, Node parent, int value) {
		if (isLeftChildofParent(child, parent, value)) {
			parent.left = (child.left == null ? child.right : child.left);
		} else
			parent.right = (child.left == null ? child.right : child.left);
child=null;
	}

	public static void deleteWithTwoChild(Node child, Node parent, int value) {
		{
		Node successor=deleteSuccessor(child.right, child, value);
		child.value=successor.value;
		child.rank=successor.rank;
		successor=null;
		}
		
	}
	public static Node deleteSuccessor(Node child,Node parent,int value){
		if(child.left==null)
		{
			parent.right=child.right;
			parent.left=null;
		return child;	
		}
		
		Node tmp= deleteSuccessor(child.left, child, value);

		child.rank = 1 + (child.left == null ? 0 : child.left.rank)
				+ (child.right == null ? 0 : child.right.rank);
		return tmp;
	}
}