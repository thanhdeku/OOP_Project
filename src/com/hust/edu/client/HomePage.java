package com.hust.edu.client;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
public class HomePage {
public void printPage() {
	Menu myMenu=new Menu();
	myMenu.PrintMenu();
	TextBox myTextBox=new TextBox();
	myTextBox.setText("Day la homepage");
	RootPanel.get().add(myTextBox);
}
}