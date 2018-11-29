#Functions

Requirement and how to examine:
    
    User able to add 20 shapes:
        - When 20 shapes is reach
        - User will be prompt "not enough storage" if attempt to add more
    
    Create custom or default shape:
        - After entering 1 in the main menu, user will have 6 choices
        - Whatever shape use decide to create, they will be given two choices
            1. Default shape
            2. Custom shape
        - Choosing default shape will create a shape of choice with all characteristic being 0
        - CHoosing custom shape will trigger user to enter more info
        
    Require user to confirm attribute:
        - If use decide to create a specific shape
        - After entering the values for the shapes attribute, they will be asked to chekc the value
        - If user is satisfied, enter "Y" or "y"
        - Anything else will trigger loop, asking user to reenter the values 
    
    Output the number of each shape created in total along with the total number of quadrilaterals created
        - At main menu, choose 4, extract info from a shape
        - Either search by key or index
        - Choose a shape
        - After choosing a shape, the first two choices are 
            - Find the total number of quadrilateral
            - Find the total number of the shape chosen
            
    Allow a user to search through the database and find a particular object based on a unique key
        - Choose 4 at main menu
        - Choose search by key
        - Enter the key (Shape type and a number separated by a space)
        - If shape with such key cannot be found, warn user "No shape with such key is found"
        - Otherwise tell user shape is found
        
    List all the objects in the database
        - Option 5 of the main menu