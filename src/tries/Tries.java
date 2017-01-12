package tries;

public class Tries {
public static TriesNode root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] allString={"myname","name","is","pankaj","ankaj"};

for(String str:allString){
	if(root==null)
		root=new TriesNode();
	root=addElement(str, 0, root,str.length());
}

for(String str:allString){
	 str=str;
	int index=str.charAt(0)-97;
	for(int l=1;l<=str.length();++l)
System.out.println(str.substring(0,l)+"::"+isExist(str.substring(0, l), 0, root.childNode[index]));

}
}
	
public static TriesNode addElement(String str,int pos,TriesNode triNode,int value){

	if(pos<str.length()){
	int index=str.charAt(pos)-97;

	if(triNode.childNode[index]==null){
		triNode.childNode[index]=new TriesNode(str.charAt(pos));
	}
	 triNode.childNode[index]=addElement(str, pos+1, triNode.childNode[index],value);
	if(pos==str.length()-1)
		triNode.childNode[index].setValue(value);
	}
		return triNode;
	
}
public static boolean isExist(String str,int pos,TriesNode triNode){
	TriesNode node=getElement(str, pos, triNode);
	boolean exist=false;
	if(node!=null&&node.getValue()>0)
		exist=true;
	return exist;
		
}
public static TriesNode getElement(String str,int pos,TriesNode triNode){
	
	if(triNode==null)
		return null;
	{
		int index=str.charAt(pos)-97;
	   {
		   if(pos==str.length()-1)
			   return triNode;
		   else
			   return getElement(str, pos+1, triNode.childNode[str.charAt(pos+1)-97]);
	   }
	
	}
	
}
}
