package Graph;

public class UnionFind {

int[] id;
int[] size;
public UnionFind(int N) {
	// TODO Auto-generated constructor stub
id=new int[N];
size=new int[N];
for(int i=0;i<N;++i){
	id[i]=i;
     size[i]=1;
}

}

public int root(int i){
	int tmp=i;
	while(id[i]!=i)
		i=id[i];
while(id[tmp]!=tmp)
{tmp=id[tmp];
id[tmp]=i;
	}
	return i;
}

public boolean connected(int n1,int n2){
	return root(n1)==root(n2);
}

public void union(int n1,int n2){
	int r1=root(n1);
	int r2=root(n2);
	  if(size[r1]>size[r2])
	  {
		  size[r1]+=size[r2];
		  id[r2]=id[r1];
	  }else{
		  size[r2]+=size[r1];
		  id[r1]=id[r2];
	  }
	
}

}
