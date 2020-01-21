package src;

import edu.uwm.cs351.Point;
import edu.uwm.cs351.Vector;


public class TestVector extends LockedTestCase {

	private static final double MARGIN = 1E-6;

	public void testDefault(){
		Vector v1 = new Vector();
		assertEquals(Td(1125694579),v1.dx());
		assertEquals(Td(1710414720),v1.dy());
		assertEquals("<0.0,0.0>",v1.toString());
	}
	
	public void testXY(){
		Vector v1 = new Vector(1.2,3.4);
		assertEquals(1.2,v1.dx());
		assertEquals(3.4,v1.dy());
		assertEquals("<1.2,3.4>",v1.toString());
		Vector v2 = new Vector(5.6,7.8);
		assertEquals(5.6,v2.dx());
		assertEquals(7.8,v2.dy());
		assertEquals("<5.6,7.8>",v2.toString());
	}
	
	public void testTheta(){
		Vector v1 = new Vector(0);
		assertEquals(Td(893182444),v1.dx(),MARGIN);
		assertEquals(Td(1285011119),v1.dy(),MARGIN);

		Vector v2 = new Vector(Math.PI);
		assertEquals(Td(21631774),v2.dx(),MARGIN);
		assertEquals(Td(193149850),v2.dy(),MARGIN);

		Vector v3 = new Vector(Math.PI/2);
		assertEquals(Td(477431906),v3.dx(),MARGIN);
		assertEquals(Td(1462847911),v3.dy(),MARGIN);

		Vector v4 = new Vector(3*Math.PI/2);
		assertEquals(Td(1846159432),v4.dx(),MARGIN);
		assertEquals(Td(394683906),v4.dy(),MARGIN);

		Vector v5 = new Vector(2*Math.PI);
		assertEquals(1.0,v5.dx(),MARGIN);
		assertEquals(0.0,v5.dy(),MARGIN);

		Vector v6 = new Vector(31*Math.PI);
		assertEquals(-1.0,v6.dx(),MARGIN);
		assertEquals(0.0,v6.dy(),MARGIN);

		Vector v7 = new Vector(-27*Math.PI/2);
		assertEquals(0.0,v7.dx(),MARGIN);
		assertEquals(1.0,v7.dy(),MARGIN);

		Vector v8 = new Vector(-101*Math.PI/2);
		assertEquals(0.0,v8.dx(),MARGIN);
		assertEquals(-1.0,v8.dy(),MARGIN);
		
		Vector v9 = new Vector(1);
		assertEquals(0.540302305868139717,v9.dx(),MARGIN);
		assertEquals(0.841470984807896507,v9.dy(),MARGIN);
		assertEquals(1.0,v9.angle(),MARGIN);

		Vector v10 = new Vector(-1);
		assertEquals(0.540302305868139717,v10.dx(),MARGIN);
		assertEquals(-0.841470984807896507,v10.dy(),MARGIN);
		assertEquals(2*Math.PI-1.0,v10.angle(),MARGIN);
		
	}
	
	public void checkVector(String name, double dx, double dy, Vector v){
		assertEquals(name+" x",dx,v.dx(),MARGIN);
		assertEquals(name+" y",dy,v.dy(),MARGIN);
	}
	
	
	public void testPoint(){
		Point p1 = new Point(-1,0);
		Point p2 = new Point(1,2);
		Vector v = new Vector(p1,p2);
		assertEquals("v.dx()?", Ti(1511950364), v.dx(), MARGIN);
		assertEquals("v.dy()?", Ti(695871863), v.dy(), MARGIN);
		
		Point p3 = new Point(3,-1);
		Point p4 = new Point(-1,-1);
		
		Vector v11 = new Vector(p1,p1);
		Vector v12 = new Vector(p1,p2);
		Vector v13 = new Vector(p1,p3);
		Vector v14 = new Vector(p1,p4);
		checkVector("p1->p1",0.0,0.0,v11);
		checkVector("p1->p2",2.0,2.0,v12);
		checkVector("p1->p3",4.0,-1.0,v13);
		checkVector("p1->p4",0.0,-1.0,v14);

		Vector v21 = new Vector(p2,p1);
		Vector v22 = new Vector(p2,p2);
		Vector v23 = new Vector(p2,p3);
		Vector v24 = new Vector(p2,p4);
		checkVector("p2->p1",-2.0,-2.0,v21);
		checkVector("p2->p2",0.0,0.0,v22);
		checkVector("p2->p3",2.0,-3.0,v23);
		checkVector("p2->p4",-2.0,-3.0,v24);

		Vector v31 = new Vector(p3,p1);
		Vector v32 = new Vector(p3,p2);
		Vector v33 = new Vector(p3,p3);
		Vector v34 = new Vector(p3,p4);
		checkVector("p3->p1",-4.0,1.0,v31);
		checkVector("p3->p2",-2.0,3.0,v32);
		checkVector("p3->p3",0.0,0.0,v33);
		checkVector("p3->p4",-4.0,0.0,v34);

		Vector v41 = new Vector(p4,p1);
		Vector v42 = new Vector(p4,p2);
		Vector v43 = new Vector(p4,p3);
		Vector v44 = new Vector(p4,p4);
		checkVector("p4->p1",0.0,1.0,v41);
		checkVector("p4->p2",2.0,3.0,v42);
		checkVector("p4->p3",4.0,0.0,v43);
		checkVector("p4->p4",0.0,0.0,v44);
	}
	
