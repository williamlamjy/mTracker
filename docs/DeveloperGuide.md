# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}


## Design

> Tip: The diagrams in this guide were designed using PlantUML.
> Their original .puml files can be found in the diagrams folder here.

### Architecture

The following diagram denotes the high-level design of the mTracker
program:

<>

Major components of the app:
* `MTracker` contains the `main` method responsible for launching and 
running the app. It first initializes the other components in the correct sequence
  and executes the overall program.
* `ui` holds the `TextUi` class, which is responsible for displaying various greetings, 
instructions for user input, and other display texts. The class contains both
  strings of commonly used display texts like the console input prompter, and 
  methods that print these strings out, thus ensuring satisfactory user interface and 
  communication with user.
* `console` is a collection of closely-related parser classes that take in the user input, analyse them 
to understand the various commands the user would like to execute through the console.
* `commands` is another collection of closely-related classes that deal with 
executing particular commands determined by the necessary parser classes in console.
* `instrument` contains two types of classes:
    * `InstrumentManager` singleton class that manages access to the arraylist containing
    all the instruments created by user during the session.
    * `subinstrument` is a collection of the different instrument classes: `Crypto`, 
    `Etf`, `Forex`, and `Stock`. The primary role of these classes is to initialize instrument
      objects of their said type containing their necessary financial information recorded from the user.
* `storage` is responsible for saving the session's instruments data to local file, updating
them during runtime, and restoring data from previous session when the program is relaunched.

The subsequent sections will elaborate on the more technical design and implementation details of
the architectural components briefly explained in this section.


### InputParser component

<Theodore_stuff>



### ui

The ui component only contains the TextUi.java file and its API can be found
[here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/src/main/java/seedu/mtracker/ui/TextUi.java).

It is a basic java class containing private string attributes of frequently used display texts.
As detailed by the UML diagrams in the other sections above, many other parser and command classes utilize
the methods contained in `TextUi` to display instructions on the console for required user input. Hence, most other
classes of this program are moderately coupled with the `TextUi` class as they are dependent on the methods of this class
for their proper interaction with the user.

Thus, the `TextUi` class is highly-cohesive as it contains all the user text display methods for the various classes
in itself. This enhances maintainability as only this class has to be modified to achieve a small change in
the desired texted or instruction to be displayed by various classes, and increases reusability of the module
as all aspects of texts or instruments to be displayed on the console have been localized.

Moreover, the following sequence diagram explains `TextUi`'s interaction with an `Instrument` class. This primarily occurs when the
`displayInstrument()` method is called when the user wishes to list out all instruments of the watchlist:

<>

Hence, in this scenario, `TextUi` relies on the particular `Instrument` class's `toList()` method to retrieve
all the financial information recorded for that instrument, and then displays them in an appropriate format to
the user.

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
