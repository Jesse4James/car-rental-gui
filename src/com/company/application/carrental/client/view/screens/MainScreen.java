package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.ADKMainPanel;
import com.company.application.carrental.client.CarRentalApplication;
import com.company.application.carrental.client.CarRentalFacade;
import com.company.application.carrental.client.view.mediators.MainScreenMediator;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class MainScreen {

	private MainScreenMediator mediator;

	public MainScreen(MainScreenMediator mediator) {
		setMediator(mediator);

		CarRentalApplication app = CarRentalFacade.getApplication();

		ADKMainPanel mainPanel = app.getMainPanel();

		buildUI();

		ContentPanel center = mainPanel.getCenterPanel();
		center.clear();
	}

	private void buildUI() {
		CarRentalTabPanel tabPanel = new CarRentalTabPanel();

		BorderLayoutData westData = new BorderLayoutData();
		// westData.setSplit(true);
		westData.setCollapsible(true);
		westData.setMargins(new Margins(5));

		// CarRentalFacade.getApplication().getMainPanel().addWestPanel("");
		CarRentalFacade.getApplication().getMainPanel().setCenterWidget(tabPanel, westData);
	}

	public MainScreenMediator getMediator() {
		return mediator;
	}

	private void setMediator(MainScreenMediator mediator) {
		this.mediator = mediator;
	}
}