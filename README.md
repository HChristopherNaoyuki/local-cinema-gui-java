# Local Cinema GUI Java Application

A Java-based desktop application for processing movie ticket sales at a local cinema. 
This application provides a user-friendly graphical interface for cinema staff to manage 
ticket sales, calculate VAT, generate reports, and maintain sales records.

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

The Local Cinema GUI Java Application is designed to streamline the ticket sales process for cinema staff. 
It provides an intuitive interface for selecting movies, entering ticket quantities and prices, calculating 
totals with VAT, and generating formatted sales reports. All transactions are automatically saved to a text 
file for record-keeping purposes.

This project demonstrates:
- Java Swing GUI development
- Object-oriented programming principles
- Interface-based design
- Data validation techniques
- File I/O operations
- Unit testing with JUnit 4
- MVC architectural pattern

## Features

### Core Functionality
- **Movie Selection**: Dropdown menu with three movie options (Napoleon, Oppenheimer, Damsel)
- **Ticket Entry**: Input fields for ticket quantity and price per ticket
- **Automated Calculations**: Automatic calculation of subtotal, 14% VAT, and total amount
- **Report Generation**: Formatted sales reports displayed in a read-only text area
- **File Persistence**: Automatic saving of all reports to `report.txt`

### User Interface
- **Menu System**: Complete menu bar with File and Tools menus
- **Keyboard Shortcuts**: Mnemonic shortcuts for all menu items
- **Form Clearing**: One-click reset of all input fields
- **Error Dialogs**: User-friendly error messages for invalid inputs
- **Success Confirmation**: Dialog confirmation after successful processing

### Data Validation
- Movie name cannot be empty
- Number of tickets must be a positive integer (> 0)
- Ticket price must be a positive number (> 0)
- Comprehensive error handling for non-numeric inputs

### Testing
- 33 unit tests covering all business logic
- Comprehensive validation test cases
- Edge case testing for boundary conditions
- Object independence verification

## Technology Stack

| Component | Technology |
|-----------|------------|
| Programming Language | Java 8 |
| GUI Framework | Swing (javax.swing) |
| Event Handling | AWT (java.awt) |
| File Operations | Java I/O (java.io) |
| Unit Testing | JUnit 4 |
| Build Tool | Manual compilation / Any Java IDE |
| Version Control | Git |

## Prerequisites

Before installing and running this application, ensure you have the following:

