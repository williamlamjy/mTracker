# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design

> Tip: The diagrams in this guide were designed using PlantUML.
> Their original .puml files can be found in the diagrams folder here.

### Architecture

The following diagram denotes the high-level design of the mTracker
program:

<img src="images/ArchitectureDiagram.png" width="345"/>

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
* `model` contains two types of classes:
    * `InstrumentManager` singleton class that manages access to the arraylist containing
    all the instruments created by user during the session.
    * `subinstrument` is a collection of the different instrument classes: `Crypto`, 
    `Etf`, `Forex`, and `Stock`. The primary role of these classes is to initialize instrument
      objects of their said type containing their necessary financial information recorded from the user.
* `filemanager` is responsible for saving the session's instruments data to local file, updating
them during runtime, and restoring data from previous session when the program is relaunched.

The subsequent sections will elaborate on the more technical design and implementation details of
the architectural components briefly explained in this section.

### Parser component

The main parent class in `console` package is the `InputParser` class which is defined in `InputParser.java`.
The figure below represents the class diagram of how all the parser classes interact with classes outside the `console`
package:

<img src="images/ConsoleDiagram.png" width="550"/>

How the `InputParser` class works:
1. When the user enters a command along with the relevant parameters if any, the
   `getCommandComponents()` method in `InputParser` separates the user's command by spaces to return a string array.
2. The command is then determined by using the `filterByCommandType()` method which would return the corresponding
   command type. Examples of different command types are `AddInstrumentCommand`, `DeleteCommand`, `ListCommand` etc.

Given the different types of financial instruments supported by mTracker, an abstract class `AddInstrumentParser`
which inherits from `InputParser` is implemented. Multiple `AddXYZParser` (`XYZ` is
a placeholder for the different instrument types, for example `AddStockParser`) child classes of
`AddInstrumentParser` support the parsing of different instruments and their parameters.
This implementation provides greater extensibility to the add functionality to support more instrument types.

Two alternatives to get the instrument information from the user were considered. The first alternative was to
get the user to add in all the information in a single line with separators
(for example: `stock TSLA; 909.68; negative; To buy`). This was not implemented as it is likely
for the user to enter the parameters in the wrong order. This becomes especially problematic if there are multiple
parameters that require the same type to represent different attributes of the instrument (for example: The entry and
exit price attributes in Forex instrument).

The second alternative was to get the user to indicate which attribute the parameter would belong to
(for example: `stock n/TSLA p/909.68 s/negative r/To buy`). This way there are distinct markers to define which
parameter belongs to which attribute. However, this was not implemented as given that some instruments have as many as
7 different attributes, it requires the user to recall all the attributes needed to add an instrument which is not
user-friendly.

Therefore, the current implementation prompts the user on the information required to add a particular instrument.
This helps to support the user through the process of adding a new instrument.

### Model Component


The `model` package contains the `InstrumentManager` class and `Instrument` class. It is defined
in `InstrumentManager.java` and `Instrument.java` respectively. This figure below represents the class diagram of 
how the different class work together:

<img src="images/ModelDiagram.png" width="550"/>

The `Model` component:

* Stores the instrument data through `Instrument` objects which are contained and managed by the `InstrumentManager`
* Contains an abstract parent `Instrument` class. The 4 child sub-instrument classes `Crypto`, `Etf`, `Forex` and 
`Stock` implements the Overridden methods (e.g. `toList()`).
* Contains the `InstrumentManager` class which manages the list of instruments (e.g. add a new instrument to 
the list). `InstrumentManager` is implemented as a singleton class to ensure that only one instrument list exists.
This ensures the user only edits one list and prevents possible data corruption (e.g. adding a new instrument to 
different lists).
* Does not have any dependencies on any of the other components, as the `Model` component is meant to be responsible
solely for the data representation and modification of instruments.

  
### Ui

The ui component only contains the TextUi.java file and its API can be found
[here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/src/main/java/seedu/mtracker/ui/TextUi.java).

It is a basic java class containing string attributes and helper methods for displaying the different features, texts and
instructions to the user.
As detailed by the UML diagrams in the other sections above, many other parser and command classes utilize
the methods contained in `TextUi` to display instructions on the console for required user input. Hence, most other
classes of this program are dependent on the methods of this `TextUi` class for their proper interaction with the user.

Thus, the `TextUi` class is highly-cohesive as it contains all the user text display methods for the various classes
in itself. This enhances maintainability as only this class has to be modified to achieve a small change in
the desired texted or instruction to be displayed by various classes, and increases reusability of the module
as all aspects of texts or instruments to be displayed on the console have been localized.

Moreover, the following sequence diagram explains `TextUi`'s interaction with an `Instrument` class. This primarily occurs with the calling of the
`displayInstrument()` method when the user wishes to list out all instruments of the watchlist:

<>

Hence, in this scenario, `TextUi` relies on the particular `Instrument` class's `toList()` method to retrieve
all the financial information recorded for that instrument, and then displays them in an appropriate format to
the user.

### Command Component


The Command component contains all the commands classes, where its respective class is instantiated when a valid command is entered by the user. 

