package com.page.module;

import com.page.data.DashBoardData;
import com.page.locators.PresentationModesNdRulesLocators;
import com.selenium.SafeActions;
import com.testng.Assert;
import org.apache.poi.ss.formula.functions.Na;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Random;

public class PresentationModesNdRulesNdRulesPages extends SafeActions implements PresentationModesNdRulesLocators {
    private WebDriver driver;
    private DashBoardData dashBoardData = new DashBoardData();
    Random random = new Random();
    String Presentation = "Presentation" + "-" + random.nextInt(500);
    String Rules = "Rules" + "-" + random.nextInt(500);
    String Edit_Rule = "EditRule" + "-" + random.nextInt(500);
    String Edit_Presentation = "EditP_Presentation" + "-" + random.nextInt(500);
    String TimeRanges ="TimeRanges" + "-" + random.nextInt(500);
    String Edit_TimeRange = "EditTimeRange"+ "-" + random.nextInt(500);
    String ROLE = "role" + "-" + random.nextInt(500);
    String Name_Add, Duration_Add, Dashboard_add, Timerange_add,Edited_Name_Add,Content_Add;
    String Minute_Add,Hour_Add,Day_Add,Year_Add,Month_add,End_Minute_Add,End_Hour_Add,End_Day_Add,End_Year_Add,End_Month_add,Start_Value_Add,Start_Unit_add,End_Value_Add,End_Unit_add;


