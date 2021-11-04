# Theodore Kwok - Project Portfolio Page

## Overview
I was involved in the development of a greenfield project known as `mTracker`. The `mTracker` program
serves as a command-line trading journal interface that allows busy individuals to store important financial instrument.
Throughout the project development, my main responsibilities include:
* Being the main code reviewer, conducting code quality and implementation checks on pull requests (PR).
* Designing and proposing software architectures to implement core features such as adding and editing
the different financial instruments.
* Implementing different features in mTracker.
* Contributed to project management by updating the issues on issue tracker and noting down any possible ways we can
improve on code quality and design.

## Summary of Contributions
Below are some of my contributions to the project

* **Code contributed:**
  * The code I contributed can be found in the reposense link [here](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-25&tabOpen=true&tabType=authorship&tabAuthor=theodorekwok&tabRepo=AY2122S1-CS2113T-T12-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false).
* **Design architecture of add and edit functionality**
  * Implemented the foundations for `add` functionality. Seen in PR
  [#18](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/18) and 
  [#20](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/20)
  * Designed how the add instrument functionality would work by taking into consideration how the design of user 
  inputs, using Object Oriented Programming (OOP) to represent the different instruments. For 
  example, the `AddInstrumentParser` class which serves as the foundation for the add functionality which provides 
  easy extensibility to allow the developers to adopt and implement different types of instruments.
  * Proposed `edit` functionality design through this PR [#130](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/130).
    * Came up with a design that implements edit feature with only one parser class `EditInstrumentParser` and one command 
    class `EditInstrumentCommand`. The helps to reduce the amount of code we needed to write and allows user to edit 
    multiple parameters at once. This was done by making use of the fact that the edit functionality is done on an 
    existing instrument. We can then use this fact to determine the type of instrument and the kind of parameters supported 
    by that type of instrument. 
    * The design also provides extensibility for any parameters changes made to any of the 
    instrument classes. This is because only the instrument class with the parameter change will need to be modified.
  
* **Enhancements**:
  * **New Feature:** Provided the add `stock` into watchlist functionality.
    * Building on the foundations of `add` functionality, I implemented the `add stock` functionality to allow users to
    store stock information into `mTracker`.
    * Justification: This feature is one of the core features given that `stock` is a widely known instrument type in the
    financial markets and is something our user would require support for.
  * **New Feature:** Provided the `delete` from watchlist functionality.
    * The `delete` functionality allows user to remove an instrument from the watchlist.
    * Justification: This is another core feature as the financial markets is something that changes with time,
    so it is expected that the user will need to constantly update their watchlist by removing instruments that are not
    useful to them.
    * Highlights: Considerations were taken to decide on how to parse the command of the index values. Previously the
    error checking and handling was done in the `DeleteCommand` class which reduced the cohesion of the class. As input
    validations and error checking are done in the parser class, it made sense to shift the index checking into the parser
    classes.
  * **Feature depth:** Add support for date type in the expiry attribute for the instruments.

* **Documentation:**
  * **UG**
    * Contributed to the add stock section through PR [#72](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/72)
  * **DG**
    * Wrote the `parser` section under Design with the design considerations for add and edit functionality.
    * Wrote the `add instrument feature` section under Implementation.
    * Created 4 diagrams:
      * Architecture [#here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/ArchitectureDiagram.png).
      * Console diagram [#here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/ConsoleDiagram.png).
      * Add stock diagram [#here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/AddStockSequenceDiagram.png).
      * Add stock reference diagram [#here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/AddStockSequenceDiagramRef.png).
* **Contributions to team-based tasks**
  * Set up the Github team org/repo.
  * Contributed to some code refactorings such as standardising the error handling and creating custom exception from 
  PR [#144](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/144)
  * Reviewed most of the PRs to ensure that the code quality standards are met and the implementation follow the
  sound design principles. Example of such PRs: [#35](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/35)
    [#41](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/41)
    [#76](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/76)
    [#98](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/98)
  * Reviewed sequence diagram PRs to ensure that the uml conventions and styles are followed. Example PR [#here](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/131)
  * Updated the issue tracker by reporting bugs and code quality issues. Example of issues:
    [#26](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/26)
    [#92](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/92)
    [#148](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/148)
  * Released v2.0 jar file link [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/releases/tag/v2.0-release).
