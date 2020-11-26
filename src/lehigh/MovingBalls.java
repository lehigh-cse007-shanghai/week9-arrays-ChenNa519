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
        this.radius=random(20,50);
        this.x=random(radius, width-radius);
        this.y=random(radius, height-radius);
        this.speedX=random(1,3);
        this.speedY=random(1,3);
    }
}

public class MovingBalls extends PApplet{
    //float x;
    //float y;
    //float speedX = 3;
    //float speedY = 3;
    //int radius = 20;


    ArrayList<Balls> balls=new ArrayList<>();
    int numOfBalls=0;
    public void settings(){
        size(800, 600);
        for(int i=0;i<numOfBalls;i++){
            balls.add(new Balls());
            balls.get(i).color= new float[]{random(0, 205), random(0, 205), random(0, 205), random(255, 255)};
        }
    }

    /*int numOfBalls=30;
    Balls[] balls = new Balls[numOfBalls];
    public void settings(){
        size(800, 600);
        for(int i=0;i<numOfBalls;i++){
            balls[i]=new Balls();
            balls[i].color= new float[]{random(0, 205), random(0, 205), random(0, 205), random(255, 255)};
        }
    }*/




    /*int numberOfBall=30;

    float[] radius=new float[numberOfBall];

    float[] speedX=new float[numberOfBall];
    float[] speedY=new float[numberOfBall];
    float[] x=new float[numberOfBall];
    float[] y=new float[numberOfBall];
    float[][] color=new float[numberOfBall][4];


    public void settings(){
        size(800, 600);
        for(int i=0;i<numberOfBall;i++) {
            speedX[i]=random(1,3);
            speedY[i]=random(1,3);
            //Arrays.fill(speedX, random(1, 3));
            //Arrays.fill(speedY, random(1, 3));
        }
        for(int i=0;i<numberOfBall;i++) {
            radius[i]=random(20,70);
            x[i] = random(radius[i], width - radius[i]);
            y[i] = random(radius[i], height - radius[i]);
            color[i] = new float[]{random(0,255),random(0,255),random(0,255),random(10,255)};
        }
    }

    void lineBuildAssistance(float x, float y, float[] arrX, float[] arrY){
        //ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<arrX.length;i++){
            float X=(x-arrX[i])*(x-arrX[i]);
            float Y=(y-arrY[i])*(y-arrY[i]);
            if(X+Y <= 15000){
                line(x,y,arrX[i],arrY[i]);
                stroke(color[i][0],color[i][1],color[i][2],color[i][3]);



                strokeWeight(radius[i]/5);
            }
        }
    }*/

    @Override
    public void mouseClicked() {
        balls.add(new Balls());
        balls.get(balls.size()-1).color=new float[]{random(0, 205), random(0, 205), random(0, 205), random(255, 255)};
    }

