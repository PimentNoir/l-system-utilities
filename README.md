# l-system-utilities

This project grew out of my exploration of the Lindenmayer-Systems that can be
used to describe plant-like structures using text Strings. What it does, is 
provide a library that can be used with processing to explore LSystems. The main
feature it provides is grammar generator (three actually via SimpleGrammar,
StochasticGrammar and CSGrammar classes) that is initialized with an "Axiom".
The user can then add one or more rules to that grammar, before requesting that
the grammar is created with a given number of generations. Also provided is a
simple Turtle class and Turtle Stack, which can be used to store context in the
'traditional' manner (cf the matrix functions provided by processing).
For usage see included examples such as my 3D Hilbert. More on my blog
(see Project Links in side panel) although these sketches are not guaranteed
to work with current version.
 
Since version 1.0.0 the library has been recompiled for processing-2.1.0, 
using jdk1.7.0_51, making it incompatible with earlier versions of processing.
