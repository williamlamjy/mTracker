# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design
### Architecture

### InputParser component
The API of this component is specified in `InputParser.java`.
The figure below represents the class diagram of the `Parser` component:

How the `InputParser` component works:
1. When the user enters a command along with the relevant parameters if any, the `InputParser` uses the 
`getCommandComponents` method to separate the user's command by spaces to create a string array. 
2. The command is determined using the `filterByCommandType` method which would return the corresponding 
command type. Examples of command type are `AddInstrumentCommand`, `DeleteCommand` and `ListCommand` etc. 

Given the different types of financial instruments supported by MTracker, an abstract class, `addInstrumentParser` 
that inherits from `InputParser` is implemented. Multiple `addXYZParser` (`XYZ` is 
a placeholder for the different instrument types. An example is `addStockParser`.) child classes of 
`addInstrumentParser` are implemented to handle the different instruments and their specific parameters.
This implementation provides greater extensibility to the add functionality to support more instrument types. 

The figure below represents the sequence diagram when the user wants to add a stock:

## Implementation
(for parser alternatives considered to design for inputs like 
"stock name/ price/ ...", "stock NAME PRICE" <- not very cli friendly with user having to recall all params,
in addition without any 'markers' like name/ it is error prone when there 2 parameters of the same type,
pros slightly simpler parser implementation with few add parser classes)
(talk about how feature is implemented, why is it implemented that way, alternatives considered)

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
