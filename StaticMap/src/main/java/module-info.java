import dk.sdu.vkp.common.map.Map;

module StaticMap {
    requires javafx.graphics;
    requires CommonMap;

    provides Map with dk.sdu.vkp.map.NebulaMap;
}