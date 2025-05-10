package dk.sdu.vkp.bullet;

import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.impl.CircleDrawingComponent;
import dk.sdu.vkp.common.components.impl.CircularHitboxComponent;
import dk.sdu.vkp.common.components.impl.LinearMovementComponent;
import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.weapon.Projectile;
import dk.sdu.vkp.common.weapon.WeaponComponent;
import javafx.scene.paint.Color;

public class BulletWeaponComponent implements WeaponComponent {
    private final Projectile projectile;

    /**
     * Constructor for the weapon component.
     * Creates the template for the bullet it will fire.
     */
    public BulletWeaponComponent() {
        this.projectile = createProjectile(new BasicPositionComponent(0, 0, 0));
    }
    @Override
    public void fire(final GameData gameData, final PositionComponent spawnPosition) {
        gameData.getEntities().addEntity(createProjectile(spawnPosition));
    }

    @Override
    public double getOffsetX() {
        return projectile.getSize() * 2 + 5;
    }

    @Override
    public double getOffsetY() {
        return projectile.getSize() * 2 + 5;
    }

    private Projectile createProjectile(final PositionComponent spawnPosition) {
        double bulletRadius = 15;
        double bulletSpeed = 15;
        double bulletRotationSpeed = 10;

        PositionComponent positionComponent =
                new BasicPositionComponent(spawnPosition.getX(), spawnPosition.getY(), spawnPosition.getRotation());
        DrawingComponent drawingComponent = new CircleDrawingComponent(Color.MAROON);
        MovementComponent movementComponent = new LinearMovementComponent(bulletSpeed, bulletRotationSpeed);
        HitboxComponent hitboxComponent = new CircularHitboxComponent(bulletRadius);

        return new Bullet(
                bulletRadius, positionComponent, drawingComponent, movementComponent, hitboxComponent
        );
    }
}