import dk.sdu.vkp.common.map.Map;
import dk.sdu.vkp.map.SpaceMap;

module StarFieldMap {
    requires CommonMap;
    requires javafx.graphics;

    provides Map with SpaceMap;
}