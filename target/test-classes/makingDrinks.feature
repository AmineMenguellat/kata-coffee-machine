Feature: Coffee Machine iteration one

In this iteration, your task is to implement the logic (starting from a simple class)
that translates orders from customers of the coffee machine to the drink maker.
Your code will use the drink maker protocol (see below) to send commands to the drink maker.
The coffee machine can serves 3 type of drinks: tea, coffee, chocolate.
  
    Scenario Outline: the coffee machine receives a commands
     Given The drink maker should receive the correct instructions for my "<command>" order  
     When I want to add  "<quantity suggar>" sugar to my order
     Then my order "<command>" has been processed
     And "<quantity suggar>" of sugar added 
     And "<number stick>" of stick added
     
     Examples:
        |command     	  |quantity suggar 	|number stick |
        |coffee					|0								|0						|
        |coffee					|1								|1						|
        |coffee					|2								|1						|
        |tea						|0								|0						|
        |tea						|1								|1						|
        |tea						|2								|1						|
        |chocolate			|0								|0				  	|
        |chocolate			|1								|1						|
        |chocolate			|2								|1						|