//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Shopping Cart 
// Course: Spring 2022 CS 300 
//
// Author: Sreya Sarathy 
// Email: sarathy2@wisc.edu
// Lecturer: Professor Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

public class ShoppingCartTester {
	/**
	 * In this particular class, the tester methods are checked to see if they are
	 * correct and if they are present in the ShoppingCart class
	 *
	 * @author Sreya Sarathy
	 *
	 * @return if the program works then true is returned, if not then false.
	 */

	public static boolean testLookupMethods() {
		
		// the test scenarios are defined. 
		
		// The item at the first index of marketItems array is to be found over here 

		String expectedOutput = "4046 Avocado $0.59";

		if (!ShoppingCart.lookupProductByName("Avocado").equals(expectedOutput)) {

			System.out.println("Problem detected: Your lookupProductByName() method "

					+ "failed to return the expected output when passed Avocado as input");

			return false;

		}
		
		// The item at the first index of marketItems array is found here 
		
		if (!ShoppingCart.lookupProductById(4046).equals(expectedOutput)) {

			System.out.println("Problem detected: Your lookupProductById() method "

					+ "failed to return the expected output when passed the id " + "of Avocado as input");

			return false;
		}
		expectedOutput = "No match found";

		if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductByName() method "
					+ "failed to return the expected output when passed the name of "
					+ "a product not found in the market.");

