# Phonebook System

This is a simple **Phonebook System** implemented in Java using Swing for the graphical user interface (GUI). The system allows users to add, delete, search, and update contact information. It also maintains a persistent contact list saved to a text file.

---

## Features

- **Add Contact**: Save a new contact with a name and phone number.
- **Delete Contact**: Remove a contact by entering the name.
- **Search Contact**: Find a contact by name.
- **Update Contact**: Modify the phone number of an existing contact.
- **Contact List Display**: View the complete list of saved contacts.

---

## How It Works

1. **Input Fields**: 
   - `Name`: Text field for entering the name.
   - `Phone`: Text field for entering the phone number.

2. **Buttons**:
   - `ADD`: Saves the entered name and phone number.
   - `DELETE`: Removes the contact with the specified name.
   - `SEARCH`: Searches for the contact by name and displays the details in a dialog box.
   - `UPDATE`: Updates the phone number of the specified name.

3. **Persistent Storage**:
   - Contacts are stored in a file named `phonebook.txt`.
   - Each contact is saved in the format: `Name,Phone`.

4. **Validation**:
   - Phone numbers must contain only digits.
   - Names and phone numbers are converted to uppercase for uniformity.

5. **Visual Layout**:
   - The GUI uses a light blue theme with clear panels and borders.
   - The contact list is displayed in a formatted, non-editable text area.

---

## File Structure

- **Main Class**: `PhonebookSystem`
  - Manages the UI components and user interactions.
- **Helper Class**: `UpperCaseDocument`
  - Ensures all text inputs are automatically converted to uppercase.
- **Data File**: `phonebook.txt`
  - Stores the list of contacts.

---

## How to Run

1. Ensure you have Java installed on your system.
2. Compile the program:
   ```
   javac PhonebookSystem.java
   ```
3. Run the program:
   ```
   java PhonebookSystem
   ```
4. Interact with the GUI to manage contacts.

---

## Usage Tips

- **Adding a Contact**:
  - Enter the name and phone number, then click `ADD`.

- **Deleting a Contact**:
  - Enter the name, then click `DELETE`. The contact will be removed if it exists.

- **Searching for a Contact**:
  - Enter the name, then click `SEARCH`. The details will appear in a dialog box if found.

- **Updating a Contact**:
  - Enter the name and the new phone number, then click `UPDATE`.

- **Viewing All Contacts**:
  - The contact list is always visible in the lower section of the window.

---

## Additional Information

- **Persistent Data**:
  - Contacts are saved in `phonebook.txt`. Ensure this file is in the same directory as the program.

- **Error Handling**:
  - The program handles invalid inputs, such as non-numeric phone numbers, and displays appropriate error messages.

---

## Example

### Input:
- Name: `John Doe`
- Phone: `123456789`

### Output in File:
```
John Doe,123456789
```

### Display in Contact List:
```
NAME:                         NUMBER:
-------------------------------------------
JOHN DOE                     123456789
```
