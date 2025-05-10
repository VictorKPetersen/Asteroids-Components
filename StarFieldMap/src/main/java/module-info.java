import dk.sdu.vkp.common.map.Map;
import dk.sdu.vkp.starmap.StarFieldMap;

module StarFieldMap {
    requires CommonMap;
    requires javafx.graphics;

    provides Map with StarFieldMap;
}