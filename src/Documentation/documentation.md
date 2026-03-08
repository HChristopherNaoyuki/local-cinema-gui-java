# Documentation

## Table of Contents

1. [Introduction](#1-introduction)
   1.1 [Purpose](#11-purpose)
   1.2 [Scope](#12-scope)
   1.3 [System Overview](#13-system-overview)
   1.4 [Target Audience](#14-target-audience)
   1.5 [Prerequisites](#15-prerequisites)

2. [System Architecture](#2-system-architecture)
   2.1 [Architectural Overview](#21-architectural-overview)
   2.2 [Package Structure](#22-package-structure)
   2.3 [Class Diagram](#23-class-diagram)
   2.4 [Dependencies](#24-dependencies)

3. [Core Components](#3-core-components)
   3.1 [Solution Class (Main Application)](#31-solution-class-main-application)
       3.1.1 [Purpose](#311-purpose)
       3.1.2 [Key Features](#312-key-features)
       3.1.3 [GUI Components](#313-gui-components)
       3.1.4 [Menu System](#314-menu-system)
       3.1.5 [Core Methods](#315-core-methods)
   3.2 [IMovieTickets Interface](#32-imovietickets-interface)
       3.2.1 [Purpose](#321-purpose)
       3.2.2 [Method Definitions](#322-method-definitions)
   3.3 [MovieTickets Class](#33-movietickets-class)
       3.3.1 [Purpose](#331-purpose)
       3.3.2 [Method Implementations](#332-method-implementations)
       3.3.3 [Validation Logic](#333-validation-logic)
   3.4 [MovieTicketData Class](#34-movieticketdata-class)
       3.4.1 [Purpose](#341-purpose)
       3.4.2 [Properties](#342-properties)
       3.4.3 [Constructor](#343-constructor)
       3.4.4 [Accessor Methods](#344-accessor-methods)

4. [User Interface Guide](#4-user-interface-guide)
   4.1 [Application Launch](#41-application-launch)
   4.2 [Main Window Layout](#42-main-window-layout)
       4.2.1 [Input Panel](#421-input-panel)
       4.2.2 [Report Panel](#422-report-panel)
   4.3 [Menu Navigation](#43-menu-navigation)
       4.3.1 [File Menu](#431-file-menu)
       4.3.2 [Tools Menu](#432-tools-menu)
   4.4 [Processing a Ticket Sale](#44-processing-a-ticket-sale)
       4.4.1 [Step-by-Step Instructions](#441-step-by-step-instructions)
       4.4.2 [Sample Report Output](#442-sample-report-output)
   4.5 [Clearing the Form](#45-clearing-the-form)
   4.6 [Exiting the Application](#46-exiting-the-application)

5. [Business Logic and Validation](#5-business-logic-and-validation)
   5.1 [Ticket Price Calculation](#51-ticket-price-calculation)
   5.2 [VAT Calculation](#52-vat-calculation)
   5.3 [Data Validation Rules](#53-data-validation-rules)
       5.3.1 [Movie Name Validation](#531-movie-name-validation)
       5.3.2 [Ticket Count Validation](#532-ticket-count-validation)
       5.3.3 [Ticket Price Validation](#533-ticket-price-validation)
   5.4 [Error Handling](#54-error-handling)

6. [File Operations](#6-file-operations)
   6.1 [Report File Format](#61-report-file-format)
   6.2 [File Writing Process](#62-file-writing-process)
   6.3 [File Location](#63-file-location)

7. [Testing and Quality Assurance](#7-testing-and-quality-assurance)
   7.1 [Testing Framework](#71-testing-framework)
   7.2 [Unit Test Structure](#72-unit-test-structure)
   7.3 [MovieTicketsTest Class](#73-movieticketstest-class)
       7.3.1 [Price Calculation Tests](#731-price-calculation-tests)
       7.3.2 [Validation Tests](#732-validation-tests)
   7.4 [MovieTicketDataTest Class](#74-movieticketdatatest-class)
       7.4.1 [Constructor Tests](#741-constructor-tests)
       7.4.2 [Accessor Method Tests](#742-accessor-method-tests)
   7.5 [Test Coverage Summary](#75-test-coverage-summary)
   7.6 [Running the Tests](#76-running-the-tests)

8. [Technical Specifications](#8-technical-specifications)
   8.1 [System Requirements](#81-system-requirements)
   8.2 [Java Version Compatibility](#82-java-version-compatibility)
   8.3 [Dependencies](#83-dependencies)
   8.4 [File Structure](#84-file-structure)

9. [Installation and Deployment](#9-installation-and-deployment)
   9.1 [Installation Steps](#91-installation-steps)
   9.2 [Building from Source](#92-building-from-source)
   9.3 [Running the Application](#93-running-the-application)

10. [Troubleshooting Guide](#10-troubleshooting-guide)
    10.1 [Common Issues and Solutions](#101-common-issues-and-solutions)
    10.2 [Error Messages](#102-error-messages)
    10.3 [Support and Contact](#103-support-and-contact)

11. [Appendix](#11-appendix)
    11.1 [Code Listings](#111-code-listings)
    11.2 [Glossary](#112-glossary)
    11.3 [References](#113-references)

## 1. Introduction

### 1.1 Purpose

This document provides comprehensive technical documentation for the Movie Ticket Sales 
System, a Java-based desktop application designed for processing movie ticket sales at a 
local cinema. The documentation serves as a reference for developers, testers, and system 
maintainers.

### 1.2 Scope

The documentation covers the complete architecture, design, implementation, testing, and 
usage of the Movie Ticket Sales System. It includes detailed information about all classes, 
methods, user interface components, business logic, validation rules, and unit testing procedures.

### 1.3 System Overview

The Movie Ticket Sales System is a graphical user interface (GUI) application that enables 
cinema staff to process ticket sales efficiently. Key features include:

- Movie selection from a dropdown menu
- Input for number of tickets and ticket price
- Automatic calculation of subtotal, VAT (14%), and total amount
- Generation of formatted sales reports
- Persistent storage of reports in text files
- Comprehensive data validation
- User-friendly menu system for navigation
- Extensive unit testing coverage

### 1.4 Target Audience

This documentation is intended for:

- Software developers maintaining or extending the application
- Quality assurance engineers performing testing
- Technical support staff troubleshooting issues
- System administrators deploying the application
- Students learning about Java GUI applications and unit testing

### 1.5 Prerequisites

To work with this system, users should have:

- Basic understanding of Java programming
- Familiarity with GUI concepts
- Knowledge of unit testing principles (for test-related sections)
- Java Development Kit (JDK) 8 or higher installed
- An IDE such as Eclipse, IntelliJ IDEA, or NetBeans (optional)

## 2. System Architecture

### 2.1 Architectural Overview

The Movie Ticket Sales System follows a Model-View-Controller (MVC) architectural pattern:

- **Model**: `MovieTicketData` class represents the data structure
- **View**: `Solution` class handles the GUI presentation
- **Controller**: `MovieTickets` class contains business logic and validation

This separation of concerns ensures maintainability, testability, and scalability of the 
application.

### 2.2 Package Structure

The application is organized in a single package named `Solution` with the following structure:

```
Solution/
├── Solution.java                 # Main application class (GUI)
├── IMovieTickets.java            # Interface defining business logic contract
├── MovieTickets.java             # Implementation of business logic
├── MovieTicketData.java          # Data container class
└── test/
    ├── MovieTicketsTest.java     # Unit tests for MovieTickets
    └── MovieTicketDataTest.java  # Unit tests for MovieTicketData
```

### 2.3 Class Diagram

```
┌─────────────────┐       ┌──────────────────┐
│   IMovieTickets │       │ MovieTicketData  │
│   (Interface)   │       │                  │
├─────────────────┤       ├──────────────────┤
│ +CalculateTotal │       │ -movieName       │
│  TicketPrice()  │       │ -numberOfTickets │
│ +ValidateData() │       │ -ticketPrice     │
└────────┬────────┘       ├──────────────────┤
         │ implements      │ +Constructor     │
         ▼                 │ +Getters/Setters │
┌─────────────────┐       └──────────────────┘
│  MovieTickets   │
├─────────────────┤
│ +CalculateTotal │
│  TicketPrice()  │       ┌──────────────────┐
│ +ValidateData() │       │     Solution     │
└────────┬────────┘       │   (Main Class)   │
         │ uses           ├──────────────────┤
         └───────────────▶│ -movieComboBox   │
                          │ -ticketCountField│
                          │ -ticketPriceField│
                          │ -reportTextArea  │
                          │ -menuBar         │
                          ├──────────────────┤
                          │ +main()          │
                          │ +processTicket() │
                          │ +generateReport()│
                          │ +saveToFile()    │
                          │ +clearForm()     │
                          └──────────────────┘
```

### 2.4 Dependencies

The application relies on the following Java packages:

| Package | Purpose |
|---------|---------|
| `javax.swing.*` | GUI components (JFrame, JPanel, JMenu, etc.) |
| `java.awt.*` | Layout management and event handling |
| `java.awt.event.*` | Event listeners for user interactions |
| `java.io.*` | File operations for report saving |
| `org.junit.*` | Unit testing framework |

## 3. Core Components

### 3.1 Solution Class (Main Application)

#### 3.1.1 Purpose

The `Solution` class serves as the entry point for the application and manages 
the graphical user interface. It handles all user interactions, orchestrates the 
business logic, and manages the display of information.

#### 3.1.2 Key Features

- Creates and manages the main application window
- Handles menu events and button clicks
- Coordinates data validation with the MovieTickets class
- Generates formatted sales reports
- Manages file operations for report persistence
- Provides user feedback through dialog boxes

#### 3.1.3 GUI Components

| Component | Type | Description |
|-----------|------|-------------|
| `movieComboBox` | `JComboBox<String>` | Dropdown for movie selection (Napoleon, Oppenheimer, Damsel) |
| `ticketCountField` | `JTextField` | Input field for number of tickets |
| `ticketPriceField` | `JTextField` | Input field for ticket price |
| `reportTextArea` | `JTextArea` | Read-only display area for generated reports |

#### 3.1.4 Menu System

**File Menu**
- **Exit**: Closes the application

**Tools Menu**
- **Process**: Processes the current ticket sale
- **Clear**: Resets all input fields and the report area

#### 3.1.5 Core Methods

| Method | Access | Description |
|--------|--------|-------------|
| `Solution()` | public | Constructor that initializes the GUI |
| `createMenuBar()` | private | Creates and configures the menu system |
| `createInputPanel()` | private | Builds the input panel with form fields |
| `createReportPanel()` | private | Builds the report display panel |
| `processTicketSale()` | private | Main processing logic for ticket sales |
| `generateReport()` | private | Creates formatted report strings |
| `saveReportToFile()` | private | Writes reports to the file system |
| `clearForm()` | private | Resets all input fields |
| `main()` | public static | Application entry point |

### 3.2 IMovieTickets Interface

#### 3.2.1 Purpose

The `IMovieTickets` interface defines the contract for business logic operations related to movie ticket processing. It ensures consistent implementation across the application.

#### 3.2.2 Method Definitions

```java
public interface IMovieTickets
{
    /**
     * Calculates the total ticket price based on quantity and unit price.
     * @param numberOfTickets The number of tickets purchased
     * @param ticketPrice The price per ticket
     * @return The subtotal before VAT
     */
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    
    /**
     * Validates the movie ticket data according to business rules.
     * @param movieTicketData The data object containing input values
     * @return true if data is valid, false otherwise
     */
    boolean ValidateData(MovieTicketData movieTicketData);
}
```

### 3.3 MovieTickets Class

#### 3.3.1 Purpose

The `MovieTickets` class implements the `IMovieTickets` interface and contains the core business logic for ticket price calculation and data validation.

#### 3.3.2 Method Implementations

**CalculateTotalTicketPrice Method**

This method performs simple multiplication of ticket quantity and unit price:

```java
public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice)
{
    return numberOfTickets * ticketPrice;
}
```

**ValidateData Method**

This method performs comprehensive validation of all input data:

```java
public boolean ValidateData(MovieTicketData movieTicketData)
{
    // Movie name validation
    if (movieTicketData.getMovieName() == null || 
        movieTicketData.getMovieName().trim().isEmpty())
    {
        return false;
    }
    
    // Ticket count validation
    try
    {
        int numberOfTickets = Integer.parseInt(movieTicketData.getNumberOfTickets());
        if (numberOfTickets <= 0)
        {
            return false;
        }
    }
    catch (NumberFormatException e)
    {
        return false;
    }
    
    // Ticket price validation
    try
    {
        double ticketPrice = Double.parseDouble(movieTicketData.getTicketPrice());
        if (ticketPrice <= 0.0)
        {
            return false;
        }
    }
    catch (NumberFormatException e)
    {
        return false;
    }
    
    return true;
}
```

#### 3.3.3 Validation Logic

The validation process follows a sequential evaluation:

1. **Movie Name Check**: Verifies the name is not null or empty after trimming whitespace
2. **Ticket Count Check**: Ensures the value is a positive integer greater than zero
3. **Ticket Price Check**: Ensures the value is a positive number greater than zero

If any validation step fails, the method immediately returns `false`. Only when all validations pass does it return `true`.

### 3.4 MovieTicketData Class

#### 3.4.1 Purpose

The `MovieTicketData` class serves as a simple data container (POJO - Plain Old Java Object) that encapsulates the raw input data for validation and processing.

#### 3.4.2 Properties

| Property | Type | Description |
|----------|------|-------------|
| `movieName` | `String` | The name of the selected movie |
| `numberOfTickets` | `String` | The number of tickets as string input |
| `ticketPrice` | `String` | The ticket price as string input |

#### 3.4.3 Constructor

```java
public MovieTicketData(String movieName, String numberOfTickets, String ticketPrice)
{
    this.movieName = movieName;
    this.numberOfTickets = numberOfTickets;
    this.ticketPrice = ticketPrice;
}
```

#### 3.4.4 Accessor Methods

| Method | Return Type | Description |
|--------|-------------|-------------|
| `getMovieName()` | `String` | Returns the movie name |
| `setMovieName(String movieName)` | `void` | Sets the movie name |
| `getNumberOfTickets()` | `String` | Returns the number of tickets |
| `setNumberOfTickets(String numberOfTickets)` | `void` | Sets the number of tickets |
| `getTicketPrice()` | `String` | Returns the ticket price |
| `setTicketPrice(String ticketPrice)` | `void` | Sets the ticket price |

## 4. User Interface Guide

### 4.1 Application Launch

To launch the application, run the `main` method in the `Solution` class. 
The application window will appear centered on the screen.

**Command Line:**
```
java Solution.Solution
```

**From IDE:**
- Right-click on `Solution.java`
- Select "Run File" or "Run Solution.main()"

### 4.2 Main Window Layout

The main application window is divided into two primary sections: the input 
panel at the top and the report panel below.

#### 4.2.1 Input Panel

The input panel contains the following elements:

| Element | Label | Purpose |
|---------|-------|---------|
| Combo Box | "Select Movie:" | Dropdown with Napoleon, Oppenheimer, Damsel |
| Text Field | "Number of Tickets:" | Input for ticket quantity |
| Text Field | "Ticket Price (R):" | Input for price per ticket |

#### 4.2.2 Report Panel

The report panel contains a read-only text area with a monospaced font for 
displaying formatted sales reports. A scroll pane allows viewing of longer reports.

### 4.3 Menu Navigation

#### 4.3.1 File Menu

**Access:** Click "File" in the menu bar or press `Alt + F`

**Exit Option:** Click "Exit" or press `Alt + X` to close the application

#### 4.3.2 Tools Menu

**Access:** Click "Tools" in the menu bar or press `Alt + T`

**Process Option:** Click "Process" or press `Alt + P` to process the current ticket sale

**Clear Option:** Click "Clear" or press `Alt + C` to reset all input fields

### 4.4 Processing a Ticket Sale

#### 4.4.1 Step-by-Step Instructions

1. **Select a Movie**: Choose a movie from the dropdown list (Napoleon, Oppenheimer, or Damsel)

2. **Enter Number of Tickets**: Type the quantity of tickets (must be a positive whole number)

3. **Enter Ticket Price**: Type the price per ticket (must be a positive number)

4. **Process the Sale**: Click `Tools → Process` or press `Alt + T` followed by `P`

5. **Review the Report**: The formatted report appears in the text area below

6. **Confirm Success**: A dialog box confirms successful processing and file saving

#### 4.4.2 Sample Report Output

```
==================================================
           MOVIE TICKET SALES REPORT
==================================================

Movie Selected: Oppenheimer
------------------------------
Number of Tickets: 3
Ticket Price: R150.00
Subtotal: R450.00
VAT (14%): R63.00
------------------------------
TOTAL AMOUNT: R513.00
==================================================
Report Generated: Wed Jan 24 14:35:22 SAST 2024
==================================================
```

### 4.5 Clearing the Form

To reset all input fields and clear the report area:

1. Click `Tools → Clear` in the menu bar
2. Or press `Alt + T` followed by `C`

The form will reset with:
- Movie selection set to the first item (Napoleon)
- Both text fields cleared
- Report area cleared

### 4.6 Exiting the Application

To close the application:

1. Click `File → Exit` in the menu bar
2. Or press `Alt + F` followed by `X`
3. Or click the standard window close button (X)

## 5. Business Logic and Validation

### 5.1 Ticket Price Calculation

The subtotal calculation is performed by the `CalculateTotalTicketPrice` method:

```
Subtotal = Number of Tickets × Ticket Price
```

**Example:**
- Number of Tickets: 3
- Ticket Price: R150.00
- Subtotal: 3 × R150.00 = R450.00

### 5.2 VAT Calculation

Value Added Tax (VAT) is calculated at a rate of 14% of the subtotal:

```
VAT Amount = Subtotal × 0.14
Total with VAT = Subtotal + VAT Amount
```

**Example (continued):**
- Subtotal: R450.00
- VAT Amount: R450.00 × 0.14 = R63.00
- Total with VAT: R450.00 + R63.00 = R513.00

### 5.3 Data Validation Rules

#### 5.3.1 Movie Name Validation

| Condition | Result | Example |
|-----------|--------|---------|
| Movie name is null | Invalid | `null` |
| Movie name is empty string | Invalid | `""` |
| Movie name contains only whitespace | Invalid | `"   "` |
| Movie name has valid text | Valid | `"Oppenheimer"` |

#### 5.3.2 Ticket Count Validation

| Condition | Result | Example |
|-----------|--------|---------|
| Value is null | Invalid | `null` |
| Value is empty string | Invalid | `""` |
| Value contains only whitespace | Invalid | `"   "` |
| Value is not a number | Invalid | `"five"` |
| Value is zero | Invalid | `"0"` |
| Value is negative | Invalid | `"-5"` |
| Value is positive integer | Valid | `"3"` |

#### 5.3.3 Ticket Price Validation

| Condition | Result | Example |
|-----------|--------|---------|
| Value is null | Invalid | `null` |
| Value is empty string | Invalid | `""` |
| Value contains only whitespace | Invalid | `"   "` |
| Value is not a number | Invalid | `"fifty"` |
| Value is zero | Invalid | `"0.00"` |
| Value is negative | Invalid | `"-50.00"` |
| Value is positive number | Valid | `"150.00"` |

### 5.4 Error Handling

The application provides user-friendly error messages through dialog boxes:

| Error Scenario | Message Displayed |
|----------------|-------------------|
| Invalid input data | "Invalid input. Please check:\n- Movie name cannot be empty\n- Number of tickets must be > 0\n- Ticket price must be > 0" |
| Non-numeric ticket count | "Please enter valid numeric values for tickets and price." |
| Non-numeric ticket price | "Please enter valid numeric values for tickets and price." |
| File write error | "Error saving report to file: [error details]" |
| General exception | "An error occurred: [error details]" |

## 6. File Operations

### 6.1 Report File Format

Reports are saved to a text file named `report.txt` with the following format:

```
==================================================
           MOVIE TICKET SALES REPORT
==================================================

Movie Selected: [Movie Name]
------------------------------
Number of Tickets: [Count]
Ticket Price: R[Price]
Subtotal: R[Subtotal]
VAT (14%): R[VAT Amount]
------------------------------
TOTAL AMOUNT: R[Total]
==================================================
Report Generated: [Timestamp]
==================================================
==================================================
```

### 6.2 File Writing Process

The `saveReportToFile` method handles file operations with the following characteristics:

- **File Mode**: Append (new reports are added to the end of the file)
- **Encoding**: Platform default
- **Resource Management**: Traditional try-catch-finally pattern for Java 8 compatibility
- **Separator**: A line of equal signs separates multiple reports

### 6.3 File Location

The `report.txt` file is created in the application's working directory:

- **When running from IDE**: The project root directory
- **When running from command line**: The directory from which the command was executed
- **When running from JAR**: The directory containing the JAR file

## 7. Testing and Quality Assurance

### 7.1 Testing Framework

The application uses JUnit 4 as the testing framework. All test classes are organized in the `Solution.test` package.

**Required Dependencies:**
- JUnit 4 library (junit-4.13.2.jar or later)
- Hamcrest core (hamcrest-core-1.3.jar)

### 7.2 Unit Test Structure

```
Solution.test/
├── MovieTicketsTest.java     # 20 test methods for business logic
└── MovieTicketDataTest.java  # 13 test methods for data container
```

### 7.3 MovieTicketsTest Class

#### 7.3.1 Price Calculation Tests

| Test Method | Description | Expected Result |
|-------------|-------------|-----------------|
| `CalculateTotalTicketPrice_CalculatedSuccessfully` | 5 tickets at R120.00 | R600.00 |
| `CalculateTotalTicketPrice_ZeroTickets_ReturnsZero` | 0 tickets at any price | R0.00 |
| `CalculateTotalTicketPrice_ZeroPrice_ReturnsZero` | Any tickets at R0.00 | R0.00 |
| `CalculateTotalTicketPrice_LargeNumbers_ReturnsCorrectTotal` | 1000 tickets at R150.50 | R150,500.00 |

#### 7.3.2 Validation Tests

**Movie Name Validation Tests:**

| Test Method | Test Input | Expected |
|-------------|------------|----------|
| `ValidateData_ValidInput_ReturnsTrue` | "Oppenheimer", "3", "150.00" | true |
| `ValidateData_EmptyMovieName_ReturnsFalse` | "", "3", "150.00" | false |
| `ValidateData_WhitespaceMovieName_ReturnsFalse` | "   ", "3", "150.00" | false |
| `ValidateData_NullMovieName_ReturnsFalse` | null, "3", "150.00" | false |

**Ticket Count Validation Tests:**

| Test Method | Test Input | Expected |
|-------------|------------|----------|
| `ValidateData_ZeroTickets_ReturnsFalse` | "Napoleon", "0", "150.00" | false |
| `ValidateData_NegativeTickets_ReturnsFalse` | "Napoleon", "-5", "150.00" | false |
| `ValidateData_NonNumericTickets_ReturnsFalse` | "Napoleon", "five", "150.00" | false |
| `ValidateData_EmptyTicketsString_ReturnsFalse` | "Napoleon", "", "150.00" | false |
| `ValidateData_WhitespaceTicketsString_ReturnsFalse` | "Napoleon", "   ", "150.00" | false |

**Ticket Price Validation Tests:**

| Test Method | Test Input | Expected |
|-------------|------------|----------|
| `ValidateData_ZeroPrice_ReturnsFalse` | "Damsel", "3", "0.00" | false |
| `ValidateData_NegativePrice_ReturnsFalse` | "Damsel", "3", "-50.00" | false |
| `ValidateData_NonNumericPrice_ReturnsFalse` | "Damsel", "3", "fifty" | false |
| `ValidateData_EmptyPriceString_ReturnsFalse` | "Damsel", "3", "" | false |
| `ValidateData_WhitespacePriceString_ReturnsFalse` | "Damsel", "3", "   " | false |

**Combined Validation Tests:**

| Test Method | Test Input | Expected |
|-------------|------------|----------|
| `ValidateData_AllFieldsInvalid_ReturnsFalse` | "", "-5", "-10.00" | false |
| `ValidateData_BoundaryValues_ReturnsTrue` | "Napoleon", "1", "0.01" | true |

### 7.4 MovieTicketDataTest Class

#### 7.4.1 Constructor Tests

| Test Method | Description |
|-------------|-------------|
| `Constructor_ValidInput_SetsAllFields` | Verifies constructor properly initializes all fields |
| `Constructor_NullValues_AllowsNull` | Ensures constructor accepts null values |
| `Constructor_EmptyStrings_AllowsEmpty` | Ensures constructor accepts empty strings |

#### 7.4.2 Accessor Method Tests

**Movie Name Tests:**

| Test Method | Description |
|-------------|-------------|
| `GetMovieName_AfterConstruction_ReturnsCorrectValue` | Verifies initial value retrieval |
| `SetMovieName_ValidValue_GetsSameValue` | Tests set/get with valid value |
| `SetMovieName_NullValue_GetsNull` | Tests set/get with null |
| `SetMovieName_EmptyString_GetsEmptyString` | Tests set/get with empty string |

**Ticket Count Tests:**

| Test Method | Description |
|-------------|-------------|
| `GetNumberOfTickets_AfterConstruction_ReturnsCorrectValue` | Verifies initial value |
| `SetNumberOfTickets_ValidValue_GetsSameValue` | Tests set/get with valid value |
| `SetNumberOfTickets_NullValue_GetsNull` | Tests set/get with null |
| `SetNumberOfTickets_EmptyString_GetsEmptyString` | Tests set/get with empty string |

**Ticket Price Tests:**

| Test Method | Description |
|-------------|-------------|
| `GetTicketPrice_AfterConstruction_ReturnsCorrectValue` | Verifies initial value |
| `SetTicketPrice_ValidValue_GetsSameValue` | Tests set/get with valid value |
| `SetTicketPrice_NullValue_GetsNull` | Tests set/get with null |
| `SetTicketPrice_EmptyString_GetsEmptyString` | Tests set/get with empty string |

**Integration Tests:**

| Test Method | Description |
|-------------|-------------|
| `SetAllProperties_ChainedOperations_AllUpdated` | Tests multiple property updates |
| `ObjectIndependence_MultipleInstances_DoNotInterfere` | Verifies instance isolation |

### 7.5 Test Coverage Summary

| Class | Number of Tests | Coverage Areas |
|-------|-----------------|----------------|
| MovieTicketsTest | 20 | Price calculation, validation rules, edge cases |
| MovieTicketDataTest | 13 | Constructor behavior, getter/setter methods, object independence |
| **Total** | **33** | Comprehensive coverage of all components |

### 7.6 Running the Tests

**From Command Line:**
```
java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Solution.test.MovieTicketsTest
java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Solution.test.MovieTicketDataTest
```

**From IDE (Eclipse):**
1. Right-click on the test package or individual test class
2. Select `Run As → JUnit Test`

**From IDE (IntelliJ IDEA):**
1. Right-click on the test package or individual test class
2. Select `Run 'Tests in...'`

## 8. Technical Specifications

### 8.1 System Requirements

| Component | Minimum Requirement |
|-----------|---------------------|
| Operating System | Windows 7/8/10/11, macOS 10.12+, Linux |
| Java Runtime | Java Runtime Environment (JRE) 8 or higher |
| Memory | 256 MB RAM minimum |
| Disk Space | 10 MB for application files |
| Display | 1024 × 768 resolution or higher |

### 8.2 Java Version Compatibility

The application is specifically designed for Java 8 compatibility:

| Feature | Java 8 Support |
|---------|----------------|
| Swing GUI components | Full support |
| AWT event handling | Full support |
| File I/O operations | Full support |
| String concatenation | Used instead of String.repeat() |
| Traditional try-catch-finally | Used instead of try-with-resources |
| JUnit 4 testing | Full support |

### 8.3 Dependencies

| Library | Version | Purpose |
|---------|---------|---------|
| Java Standard Edition | 8 or higher | Core Java functionality |
| JUnit | 4.13.2 | Unit testing framework |
| Hamcrest Core | 1.3 | Matcher library for JUnit |

### 8.4 File Structure

```
Project Root/
├── Solution/
│   ├── Solution.java
│   ├── IMovieTickets.java
│   ├── MovieTickets.java
│   ├── MovieTicketData.java
│   └── test/
│       ├── MovieTicketsTest.java
│       └── MovieTicketDataTest.java
├── lib/
│   ├── junit-4.13.2.jar
│   └── hamcrest-core-1.3.jar
├── report.txt (generated)
└── README.md
```

## 9. Installation and Deployment

### 9.1 Installation Steps

1. **Ensure Java 8 is installed**:
   ```
   java -version
   ```
   Should show version 1.8.x or higher

2. **Create project directory structure**:
   ```
   mkdir MovieTicketSystem
   cd MovieTicketSystem
   mkdir Solution
   mkdir Solution/test
   mkdir lib
   ```

3. **Copy source files** to their respective directories

4. **Download JUnit dependencies** to the `lib` folder:
   - junit-4.13.2.jar
   - hamcrest-core-1.3.jar

### 9.2 Building from Source

**Compile all Java files:**
```
javac -cp .;lib/junit-4.13.2.jar Solution/*.java Solution/test/*.java
```

**Create JAR file (optional):**
```
jar cvfm MovieTicketSystem.jar manifest.txt Solution/*.class Solution/test/*.class
```

### 9.3 Running the Application

**From compiled classes:**
```
java Solution.Solution
```

**From JAR file:**
```
java -jar MovieTicketSystem.jar
```

## 10. Troubleshooting Guide

### 10.1 Common Issues and Solutions

| Issue | Possible Cause | Solution |
|-------|---------------|----------|
| Application won't start | Java not installed or wrong version | Run `java -version` and install JDK 8+ |
| "ClassNotFoundException" | Classpath issues | Ensure all .class files are in correct directories |
| Report file not created | Write permissions | Check directory write permissions |
| Tests fail with NoClassDefFoundError | JUnit not in classpath | Add JUnit JAR files to classpath |
| GUI appears too small | Screen resolution | Adjust window size manually |

### 10.2 Error Messages

| Error Message | Meaning | Resolution |
|---------------|---------|------------|
| "Invalid input..." | Data validation failed | Check all inputs against validation rules |
| "Please enter valid numeric values..." | Non-numeric input | Enter numbers only in quantity and price fields |
| "Error saving report to file..." | File system issue | Check permissions and disk space |
| "An error occurred..." | Unexpected exception | Check stack trace for details |

### 10.3 Support and Contact

For technical support or questions about this documentation:

- **Documentation Version**: 1.0
- **Last Updated**: 2024
- **Support Email**: Not applicable for academic project

## 11. Appendix

### 11.1 Code Listings

Complete source code listings are available in the following files:

| File | Description |
|------|-------------|
| Solution.java | Main application GUI |
| IMovieTickets.java | Business logic interface |
| MovieTickets.java | Business logic implementation |
| MovieTicketData.java | Data container class |
| MovieTicketsTest.java | Unit tests for business logic |
| MovieTicketDataTest.java | Unit tests for data container |

### 11.2 Glossary

| Term | Definition |
|------|------------|
| **VAT** | Value Added Tax, calculated at 14% of the subtotal |
| **GUI** | Graphical User Interface |
| **MVC** | Model-View-Controller architectural pattern |
| **POJO** | Plain Old Java Object |
| **JUnit** | Unit testing framework for Java |
| **Subtotal** | Total before VAT (number of tickets × ticket price) |
| **Allman Style** | Coding style with braces on new lines |

### 11.3 References

1. Oracle Corporation. (2024). *Java Platform, Standard Edition Documentation*. https://docs.oracle.com/javase/8/docs/

2. JUnit Team. (2024). *JUnit 4 Documentation*. https://junit.org/junit4/

3. Burd, B. (2014). *Java For Dummies* (6th ed.). John Wiley & Sons, Inc.

---