import dk.sdu.vkp.common.services.CollisionProcessingService;

module CollisionEngine {
    requires Common;

    provides CollisionProcessingService with dk.sdu.vkp.collision.BasicCollisionProcessingService;
}