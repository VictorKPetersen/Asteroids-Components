package dk.sdu.vkp.splitterasteroid;

import dk.sdu.vkp.common.components.impl.BasicPositionComponent;
import dk.sdu.vkp.common.components.impl.CircleDrawingComponent;
import dk.sdu.vkp.common.components.impl.CircularHitboxComponent;
import dk.sdu.vkp.common.components.impl.LinearMovementComponent;
import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.MovementComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.services.PluginStarterService;

import java.util.Random;

public class SplitterAsteroidPluginStarterService implements PluginStarterService {
    private final static Random random = new Random();
    @Override
    public void start(GameData gameData) {
        SplitterAsteroid splitter = createSplitter();
        System.out.println(splitter.getSize());
        gameData.getEntities().addEntity(splitter);
    }

    private SplitterAsteroid createSplitter() {
        double asteroidRadius = random.nextDouble(30, 50);
        int asteroidLayers = random.nextInt(1, 3) + 1;
        double spawnX = 435;
        double spawnY = 250;
        double spawnRotation = 67;
        PositionComponent pos = new BasicPositionComponent(spawnX, spawnY, spawnRotation);
        DrawingComponent draw = new CircleDrawingComponent(SplitterAsteroid.getColor());
        HitboxComponent hitbox = new CircularHitboxComponent(asteroidRadius * asteroidLayers);
        MovementComponent movement = new LinearMovementComponent(SplitterAsteroid.getSpeed(), SplitterAsteroid.getRotationSpeed());

        return new SplitterAsteroid(
                pos, draw, hitbox, movement, asteroidRadius, asteroidLayers
        );
    }
}
