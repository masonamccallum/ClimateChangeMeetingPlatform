package edu.tarleton.edu.rho.climatemeetingplatform;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts between String and Integer List attributes for entities.
 * PostgreSQL doesn't handle Integer Lists very well. Therefore, lists in the 
 * database are represented as Strings. When sending a Integer List attribute
 * to the database, this first converts it into a String. Similarly, when reading
 * a String representing an Integer List from the database, this class converts 
 * it to such a List. 
 * @author Johnny
 */
@Converter
public class StringToIntegerListConverter implements AttributeConverter<List<Integer>, String> 
{
    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        if(attribute == null) {
            return "";
        }
        String listString = attribute.toString();
        listString = listString.substring(1, listString.length()-1);
        return listString;
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData.isBlank() || dbData.isEmpty()) {
            return null;
        }
        List<String> items_s = Arrays.asList(dbData.split("\\s*,\\s*"));
        List<Integer> items_i = items_s.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return items_i;
    }
    
    
    
}
