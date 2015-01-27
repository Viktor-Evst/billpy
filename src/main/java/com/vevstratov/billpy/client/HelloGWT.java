package com.vevstratov.billpy.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Created by Viktor Evstratov on 27.01.2015.
 */
public class HelloGWT implements EntryPoint {
    private GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
    private TextBox nameTextBox = new TextBox();
    private Label greetingLabel = new Label("Hello, GWT!");

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(nameTextBox);
        RootPanel.get().add(greetingLabel);

        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                greetingLabel.setText(caught.toString());
            }

            @Override
            public void onSuccess(String result) {
                greetingLabel.setText(result);
            }
        };

        nameTextBox.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent keyUpEvent) {
                greetingService.greet(nameTextBox.getText(), callback);
            }
        });
    }
}