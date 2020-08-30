package by.balashevich.shapeapp.observer.impl;

import by.balashevich.shapeapp.entity.Quadrangle;
import by.balashevich.shapeapp.entity.QuadrangleType;
import by.balashevich.shapeapp.exception.ShapeProjectException;
import by.balashevich.shapeapp.observer.Observer;
import by.balashevich.shapeapp.observer.QuadrangleEvent;
import by.balashevich.shapeapp.service.impl.QuadrangleService;
import by.balashevich.shapeapp.warehouse.QuadrangleCharacteristic;
import by.balashevich.shapeapp.warehouse.QuadrangleWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleObserver implements Observer<QuadrangleEvent> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void actionPerformed(QuadrangleEvent eventObject) {
        Quadrangle eventQuadrangle = eventObject.getSource();
        QuadrangleService service = new QuadrangleService();
        QuadrangleWarehouse warehouse = QuadrangleWarehouse.getInstance();

        double area = service.calculateArea(eventQuadrangle);
        double perimeter = service.calculatePerimeter(eventQuadrangle);
        QuadrangleType type = service.determineQuadrangleType(eventQuadrangle);
        boolean isConvex = service.isQuadrangleConvex(eventQuadrangle);

        QuadrangleCharacteristic characteristic = new QuadrangleCharacteristic(area, perimeter, type, isConvex);

        try {
            warehouse.putCharacteristic(eventQuadrangle.getId(), characteristic);
        } catch (ShapeProjectException e) {
            logger.log(Level.ERROR, "error while changing characteristic in warehouse" , e);
        }
    }
}
