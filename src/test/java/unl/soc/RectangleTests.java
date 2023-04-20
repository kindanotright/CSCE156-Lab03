package unl.soc;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import unl.soc.rectangle.Rectangle;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTests {

	/**
	 * Tests invalid x-coordinates left: (10, 0) right: (5, 10)
	 */
	@Test
	public void invalidInstantiationTest01() {
		assertThrows(IllegalArgumentException.class, () -> {
	        Rectangle r = new Rectangle(10, 0, 5, 10);
	    });
	}
	
	/**
	 * Tests invalid x-coordinates left: (10, 0) right: (10, 10)
	 */
	@Test
	public void invalidInstantiationTest02() {
		assertThrows(IllegalArgumentException.class, () -> {
	        Rectangle r = new Rectangle(10, 0, 10, 10);
	    });
	}
	
	/**
	 * Tests invalid y-coordinates left: (0, 10) right: (10, 5)
	 */
	@Test
	public void invalidInstantiationTest03() {
		assertThrows(IllegalArgumentException.class, () -> {
	        Rectangle r = new Rectangle(0, 10, 10, 5);
	    });
	}

	/**
	 * Tests invalid y-coordinates left: (0, 10) right: (10, 10)
	 */
	@Test
	public void invalidInstantiationTest04() {
		assertThrows(IllegalArgumentException.class, () -> {
	        Rectangle r = new Rectangle(0, 10, 10, 10);
	    });
	}
	
	/**
	 * Tests area method, left: (0, 0) right: (10, 10)
	 */
	@Test
	public void areaTest01() {		
		Rectangle r = new Rectangle(0, 0, 10, 10);
		Assertions.assertEquals(100.0, r.getArea());
	}

	/**
	 * Tests area method, left: (-5, -5) right: (7, 7)
	 */
	@Test
	public void areaTest02() {		
		Rectangle r = new Rectangle(-5, -5, 7, 7);
		Assertions.assertEquals(144.0, r.getArea());
	}

	/**
	 * Same rectangles
	 */
	@Test
	public void intersectionTest01() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(0, 0, 4, 4);
		Rectangle expected = new Rectangle(0, 0, 4, 4);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * Completely contained
	 */
	@Test
	public void intersectionTest02() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(1, 1, 3, 3);
		Rectangle expected = new Rectangle(1, 1, 3, 3);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * x contained, y outside
	 */
	@Test
	public void intersectionTest03() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(1, -1, 3, 5);
		Rectangle expected = new Rectangle(1, 0, 3, 4);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * y contained, x outside
	 */
	@Test
	public void intersectionTest04() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(-1, 1, 5, 3);
		Rectangle expected = new Rectangle(0, 1, 4, 3);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * no intersection, left
	 */
	@Test
	public void intersectionTest05() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(5, 0, 9, 4);
		Rectangle expected = null;
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * no intersection, right
	 */
	@Test
	public void intersectionTest06() {		
		Rectangle a = new Rectangle(5, 0, 9, 4);
		Rectangle b = new Rectangle(0, 0, 4, 4);
		Rectangle expected = null;
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * no intersection, above
	 */
	@Test
	public void intersectionTest07() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(0, 5, 4, 9);
		Rectangle expected = null;
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * no intersection, below
	 */
	@Test
	public void intersectionTest08() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(0, -5, 4, -1);
		Rectangle expected = null;
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * intersection
	 */
	@Test
	public void intersectionTest09() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(2, 1, 6, 3);
		Rectangle expected = new Rectangle(2, 1, 4, 3);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * intersection
	 */
	@Test
	public void intersectionTest10() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(2, 2, 6, 6);
		Rectangle expected = new Rectangle(2, 2, 4, 4);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * intersection
	 */
	@Test
	public void intersectionTest11() {		
		Rectangle a = new Rectangle(2, 2, 6, 6);
		Rectangle b = new Rectangle(0, 0, 4, 4);
		Rectangle expected = new Rectangle(2, 2, 4, 4);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * intersection
	 */
	@Test
	public void intersectionTest12() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(-2, 2, 2, 6);
		Rectangle expected = new Rectangle(0, 2, 2, 4);
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * no intersection
	 */
	@Test
	public void noIntersectionTest01() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(1, 5, 3, 6);
		Rectangle expected = null;
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
	
	/**
	 * no intersection, incident on x
	 */
	@Test
	public void noIntersectionTest02() {		
		Rectangle a = new Rectangle(0, 0, 4, 4);
		Rectangle b = new Rectangle(4, 0, 5, 4);
		Rectangle expected = null;
		Rectangle actual = a.getIntersection(b);
		Assertions.assertEquals(expected, actual);
	}
}
