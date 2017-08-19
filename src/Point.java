
public class Point {
	double x,y;
	
	Point(double a,double b){
		x=a;
		y=b;
	}
	Point(Point b){
		x=b.x;
		y=b.y;
	}
	
	double distance(Point b) {
		return Math.sqrt(Math.pow((x-b.x),2)+Math.pow((y-b.y),2));
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
