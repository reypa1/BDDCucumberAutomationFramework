Feature: Place the order for Products
@PlaceOrder
Scenario Outline: Place the order and checkout
 
 
 Given User is on GreenCart Landing page 
 When user searched with Shortname <Name> and extracted actual name of product
 And Added <quantity> items of the selected product to the cart
 Then User proceeds to Checkout and validate the items in checkout page
 Then verify user has ability to enter promo code and place the order
 
 
 Examples:
 | Name |quantity|
 | Tom  | 3      |
 