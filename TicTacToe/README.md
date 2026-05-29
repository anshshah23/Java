# Tic Tac Toe Terminal Game

A simple command-line Tic Tac Toe game in Java where you play against a smart AI opponent.

## Features

- Play against an AI with strategy
- Simple terminal-based interface
- AI tries to win and blocks your winning moves
- Play multiple games in a row

## How to Compile

```bash
javac Main.java Board.java Game.java
```

## How to Run

```bash
java Main
```

## How to Play

1. The board positions are numbered 1-9:
   ```
   1 | 2 | 3
   ---------
   4 | 5 | 6
   ---------
   7 | 8 | 9
   ```

2. You are X, AI is O
3. Enter a number (1-9) when prompted to place your mark
4. The AI will automatically make its move
5. First to get 3 in a row (horizontally, vertically, or diagonally) wins!

## Game Logic

The AI uses the following strategy in order of priority:
1. Win if it can complete 3 in a row
2. Block the player from winning
3. Take the center position (5)
4. Take corner positions (1, 3, 7, 9)
5. Take any remaining space

## Files

- `Main.java` - Entry point of the game
- `Board.java` - Manages the game board state and win conditions
- `Game.java` - Handles game flow and AI logic
