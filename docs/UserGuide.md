# mTracker User Guide
![foo](images/mTracker_logo_cropped.png)

## Introduction

mTracker is a **command-line based trading journal interface** that **allows 
investors and traders to store and view important trading related information** on their 
shortlisted financial instruments for **reference and decision-making**. It **summarises 
key financial details** into an **easy-to-read format and provides convenient lookups for trade setups**
for busy individuals. The instruments currently supported by the product are Stocks, ETFs,
 Forex, and Cryptocurrencies.

This user guide explains the key features of mTracker and includes examples of 
their usages. The contents table below includes clickable hyperlinks for you to 
navigate directly to a section of your preference.

The _**Quick Start**_ section provides you with the instructions to download the product, and the necessary software specifications 
needed so that you can start using mTracker on the go! The _**FAQ**_ section towards the 
end of this guide answers possible queries that you may have of this product, and the
eventual _**Command Summary**_ section gives a brief overview of the different types of
command-line commands mTracker intakes to execute the various functionalities.

## _Contents_
* [1.0 Quick Start](#10-quick-start)
* [2.0 Usage](#20-usage)
    * [Notes on command format](#notes-on-command-format)
    * [2.1.0 Add a new instrument: `add`](#210-adding-a-new-instrument-add)
      * [2.1.1 Add a new stock: `stock`](#211-adding-a-new-stock)
      * [2.1.2 Add a new crypto: `crypto`](#212-add-a-new-crypto)
      * [2.1.3 Add a new etf: `etf`](#213-adding-a-new-etf)
      * [2.1.4 Add a new forex: `forex`](#214-adding-a-new-forex)
    * [2.2.0 List all instruments: `list`](#220-displaying-general-info-of-all-instruments-added-list)
    * [2.3.0 View instrument info: `view`](#230-viewing-more-info-recorded-for-an-instrument-view)
    * [2.4.0 Mark an instrument done: `done`](#240-marking-a-setup-as-acted-upon-done)
    * [2.5.0 Edit an instrument: `edit`](#250-editing-an-instrument-edit)
    * [2.6.0 Abort an operation: `abort`](#260-aborting-an-operation-abort)
    * [2.7.0 Remove an instrument: `delete`](#270-removing-an-instrument-record-delete)
    * [2.8.0 Search for an instrument: `find`](#280-search-for-instruments-in-watchlist-find)
    * [2.9.0 Exit the application : `bye`](#290-exiting-the-bot-bye)
* [3.0 FAQ](#30-faq)
* [4.0 Command Summary](#40-command-summary)



## 1.0 Quick Start

1) Ensure that you have Java `11` installed on your computer.  
2) Download the latest version of `mTracker` from [here](https://github.com/AY2122S1-CS2113T-T12-1/tp/releases).  
3) Copy the jar file to a folder that you want to run mTracker from.  
4) At the folder where you copied the jar file run the command `java -jar [CS2113T-T12-1][mTracker].jar` in terminal.  
5) If mTracker starts successfully, you should see the following greeting:  

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
What should I do for you now?
________________________________________________________________________________
```

## 2.0 Usage
### *Notes on command format*
> * Words in `UPPER_CASE` represent the parameters to be supplied by user. This is the list of parameters
>that would often be referred to throughout this user guide.
>    * `TYPE` represents the type of the instrument. mTracker currently
       supports 4 different types of instruments: `stock`, `etf`, `crypto` and `forex`.
>    * `INDEX` represents position index at which the instrument appears in the displayed list.
>      * For example, the first instrument in the list would have a position index of 1 while 
>      the 3rd instrument in the list would have a
>position index of 3.
>    * `SEARCH_STRING` represents the phrase or word user would like to search for in the watchlist with the `find` command.
>* Extraneous parameters for all commands would be ignored.
>    * For example, the command `bye 123`
>      would be interpreted as `bye`.
>    * The command `view 2 5` will be interpreted as `view 2`, so financial details of the second item in the watchlist
> will be printed out.
>* Instrument attributes that require fixed inputs and all commands are case-insensitive.
   >    * For example, the command `ADd` would be interpreted as `add`.
   >    * The `sentiment` input `POsiTive` would be accepted as `positive`.

### 2.1.0 Adding a new instrument: `add`
Adds a new instrument to the watchlist of instruments. If at any point in time you want to terminate the `add`
process, type in `abort` without any additional characters and mTracker will bring you back to the main workspace.

**Example usage**
```
mTracker$main> add
```

**Expected outcome**

Upon entering the `add` command, mTracker prompts for the type of 
instrument to be added:

```
mTracker$main> add
	Please key in the type of instrument:
mTracker$add> TYPE 
```

After the desired instrument type is input, instruction prompts would be displayed to guide you through the process of
adding the new instrument. They are explained for the respective instrument types in the following sections below.

### *2.1.1 Adding a new `stock`*
After keying in `stock` as type of instrument to be added, the following 4 parameters are expected:
* `Name` Name of the stock. Empty name is not allowed.
* `Current price` Current price of the stock. Requires a positive number.
* `Sentiment` Sentiment of user towards the stock. Only accepts `positive`, `neutral` and `negative`.
* `Remarks` Any additional optional remarks about the stock that the user would like to record.

**Example usage**
```
mTracker$main> add
	Please key in the type of instrument: 
mTracker$add> stock
	Name of stock: 
mTracker$add> IBM
	Current Price: 
mTracker$add> 144.61
	Sentiment for instrument: 
mTracker$add> positive
	Remarks (optional): 
mTracker$add> 
```

**Expected outcome**

By following the instructions above, a new stock would be added, and an acknowledgement message would appear.
Following the usage example above would produce the following message:
```
	[S][ ] IBM; 144.61; positive - has been added to list.
```

_**Note: If any of the non-optional parameters `Name`, `Current price` and `Sentiment` are provided with invalid
inputs, mTracker would prompt you once again to give a valid input.**_

### *2.1.2 Add a new `crypto`*
The addition of a new `crypto` expects 5 parameters:
* `Name` Name of the crypto. Empty name is not allowed.
* `Current Price`  Current price of the crypto. Requires a positive number.
* `Sentiment` Sentiment of the crypto. Only accepts `positive`, `neutral` and `negative`.
* `Expiry` Expiry date of the crypto. Date only in the `YYYY-MM-DD` format is allowed, and it should be a date in the future.
* `Remarks` Any additional optional remarks about the cryptocurrency the user would like to keep
  note of in mTracker.

**Example usage**

```
mTracker$main> add
	Please key in the type of instrument: 
mTracker$add> crypto
	Name of crypto: 
mTracker$add> bitcoin
	Current Price: 
mTracker$add> 14442.22
	Sentiment for instrument: 
mTracker$add> positive
	Expiry (YYYY-MM-DD): 
mTracker$add> 2021-12-14
	Remarks (optional): 
mTracker$add> 
```

**Expected outcome**

By following the instructions above, a new crypto would be added and an acknowledgement message would appear.
Following the usage example above we would see the following message:

```
	[C][ ] bitcoin; 14442.22; positive - has been added to list.
```

_**Note: If any of the non-optional parameters `Name`, `Current price`, `Sentiment` and `Expiry` are provided with invalid
inputs, you would be prompted to give a valid input.**_

### *2.1.3 Adding a new `etf`*
An exchange-traded fund (etf) is a security that tracks an index, sector, commodity, or any
other asset. After keying in `etf` as the type of instrument, mTracker expects the 
following parameters:
* `Name` Name of the etf. Empty name is not allowed.
* `Current price` Current price of the etf. Requires a positive number.
* `Sentiment` Sentiment of user towards the etf. Only accepts `positive`, `neutral` and `negative`.
* `Past returns` Optional input for past returns of the etf.
* `Remarks` Any additional optional remarks about the etf that the user would like to record.

**Example usage**
```
mTracker$main> add
	Please key in the type of instrument: 
mTracker$add> etf
	Name of etf: 
mTracker$add> SPY
	Current Price: 
mTracker$add> 445.87
	Sentiment for instrument: 
mTracker$add> positive
	Past Returns (optional): 
mTracker$add> 1200
	Remarks (optional): 
mTracker$add> Prices will plateau out in a few days.
```
**Expected outcome**

When the above ETF is added successfully, the following acknowledgement will be printed
out:
```
	[E][ ] SPY; 445.87; positive - has been added to list.
```

### *2.1.4 Adding a new `forex`*
Bilateral currency pairs, known as forex pairs, are traded in the currency market
and mTracker provides the ability to add forex pairs to its watchlist too.
After keying in `forex` as the type of instrument, mTracker prompts for the
following parameters:
* `Name` Name of forex. Empty name is not allowed and forex pairs' names should be 
  6 letters long. (Eg. AUDUSD instead of AUD USD, or Australian dollar-US dollar, or AUD/USD)
* `Current Price` Current price of the etf. Requires a positive number.
* `Sentiment` Sentiment of user towards the etf. Only accepts `positive`, `neutral` and `negative`.
* `Entry Price` Price at which to open an order for the forex pair.
* `Exit Price` Price at which to close the order.
* `Expiry` The date by which this trade setup should be executed. Dates only in the `YYYY-MM-DD` format and in the future are allowed.
* `Remarks` Any additional optional remarks about the forex that the user would like to record.
   (Eg. trade deficits between countries, FOMC meeting dates,
   interest rates outlook in currency's home country, etc.)

**Example usage**

```
mTracker$main> add
	Please key in the type of instrument: 
mTracker$add> forex
	Name of forex: 
mTracker$add> USDJPY
	Current Price: 
mTracker$add> 114.289
	Sentiment for instrument: 
mTracker$add> negative
	Entry Price: 
mTracker$add> 114.20
	Exit Price: 
mTracker$add> 110.0
	Expiry (YYYY-MM-DD): 
mTracker$add> 2021-12-13
	Remarks (optional): 
mTracker$add> USD is losing momentum. Technical levels are holding firm.
```
**Expected outcome**

When the above forex pair is added successfully, the following acknowledgement will be printed
out:
```
	[F][ ] USDJPY; 114.289; negative - has been added to list.
```

_**Note: If any of the non-optional parameters `Name`, `Current price`, `Sentiment`, `Extry Price`, `Exit Price`,
and `Expiry` are provided with invalid
inputs, you would be prompted to give a valid input.**_

### 2.2.0 Displaying general info of all instruments added: `list`

mTracker displays the 3 general parameters of `Name`, `Current Price`, 
and `Sentiment` for all instruments added in an easy-to-view format, alongside
their execution status marked by an `[X]`.

**Example usage**

```
mTracker$main> list
```

**Expected outcome**

```
________________________________________________________________________________
CURRENT WATCHLIST
1) [C][X] bitcoin; 14442.22; positive
2) [E][ ] SPY; 445.87; positive
3) [F][ ] USDJPY; 114.289; negative
________________________________________________________________________________
```

### 2.3.0 Viewing more info recorded for an instrument: `view`

Since there are many different parameters that are recorded for
various instruments, to view all the recorded information for an
instrument apart from the general information presented
by the output of the `list` command, the `view` command can be used.

**Format**

```
mTracker$main> view INDEX
```

**Example usage**

```
mTracker$main> view 2
```

**Expected outcome**

All the parameters for the instrument at the requested index 
will be printed out:

```
________________________________________________________________________________
Type: Etf	[ ]
Name: SPY
Current Price: 445.87
Sentiment: positive
Past Returns: 1200.0
Remarks: Prices will plateau out in a few days.
________________________________________________________________________________
```

### 2.4.0 Marking a setup as acted upon: `done`

mTracker provides the ability for you to mark a particular
record of an instrument in the watchlist as executed or acted upon.

**Format**

```
mTracker$main> done INDEX
```

**Example usage**
```
mTracker$main> done 1
```

**Expected output**

Marks the first instrument in watchlist as complete,
and the following confirmation message will be displayed:

```
    Nice! I have marked this instrument as completed:
	    [S][X] IBM; 144.61; positive
```

In this example, the first instrument is `IBM` so it has been
checked as complete with an 'X'.

### 2.5.0 Editing an instrument: `edit`
Edit an existing instrument parameters. If at any point in time you want to terminate the `edit`
process, type in `abort` without any additional characters and mTracker will bring you back to the main workspace.

**Format**
```
mTracker$main> edit INDEX
```
**Example usage**

```
mTracker$main> edit 2
```

**Expected outcome:**

Upon entering the `edit` command, mTracker prompts for the parameters of 
instrument to be edited:

```
mTracker$main> edit 2
	Please enter one or more Etf parameters to edit separated by spaces only.
	done-status, name, current-price, sentiment, past-returns, remarks
mTracker$edit> name current-price
	Enter new name:
mTracker$edit> XLF
	Enter new Current price:
mTracker$edit> 148.76
```

_**Note: If unknown/invalid parameters are input when mTracker prompts for the parameters to edit,
they will be ignored.**_

Then, it prints out the changes that have been made:

```
________________________________________________________________________________
Before:
Type: Etf	[ ]
Name: SPY
Current Price: 445.87
Sentiment: positive
Past Returns: 1200.0
Remarks: Prices will plateau out in a few days.
________________________________________________________________________________
Changed To:
Type: Etf	[ ]
Name: XLF
Current Price: 148.76
Sentiment: positive
Past Returns: 1200.0
Remarks: Prices will plateau out in a few days.
________________________________________________________________________________
```
### 2.6.0 Aborting an operation: `abort`

Abort a current process. If you want to terminate the `add` or `edit` operation at any stage, enter `abort`
and the operation will be terminated.

**Note:**  `abort` is case-insensitive but must be entered without any additional characters. For example, 
`abort/` will be a invalid input.

Aborting an Add Operation:

**Example usage**
```
mTracker$add> abort
```
**Expected outcome:**

```
mTracker$main> add
Please key in the type of instrument:
mTracker$add> stock
Name of stock:
mTracker$add> abort
Addition of new instrument has been aborted! You are in the main workspace now.
```

Aborting an Edit Operation:

**Example usage**

```
mTracker$edit> abort
```

**Expected outcome:**

```
mTracker$main> edit 2
	Please enter one or more StocEtf parameters to edit separated by spaces only.
	done-status, name, current-price, sentiment, remarks
mTracker$edit> name current-price
	Enter new name:
mTracker$edit> abort
Edit process has been aborted! You are in the main workspace now.
```

_**Note: You can use this feature to cancel add or edit functionality. Calling abort in any other functionality will
result in an error message being displayed.**_

### 2.7.0 Removing an instrument record: `delete`

You can remove an instrument from the watchlist as you deem 
fit with the index number of the instrument in inventory.

**Format**

```
mTracker$main> delete INDEX
```

**Example usage**

```
mTracker$main> delete 4
```

**Expected outcome**

The 4th instrument in the watchlist is removed, 
and the remaining instruments' index numbers are updated accordingly.

```
________________________________________________________________________________
Noted. [F][ ] USDJPY; 114.289; negative - removed from your watchlist
________________________________________________________________________________
```

You can key in `list` once again to view the latest watchlist.

### 2.8.0 Search for instruments in watchlist: `find`

You can find specific instruments in the watchlist by searching for them through `find` command.

**Format**

```
mTracker$main> find SEARCH_STRING
```

**Example usage**

```
mTracker$main> find coin
```

**Expected outcome:**

Any instrument name which contains the SEARCH_STRING will be returned:

```
________________________________________________________________________________
1) [C][ ] bitcoin; 14442.22; positive
2) [C][ ] dogecoin; 21.14; positive
There were 2 instrument(s) found for keyword, coin.
________________________________________________________________________________
```

In the event that there were no instruments found for the input
SEARCH_STRING, the following message will be printed out:

```
________________________________________________________________________________
There were no instruments found for keyword, JPY.
________________________________________________________________________________
```

_**Note: SEARCH_STRING is case-sensitive.**_

### 2.9.0 Exiting the bot: `bye`
When you wish to quit the mTracker program, simply type in `bye`.

**Example usage**

```
mTracker$main> bye
```

**Expected outcome**

```
 ______            _______  _
(  ___ \ |\     /|(  ____ \( )
| (   ) )( \   / )| (    \/| |
| (__/ /  \ (_) / | (__    | |
|  __ (    \   /  |  __)   | |
| (  \ \    ) (   | (      (_)
| )___) )   | |   | (____/| _
|/ \___/    \_/   (_______/(_)
Thank you for using mTracker.
MAY THE MARKETS BE WITH YOU!!!
```

_**Note: Once quit, the instruments created during session
will be stored and retrieved back by mTracker once it is relaunched.**_

## 3.0 FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Locate text file named `mTracker.txt` and transfer the file over to another computer.

**Q**: Can I edit the data without launching the mTracker? 

**A**: You can open the `mTracker.txt` file located in the same directory as the jar file
to edit/add instruments manually. However, please make sure that the each line
contains details on only one instrument.

## 4.0 Command Summary

Action | Format | Examples
 --------- | ------ |------
Add an instrument | `add` | Read [2.1.0 Add a new instrument: `add`](#210-adding-a-new-instrument-add) for detailed instructions and examples.
List all instruments in watchlist | `list` | `mTracker$main> list` prints out all instruments in watchlist, and their respective general parameters' information.
View all info of an instrument | `view INDEX` | `mTracker$main> view 1` prints out all financial details recorded for the first instrument in watchlist.
Mark an instrument's trade setup as completed | `done INDEX` | `mTracker$main> done 2` marks second instrument in watchlist as acted upon.
Edit details recorded for an instrument | `edit INDEX` | Read [2.5.0 Edit an instrument: `edit`](#250-editing-an-instrument-edit) for detailed instructions and examples.
Abort an operation | `abort`| Read [2.6.0 Abort an operation: `abort`](#260-aborting-an-operation-abort) for detailed instructions and examples.
Delete an instrument from watchlist | `delete INDEX` | `mTracker$main> delete 5` deletes the fifth instrument in watchlist.
Search for recorded instrument(s) | `find SEARCH_STRING` | `mTracker$main> find USD` returns all financial instruments in watchlist that contain "USD". **(Note: SEARCH_STRING is case-sensitive.)**
Exit program | `bye` | `mTracker$main> bye` prints out farewell message and program ends.