    public void draw(){
        //background(255,255,245);

        background(255,255,245);
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
            DrawLineAssistance(balls.get(i),balls);


            /*PShape trapezoid=createShape();
            trapezoid.beginShape();
            trapezoid.vertex(30,40);
            trapezoid.vertex(30,100);
            trapezoid.vertex(50,80);
            trapezoid.vertex(50,60);
            noStroke();
            trapezoid.fill(200,30,40,255);
            //trapezoid.stroke(0);
            //trapezoid.strokeWeight(5);
            trapezoid.draw(getGraphics());
            trapezoid.endShape(CLOSE);*/
        }


    }

    /*void gradientTrapezoid(float x1, float y1, float x2, float y2,float x3,float y3, float x4,float y4,float[] color1, float[] color2){
        int pieceNumber=20;
        float eachPiece=1/pieceNumber;
        for(int i=0;i<pieceNumber;i++){
            float pointX_1=x1+(x2-x1)*eachPiece*i;
            float pointY_1=y1+(y2-y1)*eachPiece*i;
            float pointX_2=x1+(x2-x1)*eachPiece*(i+1);
            float pointY_2=y1+(y2-y1)*eachPiece*(i+1);
            float pointX_3=x3+(x4-x3)*eachPiece*i;
            float pointY_3=y3+(y4-y3)*eachPiece*i;
            float pointX_4=x3+(x4-x3)*eachPiece*(i+1);
            float pointY_4=y3+(y4-y3)*eachPiece*(i+1);
            PShape trapezoid=createShape();
            trapezoid.beginShape();
            trapezoid.vertex(pointX_3,pointY_3);
            trapezoid.vertex(pointX_1,pointY_1);
            trapezoid.vertex(pointX_2,pointY_2);
            trapezoid.vertex(pointX_4,pointY_4);
            noStroke();
            trapezoid.fill(color1[0],color1[1],color1[2],color1[3]-color1[3]/pieceNumber);
            trapezoid.fill(color2[0],color2[1],color2[2],color2[3]*i/pieceNumber);
            trapezoid.draw(getGraphics());
            trapezoid.endShape(CLOSE);
        }
    }*/

    /*void gradientTriangle(float x1,float y1, float x2,float y2, float x3, float y3, float[] color1, float[] color2){
        float pointX_1=x1+(x3-x1)*(5/11);
        float pointY_1=y1+(y3-y1)*(5/11);
        float pointX_2=x1+(x3-x1)*(6/11);
        float pointY_2=y1+(y3-y1)*(6/11);
        float pointX_3=x2+(x3-x2)*(5/11);
        float pointY_3=y2+(y3-y2)*(5/11);
        float pointX_4=x2+(x3-x2)*(6/11);
        float pointY_4=y2+(y3-y2)*(6/11);
        //fill(color2[0],color2[1],color2[2],color2[3]);
        //triangle(x3,y3,pointX_2,pointY_2,pointX_4,pointY_4);

        PShape trapezoid=createShape();
        trapezoid.beginShape();
        trapezoid.vertex(x3,y3);
        trapezoid.vertex(x3,y3);
        trapezoid.vertex(pointX_2,pointY_2);
        trapezoid.vertex(pointX_4,pointY_4);
        noStroke();
        trapezoid.fill(color2[0],color2[1],color2[2],color2[3]);
        trapezoid.draw(getGraphics());
        trapezoid.endShape();

        PShape trapezoid1=createShape();
        trapezoid1.beginShape();
        trapezoid1.vertex(pointX_3,pointY_3);
        trapezoid1.vertex(pointX_1,pointY_1);
        trapezoid1.vertex(pointX_2,pointY_2);
        trapezoid1.vertex(pointX_4,pointY_4);
        noStroke();
        trapezoid1.fill(color1[0],color1[1],color1[2],color1[3]);
        trapezoid1.draw(getGraphics());
        trapezoid1.endShape();
        gradientTrapezoid(pointX_1,pointY_1,pointX_2,pointY_2,pointX_3,pointY_3,pointX_4,pointY_4,color1, color2);
    }*/




    void drawTriBetweenBalls(Balls b1, Balls b2){
            float C=(b1.x-b2.x)*(b1.x-b2.x)+(b1.y-b2.y)*(b1.y-b2.y);
            if(b2.x>b1.x && b2.y<b1.y){
                float pointX_1= (float) (b1.x-0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
                float pointX_2= (float) (b1.x+0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
                float pointY_1= (float) (b1.y-0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
                float pointY_2= (float) (b1.y+0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
                //fill(b1.color[0],b1.color[1],b1.color[2],b1.color[3]);

                triangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y);

                //gradientTriangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y,b2.color,b1.color);
            }
            if(b2.x<b1.x && b2.y>b1.y){
                float pointX_1= (float) (b1.x-0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
                float pointX_2= (float) (b1.x+0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
                float pointY_1= (float) (b1.y-0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
                float pointY_2= (float) (b1.y+0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
                //fill(b1.color[0],b1.color[1],b1.color[2],b1.color[3]);

                triangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y);

                //gradientTriangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y,b2.color,b1.color);
           }
           if(b2.x>b1.x && b2.y>b1.y){
                float pointX_1= (float) (b1.x+0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
                float pointX_2= (float) (b1.x-0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
                float pointY_1= (float) (b1.y-0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
                float pointY_2= (float) (b1.y+0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
                //fill(b1.color[0],b1.color[1],b1.color[2],b1.color[3]);

               triangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y);

               //gradientTriangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y,b2.color,b1.color);
          }
          if(b2.x<b1.x && b2.y<b1.y){
               float pointX_1= (float) (b1.x+0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
               float pointX_2= (float) (b1.x-0.2*b1.radius*Math.sqrt((b1.y-b2.y)*(b1.y-b2.y)/C));
               float pointY_1= (float) (b1.y-0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
               float pointY_2= (float) (b1.y+0.2*b1.radius*Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)/C));
               //fill(b1.color[0],b1.color[1],b1.color[2],b1.color[3]);

               triangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y);

               //gradientTriangle(pointX_1,pointY_1,pointX_2,pointY_2,b2.x,b2.y,b2.color,b1.color);
         }
         if(b1.x==b2.x && b1.y==b2.y){
            return;
         }
         if(b1.x==b2.x && b2.y!=b1.y){
            float pointY_1= (float) (b1.y-0.2*b1.radius);
            float pointY_2= (float) (b1.y+0.2*b1.radius);
            //fill(b1.color[0],b1.color[1],b1.color[2],b1.color[3]);

            triangle(b1.x,pointY_1,b2.x,pointY_2,b2.x,b2.y);

            //gradientTriangle(b1.x,pointY_1, b2.x, pointY_2,b2.x,b2.y,b2.color,b1.color);
         }
         if(b1.x!=b2.x && b2.y==b1.y){
            float pointX_1= (float) (b1.x-0.2*b1.radius);
            float pointX_2= (float) (b1.X+0.2*b1.radius);
            //fill(b1.color[0],b1.color[1],b1.color[2],b1.color[3]);

            triangle(pointX_1,b1.y,pointX_2,b1.y,b2.x,b2.y);

            //gradientTriangle(pointX_1,b1.y,pointX_2,b2.y,b2.x,b2.y,b2.color,b1.color);
         }
         else{
            return;
         }
    }

    void DrawLineAssistance(Balls b,ArrayList<Balls> arrX){
        for(int i=0;i<arrX.size();i++){
            float X=(b.x-arrX.get(i).x)*(b.x-arrX.get(i).x);
            float Y=(b.y-arrX.get(i).y)*(b.y-arrX.get(i).y);
            if(X+Y<=15000){
                if(b.radius<arrX.get(i).radius){
                    drawTriBetweenBalls(arrX.get(i),b);
                }
                if(b.radius>arrX.get(i).radius){
                    drawTriBetweenBalls(b,arrX.get(i));
                }
                if(b.radius==arrX.get(i).radius){
                    line(b.x,b.y,arrX.get(i).x,arrX.get(i).y);
                    //stroke(b.color[0],b.color[1],b.color[2],b.color[3]);
                    strokeWeight((float) (0.2*b.radius));
                }
            }
        }
    }



//ellipse(mouseX, mouseY, 20, 20);
        /*for(int i=0;i<numberOfBall;i++) {   //method 1
            ellipse(x[i], y[i], radius[i] + 4, radius[i] + 4);//?why +2
            fill(color[i][0], color[i][1],color[i][2],color[i][3]);
            stroke(color[i][0],color[i][1],color[i][2],color[i][3]);
            if ((x[i] - radius[i]) <= 0 || (x[i] + radius[i]) >= width) {//change the direction of x coordinator
                speedX[i] = -speedX[i];
            }
            if ((y[i] - radius[i]) <= 0 || (y[i] + radius[i]) >= height) {//Change the direction of y coordinator
                speedY[i] = -speedY[i];
            }
            x[i] = x[i] + speedX[i];
            y[i] = y[i] + speedY[i];

            //do sth about line
        }*/


        /*int i=0;
        int j=0;
        while(i<numberOfBall){  //method 2
            noStroke();
            ellipse(x[i], y[i], radius[i] + 4, radius[i] + 4);
            fill(color[i][0], color[i][1],color[i][2],color[i][3]);
            //stroke(color[i][0],color[i][1],color[i][2],color[i][3]);
            if ((x[i] - radius[i]) <= 0 || (x[i] + radius[i]) >= width) {
                speedX[i] = -speedX[i];
            }
            if ((y[i] - radius[i]) <= 0 || (y[i] + radius[i]) >= height) {
                speedY[i] = -speedY[i];
            }
            x[i] = x[i] + speedX[i];
            y[i] = y[i] + speedY[i];
            lineBuildAssistance(x[i],y[i],x,y);



            i++;
        }*/






    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);

    }
}
