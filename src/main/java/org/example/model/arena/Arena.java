package org.example.model.arena;

import org.example.model.Position;
import org.example.model.entities.*;
import org.example.model.arena.Arena;
import org.example.model.entities.powerups.Powerup;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width, height;

    private Player player;

    private List<Enemy> enemiesList;
    private List<Wall> wallList;
    private List<Projectile> projectileList;

    private ArrayList<Weapon> weaponsList;

    private ArrayList<Powerup> powerupsList;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.projectileList = new ArrayList<Projectile>();
        this.enemiesList = new ArrayList<Enemy>();
        this.wallList = new ArrayList<Wall>();
        this.powerupsList = new ArrayList<Powerup>();
        this.weaponsList = new ArrayList<Weapon>();
    }

    //Getter Methods
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    //Player Methods
    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //Enemy List Methods
    public List<Enemy> getEnemiesList() {
        return this.enemiesList;
    }

    public void addEnemy(Enemy enemy) { this.enemiesList.add(enemy); }

    public void setEnemyList(List<Enemy> enemies) {
        this.enemiesList = enemies;
    }

    public void removeEnemy(Enemy enemy) {
        this.enemiesList.remove(enemy);
    }

    //Wall List Methods

    public List<Wall> getWallList() {
        return this.wallList;
    }

    public void setWallList(List<Wall> wallList) {
        this.wallList = wallList;
    }

    //Projectile List Methods
    public List<Projectile> getProjectileList() {
        return this.projectileList;
    }

    public void addProjectile(Projectile projectile) {
        this.projectileList.add(projectile);
    }

    public void removeProjectile(Projectile projectile) {
        this.projectileList.remove(projectile);
    }

    public int countProjectiles() {
        return this.projectileList.size();
    }

    //Powerup List Methods

    public List<Powerup> getPowerupsList() {
        return this.powerupsList;
    }

    public void setPowerupsList(ArrayList<Powerup> powerupsList) {
        this.powerupsList = powerupsList;
    }

    public void addPowerup(Powerup powerup) {
        this.powerupsList.add(powerup);
    }

    public void removePowerup(Powerup powerup) {
        this.powerupsList.remove(powerup);
    }

    //Weapon List Methods

    public ArrayList<Weapon> getWeaponsList() {
        return this.weaponsList;
    }

    public void addWeapon(Weapon weapon) {
        this.weaponsList.add(weapon);
    }

    public void removeWeapon(Weapon weapon) {
        this.weaponsList.remove(weapon);
    }

    //Other Methods

    public boolean isEnemy(Position position) {
        if (enemiesList == null) return false;

        for (Enemy enemy : enemiesList)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isWall(Position position) {
        for (Wall wall : wallList)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isPowerup(Position position) {
        if (powerupsList == null) return false;

        for (Powerup powerup : powerupsList)
            if (powerup.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isWeapon(Position position) {
        if (weaponsList == null) return false;

        for (Weapon weapon : weaponsList)
            if (weapon.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isProjectile(Position position) {
        if (projectileList == null) return false;

        for (Projectile projectile : projectileList)
            if (projectile.getPosition().equals(position))
                return true;
        return false;
    }


    //Returns true if the position is not a wall, enemy, npc, projectile, weapon, powerup or player and false otherwise
    public boolean isEmpty(Position position) {
        return !isPowerup(position) && !isWeapon(position) && !isProjectile(position) && !isWall(position) && !isEnemy(position) && !player.getPosition().equals(position);
    }
}
