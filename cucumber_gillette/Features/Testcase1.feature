Feature: Hover menu

Scenario: Open MACH3 page from hover menu
Given Initialize the "chrome" browser
Then navigate to "https://www.gillette.co.in/en-in" website
When user hovers on products MACH is displayed and click on the link
Then check if "Gillette MACH3 Turbo" is present in our products
And exit the browser 