			return false;

		}
		if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {

			System.out.println("Problem detected: Your lookupProductById() method "
					+ "failed to return the expected output when passed the identifier"
					+ "of a product not found in the market.");

			return false;
		}

		// The last non null position of the marketSize array is to be found in this particular place 

		expectedOutput = "3044 Spinach $3.09";

		if (!ShoppingCart.lookupProductByName("Spinach").equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductByName() method "
					+ "failed to return the expected output when Spinach was passed as input");

			return false;
		}
		
		if (!ShoppingCart.lookupProductById(3044).equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductById() method "
					+ "failed to return the expected output when the id of Spinach was passed as input");
			return false;
		}

		// The center position of the marketItems array is found
		
		expectedOutput = "4011 Banana $0.49";
		
		if (!ShoppingCart.lookupProductByName("Banana").equals(expectedOutput)) {
			System.out.println("Problem Detected: Your lookupProductByName() method "
					+ "failed to return the expected output when passed Banana as input");
			
			return false;
		}
		
		if (!ShoppingCart.lookupProductById(4011).equals(expectedOutput)) {
			System.out.println("Problem Detected: Your lookupProductById() method "
					+ "failed to return the expected output when the ID of banana is passed");
			
			return false;
		}
		return true;
	}

	/**
	 * The validity of ShoppingCart.getProductPrice() is checked in this particular situation 
	 * 
	 * @return if the test verifies a correct method then true is returned otherwise a false is returned 
	 *
	 */

	public static boolean testGetProductPrice() {
		double expectedPrice = 0.59;
		if (Math.abs(ShoppingCart.getProductPrice("Avocado") - expectedPrice) > 0.001) {
			return false;
		}
		return true;

	}

	/**
	 * The validity of the ShoppingCart.getProductQuantity () method is verified over here 
	 *
	 * @returns true is returned if the method is correct otherwise false is
	 *          returned
	 *
	 */

	public static boolean testAddItemToCartContainsNbOccurances() {
		// test scenarios are defined
		// the item which is at index 0 needs to be added

		String[] cart = new String[10];

		int size = 0;

		int expectedSize = 1;

		if (ShoppingCart.addItemToCart("Apple", cart, size) != expectedSize) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to return the expected output when passed Apple as input");
			return false;

		}

		if (!cart[0].equals("Apple")) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to add the item to the cart at the right position");
			return false;

		}
		cart = new String[] { "Apple", "Banana", "Milk", "Pizza" };

		size = 4;

		expectedSize = 4;

		if (ShoppingCart.addItemToCart("Eggs", cart, size) != expectedSize) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to return the expected output when passed Eggs as input");
			return false;
		}
		if (cart[3].equals("Eggs")) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to add item to the cart at the right position");
			return false;
		}

		// We need to assume that the item which has to be added is in the middle
		// position of the marketItem array

		cart = new String[] { "Milk", "Apple", "Banana", "Pizza", null, null };

		size = 4;

		expectedSize = 5;

		if (ShoppingCart.addItemToCart("Eggs", cart, size) != expectedSize) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to return the expected value when eggs was passed as an input");

			return false;

		}

		return true;
	}

	/**
	 * The validity of ShoppingCart.getCartTotal() is checked
	 *
	 * @returns true if the method is correct and false if otherwise
	 *
	 */
	public static boolean testRemoveItem() {

		// the test scenarios are defined
		// the item with an index 0 has to be added

		String[] cart = new String[10];

		int size = 0;

		int expectedSize = 0;

		if (ShoppingCart.removeItem(cart, "Apple", size) != expectedSize) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to return the expected output when passed Apple as input");

			return false;
		}
		if (cart[0] != null) {

			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");

			return false;
		}

		// The last null position of the item from the cart is now removed

		cart = new String[] { "Apple", "Banana", "Milk", "Pizza" };

		size = 4;

		expectedSize = 3;

		if (ShoppingCart.removeItem(cart, "Pizza", size) != expectedSize) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to return the expected output when passed Eggs as input");

			return false;

		}
		if (cart[3].equals("Eggs")) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");

			return false;
		}
		if (cart[3] != null) {

			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");

			return false;
		}

		// The item has to be removed from a defined position which is in the center of
		// the marketItem array

		cart = new String[] { "Milk", "Apple", "Banana", "Pizza", null, null };

		size = 4;

		expectedSize = 4;

		if (ShoppingCart.removeItem(cart, "Eggs", size) != expectedSize) {

			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to return the expected value when eggs was passed as an input");

			return false;
		}

		if (cart[4] != null) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");
			return false;

		}

		return true;
	}

	/**
	 * 
	 * This checks the validity of the ShoppingCart.getCartTotal() method
	 *
	 * @returns true is returned if the method is correct and if otherwise then
	 *          false returned
	 *
	 */

	public static boolean testCheckoutGetCartSummary() {

		// the test scenarios are defined
		// the item with an index 0 is to be added

		String[] cart = new String[7]; // there are 7 null references in the array

		int size = 0;

		String expectedOutput = "";

		String actualOutput = ShoppingCart.getCartSummary(cart, size);

		if (!actualOutput.equals(expectedOutput)) {

			System.out.println("Problem detected: Your getCartSummary() method "
					+ "failed to return the expected output when passed an empty cart");

			return false;
		}
		// This is for when the cart contains similar items

		cart = new String[] { "Apple", "Banana", "Milk", "Pizza", "Milk", "Milk" };

		size = 6; // this is done since it is a non empty cart of size 5

		expectedOutput = "(3) Apple\n(1) Banana\n(1) Milk\n(1) Pizza\n";

		actualOutput = ShoppingCart.getCartSummary(cart, size);

		System.out.println(actualOutput);

		if (!actualOutput.equals(expectedOutput)) {
			System.out.println("Problem detected: Your getCartSummary() method "
					+ "failed to return the expected output when the cart is passed with duplicate items");

			return false;
		}
		// When the cart has unique items this is used

		cart = new String[] { "Apple", "Banana", "Milk", "Pizza", null, null };

		size = 4; // since it is a non-empty cart with the size 4

		expectedOutput = "(1) Apple\n(1) Banana\n(1) Milk\n(1) Pizza\n";

		actualOutput = ShoppingCart.getCartSummary(cart, size);

		System.out.println(actualOutput);

		if (!actualOutput.equals(expectedOutput)) {

			System.out.println("Problem detected: Your getCartSummary() method "
					+ "failed to return the expected output when the cart is passed with unique items");

			return false;

		}
		return true;

	}

	/**
	 * The validity of shoppingCart class is tested
	 *
	 * @return if true is returned then it is correct
	 *
	 */
	public static boolean runAllTests() {
		if ((!testLookupMethods() && testGetProductPrice() && testAddItemToCartContainsNbOccurances()
				&& testRemoveItem() && testCheckoutGetCartSummary())) {
			return false;
		}
		return true;
	}

	/**
	 * Main method
	 *
	 * @param any input arguments
	 */
	public static void main(String[] args) {

		System.out.println("runAllTests() = " + runAllTests());
	}
}