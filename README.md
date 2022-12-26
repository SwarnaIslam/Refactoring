# TriviaGame class refactoring
## **Large class smell:** 
TriviaGame class has too many instance variables and contains too many responsibilities. 
#### **Remedies:**
**Extract class:**
I have divided the responsibilies into different classes containing related responsibilies. Question class will perform all responsibilities logically related to question. So I have moved askQuestion(), currentCategory() to it. 
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
#### ** Renaming constant:**
I have give all the constants meaningfull name and moved them to a seperate GameConfig class to make use of data object.

