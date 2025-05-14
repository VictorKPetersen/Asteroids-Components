package dk.sdu.vkp.main;

import dk.sdu.vkp.common.map.Map;
import dk.sdu.vkp.common.services.CollisionProcessingService;
import dk.sdu.vkp.common.services.DrawingService;
import dk.sdu.vkp.common.services.PluginStarterService;
import dk.sdu.vkp.common.services.ProcessingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@Configuration
public class ModuleConfig {
    public ModuleConfig() {}

    @Bean
    public Game game() {
        Game game = new Game();

        game.setPluginStarterServices(pluginStarterServiceList());
        game.setProcessingServices(processingServiceList());
        game.setDrawingServices(drawingServiceList());

        game.setCollisionProcessingService(collisionProcessingService());
        game.setMapService(mapService());

        return game;
    }

    @Bean
    public List<PluginStarterService> pluginStarterServiceList() {
        return ServiceLoader.load(PluginStarterService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

    @Bean
    public List<ProcessingService> processingServiceList() {
        return ServiceLoader.load(ProcessingService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

    @Bean
    public List<DrawingService> drawingServiceList() {
        return ServiceLoader.load(DrawingService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

    @Bean
    @Nullable
    public CollisionProcessingService collisionProcessingService() {
        return ServiceLoader.load(CollisionProcessingService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .findFirst()
                .orElse(null);
    }

    @Bean
    @Nullable
    public Map mapService() {
        return ServiceLoader.load(Map.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .findFirst()
                .orElse(null);
    }
}
