package Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


class Points implements Comparable<Points>{
	double x,y;
	double angleWithMin;

	public Points(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Points o) {
		if(this.angleWithMin>o.angleWithMin)
			return 1;
		else if(this.angleWithMin<o.angleWithMin)
			return -1;
		else
		return 0;
	}

	public double getAngleWithMin() {
		return angleWithMin;
	}

	public void setAngleWithMin(Points min) {
		if(this.x-min.x==0)
			angleWithMin=0;
		else{
		double Y=(this.y-min.y);
		double X=this.x-min.x;
		double result=Math.toDegrees(Math.atan(Y/X));
	angleWithMin=(result<0?360d+result:result);
		}
	}

	@Override
	public String toString() {
		return "Points []"+x+":"+y;
	}

	
	
}
public class ConvexHull {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader reader=new  BufferedReader(new FileReader("convex.txt"));
List<Points> points=new ArrayList<Points>();
String st;
while((st=reader.readLine())!=null){
	String[] coordinates=st.split(" ");
	points.add(new Points(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
	
}
Points smallestYPoint=points.get(0);
for(Points p:points)
	if(smallestYPoint.y>p.y)
		smallestYPoint=p;

for(Points p:points){
	p.setAngleWithMin(smallestYPoint);

}
Collections.sort(points);

Stack<Points> convexHullPoints=getConvexHullPoints(points);
for(Points p:convexHullPoints)
	System.out.println(p.x+":"+p.y);
	}

	
	public static Stack<Points> getConvexHullPoints(List<Points> points){
		Stack<Points> convexHullPoints=new Stack<Points>();
		for(Points coordinate:points){
			if(convexHullPoints.size()<2){
				
				convexHullPoints.push(coordinate);
			}else{
				arrangingPoints(convexHullPoints,coordinate);
			}
			
			
		}
		return convexHullPoints;
	}
	public static void arrangingPoints(Stack<Points> convexHullPoints,Points coordinate){
		//System.out.println("hello");
		Points top=convexHullPoints.pop();
		if(convexHullPoints.isEmpty()){
			convexHullPoints.push(top);
			convexHullPoints.push(coordinate);
			return;
		}
		Points secondTop=convexHullPoints.peek();
		if(isCounterClockwise(secondTop, top, coordinate)){
			convexHullPoints.push(top);
			convexHullPoints.push(coordinate);
		}else{
			arrangingPoints(convexHullPoints, coordinate);
		}
		
	}
	public static boolean isCounterClockwise(Points p1,Points p2,Points p3){
		//determinant of these points which actually return area of triangle//if +ve then anti-clock ,if -ve clockwise if 0,collinear
		
		double areaOfTriangle=p1.x*(p2.y-p3.y)-p2.x*(p1.y-p3.y)+p3.x*(p1.y-p2.y);
		
		if(areaOfTriangle>0.0)
			return true;
		else
			return false;
	}
}
