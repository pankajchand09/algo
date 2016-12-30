package Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Node{
	int value,rank;
	Node left,right;
	
	public Node(int value) {
		super();
		this.value = value;
	}
	
}
public class BinarySearchTree {
static Node root=null;
	public static void main(String[] args) throws IOException {
	BufferedReader reader=new BufferedReader(new FileReader("BST.txt"));
	String str;
	while((str=reader.readLine())!=null){
		root=insert(root,Integer.parseInt(str));
	}
	
	System.out.println("value 60 exist:"+getKey(root, 60));
	
}

public static Node insert(Node parent,int value){
	if(parent==null)
	{
		Node node=new Node(value);
		node.left=null;
		node.right=null;
		node.rank=1;
		parent=node;
	
	}else{
		if(parent.value>value){
			parent.left=insert(parent.left, value);
		}else if(parent.value<value){
			parent.right=insert(parent.right, value);
		}
		else{
			System.out.println("key already there");
		}
	    parent.rank=1+(parent.left==null?0:parent.left.rank)+(parent.right==null?0:parent.right.rank);
	}
	
return parent;
}
public static Node getMax(Node parent){
	if(parent.right==null)
		return parent;
	return getMax(parent.right);
	
}
public static Node getMin(Node parent){
	if(parent.left==null)
		return parent;
	return getMax(parent.left);
	
}
public static Node getKey(Node parent,int value){
	if(parent==null)
		return null;
	if(parent.value==value)
		return parent;
	else if(value<parent.value)
		return getKey(parent.left, value);
	else
		return getKey(parent.right, value);
		
	
}
public static void InorderTraversal(Node parent,ArrayList<Integer> inorder){
if(parent==null)
	return;
InorderTraversal(parent.left, inorder);
inorder.add(parent.value);
InorderTraversal(parent.right, inorder);
}
}
