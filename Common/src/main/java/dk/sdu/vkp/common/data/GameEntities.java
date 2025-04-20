package dk.sdu.vkp.common.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GameEntities {
    private final Map<UUID, Entity> entities = new HashMap<>();

    /**
     * Adds an entity to the game.
     * @param entity    The {@link Entity} to be added.
     */
    public void addEntity(final Entity entity) {
       entities.put(entity.getId(), entity);
    }

    /**
     * Removes an entity from the game.
     * @param entity    The {@link Entity} to be removed.
     */
    public void removeEntity(final Entity entity) {
        entities.remove(entity.getId());
    }

    /**
     * Gets a list of all entities in the game.
     * @return a populated list of all entities, empty if none are found.
     */
    public List<Entity> getEntities() {
       return new ArrayList<>(entities.values());
    }

    /**
     * Clears all entities from the game.
     */
    public void clearEntities() {
        entities.clear();
    }

    /**
     * Retrieves a list of entities from the Game
     * that matches the specified class type.
     * @param <E>   The type of entity to retrieve, must extend {@link Entity}.
     * @param entityClass The class type of Entities to filter.
     * @return A list of entities which are an instance of the specified type.
     */
    public <E extends Entity> List<E> getEntities(final Class<E> entityClass) {
        List<E> result = new ArrayList<>();
        for (Entity e : entities.values()) {
            if (entityClass.isInstance(e)) {
                result.add(entityClass.cast(e));
            }
        }
        return result;
    }
}
