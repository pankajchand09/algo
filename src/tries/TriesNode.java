package tries;

import java.util.Arrays;

public class TriesNode {
int value;
char ch;

TriesNode childNode[];
public TriesNode(char ch) {
	this.ch=ch;
	childNode=new TriesNode[26];
	

	
}
public TriesNode() {
	childNode=new TriesNode[26];
	

	
}

@Override
public String toString() {
	return "TriesNode [value=" + value + ", ch=" + ch +"]";
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}

}
