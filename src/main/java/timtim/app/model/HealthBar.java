package timtim.app.model;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import timtim.app.model.objects.Player;

public class HealthBar {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color backgroundColor;
    private Color foregroundColor;
    private Player player;
    
    public HealthBar(int x, int y, int width, int height, Color backgroundColor, Color foregroundColor, Player player) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.player = player;
    }
    
    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        // Begin the SpriteBatch and ShapeRenderer
        batch.begin();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeType.Filled);
        
        // Draw the background of the health bar
        shapeRenderer.setColor(backgroundColor);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end(); // End the ShapeRenderer
        
        // Calculate the width of the health bar based on the player's health
        int healthWidth = (int)((double)player.getHealth() / (double)player.getMaxHealth() * (double)width);
        
        // Begin the ShapeRenderer again
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        
        // Draw the foreground of the health bar
        shapeRenderer.setColor(foregroundColor);
        shapeRenderer.rect(x, y, healthWidth, height);
        
        // End the SpriteBatch and ShapeRenderer
        shapeRenderer.end();
        batch.end();
    }
    
    
}






