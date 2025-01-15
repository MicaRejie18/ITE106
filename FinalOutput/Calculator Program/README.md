# Calculator Application

This program is a graphical calculator implemented in Java Swing. It provides basic arithmetic operations, percentage calculations, and a history-saving feature to track past calculations.

---

## Features
- **Arithmetic Operations**: Perform addition, subtraction, multiplication, and division.
- **Percentage Calculations**: Quickly calculate percentages.
- **Clear Functionality**: Reset the current input and calculation.
- **Decimal Support**: Allows calculations with decimal numbers.
- **Result Display**: Automatically updates the display for each input and calculation.
- **History Logging**: Saves calculations to a file (`calculator_history.txt`) for future reference.

---

## How It Works

### 1. User Input
- **Numerical Input**: Click number buttons (0-9) to input digits.
- **Decimal**: Use the `.` button for decimal numbers.
- **Operators**: Click buttons for `+`, `-`, `*`, or `/` to specify the operation.

### 2. Performing Calculations
1. Enter the first number.
2. Select an operator.
3. Enter the second number.
4. Click `=` to display the result.
   - The result is also logged in the `calculator_history.txt` file in the format:
     
     `num1 operator num2 = result`

### 3. Additional Features
- **Clear (C)**: Resets all inputs and clears the display.
- **Percentage (%)**: Converts the current input into a percentage.

---

## File Management
- **History File**: Calculations are saved to a text file named `calculator_history.txt` in the following format:
  
  `num1 operator num2 = result`

- The file is appended with each new calculation.

---

## How to Run
1. Compile the program using a Java IDE or terminal.
2. Launch the application to interact with the graphical user interface.
3. Perform calculations using the buttons, and review your history in `calculator_history.txt`.

---

## Error Handling
- Division by zero displays `Error` in the calculator display.
- Invalid inputs or operations trigger error messages to ensure a smooth user experience.
