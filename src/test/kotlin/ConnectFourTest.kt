import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConnectFourTest {
    private val connectFour = ConnectFour()

    @Test
    fun `getGridStatus() returns "Red plays next" for empty grid`() {
        val emptyGrid : Array<String> = arrayOf(".......",
                                                ".......",
                                                ".......",
                                                ".......",
                                                ".......",
                                                ".......")

        assertEquals("Red plays next", connectFour.getGridStatus(emptyGrid))
    }

    @Test
    fun `getGridStatus() returns "Draw" for grid with no empty spaces`() {
        val fullGrid : Array<String> = arrayOf( "ryrryrY",
                                                "yrryyyr",
                                                "yryyryr",
                                                "rryyrry",
                                                "yyyrrry",
                                                "rrryyyr")

        assertEquals("Draw", connectFour.getGridStatus(fullGrid))
    }

    @Test
    fun `getGridStatus() returns "Yellow plays next" when "R" is present in grid`() {
        val yellowNextGrid : Array<String> = arrayOf(   "ryrryR.",
                                                        "yrryyyr",
                                                        "yryyryr",
                                                        "rryyrry",
                                                        "yyyrrry",
                                                        "rrryyyr")

        assertEquals("Yellow plays next", connectFour.getGridStatus(yellowNextGrid))
    }

//    @Test
//    fun ``() {
//
//    }
}