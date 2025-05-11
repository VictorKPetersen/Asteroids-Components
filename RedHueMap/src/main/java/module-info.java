import dk.sdu.vkp.common.map.Map;
import dk.sdu.vkp.starmap.StarFieldMap;

module RedHueMap {
    requires CommonMap;
    requires javafx.graphics;

    provides Map with StarFieldMap;
}