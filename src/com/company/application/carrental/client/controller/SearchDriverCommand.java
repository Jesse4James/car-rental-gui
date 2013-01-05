package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.model.vo.SearchDriverInput;
import com.company.application.carrental.client.service.callback.SearchDriverAsyncHandler;
import com.company.application.carrental.client.service.proxy.CarRentalServiceProxy;

public class SearchDriverCommand extends SimpleCommand {

	public void execute(INotification notification) {
		SearchDriverInput input = (SearchDriverInput) notification.getBody();

		CarRentalServiceProxy.getInstance().searchDriver(input, new SearchDriverAsyncHandler());
	}
}