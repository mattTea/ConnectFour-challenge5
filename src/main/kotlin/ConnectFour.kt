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

    fun getGridStatus(grid: Array<String>): String {
        return if (checkForBlanks(grid)) {
            return if (checkForR(grid)) {
                "Yellow plays next"
            } else {
                "Red plays next"
            }
        } else {
            "Draw"
        }
    }
}
