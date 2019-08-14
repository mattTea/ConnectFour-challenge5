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

    private fun checkForWin(grid: Array<String>, player: Char, direction: String): Boolean {
        var win = false
        var increment = 0
        when {
            direction == "dRight" -> increment = 8
            direction == "dLeft" -> increment = 6 // this is failing as an increment of 6 can be on the same line! All of these are flawed, as they could all wrap over aline break
            direction == "h" -> increment = 0
            direction == "v" -> increment = 7 // fails for above reasons
        }

        val gridString = grid.joinToString("").toLowerCase().toList()

        for ((i, char) in gridString.withIndex()) {
            if (i + (3 * (increment)) < gridString.size) {
                when {
                    char == player
                        && gridString[i + increment] == player
                        && gridString[i + (2 * (increment))] == player
                        && gridString[i + (3 * (increment))] == player -> win = true
                }
            }
        }
        return win
    }

    fun getGridStatus(grid: Array<String>): String {
        return when {
//            checkForRedWin(grid) || checkForRedColumnWin(grid) || checkForWin(grid, 'r', "dRight") || checkForWin(grid, 'r', "dLeft") -> "Red wins"
            checkForRedWin(grid) || checkForWin(grid, 'r', "v") || checkForWin(grid, 'r', "dRight") || checkForWin(grid, 'r', "dLeft") -> "Red wins"
            checkForYellowWin(grid) || checkForYellowColumnWin(grid) || checkForWin(grid, 'y', "dRight") || checkForWin(grid, 'y', "dLeft") -> "Yellow wins"
            checkForBlanks(grid) && checkForR(grid) -> "Yellow plays next"
            checkForBlanks(grid) && !checkForR(grid) -> "Red plays next"
            else -> "Draw"
        }
    }
}