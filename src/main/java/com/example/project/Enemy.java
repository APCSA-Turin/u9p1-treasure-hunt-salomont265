package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite  { //child  of Sprite
    
    public Enemy(int x, int y) {
        //initalizes sprite class consutcotr for enemy
        super(x,y);
    }


    //the methods below should override the super class 


    public String getCoords(){ //returns "Enemy:"+coordinates
    //returns the cords by calling from the sprite class
        return "Enemy:" + super.getCoords();
    }
    //method to check for treausre in moe

    
    //this move clauclutes the difference from the players location to the enemy in order to figure out which direction
    public String move(int x, int y,String d)
{

   
    
    //account for players move to factor in difference of x and y
    if(d.equals("w")){
        y++;

    }
    if(d.equals("s")){
        y--;
    }if(d.equals("a")){
        x--;
    }
    if(d.equals("d")){
        x++;
    }

    //find differenece between x and y of the player and the enemt to help create accurate positon
    int xDif =  x -super.getX();
    int yDif =  y -super.getY();
    //if they are equal dont move so enemy cant hit player
    if((x == super.getX()) &&(y == super.getY())){
        //nothing happens
        return "n";
    }
    //check if there is a bigger y or x difference
    else if( (Math.abs(yDif) >= Math.abs(xDif))){
        //if y difference greater

        //if y difference is poistive move up
        if(yDif >0){
            setY(getY()+1);
            return  "w";
        }
        else{
            //otherwise move it down one
            setY(getY()-1);
            return"s";

        }
    }else{
        //if x difference greater

        //if x difference is poistive move right
        if((xDif >0)){
            setX(getX()+1);
            return"d";

        }
        //otherwise move it sideways
        else{
            setX(getX()-1);
            return "a";

        }
    }
 

}
    public String getRowCol(int size){ //return "Enemy:"+row col
        return "Enemy:" + super.getRowCol(size);
    }
}