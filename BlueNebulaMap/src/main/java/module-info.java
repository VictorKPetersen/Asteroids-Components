import dk.sdu.vkp.common.map.Map;

module BlueNebulaMap {
    requires javafx.graphics;
    requires CommonMap;

    provides Map with dk.sdu.vkp.map.NebulaMap;
}