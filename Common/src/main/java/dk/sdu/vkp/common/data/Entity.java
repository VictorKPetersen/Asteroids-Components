package dk.sdu.vkp.common.data;

import dk.sdu.vkp.common.components.interfaces.DrawingComponent;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;

import java.util.UUID;

public class Entity {
    private final UUID id = UUID.randomUUID();
    private final double size;
    private final PositionComponent position;
    private final DrawingComponent drawingComponent;
    private final HitboxComponent hitbox;

    /**
     * Constructs a new Entity instance with
     * the specified position and drawing components.
     *
     * @param position The {@link PositionComponent}
     *                that defines the position and rotation of the entity.
     * @param drawingComponent The {@link DrawingComponent}
     *                        responsible for rendering the entity.
     * @param hitbox The {@link HitboxComponent} used for collision detection.
     */
    public Entity(double size, final PositionComponent position,
                  final DrawingComponent drawingComponent, final HitboxComponent hitbox) {
        this.size = size;
        this.position = position;
        this.drawingComponent = drawingComponent;
        this.hitbox = hitbox;
    }

    public UUID getId() {
        return id;
    }

    public PositionComponent getPosition() {
        return position;
    }

    public DrawingComponent getDrawingComponent() {
        return drawingComponent;
    }

    public HitboxComponent getHitbox() {
        return hitbox;
    }

    public double getSize() {
        return size;
    }

}