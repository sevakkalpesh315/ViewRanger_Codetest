# ViewRanger_Codetest

The code test: </br>
Overview:

This is a short exercise to test basic Java and Android skills and problem-solving ability. Feel free to use the resources you would have available in the workplace (internet, books) as we're trying to ascertain how you'd tackle a problem in a day to day work environment. The exercise itself is not one we'd expect any potential candidate to have a problem solving – we're just as interested in how something is done as simply reaching a functional solution.

The Exercise:

Write an Android mobile application that evaluates a string expression consisting of positive integers and the +, -, /,* operands only, taking into account normal mathematical rules of operator precedence. No brackets or support for input variables is required.

For example:

an input string of "4+5*2" should output 14
an input string of "4+5/2" should output 6.5
an input string of "4+5/2-1" should output 5.5

Also implement a simple Android UI that allows entering the string, and shows the result on screen.


Solution:  </br>

/**
 * Class to perform calculation
 *
 * Reverse Polish notation (RPN) is a mathematical notation in which every operator follows all of its operands, in contrast to Polish notation (PN), which puts the operator before its operands.
 * It is also known as postfix notation and does not need any parentheses as long as each operator has a fixed number of operands.
 *
**/
