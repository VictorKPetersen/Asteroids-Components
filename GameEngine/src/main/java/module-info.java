module GameEngine {
    requires javafx.graphics;
    requires Common;
    requires CommonMap;

    opens dk.sdu.vkp.main to javafx.graphics;

    uses dk.sdu.vkp.common.services.ProcessingService;
    uses dk.sdu.vkp.common.services.PluginStarterService;
    uses dk.sdu.vkp.common.services.DrawingService;
    uses dk.sdu.vkp.common.services.CollisionProcessingService;
    uses dk.sdu.vkp.common.map.Map;
}