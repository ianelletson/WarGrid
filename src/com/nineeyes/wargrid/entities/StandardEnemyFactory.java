package com.nineeyes.wargrid.entities;

/**
 * com.nineeyes.wargrid.entities
 */
public class StandardEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy(int ID) {
        Enemy enemy = null;
        switch (ID) {
            case 2:
                enemy = new Dummy();
                break;
        }
        return enemy;
    }
}
