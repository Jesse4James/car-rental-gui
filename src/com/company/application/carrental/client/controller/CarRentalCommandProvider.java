package com.company.application.carrental.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.puremvc4gwt.client.core.controller.CommandProvider;
import org.puremvc4gwt.client.interfaces.ICommand;
import org.puremvc4gwt.client.patterns.command.MacroCommand;

import com.company.application.carrental.client.CarRentalEvents;

public class CarRentalCommandProvider implements CommandProvider {

    public ICommand getCommand(String command) {
        ICommand commandToBeReturned = null;

        if (CarRentalEvents.STARTUP.equals(command)) {
            commandToBeReturned = new StartupCommand();

        } else if (CarRentalEvents.LOAD_MASTER_DATA.equals(command)) {
            commandToBeReturned = new LoadMasterDataCommand();

        } else if (CarRentalEvents.SAVE_DRIVER_APPLICATION.equals(command)) {
            commandToBeReturned = new SaveDriverApplicationCommand();

        } else if (CarRentalEvents.SEARCH_DRIVER.equals(command)) {
            commandToBeReturned = new SearchDriverCommand();
        }

        return commandToBeReturned;
    }

    public List<ICommand> getSubCommandList(Class<? extends MacroCommand> commandClass) {

        List<ICommand> subCommandList = new ArrayList<ICommand>();

        if (commandClass.getName().equals(StartupCommand.class.getName())) {
            subCommandList.add(new CarRentalModelCommand());
            subCommandList.add(new CarRentalViewCommand());
        }

        return subCommandList;
    }
}