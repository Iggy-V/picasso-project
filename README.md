# Picasso
## By Jack, Joe, Uno, and Ignas

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.
d
The given code base is a good start, but it is sparsely documented
(document each method/part after you understand what it's doing) and,
as your application grows, you may need to refactor.

See the specification for Picasso on the course web site.

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.

## Code Base History

This code base originated as a project in a course at Duke University.  The professors realized that the code could be designed better and refactored.  This code base has some code leftover from the original version.

## Extensions

####`Random Expression Extension` 
In the GUI, type randExp(int) to create a random expression that is -int- "items" long. These items are made up of our unary functions, basic operators, "x", "y", and "random()". To avoid syntax errors, an "x" or "y" may be added to the expression making it <int>+1 in length.

####`Defined Variable GUI Extension`
Extension that displays the expressions that are currently assigned to variables on the bottom of the GUI. Next to it is the current expression for reference.

