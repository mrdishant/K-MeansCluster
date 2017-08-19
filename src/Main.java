import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
        long start=System.currentTimeMillis();
	    int k=1;
		Point[] p=new Point[5];
		p[0]=new Point(1,1);
		p[1]=new Point(1,0);
		p[2]=new Point(0,2);
		p[3]=new Point(2,4);
		p[4]=new Point(3,5);
		
		ArrayList<Point> given=new ArrayList<>();
		given.add(p[0]);
		given.add(p[1]);
		given.add(p[2]);
		given.add(p[3]);
		given.add(p[4]);
		
		Collections.shuffle(given);
		Point c1=new Point(given.get(0));
		Point c2=new Point(given.get(1));


		ArrayList<Point>cluster1=new ArrayList<>();
		ArrayList<Point>cluster2=new ArrayList<>();

		ArrayList<Point>newcluster1=new ArrayList<>();
		ArrayList<Point>newcluster2=new ArrayList<>();

		double dc1,dc2;
		for(int i=0;i<5;i++) {
			dc1=c1.distance(p[i]);
			dc2=c2.distance(p[i]);
			if(dc1<dc2) {
				cluster1.add(p[i]);
			}else if(dc2<dc1) {
				cluster2.add(p[i]);
			}
		}
        c1.x=meanx(cluster1);
        c1.y=meany(cluster1);
        c2.x=meanx(cluster2);
        c2.y=meany(cluster2);
        do {
            if(!(newcluster1.isEmpty()&& newcluster2.isEmpty())) {
                cluster1.clear();
                System.out.println(cluster1.size());
                cluster1.addAll(newcluster1);
                cluster2.clear();
                cluster2.addAll(newcluster2);
                newcluster1.clear();
                newcluster2.clear();
            }
            for(int i=0;i<5;i++) {
                dc1=c1.distance(p[i]);
                dc2=c2.distance(p[i]);
                if(dc1<=dc2) {
                    newcluster1.add(p[i]);
                }else {
                    newcluster2.add(p[i]);
                }
            }
            c1.x=meanx(newcluster1);
            c1.y=meany(newcluster1);
            c2.x=meanx(newcluster2);
            c2.y=meany(newcluster2);
            k++;
        }while(!(compareCluster(cluster1, newcluster1)||compareCluster(cluster1, newcluster2))&&(compareCluster(cluster2, newcluster2)||compareCluster(cluster2, newcluster1)));
        System.out.println("Value of K is  : "+k);
		System.out.println("Time Taken : "+(System.currentTimeMillis()-start)+" milliseconds");
	}

    static boolean compareCluster(ArrayList<Point> c1,ArrayList<Point> c2) {
		if(c1.size()!=c2.size()||c1==null&&c2!=null||c1!=null&&c2==null) return false;
		if(c1==null && c2==null) return true;
		for(int i=0;i< c1.size();i++){
           if(! c2.contains(c1.get(i))) return false;
        }
        return true;
	}


	static double meanx(ArrayList<Point> c) {
		double sumx=0;
		for(int i=0;i<c.size();i++) {
			sumx+=c.get(i).x;
		}
		return sumx/c.size();
	}

    static double meany(ArrayList<Point> c) {
        double sumy=0;
        for(int i=0;i<c.size();i++) {
            sumy+=c.get(i).y;
        }
        return sumy/c.size();
    }
}
