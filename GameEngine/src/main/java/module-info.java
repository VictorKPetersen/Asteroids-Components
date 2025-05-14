module GameEngine {
    requires javafx.graphics;
    requires Common;
    requires CommonMap;

    requires spring.context;
    requires spring.core;
    requires spring.beans;

    opens dk.sdu.vkp.main to javafx.graphics, spring.core;

    uses dk.sdu.vkp.common.services.ProcessingService;
    uses dk.sdu.vkp.common.services.PluginStarterService;
    uses dk.sdu.vkp.common.services.DrawingService;
    uses dk.sdu.vkp.common.services.CollisionProcessingService;
    uses dk.sdu.vkp.common.map.Map;

    exports dk.sdu.vkp.main to spring.beans, spring.context;
}