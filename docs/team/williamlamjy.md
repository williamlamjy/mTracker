# William Lam - Project Portfolio Page

## Overview
I was involved in the development of a greenfield project known as `mTracker`. The `mTracker` program
serves as a command-line trading journal interface that allows busy individuals to store important financial instruments.
My main responsibilities include:
* Providing assisting code reviews to ensure code quality and implementation is of high quality.
* Implementing different features in mTracker.
* Contributed to project management by updating issues on issue tracker and noting down any possible ways we can
  improve on code quality and design.
* Ensured high code quality by doing code refactoring and fixed multiple bugs present in the code.

## Summary of Contributions
Below are some of my contributions to the project

* **Code contributed:**
    * The code I contributed can be found in the reposense link [here](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=T12-1&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=functional-code~other~test-code~docs&since=2021-09-25&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=williamlamjy&tabRepo=AY2122S1-CS2113T-T12-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code~test-code~docs&authorshipIsBinaryFileTypeChecked=false)
* **Design architecture of filemanager component**
  * Implemented the InstrumentEncoder, Storage and Decoder classes. PRs[#76](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/76) 
[#108](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/108) [#209](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/209)
  * Designed how the storage of data operates and split the process into encoding and decoding processes. The
  `InstrumentDecoder` is further abstracted into `XYZDecoder` classes which improves extensibility to allow greater code
  re-usability. This further improves code cohesion and more focus can be placed to abstracting each instrument type. A 
  lot of thought and effort was put in to achieving this high level of SLAP. 

* **Design architecture of model component**
  * Implemented the foundations of the `Instrument`, `InstrumentManager` and `subinstrument` classes. PR [#19](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/19)
  * Designed the structure of how the instruments are stored and edited through the `InstrumentManager` such that 
  developers could easily further enhance the respective sub-instruments with their specific attributes and methods.

* **Enhancements**:
    * **New Feature:** Provided the add `crypto` into watchlist functionality. Implemented the `add crypto` functionality to allow users to store crypto information into `mTracker`.
    * Justification: One of the core features as `crypto` is widely used in the financial markets and requires support
    * **New Feature:** Provided the `done` functionality. The `done` functionality allows the user to mark an instrument as completed in their watchlist.
    * Justification: This is another core feature to allow users to keep track of the many instruments they have by
  marking it as done if they for example sold the instrument. This allows for easier updates on instruments.
    * Highlights: The `done` functionality differs from other functionalities as it requires encoding and decoding
  features with the `filemanager` component to store the instrument's status. Thus, extra considerations were taken in
  implementation of the done feature such that it could be stored as an attribute in pre-existing instruments.

* **Documentation:**
  * **UG**
    * Contributed to the add crypto section and summary page through PR [#73](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/73)
    * Contributed to the contents page with hyperlinks through PR [#143](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/143)
    * Provide feedback for formatting and wording PR [#248](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/248)
  * **DG**
    * Wrote the `filemanager` component.
    * Wrote the `model` component.
    * Wrote implementation for `Storing current data` and `Loading pre-existing data` to show the implementation of
    encoding and decoding processes.
    * Assisted in the implementation of the `done` command by drawing the sequential diagram.
    * Created 8 diagrams:
      * [Model](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/ModelDiagram.png)
    [FileManager](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/FileManagerDiagram.png)
    [InstrumentEncoder](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/FileManagerEncodingSequenceDiag.png)
    [InstrumentDecoder](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/FileManagerSeqBetweenStorageAndDecoder.png)
    [InstrumentDecoderRef](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/FileManagerSequenceDiagram.png)
    [CryptoDecoderRef](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/FileManagerRefDiagCryptoDecoder.png)
    [DoneCommand](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/DoneCryptoSequenceDiagram.png)
    [DoneCommandRef](https://github.com/AY2122S1-CS2113T-T12-1/tp/blob/master/docs/images/DoneCryptoExecuteDiagram.png)
    * Provided user stories through PR [#152](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/152)
  * **Contributions to team-based tasks**
    * Contributed to some code refactorings:
      * Refactoring validation methods into `Validate` in the `commons` package from PR [#122](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/122)
      * Standardising junit parser tests into the same format from PR [#121](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/121)
    * Contributed to some bug fixes:
      * Fixing non-positive current price inputs from PR [#198](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/198)
      * Enabling multiple invalid instrument type inputs when adding an instrument from PR [#198](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/198)
      * Enabling upper-casing for command inputs from PR [#204](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/204)
      * Handling file separator issues in input by using a special char from PR [#199](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/199)
    * Reviewed some PRs to ensure that the code quality standards are met and the implementation follow the
      sound design principles. Example of such PRs: [#144](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/144)
    [#20](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/20)
    [#79](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/79)
    * Managed issues in the issue tracker by addressing issues with comments and assigning issues to the corresponding
    developer. Examples: [#191](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/191)
    [#186](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/186)
    [#182](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/182)
    [#179](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/179)
    * **Contributions beyond team-based tasks**
      * Helped in a query in the forum [here](https://github.com/nus-cs2113-AY2122S1/forum/issues/28)
      * Reported 17 bugs in another team's program [here](https://github.com/williamlamjy/ped/issues)