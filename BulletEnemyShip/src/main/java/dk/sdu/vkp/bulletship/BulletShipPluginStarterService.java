package dk.sdu.vkp.bulletship;

import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.impl.CircularHitboxComponent;
import dk.sdu.vkp.common.components.impl.LinearMovementComponent;
import dk.sdu.vkp.common.components.impl.TriangleDrawingComponent;
import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.enemy.components.impl.BasicAIControllerComponent;
import dk.sdu.vkp.common.enemy.components.interfaces.AIControllerComponent;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.weapon.WeaponComponent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class BulletShipPluginStarterService implements PluginStarterService {
    @Override
    public void start(final GameData gameData) {
        gameData.getEntities().addEntity(createBulletShiop(750, 500, 25));
        gameData.getEntities().addEntity(createBulletShiop(1020, 380, 75));
    }

    private BulletShip createBulletShiop(final double spawnX,
                                         final double spawnY,
                                         final double spawnRotation) {
        double shipSize = 25;
        PositionComponent position = new BasicPositionComponent(spawnX, spawnY, spawnRotation);
        DrawingComponent drawingComponent = new TriangleDrawingComponent(Color.RED);
        MovementComponent movement = new LinearMovementComponent(7.5, 2.5);
        AIControllerComponent ai = new BasicAIControllerComponent();
        WeaponComponent weapon = findFirstWeapon();
        HitboxComponent hitbox = new CircularHitboxComponent(shipSize);

        return new BulletShip(
                shipSize, position, drawingComponent, movement, ai, weapon, hitbox
        );
    }

    /**
     * Finds any registered {@link WeaponComponent} and returns the first one.
     * @return The first found {@link WeaponComponent}, will be null if none are found.
     */
    private WeaponComponent findFirstWeapon() {
        List<WeaponComponent> loadedWeapons = new ArrayList<>();
        for (WeaponComponent weapon : ServiceLoader.load(WeaponComponent.class)) {
            loadedWeapons.add(weapon);
        }

        if (loadedWeapons.isEmpty()) {
            return null;
        }
        return loadedWeapons.getFirst();
    }
}