### Software Requirements
- **Java Development Kit (JDK) 8 or higher** - [Download from Oracle](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Git** (optional, for cloning) - [Download from git-scm.com](https://git-scm.com/downloads)

### System Requirements
- **Operating System**: Windows 7/8/10/11, macOS 10.12+, or Linux
- **Memory**: 256 MB RAM minimum
- **Disk Space**: 10 MB for application files
- **Display**: 1024 × 768 resolution or higher

### Development Tools (Optional)
- **IDE**: Eclipse, IntelliJ IDEA, or NetBeans
- **JUnit 4**: For running tests (included in lib/)

## Installation

### Method 1: Clone from GitHub

```bash
# Clone the repository
git clone https://github.com/HChristopherNaoyuki/local-cinema-gui-java.git

# Navigate to project directory
cd local-cinema-gui-java

# Create necessary directories (if not present)
mkdir -p Solution/test
mkdir lib
```

### Method 2: Download ZIP

1. Visit the repository: [https://github.com/HChristopherNaoyuki/local-cinema-gui-java](https://github.com/HChristopherNaoyuki/local-cinema-gui-java)
2. Click the "Code" button
3. Select "Download ZIP"
4. Extract the ZIP file to your desired location

### Setting Up Dependencies

Download JUnit 4 and Hamcrest libraries and place them in the `lib` directory:

```bash
# Navigate to lib directory
cd lib

# Download JUnit 4
wget https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar

# Download Hamcrest Core
wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
```

Or manually download from:
- [JUnit 4.13.2](https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar)
- [Hamcrest Core 1.3](https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar)

### Compiling the Application

**On Windows:**
```bash
# Compile all Java files
javac -cp ".;lib/junit-4.13.2.jar" Solution/*.java Solution/test/*.java
```

**On macOS/Linux:**
```bash
# Compile all Java files
javac -cp .:lib/junit-4.13.2.jar Solution/*.java Solution/test/*.java
```

## Usage Guide

### Running the Application

**From the command line:**

Navigate to the project root directory and run:

```bash
# On Windows
java -cp . Solution.Solution

# On macOS/Linux
java -cp . Solution.Solution
```

**From an IDE:**
1. Open the project in your preferred IDE
2. Locate the `Solution.java` file in the `Solution` package
3. Right-click and select "Run File" or "Run Solution.main()"

### Using the Application

#### Step 1: Select a Movie
- Click the dropdown menu labeled "Select Movie:"
- Choose from: Napoleon, Oppenheimer, or Damsel

#### Step 2: Enter Ticket Details
- **Number of Tickets**: Enter a positive whole number (e.g., 3, 5, 10)
- **Ticket Price (R)**: Enter a positive number (e.g., 120.00, 150.50)

#### Step 3: Process the Sale
- Click `Tools → Process` in the menu bar, OR
- Press `Alt + T` followed by `P`

#### Step 4: Review the Report
- The formatted report appears in the text area below
- A confirmation dialog confirms successful processing

#### Step 5: Clear the Form (Optional)
- Click `Tools → Clear` in the menu bar, OR
- Press `Alt + T` followed by `C`

#### Step 6: Exit the Application
- Click `File → Exit` in the menu bar, OR
- Press `Alt + F` followed by `X`, OR
- Click the standard window close button

## Application Walkthrough

### Main Window Layout

```
┌─────────────────────────────────────────────────────┐
│  File  Tools                                         │
├─────────────────────────────────────────────────────┤
│ ┌─────────────────────────────────────────────────┐ │
│ │              Ticket Details                      │ │
│ │  Select Movie: [Napoleon       ▼]               │ │
│ │  Number of Tickets: [          ]                │ │
│ │  Ticket Price (R): [           ]                │ │
│ └─────────────────────────────────────────────────┘ │
│ ┌─────────────────────────────────────────────────┐ │
│ │                 Sales Report                     │ │
│ │  ==============================================  │ │
│ │         MOVIE TICKET SALES REPORT               │ │
│ │  ==============================================  │ │
│ │                                                   │ │
│ │  Movie Selected: Oppenheimer                      │ │
│ │  ------------------------------                   │ │
│ │  Number of Tickets: 3                             │ │
│ │  Ticket Price: R150.00                            │ │
│ │  Subtotal: R450.00                                │ │
│ │  VAT (14%): R63.00                                │ │
│ │  ------------------------------                   │ │
│ │  TOTAL AMOUNT: R513.00                            │ │
│ │  ==============================================  │ │
│ │  Report Generated: Wed Jan 24 14:35:22 SAST 2024 │ │
│ │  ==============================================  │ │
│ └─────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────┘
```

### Sample Report Output

When you process a ticket sale, the application generates a report like this:

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

### Report File

All processed reports are automatically appended to `report.txt` in the application's working directory:

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
==================================================
           MOVIE TICKET SALES REPORT
==================================================

Movie Selected: Napoleon
------------------------------
Number of Tickets: 2
Ticket Price: R120.00
Subtotal: R240.00
VAT (14%): R33.60
------------------------------
TOTAL AMOUNT: R273.60
==================================================
Report Generated: Wed Jan 24 15:10:45 SAST 2024
==================================================
```

## Business Logic

### Price Calculation

The application follows these calculation rules:

| Calculation | Formula | Example |
|-------------|---------|---------|
| Subtotal | Number of Tickets × Ticket Price | 3 × R150.00 = R450.00 |
| VAT Amount | Subtotal × 0.14 | R450.00 × 0.14 = R63.00 |
| Total with VAT | Subtotal + VAT Amount | R450.00 + R63.00 = R513.00 |

### Validation Rules

| Field | Validation Rule | Invalid Examples |
|-------|----------------|------------------|
| Movie Name | Cannot be null or empty | null, "", "   " |
| Number of Tickets | Must be positive integer > 0 | "0", "-5", "five", "" |
| Ticket Price | Must be positive number > 0 | "0.00", "-50.00", "fifty", "" |

## Testing

### Running Unit Tests

**From the command line:**

On Windows:
```bash
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore Solution.test.MovieTicketsTest
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore Solution.test.MovieTicketDataTest
```

On macOS/Linux:
```bash
java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore Solution.test.MovieTicketsTest
java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore Solution.test.MovieTicketDataTest
```

**From an IDE:**
1. Navigate to the `Solution.test` package
2. Right-click on `MovieTicketsTest.java` or `MovieTicketDataTest.java`
3. Select "Run As → JUnit Test"

### Test Coverage

| Test Class | Number of Tests | Test Categories |
|------------|-----------------|-----------------|
| MovieTicketsTest | 20 | Price calculation, validation rules, edge cases |
| MovieTicketDataTest | 13 | Constructor behavior, getter/setter methods, object independence |
| **Total** | **33** | Comprehensive coverage of all components |

## Project Structure

```
local-cinema-gui-java/
├── Solution/
│   ├── Solution.java                 # Main GUI application
│   ├── IMovieTickets.java            # Business logic interface
│   ├── MovieTickets.java             # Business logic implementation
│   ├── MovieTicketData.java          # Data container class
│   └── test/
│       ├── MovieTicketsTest.java     # Unit tests for MovieTickets
│       └── MovieTicketDataTest.java  # Unit tests for MovieTicketData
├── lib/
│   ├── junit-4.13.2.jar              # JUnit 4 testing framework
│   └── hamcrest-core-1.3.jar         # Hamcrest matchers
├── report.txt                         # Generated sales reports (created at runtime)
├── README.md                          # This file
└── .gitignore                         # Git ignore file
```

### Key Files Description

| File | Description |
|------|-------------|
| `Solution.java` | Main application class with GUI implementation |
| `IMovieTickets.java` | Interface defining the contract for business logic |
| `MovieTickets.java` | Implementation of ticket calculation and validation |
| `MovieTicketData.java` | Data container for input values |
| `MovieTicketsTest.java` | Unit tests for business logic (20 tests) |
| `MovieTicketDataTest.java` | Unit tests for data container (13 tests) |
| `report.txt` | Auto-generated file containing all sales reports |

## Contributing

Contributions to this project are welcome! Please follow these steps:

### Contribution Workflow

1. **Fork the repository**
   ```bash
   # Click the "Fork" button on GitHub
   ```

2. **Clone your fork**
   ```bash
   git clone https://github.com/your-username/local-cinema-gui-java.git
   cd local-cinema-gui-java
   ```

3. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

4. **Make your changes**
   - Follow existing code style (Allman style brackets)
   - Add comments for complex logic
   - Update or add unit tests as needed
   - Ensure all tests pass

5. **Commit your changes**
   ```bash
   git add .
   git commit -m "Description of your changes"
   ```

6. **Push to your fork**
   ```bash
   git push origin feature/your-feature-name
   ```

7. **Create a Pull Request**
   - Go to the original repository on GitHub
   - Click "New Pull Request"
   - Select your feature branch
   - Provide a clear description of your changes

### Coding Standards

- Use Allman style braces (opening brace on new line)
- Include comprehensive comments for all methods
- Follow Java naming conventions
- Maintain test coverage for new functionality
- Ensure Java 8 compatibility

## Acknowledgments

- Based on concepts from "Java For Dummies, 6th Edition" by Barry Burd
- Developed as part of Programming 1B (PROG6112) assessment

---
