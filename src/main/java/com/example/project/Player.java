package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite  {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        //intiliazes sprite with super
        super(x,y);
        //sets treasure and lives to 0 and 2 respectively
        this.treasureCount = 0;
        this.numLives = 2;
    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  @Override
  //this moves by changing the x and y direction based on input
    public void move(String direction) { //move the (x,y) coordinates of the player
        if(direction.equals("w")){
            setY(getY() + 1);
        }
        if(direction.equals("s")){
            setY(getY() - 1);

        }
        if(direction.equals("a")){
            setX(getX() - 1);

        }
        if(direction.equals("d")){
            setX(getX() + 1);

            
        }
    }

    //overloads
    //based on objects and size ti determines response
    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
    //if the object is a treausre but not trophy it increase tresure count
        if((obj instanceof Treasure) && !(obj instanceof Trophy)){
            //treasure case
            treasureCount++;
            
            
        }
        //if it has trophy and enough treasures game is won
        if((obj instanceof Trophy) &&( treasureCount == numTreasures)){
            win = true;
         }
         //if its an enemy the number of lives decrease
        if( obj instanceof Enemy){
            numLives--; 
            //if lives is 0 game ends since player is dead
            if(numLives == 0){

                win = false;
            }
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        //checks if the direction to be placed goes over the grid
        if((direction.equals("w")) && (super.getY() + 1 <=size -1)){
            return true;
        }
        if((direction.equals("s")) && (super.getY() - 1 >=0)){
            return true;
        }
        if((direction.equals("a")) && (super.getX() - 1 >=0)){
            return true;
        }
        if((direction.equals("d")) && (super.getX() + 1 <=size -1)){
            return true;
        }
        return false;
    }

    public String getRowCol(int size){
        return "Player:" + super.getRowCol(size);
    }

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "Player:" + super.getCoords();
    }

   
}



