package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.Allfigure.Cercle2D;
import fr.uvsq.pglp.Exercice9_9.Allfigure.GroupFig;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Point2D;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Rectangle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.Triangle;
import fr.uvsq.pglp.Exercice9_9.Allfigure.allfigure;

public class figureTest {
	
	Cercle2D c1;
	Point2D centre;
	Rectangle r1;
	Point2D ul;
	Point2D dr;
	Triangle t1;
	Point2D som;
	Point2D dlt;
	Point2D drt;
	GroupFig grp1;

	@Before
	public void setUp() throws Exception {
		centre = new Point2D(0, 5);
		c1 = new Cercle2D("C1",centre, 5);
		ul = new Point2D(3, 2);
		dr = new Point2D(5, 1);
		r1 = new Rectangle("R1", ul, dr);
		som = new Point2D(4, 3);
		dlt = new Point2D(3, 1);
		drt = new Point2D(5, 2);
		t1 = new Triangle("T1", som, dlt, drt);
		grp1 = new GroupFig("Grp1");
		grp1.add(c1);
		grp1.add(r1);
		grp1.add(t1);
		
		//List<allfigure> figures = grp1.gettab();
		
	}

	@Test
	public void test() {
		System.out.println(c1.toString());
		System.out.println(r1.toString());
		System.out.println(t1.toString());
		
		c1.move(2, 2);
		r1.move(2, 2);
		t1.move(2, 2);
		
		System.out.println("After move");
		System.out.println(c1.toString());
		System.out.println(r1.toString());
		System.out.println(t1.toString());
		System.out.println(grp1.toString());
		
		System.out.println("affiche les elements du groupe");
		
		List<allfigure> arrlist = grp1.gettab(); 
		  
		
		ListIterator<allfigure> iterator = arrlist.listIterator(); 

    // Printing the iterated value 
    System.out.println("\nUsing ListIterator:\n"); 
    while (iterator.hasNext()) { 
        System.out.println("Value is : " + iterator.next()); 
    } 
		
		
	}

}