Commands include:
```
1) AddCrytoCommand
2) AddEtfCommand
3) AddForexCommand
3) AddStockCommand
4) ExitCommand
5) InvalidCommand
6) ListCommand
```
This figure below shows the class diagram of all the commands classes:
<>

Command component:

* Each command class is responsible in carrying out its respective function where each command will execute different actions on the model component. In addition they ensure that the user sees the correct messages based on their input.
* All Command classes have a method `execute()` that does the actions required according to the user's input.
* Contains an abstract parent `Command` class. All commands are child classes of the Command class.
* Contains a parent `AddInstrumentCommand` class where all commands related to adding an instrument inherits from.
* Other than ExitCommand and InvalidCommand, the other command classes are dependent of on the InstrumentManager in order to execute the required actions on the stored instruments.
* The command classes are dependent on the `TextUi` class. This allows the command class to display its execution results to the user.


The figure below represents the sequence diagram when the user executes a done command:

<img src="images/DoneCryptoSequenceDiagram.png" width="1040"/>

### FileManager Component
The `filemanager` package contains the `Storage`, `InstrumentEncoder` and `InstrumentDecoder` classes. It is defined in
the `Storage.java`, `InstrumentEncoder.java` and `InstrumentDecoder.java` respectively. This figure below represents the class diagram of
how the different class work together:

<img src="images/FileManagerDiagram.png" width="550"/>

The FileManager Component:

* Contains the `Storage` class that loads data from any pre-existing text file. If the file does not exist, it creates 
a new text file to store the data. It updates the file by calling the `writeFile()` method in the `InstrumentEncoder` class.
* Contains the `InstrumentEncoder` class which encodes the instrument data into a text file format for decoding.
* Contains the `InstrumentDecoder` parent class which decodes the text file. The 4 sub-decoder classes `CryptoDecoder`,
`EtfDecoder`, `ForexDecoder` and `StockDecoder` adds the respective instruments with their decoded attributes into the
`InstrumentManager` enabling the program to load pre-existing data.
* Has some dependencies on the `Model` component as it saves and retrieves data from `Model` objects.

## Implementation

### Add instrument feature
The add instrument functionality is mainly handled by the `parser` and `commands` components. Within the `parser`
component, the `InputParser` class implements the method `InputParser#getAddInstrumentParameters()`. This method calls
`AddInstrumentParser#filterByInstrumentType()` which will then guide the user through the process of adding a new
instrument. 

The figure below represents the sequence diagram when the user wants to add a stock:

<img src="images/AddStockSequenceDiagram.png" width="1040"/>

The process for adding the other instruments follow a similar process to the sequence above. The main difference would
be the type of instrument parser called, the parameters collected from the user and the command type returned. For
example instead of calling `AddStockParser#getStockSpecificParameters()`, its equivalent for adding a crypto is 
`AddCryptoParser#getCryptoSpecificParameters()`.

From the notes in the sequence diagram above, for every attribute in the instrument, there would be an instructional
prompt to get user to provide information for that attribute. This is done through a series of methods in
the `TextUi` class.

### Loading pre-existing data
The loading of pre-existing data is mainly handled by the `filemanager` and `model` components. The main method calls `loadFileData(instrumentManager)` 
in the `Storage` class which implements `InstrumentDecoder#readFile(instrumentManager, fileData)`. This method calls 
`addSavedInstrumentToList(instrumentManager, textSegment)` for each pre-existing instrument which will add the corresponding 
instrument in the `InstrumentManager` through calling the `addXYZToList` method in the XYZDecoder classes. In the event
the instrument is not one of the 4 types of instruments, the `InstrumentDecoder` will throw a new `InvalidInstrumentInFileError`
and display the corresponding error message.

The figures below represents the sequence diagrams when the user loads a pre-existing crypto:

<img src="images/FileManagerSeqBetweenStorageAndDecoder.png" width="700"/>

<img src="images/FileManagerSequenceDiagram.png" width="1040"/>

The process for loading other pre-existing instruments follow a similar process to the sequence above. The main difference
would be the type of instrument decoder called, the different instrument specific decoded parameters and the type of instrument
added to the `InstrumentManager`. For example when loading a stock instead of calling `addCryptoToList(textSegment, instrumentManager`
it will call `addStockToList(textSegement, instrumentManager)`.

If loading the file data has any error, it will throw the corresponding file error. This file error will display the
appropriate message through the `TextUi` class.

### Storing current data
The storing of current data is mainly handled by the `filemanager` and `model` components. The main method calls
the `updateFileData(instruments)` in the Storage class which implements the `writeFile(instruments, writeToFile)` method
in the `InstrumentEncoder`. This method calls the `textFileFormatting()` method in the Instrument class for every instrument
that is being stored. The formatted instrument details are then written to the `MTracker` text file.

The figure below represents the sequence diagram when the user stores current data:
<img src="images/FileManagerEncodingSequenceDiag.png" width="700"/>

If storing the file data has any error, it will throw the corresponding file error. This file error will display the
appropriate message through the `TextUi` class.

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
