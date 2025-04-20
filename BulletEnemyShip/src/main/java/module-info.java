import dk.sdu.vkp.common.services.DrawingService;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.services.ProcessingService;

module BulletEnemyShip {
    uses dk.sdu.vkp.common.weapon.WeaponComponent;
    requires Common;
    requires CommonWeapon;
    requires CommonEnemy;
    requires javafx.graphics;

    provides ProcessingService with dk.sdu.vkp.bulletship.BulletShipProcessingService;
    provides DrawingService with dk.sdu.vkp.bulletship.BulletShipDrawingService;
    provides PluginStarterService with dk.sdu.vkp.bulletship.BulletShipPluginStarterService;
}