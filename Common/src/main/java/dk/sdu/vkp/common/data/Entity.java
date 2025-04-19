package dk.sdu.vkp.common.data;

import java.util.UUID;

public class Entity {
    private final UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }
}