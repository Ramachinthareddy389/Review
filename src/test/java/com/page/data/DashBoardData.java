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
	private ConfigManager ticketData = new ConfigManager("Ticket");
	public final String ticketTitle = ticketData.getProperty("TicketTitle");
	public final String ticketAssignee = ticketData.getProperty("TicketAssignee");
	public final String ticketParticipant = ticketData.getProperty("TicketParticipant");

	private ConfigManager dashboardVisibility = new ConfigManager("DashboardVisibility");
	public final String userName = dashboardVisibility.getProperty("username");
	public final String userPassword = dashboardVisibility.getProperty("password");
	public final String sampleDashboard_AllowedUsers = dashboardVisibility.getProperty("sampleDashboard_AllowedUsers");
	public final String sampleDB_RequiredRole = dashboardVisibility.getProperty("sampleDB_RequiredRoles");
	public final String sample_Role_Name = dashboardVisibility.getProperty("RoleName");
	public final String sample_Required_Role = dashboardVisibility.getProperty("RequiredRole");
	public final String requiredRole_Username = dashboardVisibility.getProperty("RequiredRole_TestUser");
	public final String sample_Role_Name_Owner = dashboardVisibility.getProperty("RoleName_Owner");
	public final String sampleDB_OwnerRole = dashboardVisibility.getProperty("sampleDB_OwnerRoles");
	public final String sample_Owner_Role = dashboardVisibility.getProperty("OwnerRole");
	public final String ownerRole_Username = dashboardVisibility.getProperty("OwnerRole_TestUser");

}