    public PresentationModesNdRulesNdRulesPages(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Navigating to SSH page from automation module")
    public void clickingOnPresentationModes() {
        waitForSecs(20);
        safeClick(LABEL_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_PRESENTATION_MODES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Presentation, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void addingPresentationModeConfigWithDashboards() {
        safeClick(LABEL_DASHBOARD, "Server Feild", MEDIUMWAIT);
        safeClick(DASHBOARD_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_DASHBOARD, "Business Overview", "Server name into textbox", MEDIUMWAIT);
        waitForSecs(10);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Business Overview")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(10);
        Dashboard_add = safeGetText(TXTBOX_DASHBOARD_VALUE, "Server textbox value", MEDIUMWAIT);
        System.out.println(Dashboard_add);
    }

    public void addingTimeRangesAndDurationConfigs() {
        waitForSecs(10);
        safeClick(LABEL_TIMERANGE, "Server Feild", MEDIUMWAIT);
        safeClick(TIMERANGE_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_TIMERANGE, "Today", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Today")) {

                dbs2.get(i).click();
                break;
            }
        }
        Timerange_add = safeGetText(TXTBOX_TIMERANGE, "Server textbox value", MEDIUMWAIT);
        safeType(TXTBOX_DURATION, "60", "Duration into textbox", MEDIUMWAIT);
        Duration_Add = safeGetAttribute(TXTBOX_DURATION, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Duration_Add);
        safeClick(BTN_FINISH, "Finish button", MEDIUMWAIT);
        safeClick(BTN_CLOSE, "Close button", MEDIUMWAIT);
        waitForSecs(15);
    }

    public void verifyingAddedPresenatationModesWithDasshboardsConfig() {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Presentation;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Dashboard_add.equals(driver.findElement(HYPERLINK_DASHBOARDS).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void uncheckDashBoardCheckBox() {
        waitForSecs(10);
        safeUnCheck(CHKBOX_DASHBOARD, "Dashboard checkbox", MEDIUMWAIT);
    }

    public void addingPresentationModeConfigWithViews() {
        safeClick(LABEL_VIEW, "Server Feild", MEDIUMWAIT);
        safeClick(VIEW_GHOSTEXT, "Server textbox", MEDIUMWAIT);
        safeClearAndType(TXTBOX_VIEW, "Insights", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Insights")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        Dashboard_add = safeGetText(TXTBOX_VIEW_VALUE, "Server textbox value", MEDIUMWAIT);
        System.out.println(Dashboard_add);
    }

    public void addingDashboardsNDViewsfromEditPresentationModeWindow() {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_REMOVE_DASHBOARDS, "Remove Dashboards", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DASHBOARDS_ADD_ICON, "Dashboards add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
    }

    public void verifyingAddedDashboardInEditPresentationWindow() {
        String expectedText = driver.findElement(HYPERLINK_DASHBOARDS).getText();
        Assert.assertEquals(Dashboard_add, expectedText);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void addingPresentationModePage(){
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Presentation, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
        waitForSecs(5);
    }

    public void verifyingPresentationModesInPresentationButton(){
        safeClick(PLAY_BTN_ICON,"Play button",MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(PLAYMODE_DRPDOWN);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 3; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Presentation")) {
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertFalse(false,"Presentation mode is not displaying in play button dropdown");
            }
        }
        waitForSecs(10);
        refresh();
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void editDashboardConfigValues()
    {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + Edit_Presentation);
        Edited_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_REMOVE_DASHBOARDS, "Remove Dashboards", MEDIUMWAIT);
        safeClick(BTN_SAVE, "Save button", MEDIUMWAIT);
        waitForSecs(15);
        safeClick(DASHBOARDS_ADD_ICON, "Dashboards add icon", MEDIUMWAIT);
        safeClick(BTN_NEXT, "Next button", MEDIUMWAIT);
    }

    public void verifyingEditedDashboardViewConfigValues()
    {
        waitForSecs(10);
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Dashboard_add.equals(driver.findElement(HYPERLINK_DASHBOARDS).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void verifyingPageIconsInPresentationModes() {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        //mouseHoverJScript(SELECTROW_CHKBOX, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE,"clone button",MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label","Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Presentation+" - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }
    public void applyingFiltersInPresentationModes() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Presentation + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, Presentation);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }

    public void verifyingIconsInPresentationEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, Presentation + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + Presentation + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    public void viewDataWithFeildsForViewIconInPresentationMode() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Presentation + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        waitForSecs(10);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(HYPERLINK_DASHBOARDS, "Added BP Steps", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(EYE_ICON, "Eye iocn", MEDIUMWAIT);
        isElementDisplayed(KPIS_TEXT);
        waitForSecs(5);
        String NameValue =safeGetText(DASHBOARDNAME_VALUE,"Name View Data",MEDIUMWAIT);
        Assert.assertEquals(NameValue,Dashboard_add);
        List<WebElement> wizards = driver.findElements(LIST_OF_KPIS_VALUES);
        for (int i = 1; i <wizards.size(); i++) {
            String wizardName = wizards.get(i).getText();
            Assert.assertEquals(wizardName, (dashBoardData.PRESENTATION_VALUES[i-1]));
            System.out.println(wizardName);
        }


        for (int j = 1; j < dashBoardData.PRESENTATION_VALUES.length; j++) {
            System.out.println("Values are " + dashBoardData.PRESENTATION_VALUES[j-1]);
        }
        safeClick(CLOSE_WINDOW, "Closing window");
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }

    //Rules page methods

    public void addRuleConfiguration()
    {
        safeClick(LABEL_SYSTEM,"System",MEDIUMWAIT);
        safeClick(LABEL_ENGINE_SETTINGS, "Engine Settings", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_RULES, "Rules", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, Rules, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeType(TEXTAREA_CONTENT,

                "package com.germainsoftware.apm.parser;" +
                "\n" +
                "dialect \"mvel\"\n" +
                "\n" +
                "import java.util.regex.*;\n" +
                "import java.util.Date;\n" +
                "import com.germainsoftware.apm.converter.Queues;\n" +
                "import com.germainsoftware.apm.data.*;\n" +
                "import com.germainsoftware.apm.data.model.*;\n" +
                "import com.germainsoftware.apm.parser.LogEvent;\n" +
                "import com.germainsoftware.apm.parser.DefaultLogEntry;\n" +
                "\n" +
                "global org.slf4j.Logger logger;\n" +
                "global com.germainsoftware.apm.converter.DatamartConverter datamart;\n" +
                "global com.germainsoftware.apm.parser.ParserState state;\n" +
                "global com.germainsoftware.apm.router.RouterContext context;\n" +
                "global com.germainsoftware.apm.state.model.MonitoredFile file;\n" +
                "global com.germainsoftware.apm.parser.LogScanner scanner;\n" +
                "\n" +
                "// Redeclare Java base types\n" +
                "declare DefaultLogEntry\n" +
                "end\n" +
                "\n" +
                "rule \"Crash Entry\"\n" +
                "when\n" +
                "    $e : DefaultLogEntry( )\n" +
                "then\n" +
                "    // Each crash file contains a single crash, so just read lines until we get to \n" +
                "    // the end of the file.\n" +
                "    StringBuilder sb = new StringBuilder();\n" +
                "    sb.append($e.rawText);\n" +
                "    sb.append(System.lineSeparator());\n" +
                "    boolean isDone = false;\n" +
                "    while (scanner.peek() != null) {       \n" +
                "        sb.append(scanner.peek());\n" +
                "        sb.append(System.lineSeparator());\n" +
                "        scanner.skipToken();        \n" +
                "    }\n" +
                "        \n" +
                "    String crash = sb.toString();\n" +
                "\n" +
                "\n" +
                "    Pattern p = Pattern.compile(\"Exception (\\\\w+) at (\\\\w+)\\\\s+Thread: (\\\\w+), Process (\\\\w+)(.*)\", Pattern.DOTALL);\n" +
                "    Matcher m = p.matcher(crash);\n" +
                "    if (!m.matches()) {\n" +
                "        logger.warn(\"Could not match crash: {}\", crash);\n" +
                "        return;\n" +
                "    }    \n" +
                "    logger.info(\"========================================11\");\n" +
                "    long processId = Long.decode(m.group(4)); // both in base16 with 0x prefix\n" +
                "    long threadId = Long.decode(m.group(3));\n" +
                "    logger.info(\"processId: \"+processId);\n" +
                "    logger.info(\"threadId: \"+threadId);\n" +
                "    logger.info(\"========================================11\");\n" +
                "\n" +
                "    /*\n" +
                "    Pattern p2 = Pattern.compile(\".+?- CALL STACK -\\\\s+((\\\\S+\\\\s+\\\\S+\\\\s+=.+\\r\\n)+).+?\", Pattern.DOTALL);\n" +
                "    Matcher m2 = p2.matcher(crash);\n" +
                "    String hashValue = null;\n" +
                "    if (m2.matches()) {\n" +
                "        String[] stackLines = m2.group(1).split(\"\\r\\n\");\n" +
                "        StringBuilder stackBuilder = new StringBuilder();\n" +
                "        stackBuilder.append(stackLines[0]);\n" +
                "        stackBuilder.append(\"\\r\\n\");\n" +
                "        stackBuilder.append(stackLines[1]);\n" +
                "        stackBuilder.append(\"\\r\\n\");\n" +
                "        stackBuilder.append(stackLines[2]);\n" +
                "        stackBuilder.append(\"\\r\\n\");\n" +
                "        String stack3 = stackBuilder.toString();\n" +
                "        hashValue = Long.toString(((long)stack3.hashCode()) + 2147483648L);\n" +
                "    } else {\n" +
                "        hashValue = \"<no-stack>\";\n" +
                "    }*/\n" +
                "\n" +
                "    GenericEvent ev = new GenericEvent();\n" +
                "    ev.type = \"Siebel:Core Crash\";\n" +
                "    ev.name = file.fullName;\n" +
                "    ev.timestamp = DateTimeUtils.toOffsetDt(file.lastModified);\n" +
                "    ev.details = crash;\n" +
                "    ev.pid = Long.toString(processId);\n" +
                "    ev.tid = Long.toString(threadId);\n" +
                "    datamart.insert(ev, context);\n" +
                "    \n" +
                "    logger.debug(\"Found Siebel Core Crash: {}\", ev);\n" +
                "end","Content Text are",MEDIUMWAIT);
        Content_Add = safeGetText(CONTENT_VAULUE,"Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeClick(BTN_FINISH,"Finish",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyingAddedRules()
    {
        safeType(TEXTBOX_TYPESEARCH, Rules + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Rules;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        System.out.println(driver.findElements(CONTENT_VAULUE).get(1).getText());
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) ) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void EditRulesConfig()
    {
        safeType(TEXTBOX_TYPESEARCH, Rules + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField = driver.findElement(TXTBOX_NAME);
        searchField.sendKeys(del + Edit_Rule);
        Edited_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(5);
        String del1 = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        WebElement searchField1= driver.findElement(TEXTAREA_CONTENT);
        searchField1.sendKeys(del1 + "content");
        Content_Add = safeGetText(CONTENT_VAULUE,"Name textbox value", MEDIUMWAIT);
        System.out.println(Content_Add);
        waitForSecs(20);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(30);
        safeClick(CLOSE_EDITWINDOW,"Close Edit Window",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CLEAR,"Clear button",MEDIUMWAIT);
        waitForSecs(10);
        safeType(TEXTBOX_TYPESEARCH, Edit_Rule + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Content_Add.equals(driver.findElement(CONTENT_VAULUE).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void verifyingPageIconsInRulesPage() {
        safeType(TEXTBOX_TYPESEARCH, Rules + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        //mouseHoverJScript(SELECTROW_CHKBOX, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE,"clone button",MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label","Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = Rules+" - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }
    public void applyingFiltersInRulesPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + Rules + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        Assert.assertEquals(BPName, Rules);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    public void verifyingIconsInRulesEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, Rules + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + Rules + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
 public void ValidateRuleInEditconfigWindow(){
     safeType(TEXTBOX_TYPESEARCH, Rules + "\n", "Alert Name into type search");
     System.out.println("entered dbtext");
     waitForSecs(9);
     mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
     safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
     waitForSecs(9);
     boolean validateRule = isElementEnabled(BTN_VALIDATERULE);
     Assert.assertTrue(validateRule);
     safeClick(BTN_VALIDATERULE,"Validate button",MEDIUMWAIT);
     boolean notifyText= isElementDisplayed(NOTIFYTEXT);
     Assert.assertTrue(notifyText);
     waitForSecs(10);
     safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
     waitForSecs(20);
     safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
     waitForSecs(15);
 }
    public void addingTimeRanges(){
        waitForSecs(20);
        safeClick(LABEL_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_TIMERANGES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, TimeRanges, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);

    }

    public void startPageConfigs(){
        safeJavaScriptClick(BTN_ABSOLUTE_RADIO,"Absolute radio button",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeType(TXTBOX_MINUTE, "0", "Name into textbox", MEDIUMWAIT);
        Minute_Add = safeGetAttribute(TXTBOX_MINUTE, "value", "Name textbox value", MEDIUMWAIT);
        safeType(TXTBOX_HOUR, "9", "Name into textbox", MEDIUMWAIT);
        Hour_Add = safeGetAttribute(TXTBOX_HOUR, "value", "Name textbox value", MEDIUMWAIT);
        safeType(TXTBOX_DAY, "3", "Name into textbox", MEDIUMWAIT);
        Day_Add = safeGetAttribute(TXTBOX_DAY, "value", "Name textbox value", MEDIUMWAIT);
        safeType(TXTBOX_YEAR, "2021", "Name into textbox", MEDIUMWAIT);
        Year_Add = safeGetAttribute(TXTBOX_YEAR, "value", "Name textbox value", MEDIUMWAIT);
        safeClearAndType(TXTBOX_MONTH, "January", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("January")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        Month_add = safeGetText(TXTBOX_MONTH, "Server textbox value", MEDIUMWAIT);
        System.out.println(Month_add);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
    }
    public void endPageConfigs(){
        safeType(TXTBOX_MINUTE, "0", "Name into textbox", MEDIUMWAIT);
        End_Minute_Add = safeGetAttribute(TXTBOX_MINUTE, "value", "Name textbox value", MEDIUMWAIT);
        safeType(TXTBOX_HOUR, "9", "Name into textbox", MEDIUMWAIT);
        End_Hour_Add = safeGetAttribute(TXTBOX_HOUR, "value", "Name textbox value", MEDIUMWAIT);
        safeType(TXTBOX_DAY, "3", "Name into textbox", MEDIUMWAIT);
        End_Day_Add = safeGetAttribute(TXTBOX_DAY, "value", "Name textbox value", MEDIUMWAIT);
        safeType(TXTBOX_YEAR, "2021", "Name into textbox", MEDIUMWAIT);
        End_Year_Add = safeGetAttribute(TXTBOX_YEAR, "value", "Name textbox value", MEDIUMWAIT);
        safeClearAndType(TXTBOX_MONTH, "February", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("February")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        End_Month_add = safeGetText(TXTBOX_MONTH, "Server textbox value", MEDIUMWAIT);
        System.out.println(End_Month_add);
        safeClick(BTN_FINISH,"Finish",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public void verifyingAddedAbsoluteTimeRangesInEditWindow(){
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = TimeRanges;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Minute_Add.equals(driver.findElement(TXTBOX_START_EDIT_MINUTE).getAttribute("value")) &&  Hour_Add.equals(driver.findElement(TXTBOX_START_EDIT_HOUR).getAttribute("value"))&& Year_Add.equals(driver.findElement(TXTBOX_START_EDIT_YEAR).getAttribute("value")) &&  Day_Add.equals(driver.findElement(TXTBOX_START_EDIT_DAY).getAttribute("value")) &&  Month_add.equals(driver.findElement(TXTBOX_START_EDIT_MONTH).getText())&&End_Minute_Add.equals(driver.findElement(TXTBOX_END_EDIT_MINUTE).getAttribute("value")) &&  End_Day_Add.equals(driver.findElement(TXTBOX_END_EDIT_DAY).getAttribute("value")) &&  End_Year_Add.equals(driver.findElement(TXTBOX_END_EDIT_YEAR).getAttribute("value"))&& End_Hour_Add.equals(driver.findElement(TXTBOX_END_EDIT_HOUR).getAttribute("value")) && End_Month_add.equals(driver.findElement(TXTBOX_END_EDIT_MONTH).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void addingRelativeTimeRanges(){
        safeJavaScriptClick(BTN_RELATIVE_RADIO,"Absolute radio button",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
        safeType(TXTBOX_START_VALUE, "2", "Name into textbox", MEDIUMWAIT);
        Start_Value_Add = safeGetAttribute(TXTBOX_START_VALUE, "value", "Name textbox value", MEDIUMWAIT);
        safeClearAndType(TXTBOX_START_UNIT, "Month", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Month")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        Start_Unit_add = safeGetText(TXTBOX_START_UNIT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Start_Unit_add);
        safeCheck(CHKBOX_START_OF_TIME,"Start of time checkbox",MEDIUMWAIT);
        safeClick(BTN_NEXT,"Next button",MEDIUMWAIT);
    }

    public void addingRelativeTimeRangeEndPageConfigs(){
        safeType(TXTBOX_START_VALUE, "3", "Name into textbox", MEDIUMWAIT);
        End_Value_Add = safeGetAttribute(TXTBOX_START_VALUE, "value", "Name textbox value", MEDIUMWAIT);
        safeClearAndType(TXTBOX_START_UNIT, "Year", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Year")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        End_Unit_add = safeGetText(TXTBOX_START_UNIT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Start_Unit_add);
        safeCheck(CHKBOX_START_OF_TIME,"Start of time checkbox",MEDIUMWAIT);
        safeClick(BTN_FINISH,"Finish",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public  void verifyingAddedRelativeTimeRange(){
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = TimeRanges;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        boolean startTime=  isElementSelected(CHKBOX_START_TIME_IN_EDIT);
        Assert.assertTrue(startTime);
        boolean endTime=  isElementSelected(CHKBOX_END_TIME_IN_EDIT);
        Assert.assertTrue(endTime);
        if (Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Start_Value_Add.equals(driver.findElement(TXTBOX_START_EDIT_VALUE).getAttribute("value")) &&  Start_Unit_add.equals(driver.findElement(TXTBOX_START_EDIT_UNIT).getText())&&End_Value_Add.equals(driver.findElement(TXTBOX_END_EDIT_VALUE).getAttribute("value")) &&  End_Unit_add.equals(driver.findElement(TXTBOX_END_EDIT_UNIT).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);

    }

    public void editingAbsoluteTimerange(){
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeTypeUsingChrod(TXTBOX_NAME, Edit_TimeRange, "Name into textbox", MEDIUMWAIT);
        Edited_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(5);
        safeTypeUsingChrod(TXTBOX_START_EDIT_MINUTE, "5", "Name into textbox", MEDIUMWAIT);
        Minute_Add = safeGetAttribute(TXTBOX_START_EDIT_MINUTE, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_START_EDIT_HOUR, "8", "Name into textbox", MEDIUMWAIT);
        Hour_Add = safeGetAttribute(TXTBOX_START_EDIT_HOUR, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_START_EDIT_DAY, "5", "Name into textbox", MEDIUMWAIT);
        Day_Add = safeGetAttribute(TXTBOX_START_EDIT_DAY, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_START_EDIT_YEAR, "2020", "Name into textbox", MEDIUMWAIT);
        Year_Add = safeGetAttribute(TXTBOX_START_EDIT_YEAR, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_START_EDIT_MONTH, "February", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("February")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        Month_add = safeGetText(TXTBOX_START_EDIT_MONTH, "Server textbox value", MEDIUMWAIT);
        System.out.println(Month_add);
        safeTypeUsingChrod(TXTBOX_END_EDIT_MINUTE, "9", "Name into textbox", MEDIUMWAIT);
        End_Minute_Add = safeGetAttribute(TXTBOX_END_EDIT_MINUTE, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_END_EDIT_HOUR, "10", "Name into textbox", MEDIUMWAIT);
        End_Hour_Add = safeGetAttribute(TXTBOX_END_EDIT_HOUR, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_END_EDIT_DAY, "6", "Name into textbox", MEDIUMWAIT);
        End_Day_Add = safeGetAttribute(TXTBOX_END_EDIT_DAY, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_END_EDIT_YEAR, "2025", "Name into textbox", MEDIUMWAIT);
        End_Year_Add = safeGetAttribute(TXTBOX_END_EDIT_YEAR, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_END_EDIT_MONTH, "March", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("March")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        End_Month_add = safeGetText(TXTBOX_END_EDIT_MONTH, "Server textbox value", MEDIUMWAIT);
        System.out.println(Month_add);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);

    }

    public void verifyingEditedValuesInAbsoluteTimerange(){
        waitForSecs(10);
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Minute_Add.equals(driver.findElement(TXTBOX_START_EDIT_MINUTE).getAttribute("value")) &&  Hour_Add.equals(driver.findElement(TXTBOX_START_EDIT_HOUR).getAttribute("value"))&& Year_Add.equals(driver.findElement(TXTBOX_START_EDIT_YEAR).getAttribute("value")) &&  Day_Add.equals(driver.findElement(TXTBOX_START_EDIT_DAY).getAttribute("value")) &&  Month_add.equals(driver.findElement(TXTBOX_START_EDIT_MONTH).getText())&&End_Minute_Add.equals(driver.findElement(TXTBOX_END_EDIT_MINUTE).getAttribute("value")) &&  End_Day_Add.equals(driver.findElement(TXTBOX_END_EDIT_DAY).getAttribute("value")) &&  End_Year_Add.equals(driver.findElement(TXTBOX_END_EDIT_YEAR).getAttribute("value"))&& End_Hour_Add.equals(driver.findElement(TXTBOX_END_EDIT_HOUR).getAttribute("value")) && End_Month_add.equals(driver.findElement(TXTBOX_END_EDIT_MONTH).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void editingRelativeTimeRange(){
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeTypeUsingChrod(TXTBOX_NAME, Edit_TimeRange, "Name into textbox", MEDIUMWAIT);
        Edited_Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        waitForSecs(5);
        safeTypeUsingChrod(TXTBOX_START_EDIT_VALUE, "5", "Name into textbox", MEDIUMWAIT);
        Start_Value_Add = safeGetAttribute(TXTBOX_START_EDIT_VALUE, "value", "Name textbox value", MEDIUMWAIT);
        safeClearAndType(TXTBOX_START_EDIT_UNIT, "Year", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {

            if (dbs1.get(i).getText().equals("Year")) {

                dbs1.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        Start_Unit_add = safeGetText(TXTBOX_START_EDIT_UNIT, "Server textbox value", MEDIUMWAIT);
        System.out.println(Start_Unit_add);
        safeUnCheck(CHKBOX_START_TIME_IN_EDIT,"Start of time checkbox",MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_END_EDIT_VALUE, "7", "Name into textbox", MEDIUMWAIT);
        End_Value_Add = safeGetAttribute(TXTBOX_END_EDIT_VALUE, "value", "Name textbox value", MEDIUMWAIT);
        safeTypeUsingChrod(TXTBOX_END_EDIT_UNIT, "Year", "Server name into textbox", MEDIUMWAIT);
        List<WebElement> dbs2 = driver.findElements(DROPDOWN_SERVER);
        System.out.println("Total no 0f dashboards:::====> " + dbs2.size());
        for (int i = 0; i < dbs2.size(); i++) {

            if (dbs2.get(i).getText().equals("Year")) {

                dbs2.get(i).click();
                break;
            }
        }
        waitForSecs(5);
        End_Unit_add = safeGetText(TXTBOX_END_EDIT_UNIT, "Server textbox value", MEDIUMWAIT);
        System.out.println(End_Unit_add);
        safeUnCheck(CHKBOX_END_TIME_IN_EDIT,"Start of time checkbox",MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
    }

    public void verifyingEditedRelativeTimerangeConfigs()
    {
        waitForSecs(10);
        boolean startTime=  isElementSelected(CHKBOX_START_TIME_IN_EDIT);
        Assert.assertTrue(startTime);
        boolean endTime=  isElementSelected(CHKBOX_END_TIME_IN_EDIT);
        Assert.assertTrue(endTime);
        if (Edited_Name_Add.equals(driver.findElement(TXTBOX_NAME).getAttribute("value")) && Start_Value_Add.equals(driver.findElement(TXTBOX_START_EDIT_VALUE).getAttribute("value")) &&  Start_Unit_add.equals(driver.findElement(TXTBOX_START_EDIT_UNIT).getText())&&End_Value_Add.equals(driver.findElement(TXTBOX_END_EDIT_VALUE).getAttribute("value")) &&  End_Unit_add.equals(driver.findElement(TXTBOX_END_EDIT_UNIT).getText())) {
            System.out.println("Business process details are valid");
            Assert.assertTrue(true);

        } else {
            Assert.fail("Business process details are invalid");
        }

        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }

    public void ClickingOnTimeRanges(){
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, TimeRanges, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
    }

    public void verifyTimeRangesInCalendar(){
        List<WebElement> dbs1 = driver.findElements(PREDEFINED_TIMERANGES);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {
            System.out.println(dbs1.get(i).getText());
            if (dbs1.get(i).getText().equals(TimeRanges)) {

               Assert.assertEquals(dbs1.get(i).getText(),TimeRanges);
            }
        }
        waitForSecs(20);
        safeClick(LABEL_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_TIMERANGES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public void verifyingTimeRangesInGuidedSearchPage(){
        safeClick(EXPLORE_LABEL,"Explore label",MEDIUMWAIT);
        safeClick(EXPLORE_SEARCH_TEXTBOX, "Search bar in Add Metric Window", MEDIUMWAIT);
        driver.findElement(EXPLORE_SEARCH_TEXTBOX).sendKeys(dashBoardData.portletQuery, Keys.ENTER, Keys.ENTER);
        safeClick(EXPLORE_SEARCH_TEXTBOX, "Search bar in Add Metric Window", MEDIUMWAIT);
        List<WebElement> dbs1 = driver.findElements(TIMERANGES_IN_EXPLORE_PAGE);
        System.out.println("Total no 0f dashboards:::====> " + dbs1.size());
        for (int i = 0; i < dbs1.size(); i++) {
            System.out.println(dbs1.get(i).getText());
            if (dbs1.get(i).getText().equals("for "+TimeRanges)) {

                Assert.assertEquals(dbs1.get(i).getText(),"for "+TimeRanges);
            }
        }
        waitForSecs(20);
        refresh();
        safeClick(LABEL_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        safeClick(LABEL_TIMERANGES, "DbInstances label from Datasources sub mneu", MEDIUMWAIT);
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void verifyingPageIconsInTimeRangesPage() {
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        //mouseHoverJScript(SELECTROW_CHKBOX, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        boolean b = isElementDisplayed(BTN_ENABLE);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(BTN_DISABLE, "Enable config button", MEDIUMWAIT);
        boolean disable = isElementDisplayed(BTN_STATUS);
        System.out.println(disable);
        Assert.assertTrue(disable);
        boolean row = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(row);
        Assert.assertFalse(row);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_CLONE,"clone button",MEDIUMWAIT);
        waitForSecs(10);
        String pageTitle = safeGetAttribute(HEADER_CLONED, "aria-label","Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = TimeRanges+" - Cloned";
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(5);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }
    public void applyingFiltersInTimeRangesPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + TimeRanges + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        waitForSecs(10);
        Assert.assertEquals(BPName, TimeRanges);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    public void verifyingIconsInTimeRangesEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, TimeRanges + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DISABLE_ICON, "Disable icon", MEDIUMWAIT);
        waitForSecs(10);
        boolean b = isElementDisplayed(ENABLED_STATUS);
        System.out.println(b);
        Assert.assertTrue(b);
        safeClick(CLONE_ICON, "Clone icon", MEDIUMWAIT);
        waitForSecs(10);
        By Cloned = By.xpath("//div[@aria-label='Save Configuration']/../../h5[@aria-label='" + TimeRanges + " - Cloned']");
        if (!driver.findElement(Cloned).isDisplayed())
            Assert.fail("Cloned business process not displayed");
        waitForSecs(20);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);
        mouseHoverJScript(LISTOFDBS1, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS1, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    //Roles
    public void clickingOnUserRoles(){
        waitForSecs(20);
        safeClick(LABEL_SYSTEM, "Datasources label from left side pane", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(LABEL_AUTH_SETTINGS,"Auth Settings",MEDIUMWAIT);
        waitForSecs(5);
        safeClick(LABEL_USER_ROLES,"Auth Settings",MEDIUMWAIT);
        safeClick(BTN_ADDICON, "Add button", MEDIUMWAIT);
    }

    public void addingNewUserRoles()
    {
        safeClick(LABEL_NAME, "Name Feild", MEDIUMWAIT);
        safeType(TXTBOX_NAME, ROLE, "Name into textbox", MEDIUMWAIT);
        Name_Add = safeGetAttribute(TXTBOX_NAME, "value", "Name textbox value", MEDIUMWAIT);
        System.out.println(Name_Add);
        safeCheck(CHECKBOX1,"Creativeinactive config",MEDIUMWAIT);
        safeCheck(CHECKBOX2,"Create/Edit Config",MEDIUMWAIT);
        safeCheck(CHECKBOX3,"Create Dashboards",MEDIUMWAIT);
        safeCheck(CHECKBOX4,"Edit UI Fields/Columns",MEDIUMWAIT);
        safeCheck(CHECKBOX5,"View Data",MEDIUMWAIT);
        safeCheck(CHECKBOX6,"View User Replay",MEDIUMWAIT);
        safeCheck(CHECKBOX7,"Manage Users",MEDIUMWAIT);
        safeCheck(CHECKBOX8,"Monitor",MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_FINISH_ROLE,"Finish button",MEDIUMWAIT);
        safeClick(BTN_CLOSE,"Close button",MEDIUMWAIT);
    }

    public  void verifyingAddedUserRoles()
    {
        safeType(TEXTBOX_TYPESEARCH, ROLE + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(RECORD_IN_ROLE_PAGE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(RECORD_IN_ROLE_PAGE, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        String pageTitle = safeGetText(HEADER_DB, "Db page title", MEDIUMWAIT);
        System.out.println(pageTitle);
        String expectedText = ROLE;
        Assert.assertEquals(pageTitle, expectedText);
        waitForSecs(10);
        Assert.assertEquals(Name_Add,driver.findElement(TXTBOX_NAME).getAttribute("value"));
        boolean chkBOx1=  isElementSelected(CHECKBOX1);
        Assert.assertTrue(chkBOx1);
        boolean chkBOx2=  isElementSelected(CHECKBOX2);
        Assert.assertTrue(chkBOx2);
        boolean chkBOx3=  isElementSelected(CHECKBOX3);
        Assert.assertTrue(chkBOx3);
        boolean chkBOx4=  isElementSelected(CHECKBOX4);
        Assert.assertTrue(chkBOx4);
        boolean chkBOx5=  isElementSelected(CHECKBOX5);
        Assert.assertTrue(chkBOx5);
        boolean chkBOx6=  isElementSelected(CHECKBOX6);
        Assert.assertTrue(chkBOx6);
        boolean chkBOx7=  isElementSelected(CHECKBOX7);
        Assert.assertTrue(chkBOx7);
        boolean chkBOx8=  isElementSelected(CHECKBOX8);
        Assert.assertTrue(chkBOx8);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }


    public  void editUserRolesConfig(){
        safeType(TEXTBOX_TYPESEARCH, ROLE + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(20);
        mouseHoverJScript(RECORD_IN_ROLE_PAGE, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(RECORD_IN_ROLE_PAGE, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeUnCheck(CHECKBOX1,"Creativeinactive config",MEDIUMWAIT);
        safeUnCheck(CHECKBOX2,"Create/Edit Config",MEDIUMWAIT);
        safeUnCheck(CHECKBOX3,"Create Dashboards",MEDIUMWAIT);
        safeUnCheck(CHECKBOX4,"Edit UI Fields/Columns",MEDIUMWAIT);
        safeUnCheck(CHECKBOX5,"View Data",MEDIUMWAIT);
        safeClick(BTN_SAVE,"Save button",MEDIUMWAIT);
        waitForSecs(9);
        boolean chkBOx1=  isElementSelected(CHECKBOX1);
        Assert.assertFalse(chkBOx1);
        boolean chkBOx2=  isElementSelected(CHECKBOX2);
        Assert.assertFalse(chkBOx2);
        boolean chkBOx3=  isElementSelected(CHECKBOX3);
        Assert.assertFalse(chkBOx3);
        boolean chkBOx4=  isElementSelected(CHECKBOX4);
        Assert.assertFalse(chkBOx4);
        boolean chkBOx5=  isElementSelected(CHECKBOX5);
        Assert.assertFalse(chkBOx5);
        boolean chkBOx6=  isElementSelected(CHECKBOX6);
        Assert.assertTrue(chkBOx6);
        boolean chkBOx7=  isElementSelected(CHECKBOX7);
        Assert.assertTrue(chkBOx7);
        boolean chkBOx8=  isElementSelected(CHECKBOX8);
        Assert.assertTrue(chkBOx8);
        waitForSecs(10);
        safeJavaScriptClick(DELETE_ALERT, "Delete Alert", MEDIUMWAIT);
        waitForSecs(5);
        safeJavaScriptClick(CONFIRM_DELETE, "Confirm button", MEDIUMWAIT);
        waitForSecs(10);
    }
    public void verifyingPageIconsRolesPage() {
        safeType(TEXTBOX_TYPESEARCH, ROLE + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        //mouseHoverJScript(SELECTROW_CHKBOX, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        boolean b1 = isElementSelected(SELECTROW_CHKBOX);
        System.out.println(b1);
        Assert.assertTrue(b1);
        waitForSecs(10);
        safeClick(BTN_EDIT, "Edit button", MEDIUMWAIT);
        boolean editTitle = isElementDisplayed(EDIT_HEADER_WMI);
        Assert.assertTrue(editTitle);
        List<WebElement> chkboxes = driver.findElements(CHEKBOXES_EDITWINDOW_WMI);
        for (int i = 0; i <= chkboxes.size() - 1; i++) {
            chkboxes.get(i).click();
        }
        waitForSecs(10);
        safeClick(BTN_APPLY_CHANGES_WMI, "Apply changes", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(BTN_CONFIRM, "Confirm button", MEDIUMWAIT);
        waitForSecs(15);
        safeJavaScriptClick(SELECTROW_CHKBOX, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(BTN_DELETE,"Delete button",MEDIUMWAIT);
        waitForSecs(15);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);

    }
    public void applyingFiltersInRolesPage() {
        waitForSecs(10);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        safeClick(SEARCH_ICON, "Text", MEDIUMWAIT);
        waitForSecs(10);
        safeType(TYPE_SEARCH, "name", "Enter Text in portlets");
        waitForSecs(10);
        safeClick(DROPDOWN_FEILDS, "Selecting field", MEDIUMWAIT);
        By SeachedText = By.xpath("//div[contains(text(),'" + ROLE + "')]");
        mouseHoverJScript(SeachedText, "SeachedText", "text", MEDIUMWAIT);
        driver.findElement(SeachedText).click();
        // driver.findElement(TYPE_SEARCH).sendKeys(Keys.ENTER);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        String BPName = safeGetText(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        System.out.println(BPName);
        Assert.assertTrue(isElementDisplayed(LABEL_SAVE));
        Assert.assertTrue(isElementDisplayed(BTN_CLEAR));
        waitForSecs(10);
        Assert.assertEquals(BPName, ROLE);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(10);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);

    }
    public void verifyingIconsInRolesEditConfigWindow() {
        safeType(TEXTBOX_TYPESEARCH, ROLE + "\n", "Alert Name into type search");
        System.out.println("entered dbtext");
        waitForSecs(9);
        mouseHoverJScript(LISTOFDBS, "Databse Name", "Mouse hover", MEDIUMWAIT);
        safeClick(LISTOFDBS, " Searched DatabaseName ", MEDIUMWAIT);
        waitForSecs(9);
        safeClick(DELETE_ALERT, "Delete Slas", MEDIUMWAIT);
        waitForSecs(20);
        safeClick(CONFIRM_DELETE, "Confirm delete", MEDIUMWAIT);
        waitForSecs(15);


    }
}
