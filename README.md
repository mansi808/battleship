# battleship ⛴

command-line version of battleship game

--playerVplayer

--set up your ships

--pressing enter clears out screen for next user to create secrecy for opponents ships

--sink your opponent's ships to win the game

#### How to play

```
Player 1, place your ships on the game field

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Enter the coordinates of the Aircraft Carrier (5 cells):

F3 F7

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ O O O O O ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Enter the coordinates of the Battleship (4 cells):

A1 D1

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ O O O O O ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Enter the coordinates of the Submarine (3 cells):

R4 T7

Error! Wrong ship location! Try again:
I8 I10

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ O O O O O ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ O O O 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Enter the coordinates of the Cruiser (3 cells):

I2 I4

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ O O O O O ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ O O O ~ ~ ~ O O O 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Enter the coordinates of the Destroyer (2 cells):

B3 C3

  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B O ~ O ~ ~ ~ ~ ~ ~ ~ 
C O ~ O ~ ~ ~ ~ ~ ~ ~ 
D O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ O O O O O ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ O O O ~ ~ ~ O O O 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Press Enter and pass the move to another player
```
```
Player 2, place your ships to the game field

...

  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ O ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ O ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ O ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ O ~ ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
G ~ ~ ~ ~ ~ O O O ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ O O O ~ ~ ~ ~ O O 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

--------------------------------------------------------------------
Let's start the game!
Press Enter and pass the move to another player
```

```
  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
----------------------
  1 2 3 4 5 6 7 8 9 10
A O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
B O ~ O ~ ~ ~ ~ ~ ~ ~ 
C O ~ O ~ ~ ~ ~ ~ ~ ~ 
D O ~ ~ ~ ~ ~ ~ ~ ~ ~ 
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
F ~ ~ O O O O O ~ ~ ~ 
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
I ~ O O O ~ ~ ~ O O O 
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

Player 1, it's your turn:

A1

You hit a ship!
Press Enter and pass the move to another player
```

```
...

  1 2 3 4 5 6 7 8 9 10
A X M ~ ~ ~ ~ M ~ ~ M 
B X ~ X ~ ~ M ~ ~ ~ ~ 
C X ~ X M ~ ~ ~ ~ ~ ~ 
D X ~ ~ ~ ~ ~ ~ ~ ~ M 
E M ~ ~ ~ ~ M ~ ~ ~ ~ 
F ~ ~ X X X X X M ~ ~ 
G ~ ~ M ~ ~ ~ M ~ ~ ~ 
H ~ ~ ~ ~ ~ ~ ~ ~ M ~ 
I ~ X X M ~ ~ M X X ~ 
J ~ ~ ~ ~ ~ M ~ ~ ~ ~ 
----------------------
  1 2 3 4 5 6 7 8 9 10
A X X X X X M ~ ~ ~ ~ 
B M ~ ~ ~ M ~ ~ O M ~ 
C ~ M ~ ~ ~ M ~ O ~ ~ 
D ~ M ~ M ~ ~ ~ O ~ ~ 
E ~ ~ ~ ~ M ~ ~ O ~ M 
F ~ M ~ ~ ~ ~ M ~ ~ ~ 
G ~ ~ ~ ~ M X X X ~ ~ 
H ~ M ~ ~ ~ ~ ~ ~ ~ M 
I M X X X ~ ~ ~ ~ X X 
J ~ ~ ~ M ~ M ~ ~ M ~ 

Player 2, it's your turn:

I10

You sank a ship!
Congratulation! You won!
```
