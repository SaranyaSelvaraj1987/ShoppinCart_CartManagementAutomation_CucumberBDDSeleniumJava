package org.cartManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class pages {
    private WebDriver driver;

    //By locators
    //searchBox element
   // private By searchBox = By.className("search-keyword");
   //List of product Element
    private By prodList = By.xpath("//div[@class='product']/h4[@class='product-name']");
    //List of AddToCart Element
    private By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
    //To view the item in the cart
	private By viewCart = By.xpath("//img[@alt='Cart']");
    //Cart element for added item Carrot
    private By itemAddedCarrot = By.xpath("//p[contains(text(),'Carrot')]");
   private By itemAddedBeetroot = By.xpath("//p[contains(text(),'Beetroot')]");
    private WebElement itemAddedToCart;

    //Constructor
    public pages(WebDriver driver)
    {
        this.driver = driver;
    }
    //Pages Methods
    /*public void browseAnItem(String item)
    {
        WebElement toBrowseAnItem = driver.findElement(searchBox);
        toBrowseAnItem.sendKeys(item);
    }*/

    //Method to addItem to the Cart
    public void addToCart(String item)
    {

        List<WebElement> itemList = driver.findElements(prodList);
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).getText().contains(item))
            {
                //Just to view the selected product while debugging
                String selected = itemList.get(i).getText();
                List<WebElement> addItemToCartList = driver.findElements(addToCart);
                addItemToCartList.get(i).click();
                break;
            }
        }
    }
  //Method to view the cart
  public void viewCart(String item)
  {
    WebElement viewCartItem = driver.findElement(viewCart);
    viewCartItem.click();

  }
  public void itemAdded(String item)
  {
      if(item.equals("Carrot")) {
           itemAddedToCart = driver.findElement(itemAddedCarrot);}
      else if (item.equals("Beetroot"))
          {
              itemAddedToCart = driver.findElement(itemAddedBeetroot);
          }

      String itemAdded1 = itemAddedToCart.getText();
      String[] splittedItem = itemAdded1.split(" - ");
      String itemName = splittedItem[0];
      Assert.assertEquals(itemName,item);
  }
}