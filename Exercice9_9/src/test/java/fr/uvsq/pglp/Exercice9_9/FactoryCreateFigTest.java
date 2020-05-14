package fr.uvsq.pglp.Exercice9_9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp.Exercice9_9.Allfigure.*;
import fr.uvsq.pglp.Exercice9_9.CreationFigure.*;

public class FactoryCreateFigTest {

	Cercle c1;
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
		c1 = new Cercle("C1",centre, 5);
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
	public void ContAllFigTest() {
		ContAllFig.add("C1", c1);
		ContAllFig.add("R1", r1);
		ContAllFig.add("T1", t1);
		ContAllFig.add("Grp1", grp1);

		List<allfigure> fig = ContAllFig.getAll();

		for(int i=0;i<fig.size();i++) {
			assertTrue(fig.get(i) instanceof allfigure);
		}

	}

	@Test
	public void FigFactoryTest() {
		FigFactory figureFactory = new FigFactory();

		allfigure cercle = null;

		List<String> arg = new ArrayList<String>();
		arg.add("C1");
		arg.add("cercle");
		arg.add("3.2");
		arg.add("5.0");
		arg.add("6");

		cercle = figureFactory.getCercle(arg);

		assertTrue(cercle instanceof Cercle);


	}
	
	@Test
	public void FigFactoryAndContAllFigTest() {
		FigFactory figureFactory = new FigFactory();

		allfigure cercle = null;

		List<String> arg = new ArrayList<String>();
		arg.add("C1");
		arg.add("cercle");
		arg.add("3.2");
		arg.add("5.0");
		arg.add("6");

		ContAllFig.add(arg.get(0), figureFactory.getCercle(arg));

		assertTrue(ContAllFig.get("C1") instanceof Cercle);


	}

}
