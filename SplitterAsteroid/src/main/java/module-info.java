import dk.sdu.vkp.common.services.DrawingService;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.services.ProcessingService;

module SplitterAsteroid {
    requires Common;
    requires CommonAsteroid;
    requires javafx.graphics;

    provides ProcessingService with dk.sdu.vkp.splitterasteroid.SplitterAsteroidProcessingService;
    provides DrawingService with dk.sdu.vkp.splitterasteroid.SplitterAsteroidDrawingService;
    provides PluginStarterService with dk.sdu.vkp.splitterasteroid.SplitterAsteroidPluginStarterService;
}