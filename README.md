# Local Cinema GUI Java Application

A Java-based desktop application for processing movie ticket sales at a local
cinema. This application provides a user-friendly graphical interface for
cinema staff to manage ticket sales, calculate VAT, generate reports, and
maintain sales records.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage Guide](#usage-guide)
- [Application Walkthrough](#application-walkthrough)
- [Business Logic](#business-logic)
- [Testing](#testing)
- [Project Structure](#project-structure)

## Overview

The Local Cinema GUI Java Application is designed to streamline the ticket
sales process for cinema staff. It provides an intuitive interface for
selecting movies, entering ticket quantities and prices, calculating totals
with VAT, and generating formatted sales reports. All transactions are
automatically saved to a text file for record-keeping purposes.

This project demonstrates Java Swing GUI development, object-oriented
programming principles, interface-based design, data validation techniques,
file I/O operations, unit testing with JUnit 4, and the MVC architectural
pattern.

## Features

The application includes a dropdown menu with three movie options: Napoleon,
Oppenheimer, and Damsel. Users can input fields for ticket quantity and price
per ticket. The system automatically calculates subtotal, a 14 per cent VAT,
and the total amount. Formatted sales reports appear in a read-only text area,
and all reports save automatically to a file named report.txt.

The user interface includes a complete menu bar with File and Tools menus,
keyboard mnemonics for all menu items, a one-click form reset button, error
dialogs for invalid inputs, and a confirmation dialog after successful
processing. Data validation ensures the movie name is not empty, the number
of tickets is a positive integer greater than zero, and the ticket price is a
positive number greater than zero. The project includes 33 unit tests covering
all business logic, validation test cases, edge conditions, and object
independence verification.

## Technology Stack

The application uses Java 8 as the programming language with the Swing
framework for the graphical user interface. Event handling relies on the AWT
library. File operations use the Java I/O library. Unit testing is performed
with JUnit 4. The build process uses manual compilation or any standard Java
IDE. Version control is managed with Git.

## Prerequisites

Before installing and running this application, you need the Java Development
Kit version 8 or higher installed on your system. Git is optional but
recommended for cloning the repository. The operating system can be Windows
7 through 11, macOS 10.12 or later, or any standard Linux distribution. The
application requires a minimum of 256 megabytes of RAM, 10 megabytes of disk
space, and a display resolution of 1024 by 768 pixels or higher. For
development, you may use Eclipse, IntelliJ IDEA, or NetBeans, along with the
JUnit 4 library.

## Installation

To clone the repository from GitHub, use the following command:

```bash
git clone https://github.com/HChristopherNaoyuki/local-cinema-gui-java.git
```

After cloning, navigate into the project directory and create the necessary
folders if they do not already exist:

```bash
cd local-cinema-gui-java
mkdir -p Solution/test
mkdir lib
```

You must download JUnit 4 and Hamcrest libraries and place them in the lib
directory. Use the following commands on macOS or Linux, or download the files
manually from the official Maven repository:

```bash
cd lib
wget https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-
core-1.3.jar
```

To compile the application on Windows, run:

```bash
javac -cp ".;lib/junit-4.13.2.jar" Solution/*.java Solution/test/*.java
```

On macOS or Linux, run:

```bash
javac -cp .:lib/junit-4.13.2.jar Solution/*.java Solution/test/*.java
```

## Usage Guide

To run the application from the command line on Windows, execute:

```bash
java -cp . Solution.Solution
```

On macOS or Linux, execute:

```bash
java -cp . Solution.Solution
```

You may also open the project in your preferred IDE, locate the Solution.java
file in the Solution package, and run the main method directly.

To use the application, first click the dropdown menu labeled Select Movie and
choose Napoleon, Oppenheimer, or Damsel. Then enter a positive whole number
for the number of tickets and a positive number for the ticket price in South
African Rand. Click Tools then Process in the menu bar, or press Alt followed
by T and then P. The formatted report will appear in the text area, and a
confirmation dialog will confirm success. To clear the form, click Tools then
Clear or press Alt followed by T and then C. To exit the application, click
File then Exit, press Alt followed by F and then X, or click the standard
window close button.

## Application Walkthrough

The main application window contains a menu bar with File and Tools options.
Below the menu bar, a panel labelled Ticket Details holds the movie selection
dropdown, the number of tickets input field, and the ticket price input field.
A second panel labelled Sales Report contains a read-only text area where the
formatted report appears. When you process a sale, the report displays the
movie selected, the number of tickets, the ticket price, the subtotal, the 14
per cent VAT amount, the total amount, and a timestamp showing when the report
was generated. All processed reports are automatically appended to a file
named report.txt in the application's working directory.

## Business Logic

The application calculates financial values using three key formulas. The
subtotal equals the number of tickets multiplied by the ticket price. The VAT
amount equals the subtotal multiplied by 0.14. The total with VAT equals the
subtotal plus the VAT amount. For example, three tickets at one hundred fifty
Rand each gives a subtotal of four hundred fifty Rand. The VAT amount is sixty
three Rand, and the total amount is five hundred thirteen Rand.

Validation rules require the movie name to be not null or empty, the number
of tickets to be a positive integer greater than zero, and the ticket price
to be a positive number greater than zero. Invalid examples include an empty
or blank movie name, a ticket quantity of zero or negative five, a text value
like five instead of a number, and a ticket price of zero or a text value like
fifty.

## Testing

To run the unit tests from the command line on Windows, execute:

```bash
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" \
org.junit.runner.JUnitCore Solution.test.MovieTicketsTest
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" \
org.junit.runner.JUnitCore Solution.test.MovieTicketDataTest
```

On macOS or Linux, execute:

```bash
java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar \
org.junit.runner.JUnitCore Solution.test.MovieTicketsTest
java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar \
org.junit.runner.JUnitCore Solution.test.MovieTicketDataTest
```

The MovieTicketsTest class contains 20 tests covering price calculations,
validation rules, and edge cases. The MovieTicketDataTest class contains 13
tests covering constructor behaviour, getter and setter methods, and object
independence. The total of 33 tests provides comprehensive coverage of all
business logic components.

## Project Structure

The project root directory contains a Solution folder with all source code
files, a lib folder with JUnit and Hamcrest library JAR files, a report.txt
file that is created at runtime, and a README.md file. Within the Solution
folder, the Solution.java file contains the main GUI application. The
IMovieTickets.java file defines the business logic interface. The
MovieTickets.java file provides the implementation of ticket calculations and
validation. The MovieTicketData.java file serves as the data container class
for input values. A test subfolder contains MovieTicketsTest.java with 20 unit
tests and MovieTicketDataTest.java with 13 unit tests for the data container.

---

End of Document

---