	public void testAdd(){
		Vector a = new Vector(1, 2);
		Vector b = new Vector(3, 4);
		Vector c = a.add(b);
		assertEquals("c.dx()?", Ti(994774524), c.dx(), MARGIN);
		assertEquals("c.dy()?", Ti(2129377820), c.dy(), MARGIN);
		
		Vector v1 = new Vector();
		Vector v2 = new Vector(0,5);
		Vector v3 = new Vector(-2,0);
		Vector v4 = new Vector(4,7.4);
		Vector v5 = new Vector(30,-400);
		Vector v6 = new Vector(10,10);
		Vector v7 = new Vector(-0.1,-0.1);
		checkVector("<0,0>+<0,0>",0,0,v1.add(v1));
		checkVector("<0,0>+<0,5>",0,5,v1.add(v2));
		checkVector("<0,5>+<-2,0>",-2,5,v2.add(v3));
		checkVector("<4,7.4>+<0,0>",4,7.4,v4.add(v1));
		checkVector("<4,7.4>+<4,7.4>",8,14.8,v4.add(v4));
		checkVector("<30,-400>+<-2,0>",28,-400,v5.add(v3));
		checkVector("<30,-400>+<10,10>",40,-390,v5.add(v6));
		checkVector("<30,-400>+<-0.1,-0.1>",29.9,-400.1,v5.add(v7));
		checkVector("<-0.1,-0.1>+<10,10>",9.9,9.9,v7.add(v6));
		checkVector("<-0.1,-0.1>+<-0.1,-0.1>",-0.2,-0.2,v7.add(v7));
	}
	
	public void testDot(){
		Vector v1 = new Vector();
		Vector v2 = new Vector(0,1);
		Vector v3 = new Vector(1,0);
		Vector v4 = new Vector(2,2);
		Vector v5 = new Vector(3,-3);
		Vector v6 = new Vector(-3,3);
		Vector v7 = new Vector(-9,-9);
		assertEquals("<0,0> dot <0,0>",Td(21772839),v1.dot(v1));
		assertEquals("<0,1> dot <0,0>",Td(437056019),v2.dot(v1));
		assertEquals("<0,0> dot <1,0>",Td(74074378),v1.dot(v3));
		assertEquals("<2,2> dot <2,2>",Td(1939140080),v4.dot(v4));
		assertEquals("<3,-3> dot <2,2>",Td(704217999),v5.dot(v4));
		assertEquals("<-3,3> dot <0,1>",3.0,v6.dot(v2));
		assertEquals("<1,0> dot <3,-3>",0.0,v1.dot(v5));
		assertEquals("<-9,-9> dot <0,0>",Td(77744757),v7.dot(v1),MARGIN);
		assertEquals("<-9,-9> dot <-9,-9>",Td(1524140091),v7.dot(v7));
		
		Vector v8 = new Vector(0.1,0.4);
		Vector v9 = new Vector(0.9,-0.2);
		Vector v10 = new Vector(1.7,100.1);
		assertEquals("<0.1,0.4> dot <0.1,0.4>",0.17000000000000004,v8.dot(v8),MARGIN);
		assertEquals("<0.1,0.4> dot <2,2>",1.0,v8.dot(v4),MARGIN);
		assertEquals("<0.9,-0.2> dot <0.1,0.4>",0.009999999999999995,v9.dot(v8),MARGIN);
		assertEquals("<0.9,-0.2> dot <0.9,-0.2>",0.8500000000000001,v9.dot(v9),MARGIN);
		assertEquals("<1.7,100.1> dot <0.1,0.4>",40.21,v10.dot(v8),MARGIN);
		assertEquals("<1.7,100.1> dot <1.7,100.1>",10022.899999999998,v10.dot(v10),MARGIN);
		
	}
	

