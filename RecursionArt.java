package recursionart;

import java.awt.*;

import processing.core.PApplet;
/*
 * Recursive Artwork
 * 
 * This program draws some cool images using recursion
 * 
 * David Temming
 */

public class RecursionArt extends PApplet {

	/*
	 * Sets initial size, 
	 * adds smoothing (for pixelated lines)
	 * and noStroke, which takes out outlines of shapes.
	 */
	public void setup() {
		size(800,800);
		smooth();
		noStroke();
	}

	public void draw() {
		// Drawing background
		background(255,255,255);
		// Drawing target
		circleRecursion(12, 400);
		// Draw the "dream catcher"
		squareRecursion(400, 0, 400, 400, 800);
		// Draw the triangles
		triangleRecursion(400, 0, 400, 400, 400, 400, 800, 0, 400, 0, 800, 400, 800);
		//making a black background
		fill(0, 0, 0);
		quad(400, 400, 800, 400, 800, 800, 400, 800);
		// Draw whatever you want as long as its recursive.
		colorRecursion(500, 500, 700, 500, 500, 700, 700, 700, 200, 255, 0, 155);
	}
	
	
	public void circleRecursion(int numRings, int circleSize) {
		noStroke();
		if(numRings == 0) {
			// do nothing
		}
		else {
		if(numRings % 2 == 0) {
			fill(255, 0, 0);
			ellipse(200, 200, circleSize, circleSize);
			smooth();
		} else {
			fill(0, 0, 255);
			ellipse(200, 200, circleSize, circleSize);
			smooth();
		}
		circleRecursion(numRings - 1, circleSize - (circleSize / numRings));
		}
	}
		
	
	public void squareRecursion(int rectangleSideLength, int rotatedY1, int rotatedY2, int rotatedX1, int rotatedX2) {
		noStroke();
		if(rectangleSideLength <= 5) {
			// do nothing
		}
		else {
			fill(103, 107, 251);
			rect(600, 200, rectangleSideLength, rectangleSideLength);
			rectMode(CENTER);
			
			fill(255, 255, 255);
			quad(600, rotatedY1, rotatedX1, 200, 600, rotatedY2, rotatedX2, 200);

			squareRecursion(rectangleSideLength / 2, rotatedY1 + ((rotatedY2 - rotatedY1) / 4), rotatedY2 - ((rotatedY2 - rotatedY1) / 4), 
				rotatedX1 + ((rotatedY2 - rotatedY1) / 4), rotatedX2 - ((rotatedY2 - rotatedY1) / 4));
		}
	}
	
	public void triangleRecursion(int triangleSideLength, int bluex1, int bluey1, int bluex2, int bluey2, int bluex3, int bluey3, int yellowx1, 
							 int yellowy1, int yellowx2, int yellowy2, int yellowx3, int yellowy3) {
		
		noStroke();
		fill(0, 0, 255);
		triangle(bluex1, bluey1, bluex2, bluey2, bluex3, bluey3);
		
		fill(255, 255, 0);
		triangle(yellowx1, yellowy1, yellowx2, yellowy2, yellowx3, yellowy3);
		
		
		if(triangleSideLength <= 10) {
			//nothing
		} 
		else {
			//top right
			triangleRecursion(triangleSideLength / 2, bluex1 + ((bluex2 - bluex1) / 2), bluey1, bluex2, bluey2, bluex3, bluey3 - ((bluey3 - bluey2)/ 2), 
						  yellowx1 + (yellowx3 - yellowx1) / 2, yellowy1, yellowx2 + (yellowx3 - yellowx1) / 2, 
						  yellowy2 - ((yellowy2 - yellowy1) / 2), yellowx3, yellowy3 - ((yellowy3 - yellowy1) / 2));
			//top left
			triangleRecursion(triangleSideLength / 2, bluex1, bluey1, bluex2 - ((bluex2 - bluex1) / 2), bluey2, bluex3 - ((bluex2 - bluex1) / 2), 
						  bluey3 - ((bluey3 - bluey2) / 2), yellowx1, yellowy1, yellowx2, yellowy2 - ((yellowy2 - yellowy1) / 2), 
						  yellowx3 - ((yellowx3 - yellowx2) / 2), yellowy3 - ((yellowy2 - yellowy1) / 2));
			//bottom right
			triangleRecursion(triangleSideLength / 2, bluex1 + ((bluex2 - bluex1) / 2), bluey1 + ((bluey3 - bluey2) / 2), bluex2, 
						  bluey2 + ((bluey3 - bluey2) / 2), bluex3, bluey3, yellowx1 + ((yellowx3 - yellowx2) / 2), 
						  yellowy1 + ((yellowy2 - yellowy1) / 2), yellowx2 + ((yellowx3 - yellowx2) / 2), yellowy2, yellowx3, yellowy3);
		}
	}
	
	public void colorRecursion(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int ellipseSize, int R, int G, int B) {
		if(ellipseSize < 10) {
			//do nothing
		} else {
		fill(R, G, B);
		ellipse(x1, y1, ellipseSize, ellipseSize);
		fill(G, B, R);
		ellipse(x2, y2, ellipseSize, ellipseSize);
		fill(B, G, R);
		ellipse(x3, y3, ellipseSize, ellipseSize);
		fill(B, R, G);
		ellipse(x4, y4, ellipseSize, ellipseSize);
		
		colorRecursion(500, 500, 700, 500, 500, 700, 700, 700, ellipseSize - 5, R - 10, G + 10, B - 10);
		}
	}
}
