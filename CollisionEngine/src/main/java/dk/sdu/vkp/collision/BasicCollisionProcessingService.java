package dk.sdu.vkp.collision;

import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameEntities;
import dk.sdu.vkp.common.services.CollisionProcessingService;

public class BasicCollisionProcessingService implements CollisionProcessingService {
    @Override
    public void processCollisions(final GameData gameData) {
        GameEntities entities = gameData.getEntities();
        for (Entity entity1 : entities.getEntities()) {
            for (Entity entity2 : entities.getEntities()) {
                if (entity1 == entity2) {
                    continue;
                }

                if (isColliding(entity1, entity2)) {
                    entities.removeEntity(entity1);
                    entities.removeEntity(entity2);
                }
            }
        }
    }


    public boolean isColliding(Entity a, Entity b) {
        PositionComponent posA = a.getPosition();
        PositionComponent posB = b.getPosition();

        double dx = posA.getX() - posB.getX();
        double dy = posA.getY() - posB.getY();
        double distanceSquared = dx * dx + dy * dy;

        double radiusSum = a.getHitbox().getHitboxRadius(a) + b.getHitbox().getHitboxRadius(b);

        return distanceSquared <= radiusSum * radiusSum;
    }
}
