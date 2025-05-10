package dk.sdu.vkp.collision;

import dk.sdu.vkp.common.asteroid.Asteroid;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameEntities;
import dk.sdu.vkp.common.services.CollisionProcessingService;

/**
 * A simple implementation of collision.
 * Does not check collision between asteroids,
 * and is based upon the hitboxes being circular.
 */
public class BasicCollisionProcessingService implements CollisionProcessingService {
    @Override
    public void processCollisions(final GameData gameData) {
        GameEntities entities = gameData.getEntities();
        for (Entity entity1 : entities.getEntities()) {
            for (Entity entity2 : entities.getEntities()) {
                if (entity1 == entity2) {
                    continue;
                }

                if (entity1 instanceof Asteroid && entity2 instanceof Asteroid) {
                    continue;
                }

                if (isColliding(entity1, entity2)) {
                    entity1.getHitbox().hit(entity1, gameData);
                    entity2.getHitbox().hit(entity2, gameData);
                }
            }
        }
    }


    /**
     * Checks if two entities are colliding.
     * All entities must have a valid
     * {@link dk.sdu.vkp.common.components.interfaces.HitboxComponent}.
     * @param a A non-null instance of {@link Entity}.
     * @param b A non-null instance of {@link Entity}.
     * @return True, if the entities are colliding, else false.
     */
    public boolean isColliding(final Entity a,
                               final Entity b) {
        PositionComponent posA = a.getPosition();
        PositionComponent posB = b.getPosition();

        double dx = posA.getX() - posB.getX();
        double dy = posA.getY() - posB.getY();
        double distanceSquared = dx * dx + dy * dy;

        double radiusSum = a.getHitbox().getHitboxRadius(a) + b.getHitbox().getHitboxRadius(b);

        return distanceSquared <= radiusSum * radiusSum;
    }
}
