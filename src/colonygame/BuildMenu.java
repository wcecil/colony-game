/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colonygame;

import UITools.Build;
import UITools.Bulldoze;
import colonygame.resources.BuildingType;
import colonygame.resources.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author WilCecil
 */
public class BuildMenu {

    int x, y, width, height;
    ArrayList<UIButton> myButtons;
    boolean visible;

    public BuildMenu(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        myButtons = new ArrayList<>();
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void update() {
        //int _x;
        int _y;


        Sprite s;
        Image img;
        ArrayList<UIButton> uiButts;

        Color c = Color.DARK_GRAY;

        uiButts = Main.ui.getButtons();
        uiButts.removeAll(myButtons);

        if (isVisible()) {

            //_x = 0;
            _y = 0;


            //\/\/\/\/\/\/\/\/\/\/\/\/\
            // -- MAKE BUTTONS --
            //\/\/\/\/\/\/\/\/\/\/\/\/\s
            ArrayList<BuildingType> builds = Main.game.getBuildables();



            for (int i = 0; i < builds.size(); i++) {
                final UIButton btn;
                final BuildingType temp;
                //get sprite image
                temp = builds.get(i);

                s = temp.getSprite();

                img = s.getCell(temp.getSpriteX(), temp.getSpriteY());


                //
                btn = new UIButtonSprite(x, y + _y, temp.getId(), c,
                        Color.red, img, null);

                btn.setActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Main.ui.setCurrentTool(new Build(btn, temp));
                    }
                });



                Main.ui.addButton(btn);


                //change color
                if ((i & 1) == 0) {
                    c = c.darker();
                } else {
                    c = c.brighter();
                }


                _y += img.getHeight(null);

            }

        }

        Main.ui.forceRepaint();
    }

    /**
     *
     * @param g
     */
    public void render(Graphics g) {
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
