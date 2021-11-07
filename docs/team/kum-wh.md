# Kum Wing Ho - Project Portfolio Page

## Overview
I was involved in the development of a greenfield project known as `mTracker`. The `mTracker` program
serves as a command-line trading journal interface that allows busy individuals to store important financial instrument.
Throughout the project development, my main responsibilities include:
* Implementing and handling bugs relenting to `Etf` instrument and adding it to the watchlist.
* Implementing and handling bugs relenting to `edit` feature.
* Implementing and handling bugs relenting to `list` feature.

## Summary of Contributions
Below are some of my contributions to the project

**Code contributed:**

The code I contributed can be found in the reposense link [here](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=T12-1&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=functional-code~other~test-code~docs&since=2021-09-25&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=kum-wh&tabRepo=AY2122S1-CS2113T-T12-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code~test-code~docs&authorshipIsBinaryFileTypeChecked=false)

**Enhancements**:
* **New Feature:** Provided the add `etf` into watchlist functionality.
  * Implemented the `add etf` functionality to allow users to
    store crypto information into `mTracker`.
  * Justification: This feature is one of the core features given that `crypto` is a widely known instrument type in
    the financial markets and is something our user would require support for.
* **New Feature:** Provided the `edit` functionality.
  * The `edit` functionality allows the user to edit a current instrument parameters
  * Justification: This is a core feature that allow users to edit current instruments they added. This allows for updates of parameters on the instruments.
  * Highlights: The `edit` functionality is required to interact with all instrument type and require requesting of inputs from user.
* **New Feature:** Provided the `list` functionality.
  * The `list` functionality allows the user to view all instruments and their general parameters.
  * Justification: This is a core feature that provide users with a way to view all their instruments they have added.

**Documentation:**


  * **UG**
    * Wrote the Edit feature section.[#96](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/96/files)
    * Wrote the Abort Operation section. [#246]()
    * Wrote the FAQ section.


* **DG**
  * Wrote the `command` component.[#100](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/100/files)
  * Wrote the done instrument feature section under Implementation.
  * Wrote the edit instrument feature section under Implementation.[#230](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/230/files)
  * Created 4 diagrams:
    * Edit Parser Sequence Diagram [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/.EditInstrumentSequenceDiagram.png).
    * Edit Parser Reference Diagram [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/EditRefrence.png).
    * Edit Execution Sequence Diagram [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/EditExecuteSequenceDiagram.png).
    * Edit Execution Reference Diagram [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/EditExecuteRefrence.png).
  
  
* **Contributions to team-based tasks**
    * Released v1.0 jar file link.
    * Writing of JavaDoc for Model, Commands, ui components and the EditInstrumentParser class.[#240](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/240)
    * Implementation of a feature that improve readability, by adding a new line when the text printed is long.
      The feature was eventually deemed as unnecessary and not implemented. [#133](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/133)