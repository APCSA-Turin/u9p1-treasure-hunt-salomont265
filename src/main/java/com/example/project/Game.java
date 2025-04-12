package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize(size);
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        //set variables to see if game finsiheds and if enemies get hit
        boolean finish = false;
        boolean hitE1 = false;
        boolean hitE2 = false;
        while(!finish){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // clearScreen();
             // Clear the screen at the beggining of the while loop

            //display basic info

            //grid shown
            System.out.println();

            grid.display();
            //plaeyr info
            System.out.println(player.getCoords());
            System.out.println(player.getRowCol(size));
            System.out.println("Treasures collected: " + player.getTreasureCount());
            System.out.println("Lives: "  + player.getLives());

            System.out.println("Enter a direction (w,a,s,d)");

            //get respone
            String response = scanner.nextLine();
            //move
            if( player.isValid(size, response)){

            int x = player.getX();
            int y = player.getY();
                //set enemies x and y
            
            //which directions it can move
            // boolean e1A = !(grid.getGrid()[size-e1Y-1][e1X-1] instanceof Treasure);
            // boolean e1D = !(grid.getGrid()[size-e1Y-1][e1X+1] instanceof Treasure);
            // boolean e1W= !(grid.getGrid()[size-e1Y-2][e1X] instanceof Treasure);
            // boolean e1S = !(grid.getGrid()[size-e1Y][e1X] instanceof Treasure);

            // boolean e2A = !(grid.getGrid()[size-e2Y-1][e2X-1] instanceof Treasure);
            // boolean e2D = !(grid.getGrid()[size-e2Y-1][e2X+1] instanceof Treasure);
            // boolean e2W= !(grid.getGrid()[size-e2Y-2][e2X] instanceof Treasure);
            // boolean e2S = !(grid.getGrid()[size-e2Y][e2X] instanceof Treasure);

            //figure out string for which direction

            //enemny 1
            // String e1DCant = "";
            // if(!e1A){
            //     e1DCant = "a";
            // }
            // if(!e1W){
            //     e1DCant = "w";
            // } if(!e1S){
            //     e1DCant = "S";
            // }
            // if(!e1D){
            //     e1DCant = "d";
            // }

            //enemny 2
            // String e2DCant = "";
            // if(!e2A){
            //     e2DCant = "a";
            // }
            // if(!e2W){
            //     e2DCant = "w";
            // } if(!e2S){
            //     e2DCant = "S";
            // }
            // if(!e2D){
            //     e2DCant = "d";
            // }
          
            String e1Move = "";
            String e2Move = "";
        
  
            Sprite neighbor = grid.getGrid()[size - y -1][x];
            if(response.equals("w")){
             

                //check to see it hasnt been hit/removed
                if(!hitE1){
                e1Move = enemies[0].move(x, y,"w");
                  
                }
                if(!hitE2){
                e2Move = enemies[1].move(x, y,"w");
                }
                //see wheter the nieghbor is an enemy to  see if the player will hit enemy
               
                
                if(!hitE1){
                grid.placeSprite(enemies[0],e1Move);
                }
                if(!hitE2){
                grid.placeSprite(enemies[1],e2Move);
                }
                neighbor = grid.getGrid()[size - y ][x+1];
                // System.out.println(y + " " + x);
                // System.out.println(enemies[0].getRowCol(size));
                // System.out.println(size - y -1);
                // System.out.println(x+1);
                // System.out.println(player.getRowCol(size));
                // System.out.println(neighbor.getClass());

                if(neighbor == enemies[0]){
                   hitE1 = true;
                }
                if(neighbor == enemies[1]){
                   hitE2 = true;
                }
               //interact with object
                //have player ineract wiht the object
                player.interact(size, response, 2, neighbor);


            }
   

            if(response.equals("a")){
                //check for treasure so enemy doesnt remove it
                if(!hitE1){
                    e1Move = enemies[0].move(x, y,"a");
                    
                    }
                    if(!hitE2){
                    e2Move = enemies[1].move(x, y,"a");
                    }
                 //see wheter the nieghbor is an enemy to  see if the player will hit enemy

                

                if(!hitE1){
                grid.placeSprite(enemies[0],e1Move);
                }
                if(!hitE2){
                grid.placeSprite(enemies[1],e2Move);
                }
                neighbor = grid.getGrid()[size - y -1][x];
                // System.out.println(y + " " + x);
                // System.out.println(enemies[0].getRowCol(size));
                // System.out.println(size - y -1);
                // System.out.println(x+1);
                // System.out.println(player.getRowCol(size));
                // System.out.println(neighbor.getClass());

                if(neighbor == enemies[0]){
                   hitE1 = true;
                }
                if(neighbor == enemies[1]){
                   hitE2 = true;
                }
               //interact with object
                 //interact with player
                player.interact(size, response, 2, neighbor);
                
            }
            if(response.equals("s")){
    
                if(!hitE1){
                    e1Move = enemies[0].move(x, y,"s");
                      
                    }
                if(!hitE2){
                    e2Move = enemies[1].move(x, y,"s");
                    }
                //see wheter the nieghbor is an enemy to  see if the player will hit enemy
                
                 //interact with object

                    if(!hitE1){
                    grid.placeSprite(enemies[0],e1Move);
                    }
                    if(!hitE2){
                    grid.placeSprite(enemies[1],e2Move);
                    }
                    neighbor = grid.getGrid()[size - y -2][x+1];
                    // System.out.println(y + " " + x);
                    // System.out.println(enemies[0].getRowCol(size));
                    // System.out.println(size - y -1);
                    // System.out.println(x+1);
                    // System.out.println(player.getRowCol(size));
                    // System.out.println(neighbor.getClass());
   
                    if(neighbor == enemies[0]){
                       hitE1 = true;
                    }
                    if(neighbor == enemies[1]){
                       hitE2 = true;
                    }
                   //interact with object
                player.interact(size, response, 2, neighbor);
            }
             
            
            if(response.equals("d")){
                //check for treasure so enemy doesnt remove it
                if(!hitE1){
                    e1Move = enemies[0].move(x, y,"d");
                      
                    }
                    if(!hitE2){
                    e2Move = enemies[1].move(x, y,"d");
                    }
                //see wheter the nieghbor is an enemy to  see if the player will hit enemy
                
                // System.out.println(enemies[0].getRowCol(size));

                if(!hitE1){
                grid.placeSprite(enemies[0],e1Move);
                }
                if(!hitE2){
                grid.placeSprite(enemies[1],e2Move);
                }
                neighbor = grid.getGrid()[size - y -1][x+1];
                // System.out.println(e1Move);
                // System.out.println(y + " " + x);
                // System.out.println(enemies[0].getRowCol(size));
                // System.out.println(size - y -1);
                // System.out.println(x+1);
                // System.out.println(player.getRowCol(size));
                // System.out.println(neighbor.getClass());

                if(neighbor == enemies[0]){
                   hitE1 = true;
                }
                if(neighbor == enemies[1]){
                   hitE2 = true;
                }
               //interact with object
                player.interact(size, response, 2, neighbor);

                
            }
            System.out.println(grid.getGrid()[2][4]);

            //actual movements
            player.move(response);
            // System.out.println(e1Move);
            // System.out.println(e2Move);

            grid.placeSprite(player, response);
     
            // System.out.println(player.getTreasureCount();
            if(player.getWin()){
                finish = true;
                grid.win();
            }
            if(player.getLives() == 0){
                // System.out.println(player.getWin());
                finish = true;
                grid.gameover();
            }

            // System.out.println(hitE1);  
            // System.out.println(hitE2);   
            System.err.println();          
           

            }
        }
     
    }

    public void initialize(int size){
        //make grid
        grid = new Grid(size);

      
          player = new Player( 1,2);

        //enemy definition

         enemies = new Enemy[2];
         enemies[0] = new Enemy(4, 0);
         enemies[1] = new Enemy(9, 1);

        //treasures

        treasures = new Treasure[2];
        treasures[0] = new Treasure(2, 3);
        treasures[1] = new Treasure(3, 5);

        trophy = new Trophy(4, 7);

        //placing
        grid.placeSprite(player);
        grid.placeSprite(enemies[0]);
        grid.placeSprite(enemies[1]);
        grid.placeSprite(trophy);
        grid.placeSprite(treasures[0]);
        grid.placeSprite(treasures[1]);
        


        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
   
    }

    public static void main(String[] args) {
        Game g1 = new Game(10);
        

    }
}