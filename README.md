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

#### `Random Expression Extension` 
In the GUI, type randExp(int) to create a random expression that is -int- "items" long. These items are made up of our unary functions, basic operators, "x", "y", and "random()". To avoid syntax errors, an "x" or "y" may be added to the expression making it <int>+1 in length.

#### `Defined Variable GUI Extension`
Extension that displays the expressions that are currently assigned to variables on the right side of the GUI. On the bottom is the current expression for reference.

#### `History Toggle Extension`
This extension allows users to go in between previously entered expressions. First the user needs to click on the image with a mouse (make sure that the focus is on canvas and not the entry field). And then use the left and right arrows to go back and forth between previously entered expressions. The history works as loop so if you press right arrow when on the newly entered expression, you will get the first expression ever entered. It also displays the expression entered at the bottom of the screen. This is particularly cool when looking at randExp as going through the history will show the actual expressions. Also there are no wrong or empty inputs entered in history.
