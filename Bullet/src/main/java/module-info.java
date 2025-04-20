import dk.sdu.vkp.common.services.DrawingService;
import dk.sdu.vkp.common.services.ProcessingService;
import dk.sdu.vkp.common.weapon.WeaponComponent;

module Bullet {
    requires Common;
    requires CommonWeapon;
    requires javafx.graphics;

    provides DrawingService with dk.sdu.vkp.bullet.BulletDrawingService;
    provides ProcessingService with dk.sdu.vkp.bullet.BulletProcessingService;

    provides WeaponComponent with dk.sdu.vkp.bullet.BulletWeaponComponent;
}