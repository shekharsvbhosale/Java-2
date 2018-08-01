# Java
A collection of simple Java applications.

## Technologies
I use Java 8 and Swing (partially).

## The applications
### Acronym.java 
Convert an entered name to an acronym. I/O with JOptionPane. 
 
### Aliqout Sum
Calculate the aliquot sum of a number and specify its type

Functions:
- showNumberTypeOf()
	- function that handles the order of the lower functions

- isANaturalNumber()
	- checks if the entered number is a natural number (if it´s smaller 1)

- calculateResult()
	- calculates the Aliquot Sum of the entered number
	- Aliquot Sum: the sum of all proper divisors of the entered number (not the number itself)

- checkAliquotSum()
	- Checks if the entered number is perfect, abundant or deficient by comparing with the Aliquot Sum
		- perfect: Aliquot Sum = entered number
		- abundant: Aliquot Sum > entered number
		- deficient: Aliquot Sum < entered number
	- Returns a String for the matching type

- isAnError()
	-  Returns an error message as String

- main()
	- I/O with JOptionPane
		- Entering the number
		- Show the result 