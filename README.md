# Simple CRUD example with Vaadin 10

This repository contains a tutorial on how to create a simple CRUD view for managing a list of orders.
The example is structured as a sequence of steps, where each commit represents an incremental change to a Vaadin starter, and each tag represents a milestone through the tutorial.

You can run the application by using `mvn spring-boot:run` or directly by running the Application class from your IDE, then open http://localhost:8080/ in the browser.


1. Download the [Vaadin 10 Project Base Starter with Spring](https://vaadin.com/start/lts/project-base-spring).
2. Import the project to the IDE of your choosing as a Maven project. 
3. Add entities and repository classes (for this example, our "repository" is just an in-memory list).
4. Add fields, grid and buttons.
5. [TAG step-1](https://github.com/FlowingCode/SimpleCRUDExample/tree/step-1) Now we have the UI components, but no behaviors.

6. Instantiate a `Binder` and define bindings for each field.
7. [TAG step-2](https://github.com/FlowingCode/SimpleCRUDExample/tree/step-2) At this point we have some validations (provided by `Binder`) but we cannot add new orders.

8. Autowire the repository, so that it can be used from the view.
9. Add a click listener to the OK button, so that when the user clicks the button a new row is added into the grid, based on the filled values.
10. [TAG step-3](https://github.com/FlowingCode/SimpleCRUDExample/tree/step-3) Now, new orders can be added to the grid (but after the user adds an order, the input fields remains filled, and if the user clicks the OK button again a duplicate order will be saved).

11. Add a `clearForm` method that updates the `Binder` with a new instance of `Order` in `PENDING` state.
12. Add a click listener to the Cancel button, that invokes `clearForm`.
13. Invoke `clearForm` from the OK button's click listener, after the new order has been saved.
14. [TAG step-4](https://github.com/FlowingCode/SimpleCRUDExample/tree/step-4) Now the form fields are cleaned after the user clicks on either OK or Cancel button, but we cannot edit existing items.

15. Add a grid selection listener that loads the value of the selected row into the `Binder` (if no row is selected, call `clearForm` so that the fields are set to their initial state).
16. Modify the OK click listener: if a row is selected, then update it with the new values.
17. Add a DELETE action in the `Grid`.
18. Add a renderer for the "priority" column.
19. [TAG step-5](https://github.com/FlowingCode/SimpleCRUDExample/tree/step-5) The end result.