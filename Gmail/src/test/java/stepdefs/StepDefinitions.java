package stepdefs;

import Pages.Login_Page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

           WebDriver driver;
           Login_Page login;

    private Login_Page getLoginPage() {
        if (login == null) {
            login = PageFactory.initElements(driver, Login_Page.class);
        }

        return login;
    }

      @Dado("^que que estou na pagina principal do Gmail\\.$")
    public void que_que_estou_na_pagina_principal_do_Gmail () throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Quando("^forneco as credenciais validas\\.$")
    public void forneco_as_credenciais_validas () throws Exception {
        Login_Page Login = PageFactory.initElements(driver, Login_Page.class);
        Login.Wait_and_Fill_txtemail("testingqab3@gmail.com");
        Login.waitForbtnProximo();
        Login.ClickOnNextButton();
        Login.Wait_and_Fill_txtSenha("automation10");
        Login.waitForEnterButton();
        Login.ClickOnEnterButton();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Entao("^posso ver que estou logado\\.$")
    public void posso_ver_que_estou_logado () throws Exception {
        Login_Page Login = PageFactory.initElements(driver, Login_Page.class);
        Login.VerPerfilUsua();
        Login.CapturaNome("Tadeu Silvio");
        Login.Logoff();
    }
}
