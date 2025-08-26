package Selenium_Automate.Selenium_Project;


import org.testng.annotations.Test;

import BASE.base;
import PAGES.ProductPage;

/**
 * Unit test for simple App.
 */
public class AppTest extends base {

    
	ProductPage pp = new ProductPage();
	
    @Test(priority = 1)
    public void searchProduct() {
    	pp.searchPage();
        
    }
    
    @Test(priority = 2)
    public void buyProduct() throws InterruptedException {
    	pp.searchPage();
    	pp.buyPage();
    }
}
