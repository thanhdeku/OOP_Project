package com.hust.edu.client;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.hust.edu.shared.Enroll;

public class Menu {
	
	public Menu() {
	}

	public void PrintMenu() {
		RootPanel.get().clear();
		MenuBar myBar=new MenuBar();
		myBar.addItem("Home", home);
		myBar.addItem("Academic Management",academicPage);
		myBar.addItem("Academic enroll", enroll);
		myBar.addItem("Lookups",lookUp);
		RootPanel.get().add(myBar);
	}
	private Command home = new Command() {
		@Override
		public void execute() {
			RootPanel.get().clear();
			HomePage myPage=new HomePage();
			myPage.printPage();
		}
	};

	private Command enroll = new Command() {
		@Override
		public void execute() {
			RootPanel.get().clear();
			EnrollPage myPage = new EnrollPage();
			myPage.printPage();
		}
	};
	private Command academicPage = new Command() {
		@Override
		public void execute() {
			RootPanel.get().clear();
			AcademicPage myPage = new AcademicPage();
			myPage.printPage();
		}
	};

	private Command lookUp = new Command() {
		@Override
		public void execute() {
			RootPanel.get().clear();
			LookUpPage myPage = new LookUpPage();
			myPage.printPage();
		}
	};


}
