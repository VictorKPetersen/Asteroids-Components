package dk.sdu.vkp.common.services;

import dk.sdu.vkp.common.data.GameData;

/**
 * Defines the service for handling collisions.
 * Importantly, is run after other updates.
 */
public interface CollisionProcessingService {
    /**
     * Processes collisions between entities in the game.
     * This should run after {@link ProcessingService#process(GameData)}} is called.
     * Pre: The gameData parameter must not be null
     * Pre: The gameData.getEntities() must not be null
     * Pre: All entities in gameData must have a valid HitboxComponent
     * Post: All collisions between entities are detected and processed
     * Post: Entities that have collided have their takeHit method called
     * Post: The state of the game reflects all collision outcomes
     *
     * @param gameData the non-null gameData with entity information.
     */
    void processCollisions(GameData gameData);
}
