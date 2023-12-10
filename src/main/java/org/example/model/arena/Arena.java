package org.example.model.arena;

import org.example.model.Position;
import org.example.model.entities.Enemy;
import org.example.model.entities.Player;
import org.example.model.entities.NPC;
import org.example.model.entities.Wall;
import org.example.model.entities.Projectile;
import org.example.model.arena.Arena;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width, height;

    private Player player;

    private List<Enemy> enemiesList;
    private List<NPC> NPCsList;
    private List<Wall> wallList;
    private List<Projectile> projectileList;

    //Constructor
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.projectileList = new ArrayList<Projectile>();
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

    //NPC List Methods
    public List<NPC> getNPCsList() {
        return this.NPCsList;
    }

    public void setNPCsList(List<NPC> NPCsList) {
        this.NPCsList = NPCsList;
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

    //Other Methods

    public boolean isEnemy(Position position) {
        if (enemiesList == null)
            return false;

        for (Enemy enemy : enemiesList)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isNPC(Position position) {
        if (NPCsList == null)
            return false;

        for (NPC npc : NPCsList)
            if (npc.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isWall(Position position) {
        for (Wall wall : wallList)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }
    //Returns true if the position is not a wall, enemy, npc or player and false otherwise
    public boolean isEmpty(Position position) {
        return !isWall(position) && !isEnemy(position) && !isNPC(position) && !player.getPosition().equals(position);
    }
}
