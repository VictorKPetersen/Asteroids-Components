package dk.sdu.vkp.player;

import dk.sdu.vkp.common.components.impl.LinearMovementComponent;
import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.impl.TriangleDrawingComponent;
import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.InputComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.weapon.WeaponComponent;
import dk.sdu.vkp.player.components.PlayerInputComponent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PlayerPluginStarterService implements PluginStarterService {
    @Override
    public void start(final GameData gameData) {
        Player player = createPlayer();
        gameData.getEntities().addEntity(player);
    }

    private Player createPlayer() {
        double playerSize = 15;
        int playerSpawnY = 100;
        int playerSpawnX = 100;
        double playerSpeed = 10;
        double playerRotationSpeed = 5;

        WeaponComponent weaponComponent = findFirstWeapon();
        PositionComponent playerPosition =
                new BasicPositionComponent(playerSpawnX, playerSpawnY, 0);
        DrawingComponent playerDrawingComponent =
                new TriangleDrawingComponent(Color.GREEN);
        MovementComponent playerMovementComponent =
                new LinearMovementComponent(playerSpeed, playerRotationSpeed);
        InputComponent playerInputComponent =
                new PlayerInputComponent(playerMovementComponent, weaponComponent);


        return new Player(
                playerSize, playerPosition, playerDrawingComponent,
                playerInputComponent, playerMovementComponent, weaponComponent
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