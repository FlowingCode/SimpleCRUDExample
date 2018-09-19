package com.flowingcode.vaadin.example.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
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

	Binder<Order> binder = new Binder<>(Order.class);

	public MainView() {

		comboState.setItems(State.values());

		initBindings();

		HorizontalLayout editLayout = new HorizontalLayout(tfDescription, tfQuantity, dfDueDate, comboState, cbPriority);

		Button btnCancel = new Button("Cancel");

		Button btnOk = new Button("OK");

		editLayout.add(btnOk, btnCancel);
		editLayout.setDefaultVerticalComponentAlignment(Alignment.START);
		editLayout.setVerticalComponentAlignment(Alignment.CENTER, cbPriority, btnOk, btnCancel);
		editLayout.setHeight("110px");

		add(editLayout, grid);
	}

	private void initBindings() {
		binder.forField(tfDescription).asRequired().bind(Order::getDescription, Order::setDescription);
		binder.forField(tfQuantity).asRequired().withConverter(new StringToIntegerConverter("Quantity must be integer"))
				.withValidator(value -> (value > 0), "Quantity must be positive")
				.bind(Order::getQuantity, Order::setQuantity);
		binder.forField(dfDueDate).asRequired().bind(Order::getDueDate, Order::setDueDate);
		binder.forField(comboState).asRequired().bind(Order::getState, Order::setState);
		binder.bind(cbPriority, Order::isPriority, Order::setPriority);
	}

}
