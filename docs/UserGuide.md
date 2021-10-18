# mTracker User Guide

## Introduction

mTracker is a **command-line based trading journal interface** that **allows 
investors and traders to store and view important trading related information** on their 
shortlisted financial instruments for **reference and decision-making**. It **summarises 
key details** into an **easy-to-read format and provides convenient lookups for trade setups**
for busy individuals.


## Quick Start

1. Ensure that you have Java `11` installed on your computer.
2. Download the latest version of `MTracker` from [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/releases).
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

## Usage
### *Notes on command format*
> * Words in `UPPER_CASE` represent the parameters to be supplied by user. These are the list of parameters
>that would be referred to throughout this user guide.
>    * `DATE` represents the date specified by the user in `YYYY MM DD` format.
>    * `SENTIMENT` represents the general opinion towards an instrument. It can only take 3 different values: 
>`positive`, `neutral` or `negative`.
>    * `REMARKS` represents the remarks specified by the user.
>    * `INDEX` represents position index at which the instrument appears in the displayed list.
>      * For example the first instrument in the list would have an position index of 1 while 
>      the 3rd instrument in the list would have a
>position index of 3.
>* Extraneous parameters for commands `list` and `bye` would be ignored.
>    * For example the command `bye 123`
>      would be interpreted as `bye`.

### Adding a new instrument: `add`
Adds a new instrument to the watchlist of instruments. 

Format: `add`

Upon entering the `add` command, instruction prompts would be displayed to guide you through the process of
adding a new instrument. They are explained for the respective instruments in the subsequent sections below.

```
mTracker$> add
	Please key in the type of instrument: 
```

MTracker currently supports 4 different types of instruments.
The 4 types are `stock`, `etf`, `crypto` and `forex`. 

### Adding a new `stock`
After keying in `stock` as type of instrument to be added, the following 4 parameters are expected:
* `Name` Name of the stock. Empty name is not allowed.
* `Current price` Current price of the stock. Requires a positive number.
* `Sentiment` Sentiment of user towards the stock.
* `Remarks` Any additional optional remarks about the stock that the user would like to record.

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

By following the instructions above, a new stock would be added, and an acknowledgement message would appear.
Following the usage example above would produce the following message:
```
	[S]IBM
```

Note: If any of the non-optional parameters `Name`, `Current price` and `Sentiment` are provided with invalid
inputs, you would be prompted to give a valid input.

### Adding a new `etf`
An exchange-traded fund (ETF) is a security that tracks an index, sector, commodity, or any
other asset. After keying in `etf` as the type of instrument, mTracker expects the 
following parameters:
* `Name` Name of the ETF. Empty name is not allowed.
* `Current price` Current price of the stock. Requires a positive number.
* `Sentiment` Sentiment of user towards the stock.
* `Returns` Optional input for past returns of the etf.
* `Remarks` Any additional optional remarks about the etf that the user would like to record.

Example usage
```
mTracker$> add
	Please key in the type of instrument: 
mTracker$> etf
	Name of etf: 
mTracker$> SPY
	Current Price: 
mTracker$> 445.87
	Sentiment for instrument: 
mTracker$> positive
    Past Returns (optional): 
mTracker$> 1200
	Remarks (optional): 
mTracker$> Prices will plateau out in a few days.
```
**Expected outcome**

When the above ETF is added successfully, the following acknowledgement will be printed
out:
```
	[E]SPY
```

### Adding a new `forex`
Bilateral currency pairs, known as forex pairs, are traded in the currency market
and mTracker provides the ability to add forex pairs to its watchlist too.
After keying in `forex` as the type of instrument, mTracker prompts for the
following parameters:
* `Name` Name of the ETF. Empty name is not allowed.
* `Current Price` Current price of the stock. Requires a positive number.
* `Sentiment` Sentiment of user towards the stock.
* `Entry Price` Price at which to open an order for the forex pair.
* `Exit Price` Price at which to close the order.
* `Expiry` The date by which this trade setup should be executed.
* `Remarks` Any additional optional remarks about the forex that the user would like to record.
   (Eg. trade deficits between countries, FOMC meeting dates,
   interest rates outlook in currency's home country, etc.)

Example usage
```
mTracker$> add
	Please key in the type of instrument: 
mTracker$> forex
	Name of forex: 
mTracker$> USDJPY
	Current Price: 
mTracker$> 114.289
	Sentiment for instrument: 
mTracker$> negative
	Entry price: 
mTracker$> 114.20
	Exit price: 
mTracker$> 110.0
	Expiry: 
mTracker$> 23 Oct
	Remarks (optional): 
mTracker$> USD is losing momentum. Technical levels are holding firm.
```
**Expected outcome**

When the above forex pair is added successfully, the following acknowledgement will be printed
out:
```
	[F]USDJPY
```

### To display general info of all instruments added: `list`

mTracker displays the 3 general parameters of `Name`, `Current Price`, 
and `Sentiment` for all instruments added in an easy-to-view format, alongside
their execution status marked by an [X].

**Example usage**

```
mTracker$> list
```

**Expected outcome**

```
CURRENT WATCHLIST
1. [S][ ] IBM; 144.61; positive
2. [E][ ] SPY; 445.87; positive
3. [C][X] bitcoin; 14442.22; positive
4. [F][ ] USDJPY; 114.289; negative
```

### To view more info recorded for an instrument: `view`

Since there are many different parameters that are recorded for
various instruments, to view all the recorded information for an
instrument apart from the general information presented
by the output of the `list` command, the `view` command can be used.

**Format**

```
mTracker$> view INDEX
```

**Example usage**

```
mTracker$> view 2
```

**Expected outcome**

All the parameters for the instrument at the requested index 
will be printed out:

```
________________________________________________________________________________
Type: Etf
Name: SPY
Current Price: 445.87
Sentiment: positive
Past Returns: 1200
Remarks: Prices will plateau out in a few days.
________________________________________________________________________________
```

### To mark a setup as acted upon: `done`

mTracker provides the ability for you to mark a particular
record of an instrument in the watchlist as executed or acted upon.

**Format**

```
mTracker$> done INDEX
```

**Example usage**
```
mTracker$> done 1
```

**Expected output**

Marks the first instrument in watchlist as complete,
and the following confirmation message will be displayed:

```
Okay, IBM has been marked as acted upon!
```

In this example, the first instrument is `IBM` so it has been
checked as complete.

### Removing an instrument record: `delete`

You can remove a instrument from the watchlist as you deem 
fit with the index number of the instrument in inventory.

**Format**

```
mTracker$> delete INDEX
```

**Example usage**

```
mTracker$> delete 4
```

**Expected outcome**

The 4th instrument in the watchlist is removed, 
and the remaining instruments' index numbers are updated accordingly.

```
USDJPY removed from watchlist.
Now you have 3 instruments in the watchlist.
```

You can key in `list` once again to view the latest watchlist.

### To search for instruments in watchlist: `find`

You can find specific instruments in the watchlist by searching for them through `find` command.

**Format**

```
mTracker$> find SEARCH_STRING
```

**Example usage**

```
mTracker$> find py
```

**Expected outcome:**

Any instrument name which contains the SEARCH_STRING will be returned 
- regardless of character case - alongside their watchlist index:

```
        ------------------------------------------------------------
	Instruments found for keyword, py
	2| [E][ ] SPY; 445.87; positive
	4| [F][ ] USDJPY; 114.289; negative
	------------------------------------------------------------
```

In the event that there were no instruments found for the input
SEARCH_STRING, the following message will be printed out:

```
No instruments found for keyword, py
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
