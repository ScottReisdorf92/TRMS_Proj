Feature: login feature works

	Scenario Outline: login works
		Given The user input username and password
		When The user types "<username>" and "<password>" and clicks login button
		Then The title of the page should be "<title>"
	
	Examples:
		| username | password | title 			   |
		| rdemp3   | rdemp3   | Employee Dashboard |