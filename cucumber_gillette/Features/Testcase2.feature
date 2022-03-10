Feature: search items

Scenario: Searching items in gillette
Given Initialize  the "chrome" browser
Then navigate  to "https://www.gillette.co.in/en-in" website
When searching for "razor" in search bar
Then verify if search heading is correct and contains "razor"
And exit  the browser