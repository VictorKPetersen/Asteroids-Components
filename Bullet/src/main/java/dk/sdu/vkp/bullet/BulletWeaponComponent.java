package dk.sdu.vkp.bullet;

import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.impl.CircleDrawingComponent;
import dk.sdu.vkp.common.components.impl.LinearMovementComponent;
import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.weapon.WeaponComponent;
import javafx.scene.paint.Color;

public class BulletWeaponComponent implements WeaponComponent {
    @Override
    public void fire(GameData gameData, PositionComponent spawnPosition) {
        double bulletRadius = 15;
        double bulletSpeed = 15;
        double bulletRotationSpeed = 10;

        PositionComponent positionComponent = new BasicPositionComponent(spawnPosition.getX(), spawnPosition.getY(), spawnPosition.getRotation());
        DrawingComponent drawingComponent = new CircleDrawingComponent(Color.MAROON);
        MovementComponent movementComponent = new LinearMovementComponent(bulletSpeed, bulletRotationSpeed);
        Bullet bullet = new Bullet(
                bulletRadius, positionComponent, drawingComponent, movementComponent
        );

        gameData.getEntities().addEntity(bullet);
    }
}