package com.page.locators;

import org.openqa.selenium.By;

public interface CorrelationLocators {
    By BTN_ANALYTICS = By.xpath("//span[text()='Analytics']");
    By BTN_CORRELATION = By.xpath("//span[text()='Correlation']");
    By BTN_ADDICON_CORRELATION = By.xpath("//h5[text()='Correlation Scenarios']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/label[@id='name-label']");
    By TXTBOX_NAME = By.xpath("//div[contains(@class,'WizardStep')]/div/div/div/div/div/input[@id='name']");
    By TXTBOX_NAME_GENERATOR = By.cssSelector("textarea.inputarea");
    By LABEL_RETENSION = By.xpath("//label[@id='retention-label']");
    By TXTBOX_RETENSION = By.xpath("//div[contains(@class,'WizardStep')]/div/div[5]/div/div/div/input[@id='retention']");
    By LABEL_TYPE = By.xpath("//span[text()='Type']");
    By TYPE_GHOSTEXT = By.xpath("//input[@id='factClass']/../../../div[1]");
    By TXTBOX_TYPE= By.xpath("//input[@id='factClass']");
    By LABEL_KPIS = By.xpath("//input[@id='kpis']/../../../div[1]/../../../../label/p/span[1]");
    By KPIS_GHOSTEXT = By.xpath("//input[@id='kpis']/../../../div[1]");
    By TXTBOX_KPIS = By.xpath("//input[@id='kpis']");
    By BTN_NEXT = By.xpath("//span[text()='Next']");
    By LABEL_KEYEXP = By.xpath("//span[text()='Key Expression']");
    By KEYEXP_GHOSTEXT = By.xpath("//input[@id='keyExpression']/../../../div[1]");
    By TXTBOX_KEYEXP = By.xpath("//input[@id='keyExpression']");
    By LABEL_FIELD_EXCLUSIONS = By.xpath("//span[text()='Field Exclusions']");
    By FIELD_EXCLUSIONS_GHOSTEXT = By.xpath("//input[@id='fieldExclusions']/../../../div[1]");
    By TXTBOX_FIELD_EXCLUSIONS = By.xpath("//input[@id='fieldExclusions']");
    By LABEL_MASK = By.xpath("//label[@id='mask-label']");
    By TXTBOX_MASK = By.xpath("//input[@id='mask']");
    By BTN_SLAADDICON = By.xpath("//span[text()='Filters']/..//../../button[@aria-label='Add']");
    By Filter_GHOSTEXT = By.xpath("//span[text()='Filters']/../../../../../div[4]/div/div/div/div/div/div/div/div/div/div[text()='Select...']");
    By TXTBOX_FILTESR_VALUE = By.xpath("//button[@aria-label='Delete']/preceding-sibling::i/following-sibling::div/input");
    By TXTBOX_FILTERS = By.xpath("//input[@id='filters_key_0']");
    By TEXTBOX_TYPESEARCH = By.xpath("//input[@placeholder='Type or select below']");
    By LISTOFDBS = By.xpath("//div[@title='Select Row']/following-sibling::div[2]/span/span");
    By HEADER_DB = By.xpath("//div[@aria-label='Save Configuration']/../../h5/mark");
    By BTN_SAVE = By.xpath("//div[@aria-label='Save Configuration']");
    By BTN_CLEAR = By.xpath("//span[text()='Clear']");
    By BTN_FINISH = By.xpath("//span[text()='Finish']");
    By DROPDOWN_SERVER = By.xpath("//div[contains(@class,'MuiListItem-button')]");
    By BTN_CLOSE = By.xpath("//span[text()='Close']");
    By ADDED_NAME_GENERATOR = By.xpath("//div[@class='view-lines']/div/span/span");
    By TXTBOX_EDITED_KPIS = By.xpath("//input[@id='kpis']/../../../div/span");
    By LABEL_EDITED_FACTTYPE = By.xpath("//span[text()='Fact Type']");
    By TXTBOX_EDITED_FACTTYPE = By.xpath("//input[@id='factClass']/../../../div[1]");
    By HYPERLINK_TYPES = By.xpath("//span[text()='Types']/../../../div/div/div/button");
    By TXTBOX_EDITED_RETENTION = By.xpath("//input[@id='retention']");
    By TXTBOX_EDITED_NAME = By.xpath("//input[@id='name']");//Edited
    By BTN_REMOVETYPES= By.xpath("//span[text()='Types']/../../../div/div/div/div[@aria-label='Remove Configuration']");
    By TYPES_ADDICON = By.xpath("//span[text()='Types']/../../following-sibling::div/button/span/i");
    By FILTERS_GHOSTTEXT_IN_TYPES = By.xpath("//span[text()='Filters']/../../../../../div[4]/div/div/div/div/div/div/div/div/div/div[text()='Select or Create...']");
    //Stream correlation locators
    By BTN_ADDICON_STREAM_CORRELATION = By.xpath("//h5[text()='Stream Correlation Scenarios']/../div/div/button/span/i[@aria-label='Add New Configuration']");
    By LABEL_TIME_TO_LIVE = By.xpath("//span[text()='Time To Live']");
    By TXT_BOX_TIME_TO_LIVE = By.xpath("//input[@id='timeToLive']");
    By EDITED_KPIS_GHSOTTXET = By.xpath("//input[@id='leftStream.kpis']/../../../div[1]");
    By LABEL_STREAM_KPIS = By.xpath("//span[text()='Time To Live']/../../../../../following-sibling::div/div/div/div/div/label/p/span[text()='Kpis']");
    By GHOSTTEXT_KPIS_STREAM = By.xpath("//span[text()='Time To Live']/../../../../../following-sibling::div/div/div/div/div/div/div/div/div[text()='Select or Add...']");
    By DROPDOWN_KPIS_STREAM = By.xpath("//span[text()='Time To Live']/../../../../../following-sibling::div/div/div/div/div/div/div/div/div/div/input[@id='kpis']");
    By LABEL_PARTITION_KEY = By.xpath("//span[text()='Partition Key']");
    By GHOSTTEXT_PARTITION_KEY = By.xpath("//input[@id='partitionKey']/../../../div[1]");
    By DROPDOWN_PARTITION_KEY = By.xpath("//input[@id='partitionKey']/../../../div[1]");
    By GHOSTTEXT_ORDER_BY = By.xpath("//input[@id='orderBy']/../../../div[1]");
    By LABEL_ORDER_BY = By.xpath("//span[text()='Order By']");
    By DROPDOWN_ORDER_BY = By.xpath("//input[@id='orderBy']");
    By LABEL_TIME_TO_LIVE_IN_SECONDS = By.xpath("//span[text()='Time To Live (in seconds)']");
    By TEXT_AREA_COST_FUNCTION = By.xpath("//span[text()='Cost Function']/../../../div/section/div/div/div/textarea");
    By TEXT_AREA_PAIR_FUNCTION = By.xpath("//span[text()='Pair Function']/../../../div/section/div/div/div/textarea");
    By LABEL_RSTREAM_KPIS = By.xpath("//span[text()='Time To Live (in seconds)']/../../../../../following-sibling::div/div/div/div/div/label/p/span[text()='Kpis']");
    By GHOSTTEXT_KPIS_RSTREAM = By.xpath("//span[text()='Time To Live (in seconds)']/../../../../../following-sibling::div/div/div/div/div/div/div/div/div[text()='Select or Add...']");
    By DROPDOWN_KPIS_RSTREAM = By.xpath("//span[text()='Time To Live (in seconds)']/../../../../../following-sibling::div/div/div/div/div/div/div/div/div/div/input[@id='kpis']");
    By RSTREAM_KPIS_VALUE = By.xpath("//span[text()='Time To Live (in seconds)']/../../../../../following-sibling::div/div/div/div/div/div/div/div/div/span");
    By CLOSE_EDITWINDOW = By.xpath("//div[@aria-label='Close Editor']");

