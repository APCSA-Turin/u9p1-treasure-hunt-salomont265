package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid {
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        //runs loop to fill grid array wiht dots
        grid = new Sprite[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j] = new Dot(i,j);
            }
        }
        //initalizes size
        this.size = size;
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot
        int x = s.getX();
        int y = s.getY();
        //use formula to place in right spot based on the size
        grid[size - y - 1][x] = s;

       


    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction

        //get the x and y
        int x = s.getX();
        int y = s.getY();

        //place the sprite in the right place based on it current location
        grid[size - y - 1][x] = s;
        //figure out where to put dot after it moves
        if(direction.equals("w")){
            grid[size - y ][x] = new Dot(x,y-1);

        } 
        if(direction.equals("s")){
            grid[size - y -2 ][x] = new Dot(x,y+1);


        }
        if(direction.equals("a")){
            grid[size - y - 1][x+1] = new Dot(x+1,y);


        }
        if(direction.equals("d")){
            grid[size - y - 1][x-1] = new Dot(x-1,y);


            
        }
        //if the enemy is about to hit player
        if(direction.equals("n")){
            grid[size - y- 1][ x+1] = new Dot(x,y);
        }
       
    }


    public void display() { //print out the current grid to the screen 
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                //if it a certain object print a certain image
               if( grid[i][j] instanceof Dot ){
                System.out.print("[ ]");
               }
               if(grid[i][j] instanceof Player ) {
                System.out.print("[P]");

               }
               
               if((grid[i][j] instanceof Treasure) && !(grid[i][j] instanceof Trophy)){
                System.out.print("[T]");

               }
               if(grid[i][j] instanceof Trophy){
                System.out.print("[R]");

               }
               if(grid[i][j] instanceof Enemy){
                System.out.print("[E]");

               }
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
        System.out.println("Sorry but you lose, haha!");
    }

    public void win(){ //use this method to display a win 
        System.out.println(" Congratulations you won!");
    }


}