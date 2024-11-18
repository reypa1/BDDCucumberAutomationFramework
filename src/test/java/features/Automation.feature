Feature: Automation Practise page
@Practise
Scenario Outline: Validating Automation Practise page
 
 
 Given User landed on Automation Practise page 
 When user selected <name> Radio button 
 And select <option> from dropdown
 And pick <value> from Autosuggestion list
 And check the box <checkboxname> from list
 And Enter the <Text> click on Alert button
 
 Examples:
 | name   | option  | value | checkboxname | Text |
 | radio2 | Option1 | India | option3      | Sai  |
                
 
 
 

 