	public void testMove(){
		Point p = new Point(0,0);
		p = new Vector(4,4).move(p);
		assertEquals("p.getX()?", Ti(1736813547), p.intX());
		assertEquals("p.getY()?", Ti(1653484205), p.intY());
		p = new Vector(0, -0.5).move(p);
		assertEquals("p.getX()?", Td(371873588), p.x(), MARGIN);
		assertEquals("p.getY()?", Td(1538420661), p.y(), MARGIN);
		
		Point p1 = new Point(-1,0);
		Point p2 = new Point(1,2);
		Point p3 = new Point(3,-1);
		Point p4 = new Point(-1,-1);
		
		Vector v11 = new Vector(p1,p1);
		Vector v12 = new Vector(p1,p2);
		Vector v13 = new Vector(p1,p3);
		Vector v14 = new Vector(p1,p4);

		assertEquals("p1->p1",p1,v11.move(p1));
		assertEquals("p1->p2",p2,v12.move(p1));
		assertEquals("p1->p3",p3,v13.move(p1));
		assertEquals("p1->p4",p4,v14.move(p1));
		checkVector("p1->p1",0.0,0.0,v11);
		checkVector("p1->p2",2.0,2.0,v12);
		checkVector("p1->p3",4.0,-1.0,v13);
		checkVector("p1->p4",0.0,-1.0,v14);

		Vector v21 = new Vector(p2,p1);
		Vector v22 = new Vector(p2,p2);
		Vector v23 = new Vector(p2,p3);
		Vector v24 = new Vector(p2,p4);
		assertEquals("p2->p1",p1,v21.move(p2));
		assertEquals("p2->p2",p2,v22.move(p2));
		assertEquals("p2->p3",p3,v23.move(p2));
		assertEquals("p2->p4",p4,v24.move(p2));
		checkVector("p2->p1",-2.0,-2.0,v21);
		checkVector("p2->p2",0.0,0.0,v22);
		checkVector("p2->p3",2.0,-3.0,v23);
		checkVector("p2->p4",-2.0,-3.0,v24);

		Vector v31 = new Vector(p3,p1);
		Vector v32 = new Vector(p3,p2);
		Vector v33 = new Vector(p3,p3);
		Vector v34 = new Vector(p3,p4);
		assertEquals("p3->p1",p1,v31.move(p3));
		assertEquals("p3->p2",p2,v32.move(p3));
		assertEquals("p3->p3",p3,v33.move(p3));
		assertEquals("p3->p4",p4,v34.move(p3));
		checkVector("p3->p1",-4.0,1.0,v31);
		checkVector("p3->p2",-2.0,3.0,v32);
		checkVector("p3->p3",0.0,0.0,v33);
		checkVector("p3->p4",-4.0,0.0,v34);

		Vector v41 = new Vector(p4,p1);
		Vector v42 = new Vector(p4,p2);
		Vector v43 = new Vector(p4,p3);
		Vector v44 = new Vector(p4,p4);
		assertEquals("p4->p1",p1,v41.move(p4));
		assertEquals("p4->p2",p2,v42.move(p4));
		assertEquals("p4->p3",p3,v43.move(p4));
		assertEquals("p4->p4",p4,v44.move(p4));
		checkVector("p4->p1",0.0,1.0,v41);
		checkVector("p4->p2",2.0,3.0,v42);
		checkVector("p4->p3",4.0,0.0,v43);
		checkVector("p4->p4",0.0,0.0,v44);
	}
	
