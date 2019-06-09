import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConnectFourTest {
    private val connectFour = ConnectFour()

    @Test
    fun `getGridStatus() returns a string`() {
        assertEquals("Red plays next", connectFour.getGridStatus())
    }
}