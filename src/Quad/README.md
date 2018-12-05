#Functions

Requirement and how to examine:

    Allow for up to 20 objects to be stored:
        - Utilize ArrayList
        - When adding a new object, check if there is enough space
        - If not enough space, program returns that there is not enough storage
        
    Allow the user the choice of creating a custom or default shape
        - When user choose to add a shape, they have two options
            1. Default shape
            2. Custom shape
        - If choose default shape, create a shape with all aspect being 0
        - Otherwise trigger more input for info
        
    Require the user to confirm the shape attributes
        - After entering info about the shape, ask user to confirm
        - If user choose anything but Y or y, user will need to reenter the attributes
    
    Output the number of each shape created in total along with the total number of quadrilaterals created
        - Choosing 4 in the main menu will list all shaped in the order of their index
        - After the hsape of  each index is displayed, display amount of each shape
        
    Allow a user to search through the database and find a particular object based on a unique key
        - Choosing 3 in main menu will allow user to find shape
        - User can then choose to either search by index or key
        
    List all the objects in the database
        - Displayed when the user choose 4 in main menu