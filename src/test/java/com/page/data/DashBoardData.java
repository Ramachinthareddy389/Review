package com.page.data;

import com.datamanager.ConfigManager;

public class DashBoardData {
	private ConfigManager appData   =   new ConfigManager("App");
	public final String openCartURL  = appData.getProperty("App.URL");
	public final String emailAddress = appData.getProperty("App.Username");
	public final String password    = appData.getProperty("App.Password");
	public final String dashboard   = appData.getProperty("App.Dashboard");
	public final String allpages  = appData.getProperty("App.Allpages");
	public final String LabelNewDashboard = appData.getProperty("App.LabelNewDashboard");
	public ConfigManager ticketData  = new ConfigManager("Ticket");
	public final String ticketTitle  = ticketData.getProperty("TicketTitle");
	public final String ticketAssignee = ticketData.getProperty("TicketAssignee");
	public final String ticketParticipant = ticketData.getProperty("TicketParticipant");
	public final String dashboardname   = ticketData.getProperty("Dashboards");
	private ConfigManager dashboardVisibility = new ConfigManager("DashboardVisibility");
	public final String userName         = dashboardVisibility.getProperty("username");
	public final String userPassword     = dashboardVisibility.getProperty("password");
	public final String sampleDashboard_AllowedUsers = dashboardVisibility.getProperty("sampleDashboard_AllowedUsers");
	public final String sampleDB_RequiredRole = dashboardVisibility.getProperty("sampleDB_RequiredRoles");
	public final String sample_Role_Name   = dashboardVisibility.getProperty("RoleName");
	public final String sample_Required_Role = dashboardVisibility.getProperty("RequiredRole");
	public final String requiredRole_Username = dashboardVisibility.getProperty("RequiredRole_TestUser");
	public final String sample_Role_Name_Owner = dashboardVisibility.getProperty("RoleName_Owner");
	public final String sampleDB_OwnerRole = dashboardVisibility.getProperty("sampleDB_OwnerRoles");
	public final String sample_Owner_Role = dashboardVisibility.getProperty("OwnerRole");
	public final String ownerRole_Username = dashboardVisibility.getProperty("OwnerRole_TestUser");
	private ConfigManager portletsData = new ConfigManager("Portlets");
	public final String portletKPI     = portletsData.getProperty("KPI");
	public final String portletQuery = portletsData.getProperty("Query");
	public final String drillthrghpage = portletsData.getProperty("DRILLTHROUGHPAGETITLE");
	public final String tooltip1     = portletsData.getProperty("TOOLTIP1");
	public final String tooltip2     = portletsData.getProperty("TOOLTIP2");
	public final String tooltip3     = portletsData.getProperty("TOOLTIP3");
	public final String DB_clonedPortlet = portletsData.getProperty("Dashboard_ClonedPortlet");
	public final String portletMeasureData = portletsData.getProperty("MeasureData");
	public final String nTabularPortletTrendGranularity = portletsData.getProperty("TrendGranularity");
	public final String nTabularPortletLabel = portletsData.getProperty("Label");
	public final String tabularPortletPivotData = portletsData.getProperty("PivotData");
	public final String flowPortletColumnLabel = portletsData.getProperty("ColumnLabel");
	public  final  String noPorteltNotify   = portletsData.getProperty("NoPorteltNotify");
	public final String porletHeaders       = portletsData.getProperty("portlets");
	public final String tablePortletName    = portletsData.getProperty("TablePortletName");
	public final String chartPortletName    = portletsData.getProperty("ChartPortletName");
	public final String pivotFieldPivotPage = portletsData.getProperty("Pivot_Portlet");
	public final String measurePivotPortlet = portletsData.getProperty("Measure_PivotPortlet");
	public final String chartType           = portletsData.getProperty("ChartType");
	public  final String mapHeaders         = portletsData.getProperty("Mapportlet");
	public final String updatedPivotFieldPivotPage = portletsData.getProperty("Updated_Pivot_Portlet");
	public final String updatedMeasurePivotPortlet = portletsData.getProperty("Updated_Measure_PivotPortlet");
	public final String updatedChartType           = portletsData.getProperty("UpdatedChartType");
	public final String updatedChartPortletName    = portletsData.getProperty("UpdatedChartPortletName");
	public final String updatedTablePortletName    = portletsData.getProperty("UpdatedTablePortletName");
	public final String[] pivotsArray              = portletsData.getProperty("MultiplePivots").split(",");
	public final String[] measuresArray            = portletsData.getProperty("MultipleMeasures").split(",");
	public final String constraint_DrillthroughPage = portletsData.getProperty("Constraint_Drillthrough");
	public final String pivot_DrillthroughPage      = portletsData.getProperty("Pivot_DrillthroughPage");



}
