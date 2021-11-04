# William Lam - Project Portfolio Page

## Overview
I was involved in the development of a greenfield project known as `mTracker`. The `mTracker` program
serves as a command-line trading journal interface that allows busy individuals to store important financial instrument.
Throughout the project development, my main responsibilities include:
* Providing assisting code reviews to ensure code quality and implementation is of high quality.
* Implementing different features in mTracker.
* Contributed to project management by updating issues on issue tracker and noting down any possible ways we can
  improve on code quality and design.
* Ensured high code quality by doing code refactoring for classes such as `Validate` and `AddXYZParserTest` and fixed
multiple bugs present in the code.

## Summary of Contributions
Below are some of my contributions to the project

* **Code contributed:**
    * The code I contributed can be found in the reposense link [here](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=T12-1&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=functional-code~other~test-code~docs&since=2021-09-25&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=williamlamjy&tabRepo=AY2122S1-CS2113T-T12-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code~test-code~docs&authorshipIsBinaryFileTypeChecked=false)
* **Design architecture of filemanager component**
  * Implemented the InstrumentEncoder, Storage and XYZDecoder classes. Seen in PR
    [#76](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/76) and
    [#108](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/108) and
    [#209](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/209)
  * Designed how the storage of data operates and split the process into encoding and decoding processes. The
  `InstrumentDecoder` is further abstracted into `XYZDecoder` classes which improves extensibility to allow greater code
  re-usability for developers to include more instruments in the future. This further improves code cohesion and more 
  focus can be placed to abstracting each instrument type.

* **Design architecture of model component**
  * Implemented the foundations of the `Instrument`, `InstrumentManager` and `subinstrument` classes. Seen in PR
    [#19](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/19)
    * Designed the basic structure of how the instruments are stored and edited through the `InstrumentManager` such
    that other developers could easily further enhance the respective subinstruments with their specific attributes and
    methods.

* **Enhancements**:
    * **New Feature:** Provided the add `crypto` into watchlist functionality.
    * implemented the `add crypto` functionality to allow users to
      store crypto information into `mTracker`.
    * Justification: This feature is one of the core features given that `crypto` is a widely known instrument type in 
  the financial markets and is something our user would require support for.
    * **New Feature:** Provided the `done` from watchlist functionality.
    * The `done` functionality allows the user to mark an instrument as completed in their watchlist.
    * Justification: This is another core feature to allow users to keep track of the many instruments they have by
  marking it as done if they for example sold the instrument. This allows for easier updates on instruments.
    * Highlights: The `done` functionality differs from other functionalities as it requires encoding and decoding
  features with the `filemanager` component to store the instrument's status. Thus, extra considerations were taken in
  implementation of the done feature such that it could be stored as an attribute in pre-existing instruments.

* **Documentation:**
  * **UG**
    * Contributed to the add crypto section and summary page through PR [#73](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/73)
    * Contributed to the contents page with hyperlinks through PR [#143](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/143)
  * **DG**
    * Wrote the `filemanager` component.
    * Wrote the `model` component.
    * Wrote implementation for `Storing current data` and `Loading pre-existing data` to show the implementation of
    encoding and decoding processes.
    * Assisted in the implementation of the `done` command by drawing the sequential diagram.
    * Created 8 diagrams:
      * Model Diagram [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/ModelDiagram.png)
      * FileManager Diagram [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/FileManagerDiagram.png)
      * Instrument Encoder Diagram [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/FileManagerEncodingSequenceDiag.png)
      * 