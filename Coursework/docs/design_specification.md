# Design Specification: Bookstore Order Processing System

## Overview
This document outlines the design for the Bookstore Order Processing System. The system is developed in Java without using any Java collection frameworks (e.g., ArrayList, LinkedList) and features a simple console-based UI.

## System Requirements
- Process customer orders containing customer name, shipping address, and a list of books with quantities.
- Manage orders using a FIFO queue for order processing.
- Optionally, use a stack ADT for temporary operations if needed.
- Apply sorting and searching algorithms to organize and retrieve orders.

## Data Structures and Algorithms

### Stack ADT
- Purpose: To manage data with Last-In, First-Out (LIFO) behavior.
- Valid Operations: push, pop, peek, isEmpty, size

### FIFO Queue
- Purpose: To process orders in the exact sequence they are received (First-In, First-Out).
- Valid Operations: enqueue, dequeue, front, isEmpty, size

### Sorting Algorithm
- We will implement Insertion Sort for sorting orders. It is chosen for its simplicity and clarity given our project requirements.

### Searching Algorithm
- We will implement Linear Search for searching orders in the system.

## Console-Based UI
A simple text-based interface will be provided to:
- Place new orders
- Track existing orders
- Display order statuses

## Code Organization and Scalability
- Code is modularized by functionality to ease maintenance and future enhancements.
- The design specification will guide further development and is intended to support future extensions (e.g., integrating new data structures or algorithms).
- Consistent coding standards are applied for clarity and easy modifications.

## Assumptions
- Orders are always processed in the order they are received.
- The system is intended for educational purposes with an emphasis on clarity and simplicity.
- Customers track orders via simple search functions available in the console UI. 