Connect4
========

Solution to the JL [coding challenge #05](https://coding-challenges.jl-engineering.net/challenges/challenge-5/) using Kotlin & JUnit5
<br/>


## Game rules

This is a two player game where each player takes turns adding one of their coloured tokens to a grid.

The winner is the player who gets four of their tokens in a line which can be horizontal, vertical or diagonal.

Unlike noughts and crosses, gravity is at play so any token added to a column falls to the bottom of the column.

Only one token can occupy a position in the grid so tokens added to the same column stack up.

The grid is 7 columns wide by 6 rows deep and tokens are red and yellow.

Red always plays first.

------

## Problem description

Create a function called `getGridStatus` that takes an array of strings as input and return one of the following strings as output...

```kotlin
"Red plays next"
"Yellow plays next"
"Red wins"
"Yellow wins"
"Draw" // -> this means there are no empty spaces left on the grid 
```
<br/>

The array of strings used as the input is structured so that each string represents a row in the Connect4 grid...
- The element at position zero represents the top of the grid and the element with the highest position represents the bottom of the grid
- Each character in the string represents a column position in the grid, they can be any of the following...

```kotlin
"." // -> Empty position
"r" // -> Position contains a red token
"y" // -> Position contains a yellow token
"R" // -> Position contains a red token that was the last token added to the grid
"Y" // -> Position contains a yellow token that was the last token added to the grid
```

(If a grid contains tokens then one of the tokens should be either “R” or “Y” but the grid can’t contain both “R” and “Y”.)


### Grid status examples

```kotlin
getGridStatus( [".......",
                ".......",
                ".......",
                ".......",
                ".......",
                "......."]) // -> "Red plays next"


getGridStatus( [".......",
                ".......",
                ".R.....",
                ".r.....",
                ".ry....",
                ".ryyy.."]) // -> "Red wins"


getGridStatus( [".......",
                ".......",
                ".......",
                ".yy....",
                ".rrRr..",
                ".ryyy.."]) // -> "Red wins"


getGridStatus( [".......",
                ".......",
                "....r..",
                "...ry..",
                "..Ryr..",
                ".ryyyr."] ) // -> "Red wins"


getGridStatus( [".......",
                ".......",
                "...y...",
                "...ry..",
                "...ryy.",
                "...rrrY"]) // -> "Yellow wins"


getGridStatus( [".......",
                ".......",
                ".......",
                "...ry..",
                "...ryy.",
                "..yrrrY"]) // -> "Red plays next"


getGridStatus( [".......",
                ".......",
                ".......",
                "...ry..",
                "..Rryy.",
                "..yrrry"]) // -> "Yellow plays next"
```
<br/>

------

## Problem breakdown

1. `getGridStatus` returns a string

2. `getGridStatus` returns "Red plays next" for empty grid

3. `getGridStatus` returns "Draw" for full grid

4. `getGridStatus` returns "Yellow plays next" for grid with "R" present
