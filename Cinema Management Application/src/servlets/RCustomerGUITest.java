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
public class RCustomerGUITest {

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
		tester.beginAt("rcustomergui");

		// Check all components of the search form
		tester.assertTitleEquals("Cinema Management Application - Browse Performances");
		tester.assertFormPresent();
		tester.assertButtonPresent("DisplayPerformance");

		tester.clickButton("DisplayPerformance");

		// Check the representation of the table for an empty result
		tester.assertTablePresent("availablePs");
		String[][] tableHeadings = { { "#", "Title", "Duration","Time", "Available Seats","Book Now!" } };
		tester.assertTableEquals("availablePs", tableHeadings);
	}

}

