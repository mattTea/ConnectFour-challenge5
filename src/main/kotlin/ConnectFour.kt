class ConnectFour {

    fun checkForBlanks(row: String): Boolean {
        return row.contains(".")
    }

    fun getGridStatus(grid: Array<String>, checkForBlanks: (String) -> Boolean): String {
        for (row in grid) {
            if (checkForBlanks(row)) {
                return "Red plays next"
            }
        }
        return "Draw"
    }
}
