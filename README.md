# TriviaGame class refactoring
## Large class smell:
TriviaGame class has too many instance variables and contains too many responsibilities. 
#### Remedies:
**Extract class:**
I have divided the responsibilies into different classes containing related responsibilies. Question class will perform all responsibilities logically related to question. I have moved askQuestion(), currentCategory() to it. 
It will create question of different categories using createQuestion() method.
**Replacing data value with object:**
To handle different type of question category, Category class is created which will be called from Question class based on player's place.
## Magic Numbers:
Many constants were used without clear meaning. For example, 
```
public boolean isPlayable() {
  return (howManyPlayers() >= 2);
}
```
Here the purpose of 2 is not clear.
#### Renaming constant:
I have given all the constants meaningfull name and moved them to a seperate GameConfig class to make use of data object.
```
int HOW_MANY_QUESTIONS =50;
int MIN_PLAYER_REQUIRED =2;
int COIN_NEEDED_TO_WIN =6;
int GAME_BOARD_SPACE =12;
```
## Black sheep:
announce() method should not be a responsibility of TriviaGame logically.
#### Remedies:
I have moved the announce() method to a separate utility class, as it is not directly related to the game logic. 

## Primitive Obsession
Information related to players were declared as arrays instead of using class.
#### Remedies:
**Making separate class:**
A separate class Player is created to handle player related data. For example, player's name, roll, place, purse, inPenalty.
**Replace array with List:**
List of player objects is created.
```
List<Player> players=new ArrayList<Player>();
```
## Switch Statement smell:
if statement is duplicated multiple times in askQuestion() method.
#### Remedies:
**Replace type code with Strategy:**
In askQuestion(), instead of checking category type first and then operating on it, currentCategory() will directly return object of Category class based on category type and askQuestion() will then operate on the object. This way we can reduce if statement significantly. 
## Duplicate code
**Extract method:**
Process of determining next player is calculated many times. A method nextPlayer() is created to do the calculation.
'''
private void nextPlayer(){
    currentPlayer++;
    if(currentPlayer==players.size())currentPlayer=0;
}
'''
Also duplicate code occurred in roll(), wasCorrectlyAnswered() which have been extracted using completeRoll() and correctAnswer() methods.
## Long Method
#### Remedies:
**Extract method:**
TO reduce method length because of duplications, method extract is used.
**Decompose conditional:**
Extracted method from the condion in roll()
```
if(shouldGetOutOfPenaltyBox()){
    isGettingOutOfPenaltyBox = true;
    Utility.announce(players.get(currentPlayer) + " is getting out of the penalty box");

    completeRoll();
}
private boolean shouldGetOutOfPenaltyBox(){
    return players.get(currentPlayer).getPlayerRoll()%2!=0;
}
```


