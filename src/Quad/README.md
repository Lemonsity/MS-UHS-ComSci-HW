#Functions
User are first given 5 choices:
    
    1. Add a shape:
        - Given 7 choices:
            - If the database is not full (Not yet 20)
            - 1 through 6 are specific shape:
                - Square, Rectangle, Rhombus, Parallelogram, Kite, or Trapezoid
                - Ask for side 1, side 2...
                - depend on the shape user choosed
            - 7 declears a default square with side length of 1
       
    2. Remove a shape
        - Given 7 choices:
            - 1 through 6 are specific shape:
                - Square, Rectangle, Rhombus, Parallelogram, Kite, or Trapezoid
                - Finds all the shapes that are the same kind as the user's choice
                - User can then choose to delete one of them
            - 7 finds a specific shape with specific attribute
                - If not found, return not found
                - Else displays all shapes that have the same attribute
                
    3. Manipulate a shape
        - Show list of database
        - index, the type of shape stored in that index
        - User choose the index
        - depend on the shape, use can choose to manipulate side 1, side 2, etc
        
    4. Extract information from a shape
        - Show list of database
        - index, the type of shape stored in that index
        - User choose the index
        - Some common things you can find:
            - Total amount of quadrilateral
            - Amount of shape that are saem kind as the one user choose
            - Area
            - Parameter
            
    5. Exit the program