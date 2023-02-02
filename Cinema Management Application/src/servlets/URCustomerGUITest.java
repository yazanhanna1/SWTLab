package servlets;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * This class performs a system test on the GuestGUI using JWebUnit.
 * 
 * @author swe.uni-due.de
 *
 */
public class URCustomerGUITest {

	private WebTester tester;

	/**
	 * Create a new WebTester object that performs the test.
	 */
	@Before
	public void prepare() {
		tester = new WebTester();
		tester.setBaseUrl("http://localhost:8080/Cinema%20Management%20Application/");
	}

	@Test
	public void testBrowseHolidayOffers() {
		// Start testing for registeredCustomerGUI
		tester.beginAt("urcustomergui");

		// Check all components of the search form
		tester.assertTitleEquals("Cinema Management Application - RegisterAccount");
		tester.assertFormPresent();
		tester.assertTextPresent("Required Information");
		tester.assertTextPresent("Email");
		tester.assertFormElementPresent("email");
		tester.assertTextPresent("Password");
		tester.assertFormElementPresent("password");
		tester.assertButtonPresent("RegisterWebpage");

		tester.setTextField("email", "test@test.com");
		tester.setTextField("password", "test123");
		
		tester.clickButton("RegisterWebpage");

		//tester.assertTextPresent("New Account successfuly stored in the database.");
	}

}
