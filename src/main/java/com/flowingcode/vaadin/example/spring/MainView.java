package com.flowingcode.vaadin.example.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route
public class MainView extends VerticalLayout {

	TextField tfDescription = new TextField("Description");
	TextField tfQuantity = new TextField("Quantity");
	DatePicker dfDueDate = new DatePicker("Due Date");
	ComboBox<State> comboState = new ComboBox<>("State");
	Checkbox cbPriority = new Checkbox("Priority");

	Grid<Order> grid = new Grid<>(Order.class);

	public MainView() {

		comboState.setItems(State.values());

		HorizontalLayout editLayout = new HorizontalLayout(tfDescription, tfQuantity, dfDueDate, comboState, cbPriority);

		Button btnCancel = new Button("Cancel");

		Button btnOk = new Button("OK");

		editLayout.add(btnOk, btnCancel);
		editLayout.setDefaultVerticalComponentAlignment(Alignment.START);
		editLayout.setVerticalComponentAlignment(Alignment.CENTER, cbPriority, btnOk, btnCancel);
		editLayout.setHeight("110px");

		add(editLayout, grid);
	}

}
