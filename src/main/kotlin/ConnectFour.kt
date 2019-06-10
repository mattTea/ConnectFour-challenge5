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

    fun getGridStatus(grid: Array<String>): String {
        return when {
            checkForRedWin(grid) -> "Red wins"
            checkForBlanks(grid) && checkForR(grid) -> "Yellow plays next"
            checkForBlanks(grid) && !checkForR(grid) -> "Red plays next"
            else -> "Draw"
        }
    }
}
