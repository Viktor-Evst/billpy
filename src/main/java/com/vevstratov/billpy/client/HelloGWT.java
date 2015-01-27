package com.vevstratov.billpy.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Created by Viktor Evstratov on 27.01.2015.
 */
public class HelloGWT implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Label greetingLabel = new Label("Hello, GWT!");
        RootPanel.get().add(greetingLabel);
    }
}
