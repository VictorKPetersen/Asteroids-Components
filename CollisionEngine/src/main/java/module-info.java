import dk.sdu.vkp.common.services.CollisionProcessingService;

/**
 * Provides the implementation for detecting collisions between entities.
 */
module CollisionEngine {
    requires Common;
    requires CommonAsteroid;

    provides CollisionProcessingService with dk.sdu.vkp.collision.BasicCollisionProcessingService;
}