package lehigh;
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

class Rect{
    int width;
    int height;
    int x;
    int y;
    public Rect(int x, int y, int width, int height, int[] color){
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
    }
}

class SelectionSort extends PApplet {
    int[] arr=new int[]{3,15,5,-6,-2,8,10,-5,7,11};
    int i=0;
    int j=0;
    boolean flag=false;//show if variable j has complete a loop, if it has, the variable flag will be true
    boolean J_flag=false;//
    int min_index=0;//the index of minimum in the array
    int[] color1=new int[]{78,135,34};
    int[] color2=new int[]{154,255,0};
    int[] color3=new int[]{0, 230, 255};

    //draw a set of rectangles with all the rectangle in it are in color1
    void buildRectangles(){
        background(255);
        for(int i=0;i<arr.length;i++){
            noStroke();
            Rect r=new Rect(40+i*80,400,75,-arr[i]*20,color1);
            createRectangle(r,color1);
        }
    }

    //draw one rectangle in color
    void createRectangle(Rect r, int[] color){
        noStroke();
        fill(color[0],color[1],color[2]);
        rect(r.x,r.y,r.width,r.height);
    }

    // Draw a set of rectangles;
    // the rectangle at the position of the index
    // will have a different color with other rectangles in the set,
    // and the parameter color is its color
    void drawRectangle(int index,int[] color){
        Rect r;
        background(255);
        for(int i=0;i<arr.length;i++){
            if(i!=index) {
                noStroke();
                r=new Rect(40 + i * 80, 400, 75, -arr[i] * 20, color1);
                createRectangle(r, color1);
            }else{
                noStroke();
                r=new Rect(40 + i* 80, 400, 75, -arr[i] * 20, color);
                createRectangle(r, color);
            }
        }
    }

    public void settings(){
        size(900,600);
    }

    //swap elements ar index_1 and index_2 in arr
    void swap(int index_1,int index_2){
        int temp=arr[index_1];
        arr[index_1]=arr[index_2];
        arr[index_2]=temp;
    }



    public void draw(){
        background(255);
        delay(150);

        if (i<arr.length && flag) {
            i++;
            flag=false;
            min_index=i;
            j=i;
        }
        if (i<arr.length && j<arr.length && !flag) {
            if (arr[j] < arr[min_index]) {
                min_index=j;
            }
            drawRectangle(j, color2);
            j++;
            J_flag=true;
        }
        if(J_flag)
            J_flag=false;
        else {
            if (i<arr.length && j==arr.length && !flag) {
                drawRectangle(min_index, color3);
                swap(i, min_index);
                flag=true;
            }
            J_flag=true;
        }
        if (i>=arr.length) {
            background(255);
            buildRectangles();
            noLoop();
        }
    }
    public static void main(String arg[]){
        String[] processingArgs = {"SelectionSort"};
        SelectionSort selectionSort = new SelectionSort();
        PApplet.runSketch(processingArgs, selectionSort);
    }
}
