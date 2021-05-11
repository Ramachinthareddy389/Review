package com.page.data;

import com.datamanager.ConfigManager;

public class DashBoardData {
	private ConfigManager appData = new ConfigManager("App");
	public final String openCartURL = appData.getProperty("App.URL");
	public final String emailAddress = appData.getProperty("App.Username");
	public final String password = appData.getProperty("App.Password");
	public final String dashboard = appData.getProperty("App.Dashboard");
	public final String allpages = appData.getProperty("App.Allpages");
	public final String LabelNewDashboard = appData.getProperty("App.LabelNewDashboard");
}