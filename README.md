# Food Truck Project

### Description
This program allows the user to input information for up to five food trucks including name, genre, and a rating.
Entering information for five trucks or entering 'Quit' when prompted to enter a truck name will then show a menu that gives the user choices of certain information they wish to display.

This was completed during week two of Skill Distillery's Full-Stack Java Development Bootcamp.

### Lessons Learned
- Incorporate README updates into dev process so I don't forget what lessons I've learned when writing it at the end of the project
- You can (dare I say, should) pass a Scanner object as an argument to a method
- The relationship between objects and classes can be complex, but it is clearly a very useful tool. I'm happy to be getting more comfortable with the concepts. 
- Short circuit operators are more useful than just saving CPU cycles, they can also prevent null pointer exceptions in certain cases when iterating through an array of objects that may not be full.
- "for truck in trucks[], if truck[i].getRating() > highestRating" will cause an exception
- "for truck in trucks[], if truck != null && truck[i].getRating() > highestRating" won't, since it stops evaluating the expression when it sees the object is null

### Technologies Used
- Java
- Git