package tries;

public class Tries {
public static TriesNode root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] allString={"myname","name"};

for(String str:allString){
	if(root==null)
		root=new TriesNode();
	root=addElement(str, 0, root);
}
for(String str:allString){
	 str=str;
	int index=str.charAt(0)-97;
System.out.println(str+"::"+getElement(str, 0, root.childNode[index]));
}	
}
	
public static TriesNode addElement(String str,int pos,TriesNode triNode){

	if(pos<str.length()){
	int index=str.charAt(pos)-97;

	if(triNode.childNode[index]==null){
		triNode.childNode[index]=new TriesNode(str.charAt(pos));
	}
	 triNode.childNode[index]=addElement(str, pos+1, triNode.childNode[index]);
	
	}
		return triNode;
	
}
public static boolean getElement(String str,int pos,TriesNode triNode){
	System.out.println(str+":::"+pos);
	if(triNode==null)
		return false;
	{
		int index=str.charAt(pos)-97;
	   {
		   if(pos==str.length()-1)
			   return true;
		   else
			   return getElement(str, pos+1, triNode.childNode[str.charAt(pos+1)-97]);
	   }
	
	}
	
}
}
