package by.balashevich.shapeapp.warehouse;

import by.balashevich.shapeapp.entity.QuadrangleCharacteristic;
import by.balashevich.shapeapp.exception.ShapeProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleWarehouse {
    private static Logger logger = LogManager.getLogger();
    private static QuadrangleWarehouse instance;
    private Map<Long, QuadrangleCharacteristic> characteristicList;

    private QuadrangleWarehouse() {
        characteristicList = new HashMap<>();
    }

    public static QuadrangleWarehouse getInstance() {
        if (instance == null) {
            instance = new QuadrangleWarehouse();
        }

        return instance;
    }

    public void putCharacteristic(long id, QuadrangleCharacteristic parameters) {
        characteristicList.put(id, parameters);
        logger.log(Level.INFO, "Quadrangle id {}, {} placed into warehouse", id, parameters);
    }

    public QuadrangleCharacteristic getCharacteristic(long id) {
        QuadrangleCharacteristic quadrangleCharacteristic = characteristicList.get(id);
        logger.log(Level.INFO, "Quadrangle id {}, {} selected from the warehouse", id, quadrangleCharacteristic);

        return quadrangleCharacteristic;
    }

    public QuadrangleCharacteristic removeCharacteristic(long id) throws ShapeProjectException {
        QuadrangleCharacteristic removedCharacteristic = characteristicList.remove(id);
        logger.log(Level.INFO, "Quadrangle id {}, {} removed from the warehouse", id, removedCharacteristic);

        return removedCharacteristic;
    }
}
