package com.hust.edu.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class AcademicPage {
    public void printPage(){
        Menu myMenu=new Menu();
        myMenu.PrintMenu();
        TextBox myTextBox=new TextBox();
        myTextBox.setText("Day la academicPage");
        RootPanel.get().add(myTextBox);
    }
}
