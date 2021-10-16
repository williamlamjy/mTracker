# MTracker User Guide

## Introduction

mTracker is a **command-line based trading journal interface** that **allows 
investors and traders to store and view important trading related information** on their 
shortlisted financial instruments for **reference and decision-making**. It **summarises 
key details** into an **easy-to-read format and provides convenient lookups for trade setups**
for busy individuals.


## Quick Start

1. Ensure that you have Java `11` installed on your computer.
2. Down the latest version of `MTracker` from [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/releases).
3. Copy the jar file to a folder that you want to run MTracker from.
4. At the folder where you copied the jar file run the command `java -jar TP.jar` in terminal.
5. If MTracker starts successfully, you should see the following output:
```
________________________________________________________________________________
            _________                      __
           |  _   _  |                    [  |  _
 _ .--..--.|_/ | | \_| .--.  ,--.   .---.  | | / ] .---.  _ .--.
[ `.-. .-. |   | |  [ `/'`\]`'_\ : / /'`\] | '' < / /__\\[ `/'`\]
 | | | | | |  _| |_  | |    /| | |,| \__.  | |`\ \| \__., | |
[___||__||__]|_____|[___]   \'-;__/'.___.'[__|  \_]'.__.'[___]

Hello! I am mTracker, your personal assistant bot that
helps you keep track of the markets.
What should I do for you now? ☺
________________________________________________________________________________
```

## Features 

## Notes about command format
* Words in `UPPER_CASE` represent the parameters to be supplied by user. Below we have a list of parameters
  that we would be referring to throughout this user guide.
    * `NAME` represents the name of instrument to be specified by user.
    * `PRICE` represents the price specified by the user.
    * `DATE` represents the date specified by the user in `YYYY MM DD` format.
    * `REMARKS` represents the remarks specified by the user.
    * `INDEX` represents the index value of an instrument. The index value would correspond to the instrument's
      position in the list.
      * For example the first instrument in the list would have an index value of 1 while 
      the 3rd instrument in the list would have a
  value of 3.
* Extraneous parameters for commands `list` and `bye` would be ignored.
    * For example the command `bye 123`
      would be interpreted as `bye`.

{Give detailed description of each feature}

## Adding a new instrument: `add`
Adds a new instrument to your watchlist of instruments. 

Format: `add`

Upon typing the `add` command, an instruction prompt below would be displayed to guide you through the process of
adding a new instrument.

```
mTracker$> add
	Please key in the type of instrument: 
```

MTracker currently supports 4 different types of instruments.
The 4 types are `stock`, `etf`, `crypto` and `forex`. 

### Adding a new `stock`
The addition of a new stock expects 4 parameters.
* `Name` Name of the stock. Empty name is not allowed.
* `Current price` Current price of the stock. Requires a positive number.
* `Sentiment` Sentiment of the stock. Requires one of the following types: `positive`, `neutral` or `negative`.
* `Remarks` Any additional optional remarks about the stock.

Example usage
```
mTracker$> add
	Please key in the type of instrument: 
mTracker$> stock
	Name of stock: 
mTracker$> IBM
	Current Price: 
mTracker$> 144.61
	Sentiment for instrument: 
mTracker$> positive
	Remarks (optional): 
mTracker$> 
```

By following the instructions above, a new stock would be added and an acknowledgement message would appear.
Following the usage example above we would see the following message:
```
	[S]IBM
```

Note: If any of the non-optional parameters `Name`, `Current price` and `Sentiment` are provided with invalid
inputs, you would be prompted to give a valid input.




## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
