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

    private fun checkForRedColumnWin(grid: Array<String>): Boolean {
        val transposedGrid = transpose(grid)
        return checkForRedWin(transposedGrid)
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

    fun getGridStatus(grid: Array<String>): String {
        return when {
            checkForRedWin(grid) -> "Red wins"
            checkForRedColumnWin(grid) -> "Red wins"
            checkForBlanks(grid) && checkForR(grid) -> "Yellow plays next"
            checkForBlanks(grid) && !checkForR(grid) -> "Red plays next"
            else -> "Draw"
        }
    }
}
