# Vignesh's Project Portfolio Page

## Project Overview: mTracker

mTracker is a **CLI-based trading journal** that allows
user to store and view important trading-related information on their
shortlisted financial instruments. The program allows users to store
information on 4 types of instruments: Stock, ETF, Forex, Cryptocurrency. 
mTracker is written in Java 11 and contains over 5000 LoC.

### My key contributions to the project:

- Tested out various real-time market data API provider for initial idea of 
  implementing real-time capabailities in program. Coded and tried out a HTTP client
  server in Java. Idea was later discarded by team for various reasons.
- Project was mainly divided among group members based on instrument types.
I was in charge of implementing all forex-related command and parser classes, and their testing.
- Implemented the find feature, which allows users to search for 
instruments saved in the watchlist using their input search term.
- Was instrumental in beautifying the program's UI. Coded the ACSII patterns
for bye, and mTracker logo at startup.
- Made sure that error messages were consistent in formatting with fullstops 
and commas. Also made sure grammar is correct for the error messages and the UG due to 
  my strength in language.
- Coded the main run method in MTracker class and also the bye command for exiting
program.
- Abstracted out IndexedCommand class to handle index input by user, and
managing it alongside view, delete, done, and edit command classes.
- Abstracted out AddInstrumentParserTest class for all other instruments' addition parser test classes
to depend on.
  
### Code contributed

[Vignesh's tP Code Dashboard](https://nus-cs2113-ay2122s1.github.io/tp-dashboard/?search=vignesh&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-25&tabOpen=true&tabType=authorship&tabAuthor=KVignesh122&tabRepo=AY2122S1-CS2113T-T12-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false)

### Enhancements
- Improved user-friendliness and aesthetics of program by
  making list command to display only the 3 main parameters for all instruments
  in the watchlist. Implemented a separate View feature for user to 
  take deeper look into any one of the stored financial instruments.
- Implemented abort feature in Add and Edit operations for user to exit
the process of adding/editing an instrument prematurely.
- Wrote extensive Junit tests for testing abort and addition of instrument features
for crypto and forex.
  
### Documentation:
- Reviewed grammar and sentence structure of all UG and DG content; made edits to enhance clarity.
- Contributed UML class diagram for Command classes in DG: [#238](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/238)
- Designed TextUi sequence diagram for List and View commands in DG: [#231](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/231)
- Wrote more than 60% of the UG. ([#88](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/88))
- Wrote Architecture section in DG: [#89](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/89)

### Team contributions:
- Major PRs reviewed: [#211](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/211) 
  [#95](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/95)
  [#91](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/91)
  [#83](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/83)
- Prepared the agenda, scheduled and conducted weekly project meetings outside of tutorial/lecture time.
- Assisted team members with Gradle setup.
- Planned and maintained team's GitHub issue tracker: [#29](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/29)
[#36](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/36)
  [#84](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/84)
  [#141](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/141)
- Improved overall code quality by abstracting out repetitive codeblocks as
    methods, and removed redundant setters and getters. [#92](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/92)
