package Graph.minimumSpaning;

import java.util.Comparator;

class NodeGeneric{
	int u, v, w;
public static final Comparator<NodeGeneric> SORT_BY_WEIGHT=new SortBYWeight();

	public NodeGeneric(int u, int v, int w) {
		super();
		this.u = u;
		this.v = v;
		this.w = w;
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
	
	private static class SortBYWeight implements Comparator<NodeGeneric>{

		@Override
		public int compare(NodeGeneric o1, NodeGeneric o2) {
			// TODO Auto-generated method stub
			if(o1.w<o2.w)
				return -1;
			else if(o1.w>o2.w)
				return 1;
			return 0;
		}
		
	}
}