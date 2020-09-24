package sectionals.livingRoom.Furniture.WayFair;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sectionals.livingRoom.Furniture.WayFair.pages.SectionalFurnitureDetailsPage;
import sectionals.livingRoom.Furniture.WayFair.pages.HomePage;
import sectionals.livingRoom.Furniture.WayFair.pages.SectionalsFurniturePage;

public class SectionalsFurnitureTest extends TestUtilities {

    @Test
    @Parameters("selectNthFurniture")
    public void purchaseSectionalFurniture(String selectNth){

        HomePage homePage= new HomePage(driver,log);

        //Open Page url
        homePage.openPage();
        //Navigate to Furniture link via home page:
        homePage.navigateToFurnitureTab();
        SectionalsFurniturePage sectionalsFurniturePage= homePage.clickOnSectionals();

        //Select the 12th furniture
        sectionalsFurniturePage.selectSectionalFurniture(selectNth);

        //Fetch the description of the 12th furniture
        String sectionalFurnitureDescription= sectionalsFurniturePage.getSectionalsDescription(selectNth);

        //Fetching and printing the rating of the 12th Furniture
        String rating = sectionalsFurniturePage.getRatingOfSectionals(selectNth);
        log.info("Rating of the" + selectNth +" sectional furniture is"+rating );

        // Click on the 12th Furniture
        SectionalFurnitureDetailsPage sectionalFurnitureDetailsPage= sectionalsFurniturePage.addSectionalFurnitureToCart(selectNth);
        sectionalFurnitureDetailsPage.switchToWindow();

        //Assert whether the selected sectional furniture title matches as that of the title on the Details page
        String sectionalFurnitureDescriptionDetails=sectionalFurnitureDetailsPage.getSectionalFurnitureDescriptionDetails();
        Assert.assertEquals(sectionalFurnitureDescription,sectionalFurnitureDescriptionDetails,"Fail- The titles of the selected furniture doesn't match!");

        //Printing price of the furniture
        String priceOfSectional=sectionalFurnitureDetailsPage.getPriceOfSectionals();
        log.info("Price of the" + selectNth +" sectional furniture is"+priceOfSectional );

        //Selected furniture is added to card
        sectionalFurnitureDetailsPage.addToCart();
        //Assert to verify whether continue to cart button is enabled
        Assert.assertTrue(sectionalFurnitureDetailsPage.verifySectionalAddedToCart(),"Fail- user was not able to proceed to Cart!");

    }
}
