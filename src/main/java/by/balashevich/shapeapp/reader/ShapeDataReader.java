package by.balashevich.shapeapp.reader;

import by.balashevich.shapeapp.exception.ShapeProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShapeDataReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readFileData(String filename) throws ShapeProjectException {
        List<String> dataLines;

        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {
            dataLines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ShapeProjectException("Exception while opening file", e);
        }
        logger.log(Level.INFO, "{} red successfully", filename);

        return dataLines;
    }
}
