import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConnectFourTest {
    private val connectFour = ConnectFour()

    @Test
    fun `returns "Red plays next" for empty grid`() {
        val emptyGrid : Array<String> = arrayOf(".......",
                                                ".......",
                                                ".......",
                                                ".......",
                                                ".......",
                                                ".......")

        assertEquals("Red plays next", connectFour.getGridStatus(emptyGrid))
    }

    @Test
    fun `returns "Draw" for grid with no empty spaces`() {
        val fullGrid : Array<String> = arrayOf( "yyyryyY",
                                                "rrryrrr",
                                                "yyrrryr",
                                                "rryyrry",
                                                "yyrryyr",
                                                "yyrryry")

        assertEquals("Draw", connectFour.getGridStatus(fullGrid))
    }

    @Test
    fun `returns "Yellow plays next" when "R" is present in grid`() {
        val yellowNextGrid : Array<String> = arrayOf(   "yyyRyy.",
                                                        "rrryrrr",
                                                        "yyrrryr",
                                                        "rryyrry",
                                                        "yyrryyr",
                                                        "yyrryry")

        assertEquals("Yellow plays next", connectFour.getGridStatus(yellowNextGrid))
    }

    @Test
    fun `returns "Red plays next" when "Y" is present`() {
        val redNextGrid : Array<String> = arrayOf(  ".......",
                                                    ".......",
                                                    ".......",
                                                    ".......",
                                                    ".......",
                                                    "..rY...")

        assertEquals("Red plays next", connectFour.getGridStatus(redNextGrid))
    }

    @Test
    fun `returns "Red wins" for 4 horizontal connected reds`() {
        val redWinsGrid : Array<String> = arrayOf(  ".......",
                                                    ".......",
                                                    ".......",
                                                    ".......",
                                                    "..yyy..",
                                                    "..rrrR.")

        assertEquals("Red wins", connectFour.getGridStatus(redWinsGrid))
    }

    @Test
    fun `returns "Yellow wins" for 4 horizontal connected yellows`() {
        val yellowWinsGrid : Array<String> = arrayOf(   ".......",
                                                        ".......",
                                                        ".......",
                                                        "..rr...",
                                                        "..yyyY.",
                                                        "..rrry.")

        assertEquals("Yellow wins", connectFour.getGridStatus(yellowWinsGrid))
    }

    @Test
    fun `returns "Red wins" for 4 vertical connected reds`() {
        val redWinsVert : Array<String> = arrayOf(  ".......",
                                                    ".......",
                                                    "..R....",
                                                    "..ry...",
                                                    "..ry...",
                                                    "..ry...")

        assertEquals("Red wins", connectFour.getGridStatus(redWinsVert))
    }

    @Test
    fun `returns "Yellow wins" for 4 vertical connected yellows`() {
        val yellowWinsVert : Array<String> = arrayOf(   ".......",
                                                        ".......",
                                                        "...Y...",
                                                        "..ry...",
                                                        "..ry...",
                                                        ".rry...")

        assertEquals("Yellow wins", connectFour.getGridStatus(yellowWinsVert))
    }

    @Test
    fun `returns "Yellow wins" for 4 diagonal (down right) connected yellows`() {
        val yellowWinsDiagonal : Array<String> = arrayOf(   ".......",
                                                            ".......",
                                                            "...y...",
                                                            "...ry..",
                                                            "...ryy.",
                                                            "...rrrY")

        assertEquals("Yellow wins", connectFour.getGridStatus(yellowWinsDiagonal))
    }

    @Test
    fun `returns "Yellow wins" for 4 diagonal (down left) connected yellows`() {
        val yellowWinsDiagonal : Array<String> = arrayOf(   ".......",
                                                            ".......",
                                                            "...y...",
                                                            "..yr...",
                                                            ".yyr...",
                                                            "Yrrr...")

        assertEquals("Yellow wins", connectFour.getGridStatus(yellowWinsDiagonal))
    }

    @Test
    fun `returns "Red wins" for 4 diagonal (down right) connected reds`() {
        val redWinsDiagonal: Array<String> = arrayOf(   ".......",
                                                        ".......",
                                                        "...R...",
                                                        "...yr..",
                                                        "...yyr.",
                                                        "..rryyr")

        assertEquals("Red wins", connectFour.getGridStatus(redWinsDiagonal))
    }

    @Test
    fun `returns "Red wins" for 4 diagonal (down left) connected reds`() {
        val redWinsDiagonal: Array<String> = arrayOf(   ".......",
                                                        ".......",
                                                        "...R...",
                                                        "..ry...",
                                                        ".ryy...",
                                                        "ryyrr..")

        assertEquals("Red wins", connectFour.getGridStatus(redWinsDiagonal))
    }
}