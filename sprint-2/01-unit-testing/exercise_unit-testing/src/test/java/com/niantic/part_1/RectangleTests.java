package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTests
{
    @Test
    public void getArea_shouldReturn_theProductOfNumbers()
    {
        Rectangle rectangle = new Rectangle();

        int expectedWidth = rectangle.getWidth();
        int expectedHeight = rectangle.getHeight();
        int expectedArea = expectedWidth * expectedHeight;

        int actualArea = rectangle.getArea();

        assertEquals(expectedArea, actualArea, "Because Area = Width * Height");

        Rectangle rectangle1 = new Rectangle(1,1);
        assertEquals(1, rectangle1.getArea(), "Because Area = Width * Height");

        Rectangle rectangle2 = new Rectangle(1675,873);
        assertEquals(1462275, rectangle2.getArea(), "Because Area = Width * Height");
    }

    @Test
    public void getPerimeter_shouldReturn_theSumOfNumbers_timesTwo()
    {
        Rectangle rectangle = new Rectangle();

        int expectedWidth = rectangle.getWidth();
        int expectedHeight = rectangle.getHeight();
        int expectedPerimeter = 2 * (expectedWidth + expectedHeight);

        int actualPerimeter = rectangle.getPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, "Because Perimeter = 2 * (Width + Height)");

        Rectangle rectangle1 = new Rectangle(1,1);
        assertEquals(4, rectangle1.getPerimeter(), "Because Perimeter = 2 * (Width + Height)");

        Rectangle rectangle2 = new Rectangle(1675,873);
        assertEquals(5096, rectangle2.getPerimeter(), "Because Perimeter = 2 * (Width + Height)");
    }

    @Test
    public void getArea_shouldReturnZero_ifWidthOrHeight_isZeroOrLess()
    {
        Rectangle rectangle1 = new Rectangle(0, 5);
        assertEquals(0, rectangle1.getArea(), "Area should be 0 if Width or Height are 0");

        Rectangle rectangle2 = new Rectangle(5, 0);
        assertEquals(0, rectangle2.getArea(), "Area should be 0 if Width or Height are 0");

        Rectangle rectangle3 = new Rectangle(-2, 5);
        assertEquals(0, rectangle3.getArea(), "Area should be 0 if Width or Height are negative");

        Rectangle rectangle4 = new Rectangle(5, -2);
        assertEquals(0, rectangle4.getArea(), "Area should be 0 if Width or Height are negative");

        Rectangle rectangle5 = new Rectangle(-2, 0);
        assertEquals(0, rectangle5.getArea(), "Area should be 0 if Width or Height are negative or zero");

        Rectangle rectangle6 = new Rectangle(0, -2);
        assertEquals(0, rectangle6.getArea(), "Area should be 0 if Width or Height are negative or zero");

        Rectangle rectangle7 = new Rectangle(-3, -5);
        assertEquals(0, rectangle7.getArea(), "Area should be 0 if Width or Height are negative or zero");
    }

    @Test
    public void getPerimeter_shouldReturnZero_ifWidthOrHeight_isZeroOrLess()
    {
        Rectangle rectangle1 = new Rectangle(0, 5);
        assertEquals(0, rectangle1.getPerimeter(), "Perimeter should be 0 if Width or Height are zero");

        Rectangle rectangle2 = new Rectangle(5, 0);
        assertEquals(0, rectangle2.getPerimeter(), "Perimeter should be 0 if Width or Height are zero");

        Rectangle rectangle3 = new Rectangle(-2, 5);
        assertEquals(0, rectangle3.getPerimeter(), "Perimeter should be 0 if Width or Height are negative");

        Rectangle rectangle4 = new Rectangle(5, -2);
        assertEquals(0, rectangle4.getPerimeter(), "Perimeter should be 0 if Width or Height are negative");

        Rectangle rectangle5 = new Rectangle(-2, 0);
        assertEquals(0, rectangle5.getPerimeter(), "Perimeter should be 0 if Width or Height are negative or zero");

        Rectangle rectangle6 = new Rectangle(0, -2);
        assertEquals(0, rectangle6.getPerimeter(), "Perimeter should be 0 if Width or Height are negative or zero");

        Rectangle rectangle7 = new Rectangle(-3, -5);
        assertEquals(0, rectangle7.getPerimeter(), "Perimeter should be 0 if Width or Height are negative or zero");
    }
}