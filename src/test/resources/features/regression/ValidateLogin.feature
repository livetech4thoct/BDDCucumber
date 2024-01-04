Feature: To validate Login Functionality of Adactin Hotel app

Scenario: To validate login using valid username and valid password
Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text "reyaz009" using xpath "//input[@name='username']"
And user enters text "reyaz123" using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user verify the title to be "Adactin.com - Search Hotel"