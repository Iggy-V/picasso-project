package picasso.parser.language.expressions;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.model.ImprovedNoise;
import picasso.util.Command;
import java.awt.Color;
import java.awt.Dimension;


public class PerlinColor extends ExpressionTreeNode {
    
    private ExpressionTreeNode param;
    private ExpressionTreeNode param2;
    private Pixmap noiseImage;

    public PerlinColor(ExpressionTreeNode param, ExpressionTreeNode param2) {
		this.param = param;
        this.param2 = param2;
        this.noiseImage = new Pixmap();

        Dimension size = noiseImage.getSize();
        for (int imageY = 0; imageY < size.height; imageY++) {
            double evalY = imageToDomainScale(imageY, size.height);
            for (int imageX = 0; imageX < size.width; imageX++) {
                double evalX = imageToDomainScale(imageX, size.width);
                Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
                target.setColor(imageX, imageY, pixelColor);
                
            }
        }
	}
    
    public RGBColor evaluate(double x, double y) {
		
        double xe = ((param.evaluate(x,y)).getRed());
		double ye = ((param2.evaluate(x,y)).getRed());
		
		//RGBColor imgColor = imgage.evaluate(x, y);
        RGBColor imgColor = new RGBColor(1,2,3);
		return imgColor;
		
	}
}
