import org.example.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for Dice.java file that tests that the functions in the class are behaving
 * the way they should. The roll() function is tested to see if it returns a value between 1 and 5.
 * The second function is tested to see if it throws an ArrayIndexOfBound exception because the
 * iteration parameters exceed the length of the array (Array length = no of sides of the dice).
 */
class DiceTest {

    private Dice dice = new Dice(5, "blue");



    @Test
    void testGetColor() {
        assertEquals("blue", dice.getColor());
    }

    @Test
    void testGetSides() {
        assertEquals(5, dice.getSides());
    }


    @Test
    void testRoll() {
        assertTrue(dice.roll() <= dice.getSides());
    }

@Test
void testFail(){

        fail();
}
    @Test
    void testRollMany() {
        assertThrows(ArrayIndexOutOfBoundsException.class, this::testRolls);
    }

    private void testRolls() {
        dice.rollMany(dice.getSides());
    }
}