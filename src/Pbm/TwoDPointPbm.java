package Pbm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Pgm to get the k closest points from origin
   Can be extended to indentify closest points on the 2D plane */
public class TwoDPointPbm {
	
	/*Distance between 2 points = sqrt(sq(x2-x1) + sq(y2-y1))
	  Since d is from origin, (x1, y1) = (0, 0) */
	
	public static class Point implements Comparable<Point>{
		private Integer x;
		private Integer y;
		private Integer d;
		
		public Point(Integer x, Integer y) {
			this.x = x;
			this.y = y;
			this.d = (int) Math.sqrt(x*x + y*y);
		}

		@Override
		public int compareTo(Point p) {
			
			int dd = (int) Math.sqrt(p.x*p.x + p.y*p.y);
			
			if (this.d < dd) {
				return -1;
			} else if (this.d > dd) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public static void main(String []args) {
		
		List<TwoDPointPbm.Point> lst = new ArrayList<TwoDPointPbm.Point>();
		lst.add(new TwoDPointPbm.Point(5, 1));
		lst.add(new TwoDPointPbm.Point(1, 2));
		lst.add(new TwoDPointPbm.Point(2, 1));
		lst.add(new TwoDPointPbm.Point(10, 12));
		lst.add(new TwoDPointPbm.Point(5, 8));
		
		Collections.sort(lst);
		
		System.out.println("Given points in sorted order from origin");
		for (TwoDPointPbm.Point pt : lst) {
			System.out.println(pt.x + "," + pt.y + "   Distance : " + pt.d);
		}
	}
}