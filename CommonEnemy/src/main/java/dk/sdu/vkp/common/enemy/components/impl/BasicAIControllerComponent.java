package dk.sdu.vkp.common.enemy.components.impl;

import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.enemy.Enemy;
import dk.sdu.vkp.common.enemy.components.interfaces.AIControllerComponent;
import dk.sdu.vkp.common.weapon.WeaponComponent;

public class BasicAIControllerComponent implements AIControllerComponent {
    private double targetAngle;
    private float timeUntilChange;

    /**
     * Construct a new controller component.
     * Randomly sets the start direction.
     */
    public BasicAIControllerComponent() {
        randomizeDirection();
    }

    @Override
    public void update(final Enemy enemy,
                       final GameData gameData) {
        timeUntilChange -= 1000/60000f; // Simplify Delta Time as we are not interested in that.
        if (timeUntilChange <= 0) {
            randomizeDirection();
        }
        moveEnemy(enemy.getPosition(), enemy.getMovementComponent());
        if (Math.random() < 0.01) {
            attack(enemy, gameData);
        }
    }


    private void moveEnemy(final PositionComponent pos,
                           final MovementComponent movement) {
        double currentAngle = pos.getRotation();
        double angleDiff = ((targetAngle - currentAngle + 540) % 360) - 180;
        if (angleDiff > 5) {
            movement.rotateRight(pos);
        } else if (angleDiff < -5) {
            movement.rotateLeft(pos);
        } else {
            movement.moveForward(pos);
        }
    }

    private void attack(final Enemy enemy, final GameData gameData) {
        WeaponComponent weapon = enemy.getWeaponComponent();
        if (weapon != null) {
            PositionComponent pos = enemy.getPosition();
            double radians = Math.toRadians(pos.getRotation());

            double spawnX = pos.getX() + Math.cos(radians) * weapon.getOffsetX();
            double spawnY = pos.getY() + Math.sin(radians) * weapon.getOffsetY();

            PositionComponent spawnPos = new BasicPositionComponent(spawnX, spawnY, pos.getRotation());
            weapon.fire(gameData, spawnPos);
        }
    }

    private void randomizeDirection() {
        this.targetAngle = Math.random() * 360;
        this.timeUntilChange = 1 + (float) Math.random() * 2; // 1 - 3 seconds
    }

}
