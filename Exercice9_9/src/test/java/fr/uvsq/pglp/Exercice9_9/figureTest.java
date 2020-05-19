package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.Allfigure.*;


public class figureTest {

	Cercle c1;
	Point2D centre;
	RectangleFig r1;
	RectangleFig Care;
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
		c1 = new Cercle("C1",centre, 5);

		ul = new Point2D(3, 2);
		dr = new Point2D(5, 1);
		r1 = new RectangleFig("R1", ul, dr);

		som = new Point2D(4, 3);
		dlt = new Point2D(3, 1);
		drt = new Point2D(5, 2);
		t1 = new Triangle("T1", som, dlt, drt);

		grp1 = new GroupFig("Grp1");
		grp1.add(c1);
		grp1.add(r1);
		grp1.add(t1);


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

		grp1.move(-2, -2);

		ItteratorFigure affich = new ItteratorFigure(grp1);
		Iterator grouptIter = affich.getIterator();

		while (grouptIter.HasNext()) {
			allfigure nextValue=grouptIter.Next();
			System.out.println("The next value with Iterator is: " + nextValue.toString());
		}

	}

}
