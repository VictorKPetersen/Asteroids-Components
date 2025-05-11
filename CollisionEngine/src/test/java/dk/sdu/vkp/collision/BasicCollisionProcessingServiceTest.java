package dk.sdu.vkp.collision;

import dk.sdu.vkp.common.asteroid.Asteroid;
import dk.sdu.vkp.common.components.interfaces.HitboxComponent;
import dk.sdu.vkp.common.components.interfaces.PositionComponent;
import dk.sdu.vkp.common.data.Entity;
import dk.sdu.vkp.common.data.GameData;
import dk.sdu.vkp.common.data.GameEntities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BasicCollisionProcessingServiceTest {
    private BasicCollisionProcessingService SUT;

    private GameData gameData;
    private GameEntities entities;

    private Asteroid a1;
    private Asteroid a2;

    private Entity e1;
    private Entity e2;

    private PositionComponent pos1;
    private PositionComponent pos2;

    private HitboxComponent hitbox1;
    private HitboxComponent hitbox2;

    @BeforeEach
    void setUp() {
        SUT = new BasicCollisionProcessingService();

        e1 = mock(Entity.class);
        e2 = mock(Entity.class);

        pos1 = mock(PositionComponent.class);
        pos2 = mock(PositionComponent.class);

        hitbox1 = mock(HitboxComponent.class);
        hitbox2 = mock(HitboxComponent.class);

        when(e1.getPosition()).thenReturn(pos1);
        when(e2.getPosition()).thenReturn(pos2);

        when(e1.getHitbox()).thenReturn(hitbox1);
        when(e2.getHitbox()).thenReturn(hitbox2);

        gameData = mock(GameData.class);
        entities = mock(GameEntities.class);

        when(gameData.getEntities()).thenReturn(entities);

        a1 = mock(Asteroid.class);
        a2 = mock(Asteroid.class);
    }

    @Nested
    class processTests {
        @Test
        void processShouldThrowWhenEntitiesIsNull() {
            when(entities.getEntities()).thenReturn(null);
            assertThrows(NullPointerException.class,
                    () -> SUT.processCollisions(gameData));
        }

        @Test
        void processShouldThrowWhenEntityHitboxIsNull() {
            when(entities.getEntities()).thenReturn(List.of(e1, e2));
            when(e1.getHitbox()).thenReturn(null);
            assertThrows(NullPointerException.class,
                    () -> SUT.processCollisions(gameData));
        }

        @Test
        void processShouldNotThrowWhenEntitiesIsEmpty() {
            when(entities.getEntities()).thenReturn(List.of());
            assertDoesNotThrow(() -> SUT.processCollisions(gameData));
        }

        @Test
        void processShouldCallHitboxHitWhenColliding() {
            when(entities.getEntities()).thenReturn(List.of(e1, e2));

            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(5.0);
            when(pos2.getY()).thenReturn(5.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            SUT.processCollisions(gameData);

            verify(hitbox1, atLeast(1)).hit(e1, gameData);
            verify(hitbox2, atLeast(1)).hit(e2, gameData);
        }


        @Test
        void processShouldNotCallHitboxHitWhenNotColliding() {
            when(entities.getEntities()).thenReturn(List.of(e1, e2));

            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(100.0);
            when(pos2.getY()).thenReturn(100.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            SUT.processCollisions(gameData);

            verify(hitbox1, never()).hit(e1, gameData);
            verify(hitbox2, never()).hit(e2, gameData);
        }

        @Test
        void processShouldNotCollideWithItself() {
            when(entities.getEntities()).thenReturn(List.of(e1));

            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            SUT.processCollisions(gameData);

            verify(hitbox1, never()).hit(e1, gameData);
        }

        @Test
        void processShouldNotCollideAsteroidsThatOverlap() {
            when(entities.getEntities()).thenReturn(List.of(a1, a2));

            when(a1.getPosition()).thenReturn(pos1);
            when(a2.getPosition()).thenReturn(pos2);
            when(a1.getHitbox()).thenReturn(hitbox1);
            when(a2.getHitbox()).thenReturn(hitbox2);

            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(a1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(0.0);
            when(pos2.getY()).thenReturn(0.0);
            when(hitbox2.getHitboxRadius(a2)).thenReturn(10.0);

            SUT.processCollisions(gameData);

            verify(hitbox1, never()).hit(a1, gameData);
            verify(hitbox2, never()).hit(a2, gameData);
        }

        @Test
        void processShouldCollideWhenOnlyOneAsteroidIsColliding() {
            when(entities.getEntities()).thenReturn(List.of(a1, e2));
            when(a1.getPosition()).thenReturn(pos1);
            when(a1.getHitbox()).thenReturn(hitbox1);

            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(a1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(0.0);
            when(pos2.getY()).thenReturn(0.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            SUT.processCollisions(gameData);

            verify(hitbox1, atLeast(1)).hit(a1, gameData);
            verify(hitbox2, atLeast(1)).hit(e2, gameData);
        }
    }

    @Nested
    class isCollidingTests {
        @Test
        void isCollidingShouldThrowWhenEntityIsNull() {
            assertThrows(NullPointerException.class, () -> SUT.isColliding(null,
                    e2));
        }

        @Test
        void isCollidingShouldThrowWhenEntityPosIsNull() {
            when(e1.getPosition()).thenReturn(null);
            assertThrows(NullPointerException.class, () -> SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldThrowWhenEntityHitboxIsNull() {
            when(e1.getHitbox()).thenReturn(null);
            assertThrows(NullPointerException.class, () -> SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnFalseWhenEntitiesAreNotColliding() {
            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(100.0);
            when(pos2.getY()).thenReturn(100.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertFalse(SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnTrueWhenEntitiesAreColliding() {
            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(0.0);
            when(pos2.getY()).thenReturn(0.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertTrue(SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnTrueWhenEntitiesHitboxBorder() {
            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(20.0);
            when(pos2.getY()).thenReturn(0.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertTrue(SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnFalseWhenEntitiesHitboxBarelyTouch() {
            when(pos1.getX()).thenReturn(0.0);
            when(pos1.getY()).thenReturn(0.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(20.001);
            when(pos2.getY()).thenReturn(0.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertFalse(SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnFalseWhenNotCollidingNegative() {
            when(pos1.getX()).thenReturn(-10.0);
            when(pos1.getY()).thenReturn(-10.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(-100.0);
            when(pos2.getY()).thenReturn(-100.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertFalse(SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnTrueWhenCollidingNegative() {
            when(pos1.getX()).thenReturn(-10.0);
            when(pos1.getY()).thenReturn(-10.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(-10.0);
            when(pos2.getY()).thenReturn(-10.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertTrue(SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnTrueWhenEntitiesHitboxBorderNegative() {
            when(pos1.getX()).thenReturn(-10.0);
            when(pos1.getY()).thenReturn(-10.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(-30.0);
            when(pos2.getY()).thenReturn(-10.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertTrue(SUT.isColliding(e1, e2));
        }

        @Test
        void isCollidingShouldReturnFalseWhenEntitiesHitboxBarelyTouchNegative() {
            when(pos1.getX()).thenReturn(-10.0);
            when(pos1.getY()).thenReturn(-10.0);
            when(hitbox1.getHitboxRadius(e1)).thenReturn(10.0);

            when(pos2.getX()).thenReturn(-30.001);
            when(pos2.getY()).thenReturn(-10.0);
            when(hitbox2.getHitboxRadius(e2)).thenReturn(10.0);

            assertFalse(SUT.isColliding(e1, e2));
        }
    }
}