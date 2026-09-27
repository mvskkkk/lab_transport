package by.bsu.entity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;

public class RailwayTransportTest {

    private static class TestRailwayTransport extends RailwayTransport {
        public TestRailwayTransport(String type, double speed, TypeOfFuel typeOfFuel) {
            super(type, speed, typeOfFuel);
        }

        public TestRailwayTransport(String type, double speed, TypeOfFuel typeOfFuel, int numberOfCarriages) {
            super(type, speed, typeOfFuel, numberOfCarriages);
        }
    }

    private TestRailwayTransport transport;

    @BeforeMethod
    public void setUp() {
        transport = new TestRailwayTransport("TestTrain", 100.0, TypeOfFuel.ELECTRIC, 8);
    }

    @Test
    public void testConstructorWithThreeParameters() {
        TestRailwayTransport train = new TestRailwayTransport("FastTrain", 120.0, TypeOfFuel.DIESEL);

        assertEquals(train.getTypeOfTransport(), "FastTrain");
        assertEquals(train.getSpeed(), 120.0);
        assertEquals(train.getTypeOfFuel(), TypeOfFuel.DIESEL);
        assertEquals(train.getNumberOfCarriages(), 0); // по умолчанию 0
    }

    @Test
    public void testConstructorWithFourParameters() {
        TestRailwayTransport train = new TestRailwayTransport("CargoTrain", 80.0, TypeOfFuel.HYBRID, 12);

        assertEquals(train.getTypeOfTransport(), "CargoTrain");
        assertEquals(train.getSpeed(), 80.0);
        assertEquals(train.getTypeOfFuel(), TypeOfFuel.HYBRID);
        assertEquals(train.getNumberOfCarriages(), 12);
    }

    @Test
    public void testGetTypeOfFuel() {
        assertEquals(transport.getTypeOfFuel(), TypeOfFuel.ELECTRIC);

        TestRailwayTransport dieselTrain = new TestRailwayTransport("Train", 100.0, TypeOfFuel.DIESEL);
        assertEquals(dieselTrain.getTypeOfFuel(), TypeOfFuel.DIESEL);
    }

    @Test
    public void testSetTypeOfFuel() {
        transport.setTypeOfFuel(TypeOfFuel.DIESEL);
        assertEquals(transport.getTypeOfFuel(), TypeOfFuel.DIESEL);

        transport.setTypeOfFuel(TypeOfFuel.HYBRID);
        assertEquals(transport.getTypeOfFuel(), TypeOfFuel.HYBRID);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testSetTypeOfFuelWithNull() {
        transport.setTypeOfFuel(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testConstructorWithNullFuel() {
        new TestRailwayTransport("Test", 100.0, null);
    }

    @Test
    public void testGetNumberOfCarriages() {
        TestRailwayTransport trainWithCarriages = new TestRailwayTransport("Train", 100.0, TypeOfFuel.ELECTRIC, 10);
        assertEquals(trainWithCarriages.getNumberOfCarriages(), 10);

        TestRailwayTransport trainWithoutCarriages = new TestRailwayTransport("Train", 100.0, TypeOfFuel.DIESEL);
        assertEquals(trainWithoutCarriages.getNumberOfCarriages(), 0); // по умолчанию 0
    }

    @Test
    public void testSetNumberOfCarriages() {
        transport.setNumberOfCarriages(15);
        assertEquals(transport.getNumberOfCarriages(), 15);

        transport.setNumberOfCarriages(5);
        assertEquals(transport.getNumberOfCarriages(), 5);

        transport.setNumberOfCarriages(0);
        assertEquals(transport.getNumberOfCarriages(), 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetNumberOfCarriagesWithNegative() {
        transport.setNumberOfCarriages(-5);
    }

    @Test
    public void testToString() {
        String result = transport.toString();
        assertTrue(result.contains("TestRailwayTransport"));
        assertTrue(result.contains("TestTrain"));
        assertTrue(result.contains("100.0"));
        assertTrue(result.contains("ELECTRIC"));
        assertTrue(result.contains("8"));
    }

    @Test
    public void testEquals() {
        TestRailwayTransport transport1 = new TestRailwayTransport("Train", 100.0, TypeOfFuel.ELECTRIC, 8);
        TestRailwayTransport transport2 = new TestRailwayTransport("Train", 100.0, TypeOfFuel.ELECTRIC, 8);
        TestRailwayTransport transport3 = new TestRailwayTransport("DifferentTrain", 100.0, TypeOfFuel.ELECTRIC, 8);
        TestRailwayTransport transport4 = new TestRailwayTransport("Train", 120.0, TypeOfFuel.ELECTRIC, 8);
        TestRailwayTransport transport5 = new TestRailwayTransport("Train", 100.0, TypeOfFuel.DIESEL, 8);
        TestRailwayTransport transport6 = new TestRailwayTransport("Train", 100.0, TypeOfFuel.ELECTRIC, 10);

        assertNotEquals(transport1, transport2);
        assertNotEquals(transport1, transport3);
        assertNotEquals(transport1, transport4);
        assertNotEquals(transport1, transport5);
        assertNotEquals(transport1, transport6);
    }

    @Test
    public void testEqualsWithNull() {
        assertFalse(transport.equals(null));
    }

    @Test
    public void testEqualsWithDifferentClass() {
        assertFalse(transport.equals("Some String"));
    }

    @Test
    public void testEqualsWithSameObject() {
        assertTrue(transport.equals(transport));
    }
}