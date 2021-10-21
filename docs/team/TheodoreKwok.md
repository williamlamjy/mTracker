# Theodore Kwok - Project Portfolio Page

## Overview
I was involved in the development of a greenfield project known as `mTracker`. The `mTracker` program
serves as a command-line trading journal interface that allows busy individuals to store important financial instrument.
Throughout the project development, my main responsibilities include 
* Being the main code reviewer, conducting code quality and implementation checks on pull requests (PR).
* Designing and proposing software architectures to implement some core features such as adding and editing
the different financial instruments.
* Implementing different features in mTracker.
* Contributed to project management by updating the issues on issue tracker and noting down any possible ways we can
improve on code quality and design.

## Summary of Contributions
Below are some of my contributions to the project

* Implemented the foundations for `add` functionality. Seen in PR
[#18](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/18) and 
[#20](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/20)
  * Designed how the add instrument functionality would work by taking into consideration how the design of user 
  inputs, using Object Oriented Programming (OOP) to represent the different instruments and error handling.

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

* **Enhancement:** Add support for date type in the expiry attribute for the instruments.

* **Documentation:**

* **Community**
  * Reviewed most of the PRs to ensure that the code quality standards are met and the implementation follow the
  sound design principles. Example of such PRs: [#35](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/35)
    [#41](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/41)
    [#76](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/76)
    [#98](https://github.com/AY2122S1-CS2113T-T12-1/tp/pull/98)
  * Updated the issue tracker by reporting bugs and code quality issues. Example of issues:
    [#26](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/26)
    [#92](https://github.com/AY2122S1-CS2113T-T12-1/tp/issues/92)
  * The `AddInstrumentParser` class which served as the foundation for the add functionality provided easy extensibility
  to allow the developers to adopt and implement different types of instruments.
