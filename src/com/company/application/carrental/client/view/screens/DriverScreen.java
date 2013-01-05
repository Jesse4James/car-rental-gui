package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.model.vo.DriverMasterClientDto;
import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.dnd.core.client.ListViewDragSource;
import com.sencha.gxt.dnd.core.client.ListViewDropTarget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.ListView;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DriverScreen extends Composite {

    private static final String FINANCIAL_REG_CHECK = "Have you ever been suspended, expelled or otherwise disciplined or penalised by any financial regulatory body or by any financial self regulatory organisation, exchange or association, or been denied membership therein, or ever withdrawn your application to such membership?";
    private static final String EMPLOYMENT_GAP_CHECK = "Have you ever had a gap in your employment history of 6 months or greater?";
    private static final String TRAFFIC_VIOLATION_CHECK = "Have you ever been convicted or pleaded guilty to a crime of any kind other then minor traffic violation? Minor traffic violation - Include Parking tickets and other non moving violations in addition to traffic and similar moving violations. Driving while Intoxicated is not minor violation";
    private DriverScreenMediator mediator;

    private ToolButton saveButton;

    private TextField applicationNoTextField;
    private DateField applicationDateField;
    private TextField applicationStatusTextField;
    private TextArea applicationRemarksTextField;
    private TextField userTextField;

    private TextField fullNameTextField;
    private TextField primaryContactTextField;
    private TextField currentAreaTextField;
    private TextField genderTextField;
    private DateField dobDateField;

    private TextField licenseNoTextField;
    private ComboBox licenseTypeCombo;
    private DateField licenseExpiryDateField;

    public DriverScreen(DriverScreenMediator mediator) {
        setMediator(mediator);

        buildUI();
    }

    private void buildUI() {
        FormPanel basicFormPanel = buildBasicTab();
        VerticalLayoutContainer basicContainer = new VerticalLayoutContainer();
        basicContainer.setScrollMode(ScrollMode.AUTO);
        basicContainer.add(basicFormPanel);

        FormPanel advancedFormPanel = buildAdvancedTab();
        VerticalLayoutContainer advancedContainer = new VerticalLayoutContainer();
        advancedContainer.setScrollMode(ScrollMode.ALWAYS);
        advancedContainer.add(advancedFormPanel);

        TabPanel tabPanel = new TabPanel();
        tabPanel.add(basicContainer, new TabItemConfig("Application"));
        tabPanel.add(advancedContainer, new TabItemConfig("Background Check"));

        initWidget(tabPanel);
    }

    private FormPanel buildBasicTab() {
        FormPanel formPanel = new FormPanel();

        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setHeight("700");
        verticalPanel.setSpacing(2);

        ButtonBar buttonBar = new ButtonBar();
        saveButton = new ToolButton(ToolButton.SAVE);

        saveButton.addSelectHandler(new SelectHandler() {
            public void onSelect(SelectEvent event) {
                DriverMasterClientDto masterClientDto = new DriverMasterClientDto();
                masterClientDto.setApplicationNo(applicationNoTextField.getCurrentValue());
                masterClientDto.setApplicationDate(applicationDateField.getCurrentValue());
                masterClientDto.setApplicationStatusName(applicationStatusTextField.getCurrentValue());
                masterClientDto.setApplicationRemarks(applicationRemarksTextField.getCurrentValue());
                masterClientDto.setUserName(userTextField.getCurrentValue());

                masterClientDto.setDriverFullName(fullNameTextField.getCurrentValue());
                masterClientDto.setPrimaryContactNumber(primaryContactTextField.getCurrentValue());
                // masterClientDto.setCurrentAreaId(currentAreaTextField.getCurrentValue());
                // masterClientDto.setGender(genderTextField.getCurrentValue());
                masterClientDto.setDob(dobDateField.getCurrentValue());

                masterClientDto.setLicenceNo(licenseNoTextField.getCurrentValue());
                masterClientDto.setLicenceType((String) licenseTypeCombo.getCurrentValue());
                masterClientDto.setLicenceExpiryDate(licenseExpiryDateField.getCurrentValue());

                mediator.saveDriverApplication(masterClientDto);
            }
        });

        buttonBar.add(saveButton);
        buttonBar.add(new ToolButton(ToolButton.REFRESH));
        verticalPanel.add(buttonBar);

        applicationNoTextField = new TextField();
        applicationDateField = new DateField();
        applicationStatusTextField = new TextField();
        applicationRemarksTextField = new TextArea();
        userTextField = new TextField();

        HorizontalPanel appPanel = new HorizontalPanel();
        appPanel.add(createTopFieldLabel(applicationNoTextField, "Application No"));
        appPanel.add(createTopFieldLabel(applicationDateField, "Application Date"));
        appPanel.add(createTopFieldLabel(applicationStatusTextField, "Application Status"));
        appPanel.add(createTopFieldLabel(applicationRemarksTextField, "Application Remarks"));
        appPanel.add(createTopFieldLabel(userTextField, "User"));

        FieldSet appFieldSet = new FieldSet();
        appFieldSet.setHeadingText("Application");
        appFieldSet.setCollapsible(true);
        appFieldSet.setWidth(850);
        appFieldSet.add(appPanel);

        verticalPanel.add(appFieldSet);

        fullNameTextField = new TextField();
        primaryContactTextField = new TextField();
        currentAreaTextField = new TextField();
        genderTextField = new TextField();
        dobDateField = new DateField();

        appPanel = new HorizontalPanel();
        appPanel.setSpacing(10);
        appPanel.add(createTopFieldLabel(fullNameTextField, "Full Name"));
        appPanel.add(createTopFieldLabel(primaryContactTextField, "Primary Contact"));
        appPanel.add(createTopFieldLabel(currentAreaTextField, "Current Area"));
        // verticalPanel.add(appPanel);
        //
        // appPanel = new HorizontalPanel();
        // appPanel.setSpacing(5);
        appPanel.add(createTopFieldLabel(genderTextField, "Gender"));
        appPanel.add(createTopFieldLabel(dobDateField, "DOB"));

        FieldSet basicFieldSet = new FieldSet();
        basicFieldSet.setHeadingText("Basic Details");
        basicFieldSet.setCollapsible(true);
        basicFieldSet.setWidth(1000);
        basicFieldSet.add(appPanel);

        verticalPanel.add(basicFieldSet);

        licenseNoTextField = new TextField();

        LicenseTypeProperties licenseTypeProperties = GWT.create(LicenseTypeProperties.class);
        ListStore store = new ListStore(licenseTypeProperties.value());
        store.add(new CarType("LMV", "LMV"));
        store.add(new CarType("HMV", "HMV"));
        licenseTypeCombo = new ComboBox(store, licenseTypeProperties.name());

        licenseExpiryDateField = new DateField();

        appPanel = new HorizontalPanel();
        appPanel.setSpacing(5);
        appPanel.add(createTopFieldLabel(licenseNoTextField, "License No"));
        appPanel.add(createTopFieldLabel(licenseTypeCombo, "License Type"));
        appPanel.add(createTopFieldLabel(licenseExpiryDateField, "License Expiry Date"));

        FieldSet licenseFieldSet = new FieldSet();
        licenseFieldSet.setHeadingText("License");
        // licenseFieldSet.setCollapsible(true);
        licenseFieldSet.setWidth(550);
        licenseFieldSet.setHeight(100);
        licenseFieldSet.add(appPanel);

        HorizontalPanel parentPanel = new HorizontalPanel();
        parentPanel.setSpacing(5);
        parentPanel.add(licenseFieldSet);

        HorizontalPanel jobPrefPanel = new HorizontalPanel();

        FieldSet indiFieldSet = new FieldSet();
        indiFieldSet.setHeadingText("Individual");
        indiFieldSet.add(buildJobPrefPanel());
        jobPrefPanel.add(indiFieldSet);

        FieldSet companyFieldSet = new FieldSet();
        companyFieldSet.setHeadingText("Company");
        companyFieldSet.add(buildJobPrefPanel());
        jobPrefPanel.add(companyFieldSet);

        FieldSet jobPrefFieldSet = new FieldSet();
        jobPrefFieldSet.setHeadingText("Job Preference");
        // jobPrefFieldSet.setCollapsible(true);
        jobPrefFieldSet.setWidth(600);
        jobPrefFieldSet.setHeight(100);
        jobPrefFieldSet.add(jobPrefPanel);

        parentPanel.add(jobPrefFieldSet);
        verticalPanel.add(parentPanel);

        TextField totalExpTextField = new TextField();
        TextField curSalTextField = new TextField();
        TextField expSalTextField = new TextField();

        appPanel = new HorizontalPanel();
        appPanel.setSpacing(5);
        appPanel.add(createTopFieldLabel(totalExpTextField, "Total Exp"));
        appPanel.add(createTopFieldLabel(curSalTextField, "Current Salary"));
        appPanel.add(createTopFieldLabel(expSalTextField, "Expected Salary"));
        // verticalPanel.add(appPanel);

        TextArea medicalHistoryTextArea = new TextArea();
        TextArea eyeSightTextArea = new TextArea();
        TextArea diabetesTextArea = new TextArea();
        TextArea accidentHistoryTextArea = new TextArea();

        // appPanel = new HorizontalPanel();
        // appPanel.setSpacing(5);
        appPanel.add(createTopFieldLabel(medicalHistoryTextArea, "Medical History"));
        appPanel.add(createTopFieldLabel(eyeSightTextArea, "Eye Sight"));
        appPanel.add(createTopFieldLabel(diabetesTextArea, "Diabetes"));
        appPanel.add(createTopFieldLabel(accidentHistoryTextArea, "Accident History"));
        verticalPanel.add(appPanel);

        TextField driverRefNameTextField = new TextField();
        TextField driverRefNoTextField = new TextField();

        HorizontalLayoutContainer driverReferencePanel = new HorizontalLayoutContainer();
        Margins margins = new Margins(0, 5, 0, 0);
        HorizontalLayoutData horizontalLayoutData = new HorizontalLayoutData(200, 100, margins);
        driverReferencePanel.add(createTopFieldLabel(driverRefNameTextField, "Driver Reference Name"), horizontalLayoutData);
        driverReferencePanel.add(createTopFieldLabel(driverRefNoTextField, "Driver Reference Number"), horizontalLayoutData);

        FieldSet driverReferenceFieldSet = new FieldSet();
        driverReferenceFieldSet.setSize("450", "80");
        driverReferenceFieldSet.setHeadingText("Driver Reference");
        driverReferenceFieldSet.setCollapsible(true);
        driverReferenceFieldSet.add(driverReferencePanel);

        parentPanel = new HorizontalPanel();
        parentPanel.setSpacing(5);
        parentPanel.add(buildCarType());
        parentPanel.add(driverReferenceFieldSet);

        verticalPanel.add(parentPanel);

        formPanel.add(verticalPanel);
        return formPanel;
    }

    private FormPanel buildAdvancedTab() {
        FormPanel formPanel = new FormPanel();

        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setHeight("700");
        verticalPanel.setSpacing(2);

        TextField identCodeTextField = new TextField();
        TextField maritalStatusTextField = new TextField();
        TextField passportNoTextField = new TextField();
        TextField panNoTextField = new TextField();

        HorizontalLayoutContainer bgCheckPanel = new HorizontalLayoutContainer();
        Margins margins = new Margins(0, 5, 0, 0);
        HorizontalLayoutData horizontalLayoutData = new HorizontalLayoutData(100, 100, margins);
        bgCheckPanel.add(createTopFieldLabel(identCodeTextField, "Identification Code"), new HorizontalLayoutData(150, 100, margins));
        bgCheckPanel.add(createTopFieldLabel(maritalStatusTextField, "Marital Status"), horizontalLayoutData);
        bgCheckPanel.add(createTopFieldLabel(passportNoTextField, "Passport No."), horizontalLayoutData);
        bgCheckPanel.add(createTopFieldLabel(panNoTextField, "PAN No."), horizontalLayoutData);

        FieldSet bgCheckFieldSet = new FieldSet();
        bgCheckFieldSet.setSize("500", "80");
        bgCheckFieldSet.setHeadingText("Background Check");
        bgCheckFieldSet.setCollapsible(true);
        bgCheckFieldSet.add(bgCheckPanel);

        CheckBox trafficViolationCheckBox = new CheckBox();
        trafficViolationCheckBox.setToolTip(TRAFFIC_VIOLATION_CHECK);
        CheckBox empGapCheckBox = new CheckBox();
        empGapCheckBox.setToolTip(EMPLOYMENT_GAP_CHECK);
        CheckBox finRegCheckBox = new CheckBox();
        finRegCheckBox.setToolTip(FINANCIAL_REG_CHECK);

        HorizontalLayoutContainer refCheckPanel = new HorizontalLayoutContainer();
        refCheckPanel.add(createTopFieldLabel(trafficViolationCheckBox, "Traffic Violation"), horizontalLayoutData);
        refCheckPanel.add(createTopFieldLabel(empGapCheckBox, "Employment Gap"), horizontalLayoutData);
        refCheckPanel.add(createTopFieldLabel(finRegCheckBox, "Financial Regulatory Check"), new HorizontalLayoutData(200, 100, margins));

        FieldSet refCheckFieldSet = new FieldSet();
        refCheckFieldSet.setSize("400", "80");
        refCheckFieldSet.setHeadingText("Reference Check");
        refCheckFieldSet.setCollapsible(true);
        refCheckFieldSet.add(refCheckPanel);

        // TextField ratingTextField = new TextField();
        // ratingTextField.setWidth(15);
        // ratingTextField.setHeight(10);

        Slider ratingSlider = new Slider();
        ratingSlider.setMinValue(1);
        ratingSlider.setMaxValue(5);
        ratingSlider.setIncrement(1);

        HorizontalLayoutContainer driverRatingPanel = new HorizontalLayoutContainer();
        driverRatingPanel.add(createTopFieldLabel(ratingSlider, "1-5"), horizontalLayoutData);
        // driverRatingPanel.add(ratingTextField, new HorizontalLayoutData(20, 10, new Margins(15, 5, 0, 5)));

        FieldSet driverRatingFieldSet = new FieldSet();
        driverRatingFieldSet.setSize("400", "80");
        driverRatingFieldSet.setHeadingText("Driver Rating");
        driverRatingFieldSet.setCollapsible(true);
        driverRatingFieldSet.add(driverRatingPanel);

        HorizontalPanel topPanel = new HorizontalPanel();
        topPanel.add(bgCheckFieldSet);
        topPanel.add(refCheckFieldSet);
        topPanel.add(driverRatingFieldSet);

        verticalPanel.add(topPanel);

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.setSpacing(5);
        horizontalPanel.add(new DriverContactControl().asWidget());
        horizontalPanel.add(new DriverAddressControl().asWidget());
        horizontalPanel.add(new DriverEducationControl().asWidget());
        verticalPanel.add(horizontalPanel);

        horizontalPanel = new HorizontalPanel();
        horizontalPanel.setSpacing(5);
        horizontalPanel.add(new DriverEmploymentControl().asWidget());
        verticalPanel.add(horizontalPanel);

        formPanel.add(verticalPanel);

        return formPanel;
    }

    private FieldLabel createTopFieldLabel(Widget widget, String label) {
        FieldLabel fieldLabel = new FieldLabel(widget, label);
        fieldLabel.setLabelAlign(LabelAlign.TOP);

        return fieldLabel;
    }

    private HorizontalPanel buildJobPrefPanel() {
        CheckBox temporaryCheckBox = new CheckBox();
        temporaryCheckBox.setBoxLabel("Temporary");

        CheckBox permanentCheckBox = new CheckBox();
        permanentCheckBox.setBoxLabel("Permanent");

        CheckBox adhocCheckBox = new CheckBox();
        adhocCheckBox.setBoxLabel("Adhoc");

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(temporaryCheckBox);
        horizontalPanel.add(permanentCheckBox);
        horizontalPanel.add(adhocCheckBox);
        return horizontalPanel;
    }

    public DriverScreenMediator getMediator() {
        return mediator;
    }

    private void setMediator(DriverScreenMediator mediator) {
        this.mediator = mediator;
    }

    public Widget buildCarType() {
        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingText("Car Type");
        fieldSet.setPixelSize(200, 100);
        fieldSet.setCollapsible(true);

        HorizontalLayoutContainer con = new HorizontalLayoutContainer();

        CarTypeProperties props = GWT.create(CarTypeProperties.class);
        ListStore<CarType> store = new ListStore<CarType>(props.value());
        // store.addSortInfo(new StoreSortInfo<CarType>(props.nameProp(), SortDir.ASC));
        store.add(new CarType("Car", "Car"));
        store.add(new CarType("Bus", "Bus"));
        ListView list1 = new ListView(store, props.name());

        store = new ListStore<CarType>(props.value());
        // store.addSortInfo(new StoreSortInfo<CarType>(props.name(), SortDir.ASC));

        ListView<CarType, String> list2 = new ListView<CarType, String>(store, props.name());
        list2.getSelectionModel().setSelectionMode(SelectionMode.MULTI);

        new ListViewDragSource<CarType>(list1);
        new ListViewDragSource<CarType>(list2);

        new ListViewDropTarget<CarType>(list1);
        new ListViewDropTarget<CarType>(list2);

        con.add(list1, new HorizontalLayoutData(.5, .8, new Margins(5)));
        con.add(list2, new HorizontalLayoutData(.5, .8, new Margins(5, 5, 5, 0)));

        fieldSet.add(con);

        return fieldSet;
    }

    interface LicenseTypeProperties extends PropertyAccess<LicenseType> {

        ModelKeyProvider<LicenseType> value();

        LabelProvider<LicenseType> name();
    }

    class LicenseType {

        private String name;
        private String value;

        public LicenseType() {
            super();
            // TODO Auto-generated constructor stub
        }

        public LicenseType(String name, String value) {
            super();
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    interface CarTypeProperties extends PropertyAccess<CarType> {

        ModelKeyProvider<CarType> value();

        ValueProvider<CarType, String> name();
    }

    static class CarType {

        private String name;
        private String value;

        public CarType() {
            super();
            // TODO Auto-generated constructor stub
        }

        public CarType(String name, String value) {
            super();
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}