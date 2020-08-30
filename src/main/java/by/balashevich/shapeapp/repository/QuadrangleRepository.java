package by.balashevich.shapeapp.repository;

import by.balashevich.shapeapp.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository {
    private static Logger logger = LogManager.getLogger();
    private List<Quadrangle> quadrangleList;
    private static QuadrangleRepository instance;

    private QuadrangleRepository(){
        quadrangleList = new ArrayList<>();
    }

    public static QuadrangleRepository getInstance(){
        if (instance == null){
            instance = new QuadrangleRepository();
        }

        return instance;
    }

    public boolean add(Quadrangle quadrangle){
        logger.log(Level.INFO, "adding to repository {}", quadrangle);

        return quadrangleList.add(quadrangle);
    }

    public boolean addAll(List<Quadrangle> quadrangles){
        logger.log(Level.INFO, "adding to repository {}", quadrangles);

        return  quadrangleList.addAll(quadrangles);
    }

    public boolean remove(Quadrangle quadrangle){
        logger.log(Level.INFO, "removing from repository {}", quadrangle);

        return quadrangleList.remove(quadrangle);
    }

    public List<Quadrangle> query (Specification specification){
        logger.log(Level.INFO, "query to repository executed: {}", specification.getClass().getName());

        return quadrangleList.stream().filter(specification).collect(Collectors.toList());
    }

    public List<Quadrangle> sort (Comparator<Quadrangle> comparator){
        logger.log(Level.INFO, "sort repository executed: {}", comparator.getClass().getName());

        return quadrangleList.stream().sorted(comparator).collect(Collectors.toList());
    }
}
