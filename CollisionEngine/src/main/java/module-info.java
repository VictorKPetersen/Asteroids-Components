import dk.sdu.vkp.common.services.CollisionProcessingService;

module CollisionEngine {
    requires Common;
    requires CommonAsteroid;

    provides CollisionProcessingService with dk.sdu.vkp.collision.BasicCollisionProcessingService;
}