	public void testScale(){
		Vector v = new Vector(1.05,3.25).scale(2);
		assertEquals("_dx of v?", Td(1099161973), v.dx());
		assertEquals("_dy of v?", Td(1584670509), v.dy());
		
		Vector v1 = new Vector();
		Vector v2 = v1.scale(10);
		Vector v3 = v1.scale(-2);
		Vector v4 = v1.scale(0.2);
		Vector v5 = new Vector(3,4);
		Vector v6 = v5.scale(10);
		Vector v7 = v5.scale(-2);
		Vector v8 = v5.scale(0.2);
		checkVector("nil",0,0,v1);
		checkVector("10*nil",0,0,v2);
		checkVector("-2*nil",0,0,v3);
		checkVector("0.2*nil",0,0,v4);
		checkVector("3-4",3,4,v5);
		checkVector("10*3-4",30,40,v6);
		checkVector("-2*3-4",-6,-8,v7);
		checkVector("0.2*3-4",0.6,0.8,v8);
	}
	
	public void testRotate(){
		Vector v = new Vector(4,0).rotate(Math.PI/2);
		assertEquals("_dx of v?", Td(1054221436), v.dx(), MARGIN);
		assertEquals("_dy of v?", Td(1654930987), v.dy(), MARGIN);
		
		Vector v1 = new Vector(1,0);
		Vector v2 = v1.rotate(Math.PI);
		Vector v3 = v2.rotate(3*Math.PI/2);
		Vector v4 = v3.rotate(-Math.PI);
		Vector v5 = v1.rotate(1);
		Vector v6 = v5.rotate(1);
		checkVector("v1",1,0,v1);
		checkVector("v2",-1,0,v2);
		checkVector("v3",0,1,v3);
		checkVector("v4",0,-1,v4);
		checkVector("v5",0.540302305868139717,0.841470984807896507,v5);
		checkVector("v6",-0.416146836547142387,0.9092974268256816954,v6);
	}
	
	public void testMagnitude(){
		Vector v1 = new Vector();
		Vector v2 = new Vector(3,4);
		Vector v3 = new Vector(-3,4);
		Vector v4 = new Vector(-3,-4);
		Vector v5 = new Vector(3,-4);
		assertEquals("<0,0>",Td(1194406896),v1.magnitude());
		assertEquals("<3,4>",Td(1025614320),v2.magnitude());
		assertEquals("<-3,4>",Td(988985340),v3.magnitude());
		assertEquals("<-3,-4>",5.0,v4.magnitude());
		assertEquals("<3,-4>",5.0,v5.magnitude());
	}

	public void testNormalize(){
		Vector v1 = new Vector(0.5,1.2);
		Vector v1n = v1.normalize();
		Vector v2 = new Vector(-.3,-.4);
		Vector v2n = v2.normalize();
		assertEquals("Should be same (no expectation)",v1.angle(),v1n.angle(),MARGIN);
		assertEquals(1.3,v1.magnitude(),MARGIN);
		assertEquals(Td(781829223),v1n.magnitude(),MARGIN);
		assertEquals("Should be same (no expectation)",v2.angle(),v2n.angle(),MARGIN);
		assertEquals(0.5,v2.magnitude(),MARGIN);
		assertEquals(Td(347338749),v2n.magnitude(),MARGIN);
	}
	
	public void testHash(){
		Vector v1 = new Vector(0,0);
		Vector v2 = new Vector(1,0);
		Vector v3 = new Vector(0,1);
		Vector v4 = new Vector(1.0/11.0,1.0/19.0);
		assertEquals(Ti(1312265724),v1.hashCode());
		assertEquals(Ti(1973844719),v2.hashCode());
		assertEquals(Ti(1224400163),v3.hashCode());
		assertEquals(Ti(177087713),v4.hashCode());
	}

	public void testEquals(){
		Vector v = new Vector(1,1);
		Vector v1 = new Vector(1, 1.0);
		assertEquals("should v and v1 be considered equal?", Tb(1571371929), v.equals(v1));
		
		
		double small = 2E-6;
		
		v = new Vector(1,2);
		assertTrue(v.equals(v));
		assertTrue(v.equals(new Vector(1,2)));
		assertFalse(v.equals(new Vector(1,1)));
		assertFalse(v.equals(new Vector(2,2)));
		assertFalse(v.equals(new Vector(2,1)));
		assertFalse(v.equals(new Vector(5,7)));
		
		v1 = new Vector(1+small,2);
		Vector v2 = new Vector(1-small,2);
		Vector v3 = new Vector(1,small+2);
		Vector v4 = new Vector(1,2-small);
		assertFalse("Difference should be noticed",v.equals(v1));
		assertFalse("Difference should be noticed",v.equals(v2));
		assertFalse("Difference should be noticed",v.equals(v3));
		assertFalse("Difference should be noticed",v.equals(v4));
	}
	
}
