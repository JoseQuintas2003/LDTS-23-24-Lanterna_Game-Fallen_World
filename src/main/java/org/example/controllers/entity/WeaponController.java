package org.example.controllers.entity;

import org.example.Game;
import org.example.controllers.GameController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.entities.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeaponController extends GameController {

    private boolean createdAR;
    private boolean createdMG;
    private boolean createdRPG;

    public WeaponController(Arena arena) {
        super(arena);
        this.createdAR = false;
        this.createdMG = false;
        this.createdRPG = false;
    }

    public void createWeapon(int score) {
        int randomX = (int) (Math.random() * (getModel().getWidth() - 2)) + 1;
        int randomY = (int) (Math.random() * (getModel().getHeight() - 6)) + 5;

        while (!getModel().isEmpty(new Position(randomX, randomY))) {
            randomX = (int) (Math.random() * (getModel().getWidth() - 2)) + 1;
            randomY = (int) (Math.random() * (getModel().getHeight() - 6)) + 5;
        }

        if (score >= 200 && score < 400 && !createdAR) {
            getModel().addWeapon(new Weapon(randomX, randomY, 10, 30, "Assault Rifle"));
            createdAR = true;
        }
        else if (score >= 400 && score < 600 && !createdMG){
            getModel().addWeapon(new Weapon(randomX, randomY,5, 100, "Machine Gun"));
            createdMG = true;
        }
        else if (score >= 600 && score < 800 && !createdRPG){
            getModel().addWeapon(new Weapon(randomX, randomY, 30, 3, "Rocket Launcher"));
            createdRPG = true;
        }
    }

    public void setMaxProjectiles(String weaponName) {
        switch (weaponName) {
            case "Assault Rifle" -> getModel().getPlayer().setMaxProjectiles(5);
            case "Machine Gun" -> getModel().getPlayer().setMaxProjectiles(10);
            case "Rocket Launcher" -> getModel().getPlayer().setMaxProjectiles(1);
        }
    }

    @Override
    public void step(Game game, GUI.GUI_ACTION action, long time) throws IOException {
        int score = getModel().getPlayer().getScore();
        List<Weapon> weaponsToRemove = new ArrayList<>();

        createWeapon(score);

        for (Weapon weapon : getModel().getWeaponsList()) {
            if (weapon.getPosition().equals(getModel().getPlayer().getPosition())) {
                getModel().getPlayer().setCurrentWeapon(weapon);
                getModel().getPlayer().setMaxBulletCount(weapon.getAmmo());
                getModel().getPlayer().setCurrentBulletCount(weapon.getAmmo());
                weaponsToRemove.add(weapon);
                setMaxProjectiles(weapon.getName());
            }
        }

        for (Weapon weapon : weaponsToRemove) {
            getModel().removeWeapon(weapon);
        }
    }
}
