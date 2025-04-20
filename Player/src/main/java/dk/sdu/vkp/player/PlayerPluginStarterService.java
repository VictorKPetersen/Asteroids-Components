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
import dk.sdu.vkp.player.components.PlayerInputComponent;
import javafx.scene.paint.Color;

public class PlayerPluginStarterService implements PluginStarterService {
    @Override
    public void start(final GameData gameData) {
        Player player = createPlayer();
        gameData.getEntities().addEntity(player);
    }

    private Player createPlayer() {
        int playerSpawnY = 100;
        int playerSpawnX = 100;
        double playerSpeed = 10;
        double playerRotationSpeed = 5;

        PositionComponent playerPosition =
                new BasicPositionComponent(playerSpawnX, playerSpawnY, 0);
        DrawingComponent playerDrawingComponent =
                new TriangleDrawingComponent(Color.GREEN);
        MovementComponent playerMovementComponent =
                new LinearMovementComponent(playerSpeed, playerRotationSpeed);
        InputComponent playerInputComponent =
                new PlayerInputComponent(playerMovementComponent);


        return new Player(
                playerPosition, playerDrawingComponent,
                playerInputComponent, playerMovementComponent
        );

    }
}