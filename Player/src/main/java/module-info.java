import dk.sdu.vkp.common.services.DrawingService;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.services.ProcessingService;

module Player {
    uses dk.sdu.vkp.common.weapon.WeaponComponent;
    requires javafx.graphics;
    requires Common;
    requires CommonWeapon;

    provides ProcessingService with dk.sdu.vkp.player.PlayerProcessingService;
    provides PluginStarterService with dk.sdu.vkp.player.PlayerPluginStarterService;
    provides DrawingService with dk.sdu.vkp.player.PlayerDrawingService;
}