    By EDITED_LSTREAM_NAME_TXTBOX = By.xpath("//input[@id='leftStream.name']");
    By EDITED_LSTREAM_TIMETOLIVE_TXTBOX = By.xpath("//input[@id='leftStream.timeToLive']");
    By EDITED_LSTREAM_PARTITION_KEY = By.xpath("//input[@id='leftStream.partitionKey']");
    By EDITED_LSTREAM_ORDER_BY = By.xpath("//input[@id='leftStream.orderBy']");
    By EDITED_LSTREAM_KPIS = By.xpath("//input[@id='leftStream.kpis']");
    By CLOSINGADDED_KPIS = By.xpath("//span[text()='0 KPI Threshold']/following-sibling::i");
    By EDITED_RSTREAM_NAME_TXTBOX = By.xpath("//input[@id='rightStream.name']");
    By EDITED_RSTREAM_TIMETOLIVE_TXTBOX = By.xpath("//input[@id='rightStream.timeToLive']");
    By EDITED_RSTREAM_PARTITION_KEY = By.xpath("//label[@for='rightStream.partitionKey']/following-sibling::div/div/div[1]/div[1]");
    By EDITED_RSTREAM_ORDER_BY = By.xpath("//label[@for='rightStream.orderBy']/following-sibling::div/div/div[1]/div[1]");
    By EDITED_RSTREAM_KPIS = By.xpath("//input[@id='rightStream.kpis']");
    By EDITED_COST_FUNCTION = By.xpath("//span[text()='Cost Function']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By EDITED_PAIR_FUNCTION = By.xpath("//span[text()='Pair Function']/../../../div/section/div/div/div/div[2]/div/div[4]/div/span/span");
    By EDITED_NAME_LABEl = By.xpath("//span[text()='Name']");
    By EDITED_LSTREAM_LABEL =By.xpath("//span[text()='Left Stream Name']");
    By EDITED_LSTREAM_PARTITION_LABEL = By.xpath("//span[text()='Left Stream Partition Key']");
    By EDITED_LSTREAM_ORDER_LABEL = By.xpath("//span[text()='Left Stream OrderBy']");
    By EDITED_LSTREAM_KPIS_LABEL = By.xpath("//span[text()='Left Stream KPIs']");




}
