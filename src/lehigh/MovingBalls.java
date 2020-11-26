package lehigh;

import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Arrays;




class Balls extends PApplet{
    float[] color;
    float radius;
    float x;
    float y;
    float speedX;
    float speedY;
    public Balls(){
        this.color=new float[4];
        this.radius=random(30,50);
        this.x=random(radius, width-radius);
        this.y=random(radius, height-radius);
        this.speedX=random(0.5f,2.5f);
        this.speedY=random(0.5f,2.5f);
    }
}

class GameBalls extends PApplet {
    ArrayList<Balls> balls=new ArrayList<>();
    int numOfBalls=10;
    int score=0;
    float radius=20;
    int TimeCountDown=20;
    int bestScore;
    public void settings(){
        size(800,600);
        for(int i=0;i<numOfBalls;i++){
            balls.add(new Balls());
            balls.get(i).color= new float[]{random(0, 205), random(0, 205), random(0, 205), random(255, 255)};
        }
    }

    public void draw(){
        background(255,255,245);
        ellipse(mouseX, mouseY, radius,radius);
        textSize(32);
        text("Score:",10,30);
        fill(0, 102, 153, 51);
        textSize(32);
        text(String.valueOf(score),100,30);
        fill(0, 102, 153, 51);
        /*textSize(32);
        text("Best Score:",10,70);
        fill(0, 102, 153, 51);
        textSize(32);
        text(String.valueOf(bestScore),200,70);
        fill(0, 102, 153, 51);*/



        for(int i=0;i<balls.size();i++){
            noStroke();
            ellipse(balls.get(i).x,balls.get(i).y,balls.get(i).radius+4,balls.get(i).radius+4);
            fill(balls.get(i).color[0],balls.get(i).color[1],balls.get(i).color[2],balls.get(i).color[3]);
            if((balls.get(i).x-balls.get(i).radius)<=0 || (balls.get(i).x+balls.get(i).radius)>=width){
                balls.get(i).speedX=-balls.get(i).speedX;
            }
            if((balls.get(i).y-balls.get(i).radius)<=0 || (balls.get(i).y+balls.get(i).radius)>=height){
                balls.get(i).speedY=-balls.get(i).speedY;
            }
            balls.get(i).x=balls.get(i).x+balls.get(i).speedX;
            balls.get(i).y=balls.get(i).y+balls.get(i).speedY;
        }
        textSize(32);
        text("You have  "+String.valueOf(TimeCountDown)+"  seconds left",300,30);
        fill(0, 102, 153, 51);


        /*if(score>bestScore){
            bestScore=score;
        }*/

        if(frameCount%60==0) {
            timeCountDown();
            if (TimeCountDown > 10) {
                balls.add(new Balls());
                balls.get(balls.size() - 1).color = new float[]{random(0, 205), random(0, 205), random(0, 205), random(255, 255)};
            }
        }
    }

    boolean isInBall(Balls ball, float x, float y){
        if((x-ball.x)*(x-ball.x)+(y-ball.y)*(y-ball.y)<=Math.pow(ball.radius,2)){
            return true;
        }
        else{
            return false;
        }
    }

    void speedUp(){
        for(int i=0;i<balls.size();i++){
            if(balls.get(i).speedX>=0 && balls.get(i).speedY>=0) {
                balls.get(i).speedX = balls.get(i).speedX + 0.5f;
                balls.get(i).speedY = balls.get(i).speedY + 0.5f;
            }else if(balls.get(i).speedX>=0 && balls.get(i).speedY<=0){
                balls.get(i).speedX = balls.get(i).speedX + 0.5f;
                balls.get(i).speedY = balls.get(i).speedY - 0.5f;
            }else if(balls.get(i).speedX<=0 && balls.get(i).speedY>=0){
                balls.get(i).speedX = balls.get(i).speedX - 0.5f;
                balls.get(i).speedY = balls.get(i).speedY + 0.5f;
            }else if(balls.get(i).speedX<=0 && balls.get(i).speedY<=0){
                balls.get(i).speedX = balls.get(i).speedX - 0.5f;
                balls.get(i).speedY = balls.get(i).speedY - 0.5f;
            }
        }
    }

    void removeBalls(ArrayList<Balls> balls){
        int index=Integer.MIN_VALUE;
        for(int i=0;i<balls.size();i++){
            if(isInBall(balls.get(i), mouseX, mouseY)){
                score=score+(int)balls.get(i).radius*5+(int)Math.abs(balls.get(i).speedX);
                this.radius=this.radius+0.2f*balls.get(i).radius;
                balls.remove(i);
                speedUp();
            }
        }
    }

    void refillBallList(ArrayList<Balls> b){
        for(int i=0;i<1;i++){
            b.add(new Balls());
            b.get(i).color= new float[]{random(0, 205), random(0, 205), random(0, 205), random(255, 255)};
        }
    }

    void timeCountDown(){
        if(TimeCountDown>0) {
            TimeCountDown--;
            //delay(1000);
        } else{
            textSize(64);
            text("Game Over",200,300);
            fill(0, 102, 153, 51);
            stop();
            return;
        }
    }



    public void mouseClicked(){
        removeBalls(balls);
    }

    public static void main(String arg[]){
        String[] processingArgs = {"GameBalls"};
        GameBalls gameBalls = new GameBalls();
        PApplet.runSketch(processingArgs, gameBalls);
    }
}
