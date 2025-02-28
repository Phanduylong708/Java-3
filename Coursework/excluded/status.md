# Bookstore Order Processing System - Status Update

## Completed Features
- Implemented Book class with title and quantity.
- Developed Order class to handle customer orders (includes order ID, customer name, shipping address, and list of books).
- Implemented custom Queue for processing orders (FIFO) without using Java collections.
- Implemented custom Stack for order history and undo functionality without using Java collections.
- Developed InsertionSorter for sorting books by title.
- Developed LinearSearcher for searching in arrays (used for order search).
- Created Validator utility for input validation (validates customer name and shipping address).
- Integrated the validation, ordering, and search functionalities in BookstoreUI.
- Integrated the Stack ADT into BookstoreUI to provide an undo mechanism for the last order.
- Created TestFunctions.java and additional test files; all tests (including edge cases and undo functionality) pass successfully.

## Current Progress
- Fully functional console-based UI for order processing.
- Core features: order placement, viewing, searching, and undoing an order are operational.
- All custom data structures (Queue and Stack) have been implemented and tested.
- Input validation is in place for order data.

## Issues Encountered
- Initial implementation required development of custom data structures due to the constraint of not using Java collections.
- Ensuring proper input validation for special characters required refinements.
- Minor UI enhancements needed for better user feedback (resolved in subsequent tests).

## Next Steps
- Consider implementing additional sorting algorithms to offer different sorting options.
- Enhance error messages in the UI for improved user experience.
- Expand test coverage to include more edge cases and potential failure modes.
- Add comprehensive documentation for data structures and algorithm complexity evaluation.
- Explore the addition of a simple file-based storage system for order persistence. 