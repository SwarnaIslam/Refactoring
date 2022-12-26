#TriviaGame class refactoring
##**Large class smell:** 
TriviaGame class has too many instance variables and contains too many responsibilities. 
####**Remedies:**
**Extract class:**
I have divided the responsibilies into different classes containing related responsibilies. Question class will perform all responsibilities logically related to question. So I have moved askQuestion(), currentCategory() to it. 
