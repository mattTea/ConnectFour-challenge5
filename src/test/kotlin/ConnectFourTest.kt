import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConnectFourTest {
    private val connectFour = ConnectFour()

    @Test
    fun `getGridStatus() returns "Red plays next" for empty grid`() {
        val grid : Array<String> = arrayOf( ".......",
                                            ".......",
                                            ".......",
                                            ".......",
                                            ".......",
                                            ".......")

        assertEquals("Red plays next", connectFour.getGridStatus(grid))
    }
}