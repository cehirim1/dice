import org.example.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for Dice.java file that tests that the functions in the class are behaving
 * the way they should. The roll() function is tested to see if it returns a value between 1 and 5.
 * The second function is tested to see if it throws an ArrayIndexOfBound exception because the
 * iteration parameters exceed the length of the array (Array length = no of sides of the dice).
 */
class DiceTest {

    private Dice dice;

    @BeforeEach
    public void setUp() {
        setDice(new Dice(5, "blue"));
    }

    @Test
    public void testConstructor() {

        assertAll(
                () -> assertEquals(5, getDice().getSides()),
                () -> assertEquals("blue", getDice().getColor())
        );
    }

    @Test
    public void testRoll() {
        assertTrue(getDice().roll() > 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3, 4, 6})
    public void testRollArray(int num) {
        int[] diceArr = getDice().rollMany(num);
        assertNotNull(diceArr);
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -1})
    public void testRollMany(int num) {
        assertThrows(NegativeArraySizeException.class, () -> getDice().rollMany(num));
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
