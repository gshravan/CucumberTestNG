Feature: Demo Webshop Smoke Test
Scenario Outline: Demo WebShop Login
Given Launch the application
When Enter "<username>" and "<password>"
#When Enter "JohnMake@test.com" and "test1234"
Then User should be able to login successfully

Examples:
	| username | password |
	| JohnMake@test.com | test1234 |

Scenario: Search product and add to cart
When Search for product "Health"
Then Add to cart and enter qty is "2"

Scenario: Order placement process
When Confirm billing address
When Confirm shipping address
When Select payment method
When Confirm payment information
When Confirm order
Then Order Confirmation

Scenario: Logoff demo webshop application
When Click on logout