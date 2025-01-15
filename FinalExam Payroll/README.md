# Payroll System

This program is a Java Swing-based application designed to manage payroll for employees. It enables users to input employee details, calculate pay, and manage payroll records efficiently. The system also includes a secondary screen to display calculated pay details. Below is an explanation of how the program works.

---

## Features
- **Add Employee**: Input details like Employee ID, Name, Hourly Rate, and Hours Worked to add an employee to the payroll system.
- **Calculate Pay**: View gross and net pay for a specific employee in a separate pay screen.
- **Display Records**: View all saved employee records in a table format.
- **Save Records**: Save employee records to a file (`payroll.txt`).
- **Load Records**: Automatically load existing records from the file when the application starts.

---

## How It Works

### 1. Adding an Employee
1. Fill in the fields for Employee ID, Name, Hourly Rate, and Hours Worked.
2. Click the **Add Employee** button.
3. The program calculates the Gross Pay (`Hourly Rate x Hours Worked`) and Net Pay (Gross Pay x 80%) automatically.
4. The details are added to the on-screen table and stored in memory.

### 2. Calculating Pay
1. Enter the Employee ID of an existing employee.
2. Click the **Calculate Pay** button.
3. A new window appears, displaying the Gross Pay and Net Pay for the entered Employee ID.

### 3. Displaying Records
- Click the **Display Records** button to refresh and view all employee records in the table.

### 4. Saving Records
- Click the **Save Record** button to write all employee records to the `payroll.txt` file.

### 5. Loading Records
- When the application starts, it automatically loads records from `payroll.txt` (if the file exists) and populates the table.

---

## How to Run
1. Compile and run the program using a Java IDE or the terminal.
2. Interact with the graphical user interface to add employees, calculate pay, and manage records.

---

## File Management
- **payroll.txt**: This file is used to persist employee records between sessions. It is created automatically if it doesn't exist.
