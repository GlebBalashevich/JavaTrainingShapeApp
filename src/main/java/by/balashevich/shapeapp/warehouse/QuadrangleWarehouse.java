package by.balashevich.shapeapp.warehouse;

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

    private QuadrangleWarehouse (){
        characteristicList = new HashMap<>();
    }

    public static QuadrangleWarehouse getInstance(){
        if (instance == null){
            instance = new QuadrangleWarehouse();
        }

        return instance;
    }

    public QuadrangleCharacteristic putCharacteristic(long id, QuadrangleCharacteristic parameters) throws ShapeProjectException {
        QuadrangleCharacteristic placedCharacteristic = characteristicList.put(id, parameters);

        if (placedCharacteristic == null){
            throw new ShapeProjectException("Error while placing characteristic into warehouse");
        }
        logger.log(Level.INFO, "Quadrangle id {}, {} placed into warehouse", id, placedCharacteristic);

        return characteristicList.put(id, parameters);
    }

    public QuadrangleCharacteristic getCharacteristic(long id) throws ShapeProjectException {
        QuadrangleCharacteristic quadrangleCharacteristic;

        if (characteristicList.containsKey(id)){
            quadrangleCharacteristic = characteristicList.get(id);
        } else{
            throw new ShapeProjectException("Error while selecting characteristic from warehouse"); // TODO: 19.08.2020 is it good to have exception there, not very usable
        }
        logger.log(Level.INFO, "Quadrangle id {}, {} selected into warehouse", id, quadrangleCharacteristic);

        return quadrangleCharacteristic;
    }

    public QuadrangleCharacteristic removeCharacteristic(long id) throws ShapeProjectException {
        QuadrangleCharacteristic removedCharacteristic = characteristicList.remove(id);

        if (removedCharacteristic == null){
            throw new ShapeProjectException("Error while removing characteristic from warehouse");
        }
        logger.log(Level.INFO, "Quadrangle id {}, {} removed from warehouse", id, removedCharacteristic);

        return removedCharacteristic;
    }
}
