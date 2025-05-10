import dk.sdu.vkp.common.map.Map;
import dk.sdu.vkp.map.SpaceMap;

module BlueNebulaMap {
    requires javafx.graphics;
    requires CommonMap;

    provides Map with SpaceMap;
}