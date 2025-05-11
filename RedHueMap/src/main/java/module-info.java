import dk.sdu.vkp.common.map.Map;
import dk.sdu.vkp.map.SpaceMap;

module RedHueMap {
    requires CommonMap;
    requires javafx.graphics;

    provides Map with SpaceMap;
}