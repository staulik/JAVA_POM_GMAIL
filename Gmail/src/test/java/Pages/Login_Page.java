package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

    WebDriver driver;


    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Using findby to find the elements
    @FindBy(how = How.NAME, using = "identifier")
    WebElement txtmail;
    @FindBy(how = How.CLASS_NAME, using = "CwaK9")
    WebElement btnproximo;
    @FindBy(how = How.NAME, using = "password")
    WebElement txtsenha;
    @FindBy(how = How.ID, using = "passwordNext")
    WebElement btnentrar;

    // Objects from EmailBox
    @FindBy(how = How.XPATH, using = "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/span")
    WebElement btnnomeusua;
    @FindBy(how = How.XPATH, using = "//*[@id=\"gb\"]/div[2]/div[4]/div[1]/div[2]/div[1]")
    WebElement nomeusua;
    @FindBy(how = How.ID, using = "gb_71")
    WebElement btnsair;


    //This method wait for txtmail and fill e-mail
    public void Wait_and_Fill_txtemail(String strEmail) {
        int timeout = 10;
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(txtmail));
        txtmail.sendKeys(strEmail);
    }

    // This method wait for txtmail and fill password
    public void Wait_and_Fill_txtSenha(String strPassword) {
        int timeout = 10;
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(txtsenha));
        txtsenha.sendKeys(strPassword);
    }

    // This method wait for object on Screen
    public void waitForbtnProximo() {
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(btnproximo));
    }

    //This method is to click on nextbutton
    public void ClickOnNextButton() {
        btnproximo.click();
    }

    // This method wait for object on Screen
    public void waitForEnterButton() {
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(btnentrar));
    }

    //This method is to click on Login Button
    public void ClickOnEnterButton() {
        btnentrar.click();
    }

    public void CapturaNome(String nomeesperado) {
        String nomeAtual = nomeusua.getText();
        String nomeusa = nomeesperado;
        Assert.assertTrue(nomeAtual.contains(nomeesperado));
    }


    public void VerPerfilUsua() {
        btnnomeusua.click();
    }

    // This method wait for object on Screen
    public void waitForSairButton() {
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(btnsair));
    }

    public void Logoff() { btnsair.click();
    }
}