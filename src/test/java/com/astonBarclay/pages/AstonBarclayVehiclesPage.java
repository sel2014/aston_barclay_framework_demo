package com.astonBarclay.pages;

import com.astonBarclay.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AstonBarclayVehiclesPage {

    public AstonBarclayVehiclesPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".form-control.form-control")
    public WebElement searchBox;

    @FindBy(id = "button-addon2")
    public WebElement searchButton;



}
