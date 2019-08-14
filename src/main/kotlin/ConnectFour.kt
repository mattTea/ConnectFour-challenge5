class ConnectFour {

    private fun checkForBlanks(grid: Array<String>): Boolean {
        var blankPresent = false
        for (row in grid) {
            if (row.contains(".")) {
                blankPresent = true
            }
        }
        return blankPresent
    }

    private fun checkForR(grid: Array<String>): Boolean {
        var bigRPresent = false
        for (row in grid) {
            if (row.contains("R")) {
                bigRPresent = true
            }
        }
        return bigRPresent
    }

    private fun checkForRedWin(grid: Array<String>): Boolean {
        var redWin = false
        for (row in grid) {
            if (row.toLowerCase().contains("rrrr")) {
                redWin = true
            }
        }
        return redWin
    }

    private fun checkForYellowWin(grid: Array<String>): Boolean {
        var yellowWin = false
        for (row in grid) {
            if (row.toLowerCase().contains("yyyy")) {
                yellowWin = true
            }
        }
        return yellowWin
    }

    private fun checkForRedColumnWin(grid: Array<String>): Boolean {
        val transposedGrid = transpose(grid)
        return checkForRedWin(transposedGrid)
    }

    private fun checkForYellowColumnWin(grid: Array<String>): Boolean {
        val transposedGrid = transpose(grid)
        return checkForYellowWin(transposedGrid)
    }

    private fun transpose(grid: Array<String>): Array<String> {
        val rows = grid.size
        val columns = grid[0].length
        val transposedGrid = Array(columns) { CharArray(rows) }

        for (i in 0 until rows) {
            for (j in 0 until columns) {
                transposedGrid[j][i] = grid[i][j]
            }
        }
        val transposedListOfStrings = transposedGrid.map { it.joinToString(separator = "") }
        return transposedListOfStrings.toTypedArray()
    }

    private fun checkForDiagonalWin(grid: Array<String>, player: Char): Boolean {
        var yellowWin = false
        val gridAsSingleString = grid.joinToString("").toLowerCase()

        for ((index, char) in gridAsSingleString.withIndex()) {
            if (char == player && index < 18) {
                if (gridAsSingleString.toList()[index + 8] == player
                    && gridAsSingleString.toList()[index + 16] == player
                    && gridAsSingleString.toList()[index + 24] == player) {
                    yellowWin = true
                }
            }
        }

        for ((index, char) in gridAsSingleString.withIndex()) {
            if (char == player && index < 21) {
                if (gridAsSingleString.toList()[index + 6] == player
                    && gridAsSingleString.toList()[index + 12] == player
                    && gridAsSingleString.toList()[index + 18] == player) {
                    yellowWin = true
                }
            }
        }
        return yellowWin
    }

    fun getGridStatus(grid: Array<String>): String {
        return when {
            checkForRedWin(grid) || checkForRedColumnWin(grid) || checkForDiagonalWin(grid, 'r') -> "Red wins"
            checkForYellowWin(grid) || checkForYellowColumnWin(grid) || checkForDiagonalWin(grid, 'y') -> "Yellow wins"
            checkForBlanks(grid) && checkForR(grid) -> "Yellow plays next"
            checkForBlanks(grid) && !checkForR(grid) -> "Red plays next"
            else -> "Draw"
        }
    }
}