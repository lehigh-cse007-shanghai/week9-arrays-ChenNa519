package lehigh;
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

class Rectangle_def extends PApplet{
    int height;
    int width;
    int x;
    int y;
    int[] color;
    public Rectangle_def(int x,int y, int width, int height, int[] color ){
        this.height=height;
        this.width=width;
        this.x=x;
        this.y=y;
        this.color=color;
    }
}


public class BubbleSort extends PApplet {
    int arr[]=new int[]{3,14,-2,4,7,1,8};
    int[] color1=new int[]{78,135,34};
    int[] color2=new int[]{154,255,0};
    int i=0;
    int max=arr.length-1;
    ArrayList<Rectangle_def> rectangle=new ArrayList<>();
    void buildRectangles(){
        for(int i=0;i<arr.length;i++){
            noStroke();
            Rectangle_def r=new Rectangle_def(20+i*80,300,75,-arr[i]*20,color1);
            rectangle.add(r);
            createRectangle(r,rectangle.get(i).color);
        }
    }
    void createRectangle(Rectangle_def r, int[] color){
        noStroke();
        fill(color[0],color[1],color[2]);
        rect(r.x,r.y,r.width,r.height);
    }
    public void settings(){
        size(600,400);
    }
    public void draw(){
        background(255);
        delay(200);
        buildRectangles();

        if (i >= max) {
            i = 0;
            max--;
        }
        rectangle.get(i).color=color2;
        rectangle.get(i+1).color=color2;
        rectangle.get(max).color=new int[]{0,230,255};
        buildRectangles();

        if (arr[i] >arr[i+1]) {
            swap(i,i+1);
        }
        rectangle.get(i).color=color1;
        rectangle.get(i+1).color=color1;

        if(max==0){
            for(int i=0;i<rectangle.size();i++)
                rectangle.get(i).color=color1;
            buildRectangles();
            noLoop();
        }
        i++;
    }
    void swap(int index_1,int index_2){
        int temp=arr[index_1];
        arr[index_1]=arr[index_2];
        arr[index_2]=temp;
    }
    void swap(int index_1, int index_2,ArrayList<Rectangle> r){
        Rectangle temp=r.get(index_1);
        r.set(index_1,r.get(index_2));
        r.set(index_2,temp);
    }
    public static void main(String arg[]){
        String[] processingArgs = {"BubbleSort"};
        BubbleSort bubbleSort = new BubbleSort();
        PApplet.runSketch(processingArgs, bubbleSort);


    }
}
